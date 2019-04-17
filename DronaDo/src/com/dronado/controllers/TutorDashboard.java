package com.dronado.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dronado.daos.UserDaos;

/**
 * Servlet implementation class TutorDashboard
 */
@WebServlet("/TutorDashboard")
public class TutorDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		UserDaos ud = new UserDaos();
		// for testing purpose
		
		int uid = (int)session.getAttribute("uid");
		request.setAttribute("mainPartFile","DashboardMainPart.jsp");
		request.setAttribute("title", "DronaDo - Tutor Dashboard");
		RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
		rs.forward(request, response); 
	}

}
