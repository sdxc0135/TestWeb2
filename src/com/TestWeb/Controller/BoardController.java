package com.TestWeb.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.Board.service.BoardDeleteServiceImpl;
import com.TestWeb.Board.service.BoardGetContentServiceImpl;
import com.TestWeb.Board.service.BoardGetListServiceImpl;
import com.TestWeb.Board.service.BoardModifyServiceImpl;
import com.TestWeb.Board.service.BoardServiceImpl;
import com.TestWeb.Board.service.BoardWriteServiceImpl;
import com.TestWeb.user.service.UserServiceImpl;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.bbs")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String com = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("요청경로: " + com);
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		BoardServiceImpl service = null;
		
		if(com.equals("/bbs/list.bbs")) {
			System.out.println("게시판 전체 게시글 요청 및 화면이동");
			
			request.setAttribute("reqURI", request.getRequestURI());
			
			service = new BoardGetListServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("bbs.jsp").forward(request, response);
			
		}else if(com.equals("/bbs/content.bbs")) {
			System.out.println("게시글 요청 및 화면 이동");
			
			request.setAttribute("reqURI", request.getRequestURI()+"?bno="+request.getParameter("bno"));
			
			service = new BoardGetContentServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("bbs_content.jsp").forward(request, response);
			
		}else if(com.equals("/bbs/modify.bbs")) {
			System.out.println("게시글수정 화면 이동");
			request.getRequestDispatcher("bbs_modify.jsp").forward(request, response);
			
		}else if(com.equals("/bbs/req_modify.bbs")) {
			System.out.println("게시글 수정 요청 및 게시글 화면 이동");
			
			service = new BoardModifyServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("content.bbs?bno="+request.getParameter("bno"));
			
		}else if(com.equals("/bbs/delete.bbs")) {
			System.out.println("게시글 삭제 요청 및 게시글 화면 이동");
			
			service = new BoardDeleteServiceImpl();
			service.execute(request, response);
			response.sendRedirect("list.bbs");
			
		}else if(com.equals("/bbs/write.bbs")) {
			System.out.println("게시글작성 화면 이동");
			request.getRequestDispatcher("bbs_write.jsp").forward(request, response);
			
		}else if(com.equals("/bbs/req_write.bbs")) {
			System.out.println("게시글작성 요청");
			
			service = new BoardWriteServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("list.bbs");
		}
		
		else {
			System.out.println("미분류된 화면(임시)");
			request.getRequestDispatcher("/errorPage/error_view.jsp").forward(request, response);;
		}
		
	}

}
