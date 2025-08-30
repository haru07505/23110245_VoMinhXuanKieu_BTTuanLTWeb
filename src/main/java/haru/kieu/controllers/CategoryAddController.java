package haru.kieu.controllers;

import haru.kieu.model.Category;
import haru.kieu.service.CategoryService;
import haru.kieu.service.CategoryServiceImpl;
import haru.kieu.util.Constant;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.core.FileUploadException;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
//import java.nio.charset.StandardCharsets;
import java.io.File;
import java.util.List;


/**
 * Servlet implementation class CategoryAddController
 */
@WebServlet(urlPatterns = {"/admin/category/add"})
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryService cateService = new CategoryServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryAddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/addcategory.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = new Category();
		DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
        JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					if ("catename".equals(item.getFieldName())) {
						category.setCatename(item.getString(StandardCharsets.UTF_8));
					}
				} else {
					if ("icon".equals(item.getFieldName()) && item.getSize() > 0) {
						String original = item.getName();
						int dot = original.lastIndexOf('.');
						String ext = (dot >= 0) ? original.substring(dot + 1) : "";
						String fileName = System.currentTimeMillis() + (ext.isEmpty() ? "" : "." + ext);

						File dir = new File(Constant.DIR + "/category");
						if (!dir.exists())
							dir.mkdirs();

						File file = new File(dir, fileName);
						item.write(file.toPath());

						category.setIcon("category/" + fileName);
					}
				}
			}
			cateService.insert(category);
			response.sendRedirect(request.getContextPath() + "/admin/category/list");
		} catch (FileUploadException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
