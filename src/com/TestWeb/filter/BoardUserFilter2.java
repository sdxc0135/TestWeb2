package com.TestWeb.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.Board.model.BoardDAO;
import com.TestWeb.user.model.UserDTO;

@WebFilter({"/bbs/modify.bbs", "/bbs/delete.bbs","/bbs/req_modify.bbs"})
public class BoardUserFilter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		req.setCharacterEncoding("utf-8");
		
		String bno = req.getParameter("bno");
		
		UserDTO user = (UserDTO) req.getSession().getAttribute("user");
		
		boolean flag = false;
		
		
		if(bno != null && user != null) {						
			
			String writer = BoardDAO.getInstance().getWriter(bno);
			String userId = user.getId();
			
			if(writer.equals(userId)) {
				flag = true;
			}
		}
		
		if(!flag) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			
			out.append("<script>");
			out.append("alert('잘못된 접근입니다.');");
			out.append("location.href='/TestWeb'");
			out.append("</script>");
			
			return;
		}
		
		chain.doFilter(request, response);
		
	}

}
