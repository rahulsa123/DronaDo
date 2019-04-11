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

import com.dronado.daos.SubjectDaos;
import com.dronado.daos.TeachesDaos;
import com.dronado.daos.TutorDaos;
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
		String classes="";
		String operation = "";
		try {
			operation = request.getParameter("operation");
			if(operation.equals("update")) {
				//also send message to students who have been assigned the class
			}else if(operation.equals("remove")) {
				
			}else if(operation.equals("add")) {
				
			}else if(operation.equals("exit")) {
				
			}
		}catch(Exception e) {
			
		}
		
		try {
			uid = Integer.parseInt((String)session.getAttribute("uid"));
			
			String userType = (String)session.getAttribute("userType");
			TeachesDaos ted= new TeachesDaos();
			ArrayList<Teaches> ts = ted.findAllByTuId(new TutorDaos().findByUId(uid).getTuId());
			if(userType.equalsIgnoreCase("tutor")) {
				if(ts.size()>0) {
					classes += "<table><tr>" +
								"<th>" + "Subject" + "</th>"+
								"<th>" + "Fees" + "</th>"+
								"<th>" + "Experience" + "</th>"+
								"<th>" + "Address" + "</th>"+
								"</tr>";
								
				}
				for(int i=0;i<ts.size();i++) {
					Teaches t = ts.get(i);
					classes += "<tr>" + 
								"<td>"+new SubjectDaos().getSubjectById(t.getsId()).getSName() + "</td>"+
							"<td>"+t.getFees() + "</td>"+
							"<td>"+t.getDuration() + "</td>"+
							"<td>"+t.getExperience() + "</td>"+
							"<td>"+t.gettAddress() + "</td>";
					classes+="</tr>";
				}
				if(ts.size()>0)
					classes+="</table>";
				request.setAttribute("classes", classes);
				request.setAttribute("title", "Dashboard - Manage Class");
				request.setAttribute("mainPartFile", "ManageClass.jsp");
				RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
				rs.forward(request, response);
			}else {
				String display= "";
				if(ts.size()>0) {
					display += "<table><tr>" +
								"<th>" + "Subject" + "</th>"+
								"<th>" + "Fees" + "</th>"+
								"<th>" + "Experience" + "</th>"+
								"<th>" + "Address" + "</th>"+
								"</tr>";
								
				}
				for(int i=0;i<ts.size();i++) {
					Teaches t = ts.get(i);
					display += "<tr>" + 
							"<td>"+new SubjectDaos().getSubjectById(t.getsId()).getSName() + "</td>"+
						"<td>"+t.getFees() + "</td>"+
						"<td>"+t.getDuration() + "</td>"+
						"<td>"+t.getExperience() + "</td>"+
						"<td>"+t.gettAddress() + "</td>"+
						"<td>" + ""+ "</td>";
					display+="</tr>";
				}
				if(ts.size()>0)
					display+="</table>";
				request.setAttribute("display", display);
				request.setAttribute("title", "Dashboard - Class Status");
				request.setAttribute("mainPartFile", "ManageClass.jsp");
				RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
				rs.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("index.html");
		}
	}

}
