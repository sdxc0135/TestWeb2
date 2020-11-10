package com.TestWeb.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.Board.model.BoardDAO;
import com.TestWeb.Board.service.BoardGetListServiceImpl;
import com.TestWeb.Board.service.BoardServiceImpl;
import com.TestWeb.main.service.GetBoardListMainServiceImpl;
import com.TestWeb.main.service.MainServiceImpl;

/**
 * Servlet implementation class MainController
 */
@WebServlet({"/main","/index.main"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("진입");
		System.out.println(request.getRequestURI());
		request.setCharacterEncoding("utf-8");
		
		MainServiceImpl service = new GetBoardListMainServiceImpl();
		service.execute(request, response);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
