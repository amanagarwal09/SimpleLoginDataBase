<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<title>HELLO PAGE</title>
</head>
<body style="background-color: #eee;">
	<!-- <div class="container"> -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
			<div class="container">
				<a href="/" class="navbar-brand navbar-brand-sm">WELCOME SIMPLE REGISTRATION
					PAGE</a>
				<button class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarNav">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="/" class="nav-link">Login</a></li>
						<li class="nav-item"><a href="/registerPage" class="nav-link">Register</a></li>
					</ul>
				</div>
				</div>
		</nav>
	<!-- </div> -->
	<div class="container ">
		<div class="text-center text-success">${ updatedonemsg}</div>
		<div class="text-center text-warning">${ updatenotdonemsg}</div>
		<div class="text-center text-success">${ deletedonemsg}</div>
		<div class="text-center text-warning">${ deletenotdonemsg}</div>
		<div class="text-center text-danger">${ checkpass}</div>
		<div class="table-responsive">
		<table class="table table-sm text-center table-bordered mt-3 table-light table-hover">
			<thead class="thead-dark">
				<tr>
					<th>NAME</th>
					<th>EMAIL</th>
					<th>PASSWORD</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				${nothing }
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.name }</td>
						<td>${list.email }</td>
						<td>${list.password }</td>
						<td><a href="update?name=${list.name }&email=${list.email }"
							class="btn btn-primary">Update</a></td>
						<td><a href="delete?email=${list.email }"
							class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark fixed-bottom">
			<div class="container">
				<a href="#" class="navbar-brand">COPYRIGHT SIMPLE REGISTRATION
					&copy; 2020</a>
			</div>
		</nav>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script>
		$('#myAlert').on('closed.bs.alert', function() {
			console.log('Alert closed...');
		})
	</script>
</body>
</html>