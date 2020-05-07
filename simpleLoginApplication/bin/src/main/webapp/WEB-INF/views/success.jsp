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
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a href="#" class="navbar-brand">WELCOME PAGE</a>
				<button class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarNav">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="/registerCompany" class="nav-link">Register Company</a></li>
					</ul>
				</div>
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
				<h4 class="card-title">Welcome, ${name }</h4>
				<p class="card-text">A warm welcome and lots of good wishes on
					becoming part of our growing team. Congratulations and on behalf of
					all the members.</p>
				<a class="btn btn-danger text-white" data-toggle="modal"
					data-target="#modal1">Log Out</a>
				<div class="modal" id="modal1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">
									<strong>Warning</strong> to ${name }
								</h5>
								<button class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								Are you sure you want to navigate away from this page?<br>
								You will lose any unsaved modifications to this document.<br>
								Press OK to continue, or Cancel to stay on the current page.
							</div>
							<div class="modal-footer">
								<a class="btn btn-danger" href="/">OK</a>
								<button class="btn btn-info" data-dismiss="modal">Cancel</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-white bg-secondary">Logged in now
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