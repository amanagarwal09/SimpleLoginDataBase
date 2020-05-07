<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
						<li class="nav-item"><a href="/registerCompany"
							class="nav-link">Register-Company</a></li>
						<li class="nav-item"><a href="showregistercompany"
							class="nav-link">Show-Register-Company</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div style="margin-top: 80px;"></div>
	<div class="container">${msg }</div>
	
	<div class="container ">
		<form:form modelAttribute="registercompany" action="/registercompany"
			method="post">
			<div class="form-group ">
				<form:label path="name" for="name">NAME</form:label>
				<form:input path="name" name="name" id="name" class="form-control"
					placeholder="Enter Your Name"
					cssErrorClass="form-control is-invalid" />
				<form:errors path="name" cssClass="invalid-feedback" />
			</div>
			<div class="form-group ">
				<form:label path="companyname" for="companyname">COMPANY NAME</form:label>
				<form:input path="companyname" name="companyname" id="companyname"
					class="form-control" placeholder="Enter Your Company Name"
					cssErrorClass="form-control is-invalid" />
				<form:errors path="companyname" cssClass="invalid-feedback" />
			</div>
			<div class="form-group ">
				<form:label path="contact" for="contact">CONTACT NUMBER</form:label>
				<form:input path="contact" name="contact" id="contact"
					class="form-control" placeholder="Enter Your Contact Number"
					cssErrorClass="form-control is-invalid" />
				<form:errors path="contact" cssClass="invalid-feedback" />
			</div>
			<div class="form-group ">
				<form:label path="gender">Male</form:label>
				<form:radiobutton path="gender" name="gender" id="gender"
					value="Male"/>
				<form:label path="gender">Female</form:label>
				<form:radiobutton path="gender" name="gender" id="gender"
					value="Female" />
				<small class="text-danger ml-5"><form:errors path="gender" /></small>
			</div>
			<div class="form-group">
				<form:label path="country" for="country">COUNTRY</form:label>
				<form:select path="country" id="country" cssClass="form-control"
					cssErrorClass="form-control is-invalid">
					<form:option value="Choose">Choose</form:option>
				</form:select>
				<form:errors path="country" cssClass="invalid-feedback" />
			</div>
			<div class="form-group">
				<form:label path="state" for="state">STATE</form:label>
				<form:select path="state" id="state" cssClass="form-control"
					cssErrorClass="form-control is-invalid">
					<form:option value="Choose">Choose</form:option>
				</form:select>
				<form:errors path="state" cssClass="invalid-feedback" />
			</div>
			<div class="form-group">
				<form:label path="city" for="city">CITY</form:label>
				<form:select path="city" id="city" cssClass="form-control"
					cssErrorClass="form-control is-invalid">
					<form:option value="Choose">Choose</form:option>
				</form:select>
				<form:errors path="city" cssClass="invalid-feedback" />
			</div>
			<div class="form-row">
				<div class="col">
					<button type="submit" class="btn btn-success btn-block">Register
						Company</button>
				</div>
				<div class="col">
					<button type="reset" class="btn btn-warning btn-block">Reset</button>
				</div>
			</div>
		</form:form>
	</div>
	<div style="margin-top: 100px"></div>
	<nav class="navbar navbar-dark bg-dark mt-3 fixed-bottom">
		<div class="container">
			<a href="#" class="navbar-brand">COPYRIGHT SIMPLE REGISTRATION
				&copy; 2020</a>
		</div>
	</nav>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script>
		$('#myAlert').on('closed.bs.alert', function() {
			console.log('Alert closed...');
		})
		var countrystate = {
			"India" : {
				"WB" : [ "Kolkata", "Howrah", "Assansol" ],
				"UP" : [ "Meerut", "Luckhnow" ],
				"Maharastra" : [ "Pune", "Mumbai" ]
			},
			"USA" : {
				"Michigan" : [ "Lansing" ],
				"New York" : [ "Albany" ]
			},
			"France" : {
				"Limousin" : [ "Tulle" ],
				"Bourgogne" : [ "Auxerre" ]
			}
		}
		window.onload = function() {
			var countrySel = document.getElementById("country");
			var stateSel = document.getElementById("state");
			var citySel = document.getElementById("city");
			for ( var country in countrystate) {
				countrySel.options[countrySel.options.length] = new Option(
						country, country)
			}

			countrySel.onchange = function() {
				stateSel.length = 1;
				citySel.length = 1;
				if (this.selectIndex < 1)
					return;
				for ( var state in countrystate[this.value]) {
					stateSel.options[stateSel.options.length] = new Option(
							state, state);
				}
			}

			stateSel.onchange = function() {
				citySel.length = 1;
				if (this.selectedIndex < 1)
					return;

				var c = countrystate[countrySel.value][this.value];
				for (var i = 0; i < c.length; i++) {
					citySel.options[citySel.options.length] = new Option(c[i],
							c[i]);
				}

			}

		}
	</script>
</body>
</html>