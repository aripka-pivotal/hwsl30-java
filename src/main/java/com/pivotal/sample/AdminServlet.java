package com.pivotal.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;

@WebServlet(name="admin", urlPatterns={"/admin"})
public class AdminServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h2>Admin Servlet</h2>");
		CsrfToken  token = (CsrfToken)req.getAttribute("_csrf");
		out.println("<form class=\"form-inline\" action=\"./logout\" method=\"post\"><input type=\"submit\" value=\"Log out\" /><input type=\"hidden\" name=\""+token.getParameterName()+"\" value=\""+token.getToken()+"\"/></form>");
		out.close();
		
	}
	
	

}
