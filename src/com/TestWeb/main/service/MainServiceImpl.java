package com.TestWeb.main.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MainServiceImpl {
	abstract public int execute(HttpServletRequest request, HttpServletResponse response);
}
