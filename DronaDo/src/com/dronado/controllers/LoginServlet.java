package com.dronado.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dronado.daos.StudentDaos;
import com.dronado.daos.TutorDaos;
import com.dronado.daos.UserDaos;
import com.dronado.pojos.Student;
import com.dronado.pojos.Tutor;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("remember-me");
		UserDaos ud = new UserDaos();
		int uid = ud.validUser(username, password);
		try {
		if(uid==-1) {
			request.setAttribute("infoMessage", "<a%20class=\\\"alert%20alert-danger\\\">Invalid%20Username%20or%20Password</a>");
			request.setAttribute("showSignIn", "true");
			request.setAttribute("showSignUp", "false");
			RequestDispatcher rd = request.getRequestDispatcher("pages/index.jsp");
			rd.forward(request, response);
			return;
		}
		if(rememberMe!=null) {
			Cookie c  = new Cookie("username",username);
			response.addCookie(c);
			c = new Cookie("password",password);
			response.addCookie(c);
		}
		HttpSession session = request.getSession();
		session.setAttribute("uid", uid);
		String userType = ud.getUserTypeByUId(uid);
		if(userType.equals("")) {
			response.sendRedirect("pages/completeRegistration.jsp");
		}
		else if(userType.equalsIgnoreCase("student")){
			session.setAttribute("uid", uid);
			session.setAttribute("userType", "student");
			response.sendRedirect("StudentDashboard");
		}
		else  if(userType.equalsIgnoreCase("tutor")){
			session.setAttribute("uid", uid);
			session.setAttribute("userType", "tutor");
			response.sendRedirect("TutorDashboard");
		}
		}
		catch(Exception e) {	
			e.printStackTrace();
		}
	}

}
