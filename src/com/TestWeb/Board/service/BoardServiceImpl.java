package com.TestWeb.Board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardServiceImpl {
	abstract public int execute(HttpServletRequest request, HttpServletResponse response);
	
}
