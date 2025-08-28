<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Thanh topbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<!-- Logo -->
		<a class="navbar-brand" href="${pageContext.request.contextPath}/home">MyWebsite</a>

		<!-- Nút toggle cho mobile -->
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- Menu -->
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ms-auto">
				<c:choose>
					
					<c:when test="${sessionScope.account == null}">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath }/logindb">Đăng nhập</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath }/register">Đăng ký</a></li>
					</c:when>

					
					<c:otherwise>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath }/member/myaccount">
								<i class="fa fa-user"></i> ${sessionScope.account.fullName}
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath }/logoutcontroller">Đăng Xuất</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>

<!-- Bootstrap 5 + FontAwesome -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
