package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDAO;

/**
 * Servlet implementation class servletSignUp
 */
@WebServlet("/servletSignUp")
public class servletSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletSignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		User user = new User(username, email, pass);
		UserDAO.getListUser();
	
		if (UserDAO.inserUser(user)) {
			for (int i = 0; i < UserDAO.listUser.size(); i++) {
				System.out.println(UserDAO.listUser.get(i).getUser()
						+" = " +UserDAO.listUser.get(i).getPassword());
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			rd.forward(request, response);

		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/signUp");
			rd.forward(request, response);
		}
	}

}
