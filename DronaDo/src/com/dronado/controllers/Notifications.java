package com.dronado.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
import com.dronado.utilities.DateUtils;

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
		uid = (int)session.getAttribute("uid");
		NotificationDaos nd = new NotificationDaos();
		UserDaos ud = new UserDaos();
		if(request.getParameter("isFormSubmitted")!=null && request.getParameter("isFormSubmitted").equalsIgnoreCase("true")) {
			String message= request.getParameter("message");
			System.out.println("users"+request.getParameter("all"));
			System.out.println("message"+message);
			if(request.getParameter("all")!=null){
			for(String username: request.getParameter("all").split(",")) {
				int recId = ud.getUidByUsername(username);
				if(recId!=-1)
					nd.insert(new Notification(0,new java.util.Date(),recId,uid,message,"normal"));
			}
			}
		}
		ArrayList<Notification> all = nd.findBySenderOrReceiverUId(uid);
		String toPrint ="";
		int z=0;
		for (Notification i: all) {
			if(i.getSender() == uid) {
					Student s = new StudentDaos().findByUId(i.getReceiver());
					if(s!=null)
						toPrint += "<div class=\"accordion-group \">" + 
								"                  <div class=\"accordion-heading \">" + 
								"                    <input  type=\"button\" class=\"accordion-toggle  dropdown-toggle btn btn-primary\" style=\"width:100%;text-align: left;\" value=\""+"<<<< "+s.getStudFullName()+"(Student) At : "+ DateUtils.DateToString(i.getDate())+ 
														"\" onclick =\" popupmessage("+z+");\">"+
								"								<i class=\"icon-plus\"></i>\n"+ 
								"                  </div>" + 
								"                  <div id=\""+z+"\" class=\"accordion-body collapse card \" >" + 
								"                    <div class=\"accordion-inner  card-body  ml-5 \">" + i.getMessage()+ 
								"                    </div>" + 
								"                  </div>" + 
								"                </div> <br>";
					else {
						Tutor t = new TutorDaos().findByUId(i.getReceiver());
						toPrint += "<div class=\"accordion-group \">\n" + 
								"                  <div class=\"accordion-heading\">\n" + 
								"                    <input type=\"button\" class=\"accordion-toggle dropdown-toggle btn btn-primary \"  style=\"width:100%;text-align: left;\" value=\""+"<<<< "+t.getTuFullName()+"(Tutor) At : "+ DateUtils.DateToString(i.getDate())+ 
														"\" onclick =\" popupmessage("+z+");\">"+
														"\n" +	"<i class=\"icon-plus\"></i>"+"\n" + 
								"                  </div>" + 
								"                  <div id=\""+z+"\" class=\"card \" style=\"display:none;margin:0px 0px 0px 0px;\" >\n" + 
								"                    <div class=\" card-body ml-5 \">" + i.getMessage()+ 
								"                    </div>\n" + 
								"                  </div>\n" + 
								"                </div>\n <br>";
					}
			}
			else {
				Student s = new StudentDaos().findByUId(i.getSender());
				if(s!=null)
					toPrint += "<div class=\"accordion-group \">" + 
							"                  <div class=\"accordion-heading \">" + 
							"                    <input type=\"button\" class=\"accordion-toggle  dropdown-toggle btn btn-primary \" style=\"width:100%;text-align: left;\" value=\""+">>>> "+s.getStudFullName()+"(Student) At : "+ DateUtils.DateToString(i.getDate())+   
												"\" onclick =\" popupmessage("+z+");\">"+
							"								<i class=\"icon-plus\"></i> \n"+ 
							"                  </div>" + 
							"                  <div id=\""+z+"\" class=\"accordion-body collapse card  \" >" + 
							"                    <div class=\"accordion-inner  card-body  ml-5\">" + i.getMessage()+ 
							"                    </div>" + 
							"                  </div>" + 
							"                </div> <br>";
				else {
					Tutor t = new TutorDaos().findByUId(i.getSender());
					toPrint +=  "<div class=\"accordion-group \">\n" + 
							"                  <div class=\"accordion-heading\">\n" + 
							"                    <input type=\"button\" class=\"accordion-toggle dropdown-toggle btn btn-primary \" style=\"width:100%;text-align: left;\" value=\""+">>>> "+t.getTuFullName()+"(Tutor) At : "+ DateUtils.DateToString(i.getDate())+"\n" + 
											"\" onclick =\" popupmessage("+z+");\">"+
							"								<i class=\"icon-plus\"></i> "+ 
							"                  </div>\n" + 
							"                  <div id=\""+z+"\" class=\"accordion-body collapse card\" >\n" + 
							"                    <div class=\"accordion-inner card-body ml-5 \">" + i.getMessage()+ 
							"                    </div>\n" + 
							"                  </div>\n" + 
							"                </div>\n <br>";
				}
			}
			z+=1;
		}
		request.setAttribute("notifications", toPrint);
		//System.out.println(toPrint);
		request.setAttribute("title", "Dashboard - Notification");
		request.setAttribute("mainPartFile", "Notification.jsp");
		RequestDispatcher rs = request.getRequestDispatcher("/pages/Dashboard.jsp");
		rs.forward(request, response);
		}
		catch(Exception e) {
			//System.out.println(e);
			e.printStackTrace();
			response.sendRedirect("/DronaDo/pages/index.jsp");
		}
		
	}

}
