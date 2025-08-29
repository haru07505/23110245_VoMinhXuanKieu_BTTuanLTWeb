<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt lại mật khẩu</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body
	class="bg-light d-flex align-items-center justify-content-center vh-100">
	<div class="card shadow-lg p-4" style="max-width: 420px; width: 100%;">
		<h3 class="text-center mb-3">Đặt lại mật khẩu</h3>
		<p class="text-muted text-center">Nhập mật khẩu mới của bạn.</p>

		<form action="${pageContext.request.contextPath}/resetpass" method="post">
			<!-- Truyền hidden username/email từ forgot.jsp qua -->
			<input type="hidden" name="username"
				value="${username}">

			<div class="mb-3">
				<label for="newPassword" class="form-label">Mật khẩu mới</label> <input
					type="password" class="form-control" id="newPassword"
					name="newPassword" required>
			</div>

			<div class="mb-3">
				<label for="confirmPassword" class="form-label">Xác nhận mật
					khẩu</label> <input type="password" class="form-control"
					id="confirmPassword" name="confirmPassword" required>
			</div>

			<button type="submit" class="btn btn-success w-100">Cập nhật
				mật khẩu</button>
		</form>

		<div class="text-center mt-3">
			<a href="${pageContext.request.contextPath}/logindb" class="text-decoration-none">Quay lại đăng
				nhập</a>
		</div>
	</div>
</body>
</html>
