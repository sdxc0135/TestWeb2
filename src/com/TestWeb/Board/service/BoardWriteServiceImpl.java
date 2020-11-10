package com.TestWeb.Board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.Board.model.BoardDAO;

public class BoardWriteServiceImpl implements BoardServiceImpl {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.insert(title, writer, content);
		
		return 0;
	}

}
