package com.dronado.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ProfileImage
 */
@WebServlet("/ProfileImage")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class ProfileImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileImage() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//System.out.println("app path"+request.getServletContext().getRealPath(""));
		String img = request.getServletContext().getRealPath("")+"/img/"+"profile"+(Integer)session.getAttribute("uid");
		for(Part p : request.getParts()) {
			System.out.println(p.getName());
			if(p.getName().equalsIgnoreCase("NewProfileImage"))
				p.write(img);
		}
		File  f = new File(request.getServletContext().getRealPath("")+"\\img\\"+"profile"+(Integer)session.getAttribute("uid"));
		System.out.println("about file"+f.getAbsolutePath()+"  "+f.exists());
		RequestDispatcher rs = request.getRequestDispatcher("/Profile");
		rs.forward(request, response);
		//System.out.println(img);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
