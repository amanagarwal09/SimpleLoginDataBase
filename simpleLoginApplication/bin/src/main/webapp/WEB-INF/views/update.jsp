<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<title>HELLO PAGE</title>
</head>
<body style="background-color: #eee;">
	<div class="container">
		<nav class="navbar navbar-dark bg-dark fixed-top">
			<div class="container">
				<a href="#" class="navbar-brand">WELCOME UPDATE PAGE</a>
			</div>
		</nav>
	</div>
	<div style="margin-top: 80px;"></div>
	<div class="container ">
		<form action="update" method="post">
			<div class="form-group ">
				<label for="name">UPDATE NAME</label> <input type="text" name="name"
					id="name" class="form-control" placeholder="Update Your Name"
					value="${name }" required="required"/>
			</div>
			<div class="form-group ">
				<label for="email">EMAIL</label> <input type="email" name="email"
					id="email" class="form-control" placeholder="Enter Your Email"
					value="${email }" readonly="readonly" required="required" />
			</div>
			<div class="form-group ">
				<label for="name">CONFIRM PASSWORD</label> <input type="password"
					name="password" id="password" class="form-control"
					placeholder="Confirm Your Password" required="required"/>
			</div>
			<button type="submit" class="btn btn-success btn-block">Update</button>
		</form>
	</div>
	<div class="container">
		<nav class="navbar navbar-dark bg-dark fixed-bottom">
			<div class="container">
				<a href="#" class="navbar-brand">COPYRIGHT UPDATE PAGE &copy;
					2020</a>
			</div>
		</nav>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script>
		$('#myAlert').on('closed.bs.alert', function() {
			console.log('Alert closed...');
		})
	</script>
</body>
</html>