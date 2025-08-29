<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/views/topbar.jsp"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>



<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<style>
body {
	background: #f0f2f5;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}

.login-box {
	width: 380px;
	background: #fff;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
}

.login-title {
	font-weight: bold;
	color: #0d6efd;
	text-align: center;
	margin-bottom: 20px;
}

.input-group-text {
	background: #e9ecef;
	border-right: none;
}

.form-control {
	border-left: none;
}

.btn-login {
	border-radius: 8px;
}
</style>
</head>
<body>
	<div class="login-box">
		<h3 class="login-title">
			<i class="fa fa-user-circle"></i> Đăng nhập
		</h3>

		<!-- Thông báo lỗi -->
		<c:if test="${alert != null}">
			<div class="alert alert-danger text-center">${alert}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/logindb"
			method="post">
			<!-- Username -->
			<div class="mb-3">
				<div class="input-group">
					<span class="input-group-text"><i class="fa fa-user"></i></span> <input
						type="text" class="form-control" name="username"
						placeholder="Tên đăng nhập">
				</div>
			</div>

			<!-- Password -->
			<div class="mb-3">
				<div class="input-group">
					<span class="input-group-text"><i class="fa fa-lock"></i></span> <input
						type="password" class="form-control" name="password"
						placeholder="Mật khẩu">
				</div>
			</div>

			<!-- Remember me -->
			<div class="form-check mb-3">
				<input class="form-check-input" type="checkbox" name="remember"
					id="remember"> <label class="form-check-label"
					for="remember">Ghi nhớ đăng nhập</label>
			</div>

			<!-- Button -->
			<button type="submit" class="btn btn-primary w-100 btn-login">
				<i class="fa fa-sign-in-alt"></i> Đăng nhập
			</button>

			<!-- Forgot password -->
			<div class="text-center mt-3">
				<a href="${pageContext.request.contextPath}/forgotpass" class="text-decoration-none">Quên mật khẩu?</a>
			</div>
		</form>

		<div class="text-center mt-3">
			<small>Chưa có tài khoản? <a
				href="${pageContext.request.contextPath}/register"
				class="text-decoration-none"> Đăng ký </a>
			</small>
		</div>
	</div>
</body>
</html>
