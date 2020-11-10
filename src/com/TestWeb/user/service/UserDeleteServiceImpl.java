package com.TestWeb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TestWeb.user.model.UserDAO;
import com.TestWeb.user.model.UserDTO;

public class UserDeleteServiceImpl implements UserServiceImpl {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		UserDTO dto = (UserDTO)session.getAttribute("user");
		
		String id = dto.getId();
		String pw = request.getParameter("pw");
		
		if(UserDAO.getInstance().delete(id, pw) == 1) {
			session.invalidate();
			return 1;
		}
		
		return 0;
	}

}
