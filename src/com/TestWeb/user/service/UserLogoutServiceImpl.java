package com.TestWeb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogoutServiceImpl implements UserServiceImpl{
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		request.getSession().invalidate();
		return 0;
	}
}
