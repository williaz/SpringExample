<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin control station</title>

<style>
table, th, td {
    border: 0.5px solid black;
}
</style>

</head>
<body>

<h3>Display Message:</h3>
${message}<hr>

<!-- top -->
<h1 id="top">To Do </h1>
<ol>
<li><a href="#viewAll">View All Accounts Info</a></li>
<li><a href="#viewOne">View Specific Customer</a></li>
<li><a href="#location">Search Customer by Location</a></li>
<li><a href="#list">See the Result List</a></li>
<li><a href="#add">Add New Customer</a></li>
<li><a href="#changeTempAddress">Change Temporary Address</a></li>
<li><a href="#changePermAddress">Change Permanent Address</a></li>
<li><a href="#changePhone">Change Phone Number</a></li>
<li><a href="#changePin">Change PIN</a></li>
<li><a href="#delete">Delete a Customer</a></li>
<li><a href="home">Back to Home page</a></li>
</ol>


<hr>

<!-- view all -->
<h2 id="viewAll">View All Accounts Info:</h2>
<form action="./adminHome/all" method="GET" >


All Accounts<input type="submit" name="sumbit" value="view" ><br>

</form>

<!-- view one -->

<h2 id="viewOne">View Specific Customer:</h2>
<form action="./adminHome/one" method="GET" >

Account number <input type="search" name="id" >

<input type="submit" name="sumbit" value="view" ><br>

</form>

<!-- view by location -->
<h2 id="location">Search Customer by Location</h2>
<form action="./adminHome/location" method="GET" >

Permanent Address<input type="search" name="permAddress" > 

<input type="submit" name="sumbit" value="findByLocation" ><br>

</form>

<hr>

<!-- list -->
<h2 id="list">Result List</h2>
<table>

<thead>
<tr>
<th scope="col">Account Number</th>
<th scope="col">Name</th>
<th scope="col">Account Type</th>
<th scope="col">Temporary Address </th>
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


<!-- add -->
<h2 id="add">Add New Customer:</h2>
<fieldset>
<legend>Customer Details</legend>
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" maxlength="20" required="required"> <br>
Account type: <input type="radio" name="type" value="saving" checked="checked">saving
 <input type="radio" name="type" value="checking">checking<br>
Name <input type="text" name="name" placeholder="Enter Full Name"> <br>
Temporary Address
<select name="tempAddress">
<option value="Boston">Boston</option>
<option value="Edison">Edison</option>
<option value="Harrison">Harrison</option>
<option value="Jersey City">Jersey City</option>
<option value="DC">DC</option>
<option value="Hawii">Hawii</option>
<option value="Newark">Newark</option>
</select><br>
Permanent Address
<select name="permAddress">
<option value="USA">USA</option>
<option value="UK">UK</option>
<option value="China">China</option>
<option value="Brazil">Brazil</option>
<option value="India">India</option>
<option value="Korea">Korea</option>
</select><br>
Phone Number<input type="text" name="mobile" maxlength="10" required="required" /> <br>
Join Date<input type="date" name="joinDate" /> <br>
<!-- Formate(yyyy-[m]m-[d]d) -->
Balance<input type="text" name="balance" required="required" placeholder="$$$$"/> <br>
PIN<input type="password" name="pin" maxlength="4" required="required"/> <br>

<input type="submit" name="sumbit" value="add" />
</form>
</fieldset>
<br>



<!-- ch temp -->

<h2 id="changeTempAddress">Change Temporary Address:</h2>
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" > <br>

Temporary Address<input type="text" name="tempAddress" > <br>

<input type="submit" name="sumbit" value="update" ><br>

</form>

<!-- ch perm -->


<h2 id="changePermAddress">Change Permanent Address:</h2> 
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" > <br>

Permanent Address<input type="text" name="permAddress" > <br>

<input type="submit" name="sumbit" value="update" ><br>

</form>

<!-- ch Ph -->

<h2 id="changePhone">Change Phone Number:</h2>
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" > <br>

Phone Number<input type="text" name="mobile" > <br>

<input type="submit" name="sumbit" value="update" ><br>

</form>

<!-- ch pin -->

<h2 id="changePin">Change PIN:</h2>
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" > <br>

PIN<input type="text" name="pin"> <br>
<input type="submit" name="sumbit" value="update" ><br>

</form>


<!-- del -->

<h2 id="delete">Delete a Customer:</h2>
<form action="./adminHome/delete" method="GET" >

Account number <input type="text" name="id" >

<input type="submit" name="sumbit" value="delete" ><br>

</form>





</body>
</html>