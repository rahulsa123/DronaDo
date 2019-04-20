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

import com.dronado.daos.AdminDaos;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDaos ad = new AdminDaos();
		String tableName = (String)request.getParameter("tableName");
		System.out.println((String)request.getParameter("operation"));
		if(request.getParameter("operation")!=null &&((String)request.getParameter("operation")).equalsIgnoreCase("remove")) {
			String colName = (String)request.getParameter("colname");
			int value = Integer.parseInt(request.getParameter("v"));
			ad.removeDataOfTable(tableName, colName, value);
		}
		if(tableName!=null) {
			request.setAttribute("tableName", tableName);
			ArrayList<String> column = ad.getAllColumnNameOfTable(tableName);
			request.setAttribute("column", column);
			RequestDispatcher rs = request.getRequestDispatcher("/pages/AdminEdit.jsp");
			rs.forward(request, response);
			return;
		}
		
		
		ArrayList<String> tables = ad.getAllTableName();
		HashMap<String, ArrayList<String>> tableAndColumn = new HashMap<String, ArrayList<String>> ();
		for(String table: tables) {
			tableAndColumn.put(table, ad.getAllColumnNameOfTable(table));
		}
		request.setAttribute("tableAndColumn", tableAndColumn);
		RequestDispatcher rs = request.getRequestDispatcher("/pages/AdminHome.jsp");
		rs.forward(request, response);
		return;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in admin home doPost");
		doGet(request, response);
	}

}
