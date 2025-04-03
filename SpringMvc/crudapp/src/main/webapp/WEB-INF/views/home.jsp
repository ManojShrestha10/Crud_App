<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="d-flex justify-content-center align-items-center">
		<div class="container mt-5">
			<h1 class="text-center mb-4">Welcome to Product App</h1>
			<table class="table table-striped table-hover table-bordered">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">About</th>
						<th scope="col">Price</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${product}" var="p">
						<tr>
							<th scope="row">${p.id}</th>
							<td>${p.getName()}</td>
							<td>${p.getAbout()}</td>
							<td>&#8377;${p.getPrice()}</td>
							<td><a href="delete/${p.id}"> <i
									class="fa-solid fa-trash text-danger" style="font-size: 30px"></i></a></td>
							<td><a href="update/${p.id}">
								<i class="fa-solid fa-pen-nib text-warning" style="font-size: 30px"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="d-flex justify-content-center">
		<a href="${pageContext.request.contextPath}/add-product"
			class="btn btn-outline-info">Add Product</a>
	</div>
</body>
</html>
