package haru.kieu.reset;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import haru.kieu.dao.UserDaoImpl;
import haru.kieu.model.User;
import haru.kieu.dao.UserDao;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/resetpass")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/resetpass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");;

		if (username == null || username.isEmpty() || newPassword == null || newPassword.isEmpty() || 
				confirmPassword == null || confirmPassword.isEmpty()) {
			request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin.");
			request.setAttribute("username", username);
			request.getRequestDispatcher("views/forgot.jsp").forward(request, response);
			return;
		}

		UserDao dao = new UserDaoImpl();
		User user = dao.findByUserName(username.trim()); // kiểm tra user có tồn tại
		
		if (user != null) {
			boolean updated = dao.updatePassword(user.getId(), newPassword); // update theo ID
			
			if (updated) {
				request.setAttribute("message", "Đổi mật khẩu thành công! Mời bạn đăng nhập lại.");
				request.getRequestDispatcher("views/login.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Có lỗi xảy ra khi đổi mật khẩu, thử lại!");
				request.getRequestDispatcher("views/resetpass.jsp").forward(request, response);
			}
		}

	}

}
