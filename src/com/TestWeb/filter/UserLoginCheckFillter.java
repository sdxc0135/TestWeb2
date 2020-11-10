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


@WebFilter({"/user/mypage.user","/user/mypageinfo.user","/user/delete.user","/user/logout.user"
	,"/bbs/write.bbs"})
public class UserLoginCheckFillter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		req.setCharacterEncoding("utf-8");
		
		System.out.println("유저 필터");
		
		if(req.getSession().getAttribute("user") == null) {
			
			System.out.println("유저 정보 없음 " + req.getRequestURI());
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			
			out.append("<script>");
			out.append("alert('로그인이 필요합니다.');");
			out.append("location.href='/TestWeb/user/login.user?reqURI="+req.getRequestURI() + "';");
			out.append("</script>");
			
			return;
		}
		
		chain.doFilter(request, response);
	}

}
