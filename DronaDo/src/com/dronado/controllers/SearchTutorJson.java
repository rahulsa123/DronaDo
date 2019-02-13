package com.dronado.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dronado.daos.TutorDaos;
import com.dronado.pojos.Tutor;
import com.dronado.pojos.TutorJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class SearchTutorJson
 */
@WebServlet("/SearchTutorJson")
public class SearchTutorJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTutorJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		TutorDaos td = new TutorDaos();
		ArrayList<Tutor> array = td.findAllTutor();
		TutorJson tj = new TutorJson();
		tj.setiTotalDisplayRecords(array.size());
		tj.setiTotalRecords(array.size());
		tj.setAaData(array);
		Gson gs = new GsonBuilder().setPrettyPrinting().create();
		String dataInJson = gs.toJson(tj);
		//System.out.println(dataInJson);
		out.print(dataInJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
