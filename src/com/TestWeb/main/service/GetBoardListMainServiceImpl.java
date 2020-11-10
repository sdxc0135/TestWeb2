package com.TestWeb.main.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.Board.model.BoardDAO;
import com.TestWeb.Board.model.BoardDTO;

public class GetBoardListMainServiceImpl implements MainServiceImpl {

	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int page = 1;
		
		int contentAmount = 10;
		
		List<BoardDTO> list = dao.getList(page, contentAmount);
		
		request.setAttribute("MainBoardList", list);
		
		return 0;
	}
	
}
