package edu.bo.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myCookie
 */
@WebServlet("/myCookie")
public class myCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String searchString=request.getParameter("searchString");
		String engineName=request.getParameter("searchEngine");
		String numResult=request.getParameter("numResults");
		
		Cookie[] cks=request.getCookies();
		
		Cookie id=null;
		Cookie nickname=null;
		Cookie password=null;
		
		for (Cookie ck : cks)
		{
			if (ck.getName().equals("id"))
				id=ck;
			
			if (ck.getName().equals("nick"))
				nickname=ck;
			
			if (ck.getName().equals("password"))
				password=ck;
				
			
		}
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.println("Hi,"+id.getValue()+"-"+nickname.getValue()+"  "+password.getValue()+"<br>");
		
		Enumeration<String> reqHeader=(Enumeration<String>) request.getHeaderNames();
		
		while(reqHeader.hasMoreElements())
		{
			String reqH=reqHeader.nextElement();
			pw.println("Name: "+reqH+"\tValue: "+request.getHeader(reqH)+"<br>");
			
		}
			
		/*
		pw.println("<br>Response:<br>");
		
		ArrayList<String> resHeader=(ArrayList<String>) response.getHeaderNames();
		
		for (String r:resHeader)
		{
			
			pw.println("Name: "+r+"\tValue: "+response.getHeader(r)+"<br>");
			
			
			
		}
			
		*/
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
