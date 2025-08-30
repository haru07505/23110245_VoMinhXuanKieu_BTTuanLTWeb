<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Edit Category</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body class="container mt-4">
	<h2 class="mb-4">✏️ Edit Category</h2>
	<form action="${pageContext.request.contextPath}/admin/category/edit"
		method="post" enctype="multipart/form-data"
		class="border p-4 rounded shadow-sm bg-light">
		<input type="hidden" name="cateid" value="${category.cateid}" />

		<div class="mb-3">
			<label class="form-label">Name:</label> <input type="text"
				name="catename" value="${category.catename}" class="form-control" required />
		</div>

		<div class="mb-3">
			<label class="form-label">Current Icon:</label><br />
			<c:if test="${not empty category.icon}">
				<img
					src="${pageContext.request.contextPath}/image?fname=${category.icon}"
					width="80" class="rounded border" />
			</c:if>
		</div>

		<div class="mb-3">
			<label class="form-label">New Icon (optional):</label> <input
				type="file" name="icon" class="form-control" />
		</div>

		<button type="submit" class="btn btn-primary">Update</button>
		<a href="${pageContext.request.contextPath}/admin/category/list"
			class="btn btn-secondary">Back</a>
	</form>
</body>
</html>
