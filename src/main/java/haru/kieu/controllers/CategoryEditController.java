package haru.kieu.controllers;

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
import java.io.File;
import java.util.List;

import haru.kieu.model.Category;
import haru.kieu.service.CategoryService;
import haru.kieu.service.CategoryServiceImpl;
import haru.kieu.util.Constant;

/**
 * Servlet implementation class CategoryEditController
 */
@WebServlet(urlPatterns = {"/admin/category/edit"})
public class CategoryEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CategoryService cateService = new CategoryServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryEditController() {
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
		Category category = cateService.get(Integer.parseInt(id));
		request.setAttribute("category", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/editcategory.jsp");
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
		//upload.setHeaderEncoding("UTF-8");

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");

			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					switch (item.getFieldName()) {
					case "cateid":
						category.setCateid(Integer.parseInt(item.getString(StandardCharsets.UTF_8)));
						break;
					case "catename":
						category.setCatename(item.getString(StandardCharsets.UTF_8));
						break;
					}
				} else if ("icon".equals(item.getFieldName())) {
					if (item.getSize() > 0) {
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
					} else {
						category.setIcon(null); // giữ icon cũ
					}
				}
			}
			cateService.edit(category);
			response.sendRedirect(request.getContextPath() + "/admin/category/list");
		} catch (FileUploadException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
