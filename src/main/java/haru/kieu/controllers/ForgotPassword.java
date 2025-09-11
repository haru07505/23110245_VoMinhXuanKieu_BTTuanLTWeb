package haru.kieu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import haru.kieu.dao.UserDao;
import haru.kieu.dao.UserDaoImpl;
import haru.kieu.model.User;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet(urlPatterns = { "/forgotpass" })
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/forgot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findByUserName(username);
		
		
		if (user != null) {

			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("views/resetpass.jsp").forward(request, response);			
		} else {

			request.setAttribute("error", "Không tìm thấy tài khoản!");
			request.getRequestDispatcher("views/forgot.jsp").forward(request, response);
		}
	}

}
