package com.TestWeb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.user.model.UserDAO;
import com.TestWeb.user.model.UserDTO;
import com.TestWeb.util.DTOutil;

public class UserJoinSerivceImpl implements UserServiceImpl {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		String phone_number1 = request.getParameter("phone_number1");
		String phone_number2 = request.getParameter("phone_number2");
		String phone_number3 = request.getParameter("phone_number3");

		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");

		UserDTO user = new UserDTO(id, pw, name, 
				phone_number1, 
				phone_number2, 
				phone_number3, 
				email1,
				email2, 
				address1,
				address2,
				null);

		System.out.println(user.toString());
		if (UserDAO.getInstance().join(user) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
