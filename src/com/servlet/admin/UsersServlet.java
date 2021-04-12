package com.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;
import com.utils.HibernateUtils;

@WebServlet({
	"/admin/users",
	"/admin/users/delete",
})
public class UsersServlet extends HttpServlet {
	private UserDAO userDAO;

    public UsersServlet() {
        super();
        
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String pageStr = request.getParameter("page"),
			limitStr = request.getParameter("limit");

		int page = pageStr == null ? 1 : Integer.parseInt(pageStr),
			limit = limitStr == null ? 10 : Integer.parseInt(limitStr),
			offset = limit * (page - 1);
		
		List<User> listUser = this.userDAO.paginate(offset, limit);
		
//		TypedQuery<User> query = HibernateUtils.getSession().createNamedQuery(
//			"User.loadActiveUser", User.class);
//		List<User> listUser = query.getResultList();
		
		request.setAttribute("listUser", listUser);
		request.setAttribute("page", page);
		request.setAttribute("view", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	@Override
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		
		if (idStr == null) {
			// Bad request
		}
		
		int id = Integer.parseInt(idStr);
		
		User entity = new User();

		entity.setId(id);

		this.userDAO.delete(entity);
		
		response.sendRedirect("/PT15307UD/users");
	}

}
