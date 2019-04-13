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

import com.dronado.daos.NotificationDaos;
import com.dronado.daos.StudentDaos;
import com.dronado.daos.TutorDaos;
import com.dronado.daos.UserDaos;
import com.dronado.pojos.Notification;
import com.dronado.pojos.Student;
import com.dronado.pojos.Tutor;

/**
 * Servlet implementation class Notifications
 */
@WebServlet("/Notifications")
public class Notifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notifications() {
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
		int uid = -1;
		try {
		uid = Integer.parseInt((String)session.getAttribute("uid"));
		NotificationDaos nd = new NotificationDaos();
		UserDaos ud = new UserDaos();
		if(request.getParameter("isFormSubmitted").equalsIgnoreCase("true")) {
			String message= request.getParameter("message");
			for(String username: request.getParameter("all").split(",")) {
				int recId = ud.getUidByUsername(username);
				if(recId!=-1)
					nd.insert(new Notification(0,new java.util.Date(),recId,uid,message,"normal"));
			}
		}
		ArrayList<Notification> all = nd.findBySenderOrReceiverUId(uid);
		String toPrint ="";
		int z=0;
		for (Notification i: all) {
			if(i.getSender() == uid) {
					Student s = new StudentDaos().findByUId(i.getReceiver());
					if(s!=null)
						toPrint += "<div class=\"accordion-group\">" + 
								"                  <div class=\"accordion-heading\">" + 
								"                    <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#"+z+"\">" + 
								"								<i class=\"icon-plus\"></i> "+s.getStudFullName()+" </a>" + 
								"                  </div>" + 
								"                  <div id=\""+z+"\" class=\"accordion-body collapse\">" + 
								"                    <div class=\"accordion-inner\">" + i.getMessage()+ 
								"                    </div>" + 
								"                  </div>" + 
								"                </div>";
					else {
						Tutor t = new TutorDaos().findByUId(i.getReceiver());
						toPrint += "<div class=\"accordion-group\">" + 
								"                  <div class=\"accordion-heading\">" + 
								"                    <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#"+z+"\">" + 
								"								<i class=\"icon-plus\"></i> "+t.getTuFullName()+" </a>" + 
								"                  </div>" + 
								"                  <div id=\""+z+"\" class=\"accordion-body collapse\">" + 
								"                    <div class=\"accordion-inner\">" + i.getMessage()+ 
								"                    </div>" + 
								"                  </div>" + 
								"                </div>";
					}
			}
			else {
				Student s = new StudentDaos().findByUId(i.getSender());
				if(s!=null)
					toPrint += "<div class=\"accordion-group\">" + 
							"                  <div class=\"accordion-heading\">" + 
							"                    <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#"+z+"\">" + 
							"								<i class=\"icon-plus\"></i> "+s.getStudFullName()+" </a>" + 
							"                  </div>" + 
							"                  <div id=\""+z+"\" class=\"accordion-body collapse\">" + 
							"                    <div class=\"accordion-inner\">" + i.getMessage()+ 
							"                    </div>" + 
							"                  </div>" + 
							"                </div>";
				else {
					Tutor t = new TutorDaos().findByUId(i.getSender());
					toPrint +=  "<div class=\"accordion-group\">" + 
							"                  <div class=\"accordion-heading\">" + 
							"                    <a class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#"+z+"\">" + 
							"								<i class=\"icon-plus\"></i> "+t.getTuFullName()+" </a>" + 
							"                  </div>" + 
							"                  <div id=\""+z+"\" class=\"accordion-body collapse\">" + 
							"                    <div class=\"accordion-inner\">" + i.getMessage()+ 
							"                    </div>" + 
							"                  </div>" + 
							"                </div>";
				}
			}
		}
		request.setAttribute("notifications", toPrint);
		request.setAttribute("title", "Dashboard - Notification");
		request.setAttribute("mainPartFile", "Notification.jsp");
		RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
		rs.forward(request, response);
		}
		catch(Exception e) {
			response.sendRedirect("index.html");
		}
		
	}

}
