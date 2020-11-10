package com.TestWeb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.util.MakeParameter;

@WebFilter({"/bbs/list.bbs","/bbs/content.bbs"})
public class ReqURI implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		
		String path = req.getRequestURI();
		String bno = req.getParameter("bno");
		
		String reqURI = MakeParameter.get("reqURI", path, "bno", bno);
		
		request.setAttribute("reqURI", reqURI);
		
		chain.doFilter(request, response);
	}

}
