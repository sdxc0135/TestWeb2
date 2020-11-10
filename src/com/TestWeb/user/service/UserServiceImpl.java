package com.TestWeb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserServiceImpl {
	abstract public int execute(HttpServletRequest request, HttpServletResponse response);
}
