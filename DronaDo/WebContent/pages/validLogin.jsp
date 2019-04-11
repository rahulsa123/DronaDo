<%@page language="java" import="com.dronado.daos.UserDaos"%>
<%
	UserDaos ud = new UserDaos();
	if(ud.validUser(request.getParameter("username"),request.getParameter("password"))==-1){
		out.println("<h4>Invalid Username or Password</h4>");
	}
	else{
		out.println("");
	}
%>
