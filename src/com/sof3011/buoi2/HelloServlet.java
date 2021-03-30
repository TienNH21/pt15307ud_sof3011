package com.sof3011.buoi2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pt15307-ud/hello")
public class HelloServlet extends HttpServlet
{
	@Override
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException, ServletException {
		String param = request.getParameter("name");
		
		String name = param != null ? param : "BugMaker";

		request.setAttribute("myName", name);

		request.getRequestDispatcher("/views/buoi3/hello.jsp")
			.forward(request, response);
	}
	
	@Override
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) {
		//
	}
}
