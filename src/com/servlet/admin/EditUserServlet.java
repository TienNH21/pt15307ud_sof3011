package com.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/admin/user/edit")
public class EditUserServlet extends HttpServlet {
	private UserDAO userDAO;
    public EditUserServlet() {
        super();
        
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		int id = Integer.parseInt(
				request.getParameter("id")
		);
		
		User entity = this.userDAO.findById(id);
		
		request.setAttribute("user", entity);

		request.getRequestDispatcher("/views/admin/users/edit.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
