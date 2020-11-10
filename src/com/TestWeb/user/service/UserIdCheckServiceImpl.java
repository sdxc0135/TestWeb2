package com.TestWeb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.user.model.UserDAO;

public class UserIdCheckServiceImpl implements UserServiceImpl {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		if(UserDAO.getInstance().checkId(id) == 1) {
			return 1;
		}
		
		return 0;
	}

}
