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
import com.dronado.daos.SubjectDaos;
import com.dronado.daos.TeachesDaos;
import com.dronado.daos.TutorDaos;
import com.dronado.daos.UserDaos;
import com.dronado.pojos.Address;
import com.dronado.pojos.Student;
import com.dronado.pojos.Subject;
import com.dronado.pojos.Teaches;
import com.dronado.pojos.Tutor;
import com.dronado.pojos.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		UserDaos ud = new UserDaos();
		System.out.println(username);
		if (username == null) {
			int uid = -1;
			try {
				uid = Integer.parseInt(""+request.getSession().getAttribute("uid"));
				System.out.println(uid);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("infoMessage", "<a%20class=\\\"alert%20alert-danger\\\">Invalid%20Access</a>");
				request.setAttribute("showSignUp", "true");
				request.setAttribute("showSignIn", "false");
				RequestDispatcher rd = request.getRequestDispatcher("/pages/index.jsp");
				rd.forward(request, response);
				return;
			}
			System.out.println("&"+ud.getUserTypeByUId(uid)+"&");
			if (ud.getUserTypeByUId(uid).equals("")) {
				String type = request.getParameter("userType");
				String fullname = request.getParameter("fullname");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				int addressId = 0;
				if (request.getParameter("new_latitude") != null && request.getParameter("new_longitude") != null
						&& request.getParameter("new_latitude").length() != 0
						&& request.getParameter("new_longitude").length() != 0)
					addressId = new AddressDaos()
							.insert(new Address(Float.parseFloat((String) request.getParameter("new_latitude")),
									Float.parseFloat((String) request.getParameter("new_longitude"))));
				if (type.equals("student")) {
					StudentDaos sd = new StudentDaos();
					Student s = new Student(fullname, email, phone, address, addressId);
					s.setUId(uid);
					s.setPassword(ud.getPasswordByUId(uid));
					s.setUsername(ud.getUsernameByUId(uid));
					s.setUserType("student");
					ud.remove(uid);
					System.out.println(s);
					int sid = sd.insert(s);
					uid = sd.findByStudId(sid).getUId();
					request.getSession().setAttribute("userType", "student");
					

				} else {
					String qualification = "";
					TutorDaos td = new TutorDaos();
					qualification = request.getParameter("qualification");
					Tutor t = new Tutor(fullname, email, phone, address, qualification, addressId);
					t.setUId(uid);
					t.setUsername(ud.getUsernameByUId(uid));
					t.setPassword(ud.getPasswordByUId(uid));
					t.setUserType("tutor");
					ud.remove(uid);
					System.out.println(t);
					int tid = td.insert(t);
					String sname[] = request.getParameterValues("sname");
					String stdFrom[] = request.getParameterValues("stdFrom");
					String stdTo[] = request.getParameterValues("stdTo");
					String stream[] = request.getParameterValues("stream");					
					for (int i=0;i<sname.length;i++) {
						
						int temp = new SubjectDaos().checkExistance(sname[i].toUpperCase(), stream[i].toUpperCase(), stdFrom[i] + "-" + stdTo[i]);
						if(temp==-1)
							temp = new SubjectDaos().insert(new Subject(0,sname[i].toUpperCase(),stdFrom[i]+"-"+stdTo[i],stream[i].toUpperCase()));
						td.addSubjectByTuId(temp, tid);
						TeachesDaos tdu = new TeachesDaos();
						tdu.insert(new Teaches(0,temp,tid,0,"",address,addressId,"0"));
					}
					uid = td.findByTuId(tid).getUId();
					request.getSession().setAttribute("userType", "tutor");
					
				}
				request.getSession().setAttribute("uid", uid);
				
			}
			if(ud.getUserTypeByUId(uid).equalsIgnoreCase("tutor")) {
				System.out.println("forwarding tutor");
				RequestDispatcher rd = request.getRequestDispatcher("TutorDashboard");
				rd.forward(request, response);
				System.out.println("forwarded tutor");
			}
			else if(ud.getUserTypeByUId(uid).equalsIgnoreCase("student")) {
				System.out.println("forwarding student");
				RequestDispatcher rd = request.getRequestDispatcher("StudentDashboard");
				rd.forward(request, response);
				System.out.println("forwarded student");
			}
		} else {
			String password = request.getParameter("pass");
			int uid = ud.getUidByUsername(username);
			if(uid==-1)
				uid = ud.insert(new User(username, password, ""));
			else {
				request.setAttribute("infoMessage", "<a%20class=\\\"alert%20alert-danger\\\">Username%20already%20exists</a>");
				request.setAttribute("showSignUp", "true");
				request.setAttribute("showSignIn", "false");
				RequestDispatcher rd = request.getRequestDispatcher("/pages/index.jsp");
				rd.forward(request, response);
				return;
			}
			request.getSession().setAttribute("uid", uid);
			request.getSession().setAttribute("userType", ud.getUserTypeByUId(uid));
			response.sendRedirect("pages/completeRegistration.jsp");
		}

	}
}
