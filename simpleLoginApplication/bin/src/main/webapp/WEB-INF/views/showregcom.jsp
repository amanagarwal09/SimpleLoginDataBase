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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
		<div class="container">
			<a href="#" class="navbar-brand">WELCOME PAGE</a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="/registerCompany"
						class="nav-link">Register-Company</a></li>
					<li class="nav-item"><a href="showregistercompany"
						class="nav-link">Show-Register-Company</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		${msg }
	</div>
	<div class="container ">
		<div class="table-responsive">
			<table
				class="table table-sm text-center table-bordered mt-3 table-light table-hover">
				<thead class="thead-dark">
					<tr>
						<th>NAME</th>
						<th>COMPANY NAME</th>
						<th>CONTACT</th>
						<th>GENDER</th>
						<th>COUNTRY</th>
						<th>STATE</th>
						<th>CITY</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${getall }" var="list">
						<tr>
							<td>${list.name }</td>
							<td>${list.companyname }</td>
							<td>${list.contact }</td>
							<td>${list.gender }</td>
							<td>${list.country }</td>
							<td>${list.state }</td>
							<td>${list.city }</td>
							<td><a class="btn btn-primary btn-sm"
								href="regComUpdate?id=${list.id }&name=${list.name }&companyname=${list.companyname }&contact=${list.contact}&gender=${list.gender }&state=${list.state }&city=${list.city }&country=${list.country }">Update</a></td>
							<td><a class="btn btn-danger btn-sm" href="regComDelete?id=${list.id }">Delete</a></td>
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