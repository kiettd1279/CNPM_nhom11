package controller;

import java.io.IOException;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.ValidateUser;

/**
 * Servlet implementation class servletLogin
 */
@WebServlet("/servletLogin")
public class servletSignInAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletSignInAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lấy thông tin từ trang jsp
		String name = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		//tạo user và gọi hàm kt
		
		User u = new User(name, pass);
		ValidateUser.getListUser();
		String usernameErro ;
		String passwordErro;
		request.setAttribute("userName", name);
		request.setAttribute("pass", pass);
		
		//isValidateUser trả về int : - 0:username vs pass sai 1:username đúng pass sai 2:cả hai đều đúng
		
		
		if (ValidateUser.isValidate(u)==2) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			

		}else if (ValidateUser.isValidate(u)==0) {
			
			usernameErro ="Username không đúng hoặc chưa được đăng ký " ;
			request.setAttribute("usernameErro", usernameErro);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}else {
			passwordErro ="Password không chính xác" ;
			request.setAttribute("username", name);
			request.setAttribute("passwordErro", passwordErro);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			
		}
	}
}
