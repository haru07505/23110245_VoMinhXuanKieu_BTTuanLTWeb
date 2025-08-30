<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Category List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body class="container mt-4">
	<%@ include file="/views/topbar.jsp"%>
	
	<h2 class="mb-4">Category List</h2>
	<a class="btn btn-primary mb-3"
		href="${pageContext.request.contextPath}/admin/category/add">➕ Add
		Category</a>

	<table class="table table-bordered table-hover">
		<thead class="table-dark">
			<tr>
				<th>STT</th>
				<th>Tên danh mục</th>
				<th>Hình ảnh</th>
				<th>Hành động</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cate" items="${cateList}">
				<tr>
					<td>${cate.cateid}</td>
					<td>${cate.catename}</td>
					<td><c:if test="${not empty cate.icon}">
							<img
								src="${pageContext.request.contextPath}/image?fname=${cate.icon}"
								width="60" class="rounded" />
						</c:if></td>
					<td><a class="btn btn-sm btn-warning"
						href="${pageContext.request.contextPath}/admin/category/edit?id=${cate.cateid}">✏️
							Edit</a> <a class="btn btn-sm btn-danger"
						href="${pageContext.request.contextPath}/admin/category/delete?id=${cate.cateid}"
						onclick="return confirm('Delete this category?')">🗑️ Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
