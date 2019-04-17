package com.dronado.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dronado.daos.AssignedDaos;
import com.dronado.daos.NotificationDaos;
import com.dronado.daos.StudentDaos;
import com.dronado.daos.SubjectDaos;
import com.dronado.daos.TeachesDaos;
import com.dronado.daos.TutorDaos;
import com.dronado.pojos.Assigned;
import com.dronado.pojos.Notification;
import com.dronado.pojos.Student;
import com.dronado.pojos.Subject;
import com.dronado.pojos.Teaches;

/**
 * Servlet implementation class ManageClass
 */
@WebServlet("/ManageClass")
public class ManageClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageClass() {
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
		HttpSession session = request.getSession();
		int uid= -1;
		String userType = "";
		try {
			uid = (int)session.getAttribute("uid");
			userType = (String)session.getAttribute("userType");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("infoMessage", "<a%20class=\\\"alert%20alert-info\\\">You%20need%20to%20login</a>");
			request.setAttribute("showSignIn", "true");
			request.setAttribute("showSignUp", "false");
			RequestDispatcher rd= request.getRequestDispatcher("/pages/index.jsp");
			rd.forward(request, response);
			return;
		}

		String operation = "";
		try {
			operation = request.getParameter("operation");
			if(operation == null) {}
			else if(operation.equalsIgnoreCase("Update")) {
				int teid = Integer.parseInt(request.getParameter("formSno"));
				String subject = request.getParameter("formSubject");
				float fees = Float.parseFloat(request.getParameter("formFees"));
				String address = request.getParameter("formAddress");
				String duration = request.getParameter("formDuration");
				int experience = Integer.parseInt(request.getParameter("formExperience"));
				Teaches te = new TeachesDaos().findByTId(teid);
				new SubjectDaos().edit(new Subject(te.getsId(),subject.split(" & ")[0],subject.split(" & ")[1],subject.split(" & ")[2]));
				new TeachesDaos().edit(new Teaches(teid,te.getsId(),new TutorDaos().findByUId(uid).getTuId(),fees,duration,address,te.gettAddressId(),experience+""));
				for(Student s: new AssignedDaos().findAllStudentByTid(Integer.parseInt(request.getParameter("formSno")))) {
					Notification n = new Notification(0,new java.util.Date(),uid,s.getUId(),"Tutor has updated the details of class","close");
					new NotificationDaos().insert(n);
				}
			}else if(operation.equalsIgnoreCase("Delete")) {
				new TeachesDaos().removeById(Integer.parseInt(request.getParameter("formSno")));
				for(Student s: new AssignedDaos().findAllStudentByTid(Integer.parseInt(request.getParameter("formSno")))) {
					Notification n = new Notification(0,new java.util.Date(),uid,s.getUId(),"Tutor has closed the class","close");
					new NotificationDaos().insert(n);
				}
			}else if(operation.equalsIgnoreCase("Add")) {
				String subject = request.getParameter("formSubject");
				float fees = Float.parseFloat(request.getParameter("formFees"));
				String address = request.getParameter("formAddress");
				String duration = request.getParameter("formDuration");
				int experience = Integer.parseInt(request.getParameter("formExperience"));
				int sid = -1;
			
				for(int i: new TutorDaos().getTuSubjects(uid)) {
					Subject s = new SubjectDaos().getSubjectById(i);
					if(s.getSName().equals(subject.split(" & ")[0]) && s.getSStandard().equals(subject.split(" & ")[1]) && s.getSStream().equals(subject.split(" & ")[2])) {
						sid=i;
						break;
					}
				}
				new TeachesDaos().insert(new Teaches(0, sid, new TutorDaos().findByUId(uid).getTuId(), fees, duration, address, new TutorDaos().findByUId(uid).getTuAddressId(), ""+experience));
			}else if(operation.equalsIgnoreCase("Exit")) {
				Assigned a = new AssignedDaos().getAssignedById(Integer.parseInt(request.getParameter("teid")));
				new AssignedDaos().removeById(a.getaId());
				Notification n = new Notification(0,new java.util.Date(),uid,new TutorDaos().findByTuId(new TeachesDaos().findByTId(a.gettId()).getTuId()).getUId(),"Student has left the class","exit");
				new NotificationDaos().insert(n);
			}
			else if(operation.equalsIgnoreCase("MessageByTutor")) {
				String message = request.getParameter("message");
				for(Student s: new AssignedDaos().findAllStudentByTid(Integer.parseInt(request.getParameter("formSno")))) {
					Notification n = new Notification(0,new java.util.Date(),uid,s.getUId(),message,"close");
					new NotificationDaos().insert(n);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		if(userType!=null && userType.equalsIgnoreCase("tutor"))
				request.setAttribute("title", "DronaDo - Manage Class");
		else if(userType!=null && userType.equalsIgnoreCase("student"))
		request.setAttribute("title", "DronaDo - Class Status");
		request.setAttribute("mainPartFile", "ManageClass.jsp");
		RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
		rs.forward(request, response);
	}

}
