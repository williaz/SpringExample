<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="simple ATM">
<meta name="author" content="Will Wang">
<link rel="icon" href="../../favicon.ico">

<title>Welcome, Customer!</title>

<!-- Bootstrap core CSS -->
<link href="static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="static/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="static/css/signin.css" rel="stylesheet" type="text/css">

<link href="static/css/navbar-fixed-top.css" rel="stylesheet"
	type="text/css">

<link href="dashboard.css" rel="stylesheet" type="text/css">

</head>

<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="http://www.github.com/williaz/SpringExample/tree/master/SimpleATM">Simple
					ATM</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Operations <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#viewAll">View All Accounts Info</a></li>
							<li><a href="#viewOne">View Specific Customer</a></li>
							<li><a href="#location">Search Customer by Location</a></li>
							<li><a href="#list">See the Result List</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#add">Add New Customer</a></li>
							<li><a href="#changeTempAddress">Change Temporary
									Address</a></li>
							<li><a href="#changePermAddress">Change Permanent
									Address</a></li>
							<li><a href="#changePhone">Change Phone Number</a></li>
							<li><a href="#changePin">Change PIN</a></li>
							<li><a href="#delete">Delete a Customer</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="home">Home</a></li>
					<li><a href="userLogin">User Login</a></li>
					<li class="active"><a href="adminHome">Admin Home</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>




	<!-- ------------- -->


	<div class="container-fluid">
		<div class="row">




			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h3>Display Message:</h3>
				${message}
				<hr>
				<h1 class="page-header">View</h1>

				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">

						<h4 id="viewAll">View All Accounts Info:</h4>
						<form action="./adminHome/all" method="GET">
							All Accounts<input type="submit" name="sumbit" value="view"><br>
						</form>
					</div>

					<div class="col-xs-6 col-sm-3 placeholder">
						<h4 id="viewOne">View Specific Customer:</h4>
						<form action="./adminHome/one" method="GET">

							Account number <input type="search" name="id"> <input
								type="submit" name="sumbit" value="view"><br>

						</form>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4 id="location">Search Customer by Location</h4>
						<form action="./adminHome/location" method="GET">

							Permanent Address<input type="search" name="permAddress">

							<input type="submit" name="sumbit" value="findByLocation"><br>

						</form>
					</div>

				</div>


				<!-- list ------------->

				<h2 id="list" class="sub-header">Result List</h2>
				<div class="table-responsive">
					<table class="table table-striped">

						<thead>
							<tr>
								<th scope="col">Account Number</th>
								<th scope="col">Name</th>
								<th scope="col">Account Type</th>
								<th scope="col">Temporary Address</th>
								<th scope="col">Permanent Address</th>
								<th scope="col">Phone Number</th>
								<th scope="col">Join Date</th>
								<th scope="col">Balance</th>
								<th scope="col">Password</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reports}" var="customer">
								<tr>
									<td>${customer.id}</td>
									<td>${customer.type}</td>
									<td>${customer.name}</td>
									<td>${customer.tempAddress}</td>
									<td>${customer.permAddress}</td>
									<td>${customer.mobile}</td>
									<td>${customer.joinDate}</td>
									<td>${customer.balance}</td>
									<td>${customer.pin}</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
				<!-- -------------------list -->


				<!-- add -->
				<h2 id="add">Add New Customer:</h2>
				<fieldset>
					<legend>Customer Details</legend>
					<form action="./adminHome/form" method="Post">

						Account number <input type="text" name="id" maxlength="20"
							required="required"> <br> Account type: <input
							type="radio" name="type" value="saving" checked="checked">saving
						<input type="radio" name="type" value="checking">checking<br>
						Name <input type="text" name="name" placeholder="Enter Full Name">
						<br> Temporary Address <select name="tempAddress">
							<option value="Boston">Boston</option>
							<option value="Edison">Edison</option>
							<option value="Harrison">Harrison</option>
							<option value="Jersey City">Jersey City</option>
							<option value="DC">DC</option>
							<option value="Hawii">Hawii</option>
							<option value="Newark">Newark</option>
						</select><br> Permanent Address <select name="permAddress">
							<option value="USA">USA</option>
							<option value="UK">UK</option>
							<option value="China">China</option>
							<option value="Brazil">Brazil</option>
							<option value="India">India</option>
							<option value="Korea">Korea</option>
						</select><br> Phone Number<input type="text" name="mobile"
							maxlength="10" required="required" /> <br> Join Date<input
							type="date" name="joinDate" /> <br>
						<!-- Formate(yyyy-[m]m-[d]d) -->
						Balance<input type="text" name="balance" required="required"
							placeholder="$$$$" /> <br> PIN<input type="password"
							name="pin" maxlength="4" required="required" /> <br> <input
							type="submit" name="sumbit" value="add" />
					</form>
				</fieldset>
				<br>



				<!-- ============ -->

				<div class="page-header"></div>
				<div class="row">
					<div class="col-sm-4">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 id="changeTempAddress" class="panel-title">Change
									Temporary Address</h3>
							</div>
							<div class="panel-body">
								<form action="./adminHome/form" method="Post">

									Account number <input type="text" name="id"> <br>

									Temporary Address<input type="text" name="tempAddress">
									<br> <input type="submit" name="sumbit" value="update"><br>

								</form>
							</div>
						</div>
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 id="changePermAddress" class="panel-title">Change
									Permanent Address</h3>
							</div>
							<div class="panel-body">

								<form action="./adminHome/form" method="Post">

									Account number <input type="text" name="id"> <br>

									Permanent Address<input type="text" name="permAddress">
									<br> <input type="submit" name="sumbit" value="update"><br>

								</form>
							</div>
						</div>
					</div>
					<!-- /.col-sm-4 -->
					<div class="col-sm-4">
						<div class="panel panel-success">
							<div class="panel-heading">
								<h3 id="changePhone" class="panel-title">Change Phone
									Number</h3>
							</div>
							<div class="panel-body">
								<form action="./adminHome/form" method="Post">

									Account number <input type="text" name="id"> <br>

									Phone Number<input type="text" name="mobile"> <br>
									<input type="submit" name="sumbit" value="update"><br>

								</form>
							</div>
						</div>
						<div class="panel panel-warning">
							<div class="panel-heading">
								<h3 id="changePin" class="panel-title">Change PIN</h3>
							</div>
							<div class="panel-body">
								<form action="./adminHome/form" method="Post">

									Account number <input type="text" name="id"> <br>
									PIN<input type="text" name="pin"> <br> <input
										type="submit" name="sumbit" value="update"><br>

								</form>
							</div>
						</div>
					</div>
					<!-- /.col-sm-4 -->
					<div class="col-sm-4">
						<div class="panel panel-danger">
							<div class="panel-heading">
								<h3 id="delete" class="panel-title">Delete a Customer</h3>
							</div>
							<div class="panel-body">

								<form action="./adminHome/delete" method="GET">

									Account number <input type="text" name="id"> <input
										type="submit" name="sumbit" value="delete"><br>

								</form>
							</div>
						</div>
					</div>
					<!-- /.col-sm-4 -->
				</div>

				<!-- ---======= -->
			</div>
		</div>
		<!-- ----------------------------- -->


	</div>
</body>
</html>