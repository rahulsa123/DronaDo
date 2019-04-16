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
		HttpSession session = request.getSession();
		
		if(session.getAttribute("uid") == null) {
			request.setAttribute("infoMessage", "<a%20class=\\\"alert%20alert-info\\\">You%20need%20to%20login</a>");
			request.setAttribute("showSignIn", "true");
			request.setAttribute("showSignUp", "false");
			RequestDispatcher rd = request.getRequestDispatcher("pages/index.jsp");
			rd.forward(request, response);
			return;
		}
		int uid = (Integer)session.getAttribute("uid");
		if(request.getParameter("operation")!=null) {
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			String standardFrom = request.getParameter("stdFrom");
			String standardTo = request.getParameter("stdTo");
			String stream = request.getParameter("stream");
			SubjectDaos sd = new SubjectDaos();
			TutorDaos td = new TutorDaos();
			if( request.getParameter("operation").equalsIgnoreCase("Add")) {

				int sid = sd.insert(new Subject(0,sname,standardFrom +"-"+standardTo,stream));
				
				td.addSubjectByUid(sid,(int)session.getAttribute("uid"));
			}
			else if(request.getParameter("operation").equalsIgnoreCase("Delete")) {
				System.out.println(sno + "--" +uid);
				td.removeSubjectByUId(Integer.parseInt(sno), uid);
				sd.removeById(Integer.parseInt(sno));
			} else if(request.getParameter("operation").equalsIgnoreCase("Update")) {
				sd.edit(new Subject(Integer.parseInt(sno), sname, standardFrom +"-" + standardTo, stream));
			}
		}
		
		request.setAttribute("title", "Dashboard - Manage Subjects");
		request.setAttribute("mainPartFile", "ManageSubjects.jsp");
		RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
		rs.forward(request, response);
	}

}
