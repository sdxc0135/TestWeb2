package com.TestWeb.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TestWeb.user.model.UserDAO;
import com.TestWeb.user.model.UserDTO;
import com.TestWeb.user.service.UserDeleteServiceImpl;
import com.TestWeb.user.service.UserIdCheckServiceImpl;
import com.TestWeb.user.service.UserJoinSerivceImpl;
import com.TestWeb.user.service.UserLoginServiceImpl;
import com.TestWeb.user.service.UserLogoutServiceImpl;
import com.TestWeb.user.service.UserModifyServiceImpl;
import com.TestWeb.user.service.UserMyPageServiceImpl;
import com.TestWeb.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UserController() {
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
		System.out.println("요청 경로:" + com);
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		UserServiceImpl service = null;
		
		if(com.equals("/user/join.user")) {
			System.out.println("회원가입 화면 이동");
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
		}
		else if(com.equals("/user/req_join.user")) {
			System.out.println("회원가입 요청");
			
			PrintWriter out = response.getWriter();
			
			service = new UserIdCheckServiceImpl();
			if(service.execute(request, response) == 1) {
				System.out.println("회원아이디확인 요청");
				
				out.append("<script>");
				out.append("alert('중복된 아이디입니다.');");
				out.append("history.go(-1);");
				out.append("</script>");
				
			}else {
				service = new UserJoinSerivceImpl();
				if(service.execute(request, response) == 1) {
					out.append("<script>");
					out.append("alert('회원 가입에 성공했습니다.');");
					out.append("location.href='login.user';");
					out.append("</script>");
				}else {
					out.append("<script>");
					out.append("alert('회원 가입에 실패했습니다.');");
					out.append("location.href='login.user';");
					out.append("</script>");
				}
			}
			
		}else if(com.equals("/user/login.user")){
			System.out.println("로그인 화면 이동");
			
			if(request.getParameter("reqURI") != null) {
				request.setAttribute("reqURI", request.getParameter("reqURI"));
			}
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
			
		}else if(com.equals("/user/chk_login.user")) {
			System.out.println("로그인 요청");
			
			PrintWriter out = response.getWriter();
			
			service = new UserLoginServiceImpl();
			if(service.execute(request, response) ==1) {
				System.out.println("로그인 성공");
				
				String reqURI = request.getParameter("reqURI");
				System.out.println("이동정보: " + reqURI);
				if(reqURI != null && reqURI != "") {
					System.out.println("이동정보 있음");
					response.sendRedirect(reqURI);
				}else {
					System.out.println("이동정보 없음");
					response.sendRedirect("/TestWeb");
				}
				
			}else {
				System.out.println("로그인 실패");
				
				out.append("<script>");
				out.append("alert('아이디나 비밀번호를 확인해주세요.');");
				out.append("location.href='login.user';");
				out.append("</script>");
			}
			
		}else if(com.equals("/user/logout.user")) {
			System.out.println("로그아웃 요청");
			service = new UserLogoutServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("/TestWeb");
		}else if(com.equals("/user/mypage.user")) {
			System.out.println("마이페이지 게시글 요청 및 마이페이지 화면 이동");
			
			service = new UserMyPageServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);		
			
		}else if(com.equals("/user/req_modify.user")) {
			System.out.println("회원정보수정 요청");
			
			service = new UserModifyServiceImpl();
			if(service.execute(request, response) == 1) {
				response.sendRedirect("mypage.user");
			}else {
				PrintWriter out = response.getWriter();
				out.append("<script>");
				out.append("alert('회원정보 수정에 실패했습니다.');");
				out.append("location.href='mypage.user';");
				out.append("</script>");
			}
		}
		
		else if(com.equals("/user/delete.user")) {
			System.out.println("회원삭제 요청");
			
			service = new UserLoginServiceImpl();
			
			if(service.execute(request, response) == 1) {
				service = new UserDeleteServiceImpl();
				
				if(service.execute(request, response) == 1) {
					System.out.println("회원삭제 완료");
					
					response.sendRedirect("/TestWeb");
				}else {
					System.out.println("회원삭제 실패");
					response.sendRedirect("mypage.user");
				}
			}else {
				
				PrintWriter out = response.getWriter();
				
				out.append("<script>");
				out.append("alert('비밀번호를 확인해주세요');");
				out.append("location.href='mypage.user';");
				out.append("</script>");
			}
		}else if(com.equals("/user/mypageinfo.user")) {
			System.out.println("회원정보수정 화면 이동");
			request.getRequestDispatcher("user_mypageinfo.jsp").forward(request, response);
		}
		else {
			System.out.println("미분류 화면(임시)");
			request.getRequestDispatcher("/errorPage/error_view.jsp").forward(request, response);;
		}
	}
}
