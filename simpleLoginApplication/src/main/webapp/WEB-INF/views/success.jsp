<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body style="background-color: #eee">
	<div class="container">
		<nav class="navbar navbar-dark bg-dark fixed-top">
			<div class="container">
				<a href="#" class="navbar-brand">WELCOME PAGE</a>
			</div>
		</nav>
	</div>
	<div style="margin-top: 80px;"></div>
	<div class="container ">
		
		<div class="card text-center border-secondary">
			<div class="card-header text-white bg-secondary">
				<strong>My-Info</strong>
			</div>
			<div class="card-body">
				<h4 class="card-title">Welcome, ${userid }</h4>
				<a class="btn btn-danger text-white" href="/" >Log Out</a>
			</div>
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