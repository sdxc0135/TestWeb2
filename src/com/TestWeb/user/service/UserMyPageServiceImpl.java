package com.TestWeb.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.Board.model.BoardDAO;
import com.TestWeb.Board.model.BoardDTO;
import com.TestWeb.Board.model.PageVO;
import com.TestWeb.user.model.UserDAO;
import com.TestWeb.user.model.UserDTO;

public class UserMyPageServiceImpl implements UserServiceImpl {
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		UserDTO user = (UserDTO) request.getSession().getAttribute("user");
		BoardDAO dao = BoardDAO.getInstance();
		
		int page = 1;
		
		if(request.getParameter("page") != null) {
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				page = 1;
			}
		}
		
		int contentAmount = 10;
		int pageAmount = 5;
		
		PageVO pageVo = new PageVO(page, contentAmount, dao.getUserCount(user.getId()), pageAmount);
		
		List<BoardDTO> list = dao.getUserList(page, contentAmount, user.getId());
		
		list.stream().forEach(x->System.out.println(x.toString()));
		
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("myBoardList", list);
		
		return 0;
		
	}
}
