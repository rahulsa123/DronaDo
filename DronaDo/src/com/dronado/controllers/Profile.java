package com.dronado.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserDaos ud = new UserDaos();
		// for testing purpose
		int uid1=2;
		session.setAttribute("uid", uid1);
		
		session.setAttribute("userType", ud.getUserTypeByUId(uid1));
		
		
		int uid = (int)session.getAttribute("uid");
		if(uid!=0) {
			// to edit information
		
			String operation = request.getParameter("operation");
		//	System.out.println(operation+request.getParameter("fullName"));
			if(operation!= null && operation.equalsIgnoreCase("edit")){
				String userType =ud.getUserTypeByUId(uid);
				if(userType.equalsIgnoreCase("student") || userType.equalsIgnoreCase("Parent")) {
					StudentDaos sd = new StudentDaos();
					Student s = sd.findByUId(uid);
					s.setStudFullName(request.getParameter("fullName"));
					s.setStudEmail(request.getParameter("email"));
					s.setStudPhoneNo(request.getParameter("phoneNo"));
					s.setStudAddress(request.getParameter("address"));
				//	System.out.println(s);
					sd.edit(s);
				}
				else if(userType.equalsIgnoreCase("tutor") ) {
				TutorDaos td = new TutorDaos();
				Tutor t = td.findByUId(uid);
				t.setTuFullName(request.getParameter("fullName"));
				t.setTuEmail(request.getParameter("email"));
				t.setTuPhoneNo(request.getParameter("phoneNo"));
				t.setTuAddress(request.getParameter("address"));
				t.setQualification(request.getParameter("qualification"));
				td.edit(t);
				}
			}
			
			
			
			//to set information for jsp page
			String userType = ud.getUserTypeByUId(uid);
			request.setAttribute("userType", userType);
			if(userType.equalsIgnoreCase("student") || userType.equalsIgnoreCase("Parent")) {
				request.setAttribute("usertype", "Student");
				StudentDaos sd = new StudentDaos();
				Student s = sd.findByUId(uid);
		
				request.setAttribute("fullName", s.getStudFullName());
				request.setAttribute("email", s.getStudEmail());
				request.setAttribute("phoneNo", s.getStudPhoneNo());
				request.setAttribute("address", s.getStudAddress());
				request.setAttribute("qualification", "");
			}
			else if(userType.equalsIgnoreCase("tutor") ) {
				request.setAttribute("usertype", "Tutor");
				TutorDaos td = new TutorDaos();
				Tutor t = td.findByUId(uid);
		
				request.setAttribute("fullName", t.getTuFullName());
				request.setAttribute("email", t.getTuEmail());
				request.setAttribute("phoneNo", t.getTuPhoneNo());
				request.setAttribute("address", t.getTuAddress());
				request.setAttribute("qualification", t.getQualification());
			}
			
		}
	//System.out.println(uid);
		//System.out.println(request.getAttribute("fullName"));
		RequestDispatcher rs = request.getRequestDispatcher("/pages/Profile.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
