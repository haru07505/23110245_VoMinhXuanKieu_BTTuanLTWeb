<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container d-flex justify-content-center align-items-center"
		style="height: 100vh;">
		<div class="card shadow-lg p-4"
			style="width: 400px; border-radius: 20px;">
			<h3 class="text-center mb-3">Quên mật khẩu</h3>
			<p class="text-muted text-center small mb-4">Nhập email hoặc tên
				tài khoản để đặt lại mật khẩu</p>

			<form action="${pageContext.request.contextPath}/forgotpass" method="post">
				<div class="mb-3">
					<label for="email" class="form-label">Email / Username</label> <input
						type="text" class="form-control" id="username" name="username"
						placeholder="Nhập email hoặc username" required>
				</div>

				<button type="submit" class="btn btn-primary w-100"
					style="border-radius: 30px;">Tiếp tục</button>

				<div class="text-center mt-3">
					<a href="${pageContext.request.contextPath}/logindb" class="text-decoration-none">Quay lại đăng
						nhập</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
