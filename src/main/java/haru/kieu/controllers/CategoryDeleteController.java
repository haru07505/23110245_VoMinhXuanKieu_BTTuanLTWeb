package haru.kieu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import haru.kieu.service.CategoryService;
import haru.kieu.service.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryDeleteController
 */
@WebServlet(urlPatterns = { "/admin/category/delete" })
public class CategoryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryService cateService = new CategoryServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		cateService.delete(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath() + "/admin/category/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
