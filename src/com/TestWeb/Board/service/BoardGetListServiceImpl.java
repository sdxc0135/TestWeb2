package com.TestWeb.Board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.Board.model.BoardDAO;
import com.TestWeb.Board.model.BoardDTO;
import com.TestWeb.Board.model.PageVO;

public class BoardGetListServiceImpl implements BoardServiceImpl{
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int page = 1;
		
		if(request.getParameter("page") != null) {
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				page =1;
			}
		}
		
		
		int contentAmount = 20;
		int pageAmount = 5;
		
		PageVO pageVo = new PageVO(page, contentAmount, dao.getCount(), pageAmount);
		
		List<BoardDTO> list = dao.getList(page, contentAmount);
		
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("boardList", list);
		
		return 0;
	}
}
