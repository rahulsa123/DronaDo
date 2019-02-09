package com.dronado.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dronado.daos.SubjectDaos;
import com.dronado.daos.TeachesDaos;
import com.dronado.daos.TutorDaos;
import com.dronado.daos.UserDaos;
import com.dronado.pojos.Subject;
import com.dronado.pojos.Teaches;

/**
 * Servlet implementation class EditSubject
 */
@WebServlet("/ManageSubjects")
public class ManageSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageSubjects() {
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
		int uid1=1;
		HttpSession session = request.getSession();
		UserDaos ud = new UserDaos();
		session.setAttribute("uid", uid1);
		session.setAttribute("userType", ud.getUserTypeByUId(uid1));
		
		
		
		if(request.getParameter("manageSubjectsOperation")!=null && request.getParameter("manageSubjectsOperation").equals("add")) {
			String subjectName = request.getParameter("subjectName");
			String subjectStandard = request.getParameter("subjectStandard");
			String subjectStream = request.getParameter("subjectStream");
			SubjectDaos sd = new SubjectDaos();
			int sid = sd.checkExistance(subjectName, subjectStream, subjectStandard);
			if(sid!=-1)
				sid = sd.insert(new Subject(0,subjectName,subjectStandard,subjectStream));
			TutorDaos td = new TutorDaos();
			td.addSubject(sid,(int)session.getAttribute("uid"));
		}
		SubjectDaos sd = new SubjectDaos();
		request.setAttribute("title", "Dashboard - Manage Subjects");
		request.setAttribute("mainPartFile", "ManageSubjects.jsp");
		RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
		rs.forward(request, response);
	}

}
