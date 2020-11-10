package com.TestWeb.Board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.Board.model.BoardDAO;

public class BoardDeleteServiceImpl implements BoardServiceImpl {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardDAO.getInstance().delete(bno);
		
		
		return 0;
	}

}
