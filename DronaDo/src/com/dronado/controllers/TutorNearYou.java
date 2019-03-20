package com.dronado.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dronado.daos.AddressDaos;
import com.dronado.daos.StudentDaos;
import com.dronado.daos.TutorDaos;
import com.dronado.pojos.Student;
import com.dronado.pojos.Tutor;
/**
 * Servlet implementation class TutorNearYou
 */
@WebServlet("/TutorNearYou")
public class TutorNearYou extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorNearYou() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// here two array was created, first is 1D string array, at 0 index it will contains information about student, and other index contain information about tutor
		// second array is 2D float array containing latitude and longitude of each entry present in first array with same indexing.
		
		// first tutor
		TutorDaos td = new TutorDaos();
		StudentDaos sd = new StudentDaos();
		AddressDaos ad = new AddressDaos();
		
		//of student
		int uid = (Integer)(request.getSession().getAttribute("uid"));
		Student s = sd.findByUId(uid);
		
		ArrayList<Tutor> tutor_array = td.findAllTutor();
		// both array is one plus size of tutor_array 
		// string array
		String[] entry_information= new String[tutor_array.size()+1];
		// first is latitude and seconda is longitude
		float[][] location = new float[tutor_array.size()+1][2];
		// first at 0 index student information
		entry_information[0]="Your Location";
		location[0]= ad.findLatitudeAndLongitude(s.getStudAddressId());
		// ref for indexing purpose
		int ref =1;
		for(Tutor t : tutor_array) {
			entry_information[ref]=t.getTuFullName()+" "+t.getTuEmail();
			location[ref]= ad.findLatitudeAndLongitude(t.getTuAddressId());
			ref++;
		}
		request.setAttribute("entry_information", entry_information);
		request.setAttribute("location", location);
		request.setAttribute("title", "Dashboard - Tutor Near You ");
		request.setAttribute("mainPartFile", "TutorNearYouView.jsp");
		RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
		rs.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
