<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>
	<div
		class="d-flex justify-content-center align-items-start vh-100 mt-5">
		<div class="col-md-8">
			<div class="card shadow-lg">
				<div class="card-header bg-primary text-white text-center">
					<h2>Update the Product Details</h2>
				</div>
				<div class="card-body">
					<form action="${pageContext.request.contextPath}/handle-product" method="post">
					<div class="form-group mb-3">
							<input
								type="hidden" class="form-control" id="id name="id"
								placeholder="Enter the product name" value="${product.id}">
						</div>
						<div class="form-group mb-3">
							<label for="name" class="form-label">Product Name</label> <input
								type="text" class="form-control" id="name" name="name"
								placeholder="Enter the product name" value="${product.name}">
						</div>
						<div class="form-group mb-3">
							<label for="about" class="form-label">About</label>
							<textarea class="form-control" name="about"
								placeholder="Write about product" id="floatingTextarea"
								style="height: 100px">${product.about}</textarea>
						</div>
						<div class="form-group mb-3">
							<label for="price" class="form-label">Product Price</label> <input
								type="text" placeholder="Enter Product Price" name="price"
								class="form-control" id="price" value="${product.price}">
						</div>
						<div class="d-flex justify-content-between">
							<a href="${pageContext.request.contextPath}/home"
								class="btn btn-outline-danger">Back</a>
							<button class="btn btn-primary" type="submit">Update</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
