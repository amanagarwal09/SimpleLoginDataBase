<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HELLO PAGE</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body style="background-color: #eee;">
	<nav class="navbar navbar-dark navbar-expand-lg bg-dark mb-3">
		<div class="container">
			<a href="#" class="navbar-brand">WELCOME SIMPLE REGISTRATION PAGE</a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="/showAll" class="nav-link">Show
							All</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container ">
		<div class="text-center text-danger">${ sameEmail}</div>
		<div class="text-center text-success">${ nowlogin}</div>
		<form:form modelAttribute="register" action="/submitRegister"
			method="post">
			<div class="form-group ">
				<form:label path="name" for="name">NAME</form:label>
				<form:input path="name" name="name" id="name" class="form-control"
					placeholder="Enter Your Name"
					cssErrorClass="form-control is-invalid" />
				<form:errors path="name" cssClass="invalid-feedback" />
			</div>
			<div class="form-group">
				<form:label path="email" for="email">EMAIL</form:label>
				<form:input path="email" name="email" id="email"
					class="form-control" placeholder="Enter Your Email-ID"
					cssErrorClass="form-control is-invalid" />
				<form:errors path="email" cssClass="invalid-feedback" />

			</div>
			<div class="form-group">
				<form:label path="password" for="password">PASSWORD</form:label>
				<form:password path="password" name="password" id="password"
					class="form-control" placeholder="Enter Your Password"
					cssErrorClass="form-control is-invalid" />
				<form:errors path="password" cssClass="invalid-feedback" />
			</div>
			<div class="form-row">
				<div class="col">
					<button type="submit" class="btn btn-success btn-block">Register</button>
				</div>
				<div class="col">
					<button type="reset" class="btn btn-warning btn-block">Reset</button>
				</div>
			</div>
			<div class="form-row mt-3">
				<div class="col">
					<a href="/" class="btn btn-secondary btn-block text-white">Login
						Now</a>
				</div>
			</div>
		</form:form>
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