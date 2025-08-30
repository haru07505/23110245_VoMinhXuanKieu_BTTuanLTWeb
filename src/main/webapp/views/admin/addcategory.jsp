<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-4">
<h2 class="mb-4">➕ Add New Category</h2>
<form action="${pageContext.request.contextPath}/admin/category/add" method="post" enctype="multipart/form-data" class="border p-4 rounded shadow-sm bg-light">
    <div class="mb-3">
        <label class="form-label">Name:</label>
        <input type="text" name="catename" class="form-control" required/>
    </div>
    <div class="mb-3">
        <label class="form-label">Icon:</label>
        <input type="file" name="icon" class="form-control"/>
    </div>
    <button type="submit" class="btn btn-success">Save</button>
    <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-secondary">Back</a>
</form>
</body>
</html>
