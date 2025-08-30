package haru.kieu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


import haru.kieu.model.User;
import haru.kieu.service.UserService;
import haru.kieu.service.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/logindb" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserServiceImpl();
	
    //public static final String SESSION_ACCOUNT = "account";
    public static final String SESSION_USERNAME = "username";
    public static final String COOKIE_REMEMBER = "username";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			response.sendRedirect(request.getContextPath() + "/waiting");
			return;
		}

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (COOKIE_REMEMBER.equals(cookie.getName())) {
                    User user = service.findByUserName(cookie.getValue().trim());
                    if (user != null) {
                        session = request.getSession(true);
                        session.setAttribute("account", user);
                        response.sendRedirect(request.getContextPath() + "/waiting");
                        return;
                    }
                }
			}
		}

		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isRememberMe = "on".equals(request.getParameter("remember"));

		String alertMsg = "";

		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			return;
		}

		//UserService service = new UserServiceImpl();
		User user = service.login(username, password);

		if (user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("account", user);
//			System.out.println("DEBUG: user from DB -> id=" + user.getId() + ", username=" + user.getUserName()
//					+ ", password=" + user.getPassWord());

			if (isRememberMe) {
				saveRememberMe(response, username);
			}
			response.sendRedirect(request.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

	private void saveRememberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(COOKIE_REMEMBER, username.trim());
		cookie.setMaxAge(30 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
