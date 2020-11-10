package com.TestWeb.Board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.Board.model.BoardDAO;
import com.TestWeb.Board.model.BoardDTO;

public class BoardGetContentServiceImpl implements BoardServiceImpl{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto =  dao.getContent(bno);
		
		if(dto != null) {
			request.setAttribute("boardContent", dto);
		}
		
		return 0;
	}
	
}
