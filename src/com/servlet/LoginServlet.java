package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserDAO userDAO;

    public LoginServlet() {
        super();
        
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String view = "/views/auth/login.jsp";
		request.setAttribute("view", view);
		
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User entity = this.userDAO.login(email, password);
		
		if (entity == null) {
			request.setAttribute("error", "Đăng nhập thất bại");
			
			response.sendRedirect("/PT15307UD/login");
		}
		
		response.sendRedirect("/PT15307UD/users");
	}

}
