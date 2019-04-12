package com.dronado.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dronado.daos.AddressDaos;
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
		
		//for image 
//		String appPath = request.getServletContext().getRealPath("");
//		appPath+=File.separator+"img"+File.separator;
//		// Profile Image
//		
//		Part p =request.getPart("profile_pic");
//		
//		System.out.println(p.getSize());
//		if(p.getSize()>0) {
//		p.write(appPath+"profile_pic"+uid);
//		System.out.println(appPath+"profile_pic"+uid);
//		}
		
		
		int uid = (int)session.getAttribute("uid");
		if(uid!=0) {
			// to edit information
			//Part op = request.getPart("operation");
			String operation = request.getParameter("operation");
			
			System.out.println(operation+request.getParameter("fullName"));
			if(operation!= null && operation.equalsIgnoreCase("edit")){
				String userType =ud.getUserTypeByUId(uid);
				if(userType.equalsIgnoreCase("student") || userType.equalsIgnoreCase("Parent")) {
					StudentDaos sd = new StudentDaos();
					AddressDaos ad = new AddressDaos();
					Student s = sd.findByUId(uid);
					s.setStudFullName(request.getParameter("fullName"));
					s.setStudEmail(request.getParameter("email"));
					s.setStudPhoneNo(request.getParameter("phoneNo"));
					s.setStudAddress(request.getParameter("address"));
					float[] lati_and_longi = new float[2];
					if(request.getParameter("new_latitude")!=null && request.getParameter("new_longitude")!=null && request.getParameter("new_latitude").length()!=0 && request.getParameter("new_longitude").length()!=0) {
					//System.out.println("New value");
					lati_and_longi[0]=Float.parseFloat(request.getParameter("new_latitude"));
					lati_and_longi[1]=Float.parseFloat(request.getParameter("new_longitude"));
					ad.updateLatitudeAndLongitudeByAddressId(s.getStudAddressId(),lati_and_longi[0], lati_and_longi[1]);
					}
					System.out.println(s);
					sd.edit(s);
				//alert purpose 
					
					request.setAttribute("edit", true);
				}
			else if(userType.equalsIgnoreCase("tutor") ) {
				TutorDaos td = new TutorDaos();
				AddressDaos ad = new AddressDaos();
				Tutor t = td.findByUId(uid);
				t.setTuFullName(request.getParameter("fullName"));
				t.setTuEmail(request.getParameter("email"));
				t.setTuPhoneNo(request.getParameter("phoneNo"));
				t.setTuAddress(request.getParameter("address"));
				t.setQualification(request.getParameter("qualification"));
				float[] lati_and_longi = new float[2];
				if(request.getParameter("new_latitude")!=null && request.getParameter("new_longitude")!=null  && request.getParameter("new_latitude").length()!=0 && request.getParameter("new_longitude").length()!=0) {
				System.out.println("New value"+request.getParameter("new_latitude")+request.getParameter("new_latitude"));
				lati_and_longi[0]=Float.parseFloat(request.getParameter("new_latitude"));
				lati_and_longi[1]=Float.parseFloat(request.getParameter("new_longitude"));
				ad.updateLatitudeAndLongitudeByAddressId(t.getTuAddressId(),lati_and_longi[0], lati_and_longi[1]);
				}
				System.out.println(t);
				td.edit(t);
				}
				//alert purpose
				request.setAttribute("edit", true);
			}else {
				//alert purpose
				request.setAttribute("edit", false);
			}
			
			
			
			//to set information for jsp page
			String userType = ud.getUserTypeByUId(uid);
			request.setAttribute("userType", userType);
			if(userType.equalsIgnoreCase("student") || userType.equalsIgnoreCase("Parent")) {
				request.setAttribute("usertype", "Student");
				StudentDaos sd = new StudentDaos();
				AddressDaos ad = new AddressDaos();
				Student s = sd.findByUId(uid);
		
				request.setAttribute("fullName", s.getStudFullName());
				request.setAttribute("email", s.getStudEmail());
				request.setAttribute("phoneNo", s.getStudPhoneNo());
				request.setAttribute("address", s.getStudAddress());
				request.setAttribute("qualification", "");
				float[] lati_and_longi = ad.findLatitudeAndLongitude(s.getStudAddressId());
				request.setAttribute("latitude", lati_and_longi[0]);
				request.setAttribute("longitude", lati_and_longi[1]);
			}
			else if(userType.equalsIgnoreCase("tutor") ) {
				request.setAttribute("usertype", "Tutor");
				TutorDaos td = new TutorDaos();
				AddressDaos ad = new AddressDaos();
				
				Tutor t = td.findByUId(uid);
		
				request.setAttribute("fullName", t.getTuFullName());
				request.setAttribute("email", t.getTuEmail());
				request.setAttribute("phoneNo", t.getTuPhoneNo());
				request.setAttribute("address", t.getTuAddress());
				request.setAttribute("qualification", t.getQualification());
				
				float[] lati_and_longi = ad.findLatitudeAndLongitude(t.getTuAddressId());
				request.setAttribute("latitude", lati_and_longi[0]);
				request.setAttribute("longitude", lati_and_longi[1]);
			}
			
		}
	//System.out.println(uid);
		//System.out.println(request.getAttribute("fullName"));
		
		request.setAttribute("title", "Dashboard - Edit Profile");
		request.setAttribute("mainPartFile", "Profile.jsp");
		RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
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
