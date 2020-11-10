package com.TestWeb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.user.model.UserDAO;
import com.TestWeb.user.model.UserDTO;

public class UserLoginServiceImpl implements UserServiceImpl {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		
		UserDTO user = dao.login(id, pw);
		
		if(user != null){
			request.getSession().setAttribute("user", user);
			return 1;
		}

		return 0;
	}

}
