package com.jlcindia.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{

	public LoginServlet(){System.out.println("Servlet-DC");}
	@Override
	public void init() throws ServletException {
		System.out.println("init method called");
		
	}
	    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("service method called");
		String msg=req.getParameter("name");
		
		
		if(msg.trim().equals("ashish")){
			RequestDispatcher rd1 = req.getRequestDispatcher("header.html");
			 rd1.include(req, res);
			
			 
			RequestDispatcher rd = req.getRequestDispatcher("home.html");
			rd.include(req, res);
			
			 RequestDispatcher rd2 = req.getRequestDispatcher("footer.html");
			 rd2.include(req, res);
			
		}else
		if(msg.trim().equals("facebookpage")){
			res.sendRedirect("http://www.facebook.com");
		}else
		
		{
			
			
		PrintWriter out = res.getWriter();
		RequestDispatcher rd1 = req.getRequestDispatcher("header.html");
		 rd1.include(req, res);
		out.write("<h1>");
		out.write(msg);
		ServletConfig cfg = getServletConfig();
		String email = cfg.getInitParameter("email");
		
		ServletContext ctx = cfg.getServletContext();
		String website = ctx.getInitParameter("website");
		out.write("<br>");
		out.write(email);
		out.write("<br>");
		out.write(website);
		RequestDispatcher rd = req.getRequestDispatcher("footer.html");
		rd.include(req, res);
		}
		
	}
	///adding one to 1st branch
	@Override
	public void destroy() {
		System.out.println("destroy method called");
	}
}
