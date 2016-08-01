<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
${message}<hr>

Add New Customer:
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" > <br>
Account type <input type="text" name="type" > <br>
Name <input type="text" name="name" > <br>
Temporary Address<input type="text" name="tempAddress" > <br>
Permanent Address<input type="text" name="permAddress" > <br>
Phone Number<input type="text" name="mobile" > <br>
Join Date<input type="text" name="joinDate" > Formate(yyyy-[m]m-[d]d)<br>
Balance<input type="text" name="balance" > <br>
PIN<input type="text" name="pin"> <br>

<input type="submit" name="sumbit" value="add" >
<br>

</form>

<table>
<tr>
<td>
Change Temporary Address:
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" > <br>

Temporary Address<input type="text" name="tempAddress" > <br>

<input type="submit" name="sumbit" value="update" ><br>

</form>
</td>

<td>

Change Permanent Address:
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" > <br>

Permanent Address<input type="text" name="permAddress" > <br>

<input type="submit" name="sumbit" value="update" ><br>

</form>
</td>
</tr>

<tr>
<td>

Change Phone Number:
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" > <br>

Phone Number<input type="text" name="mobile" > <br>

<input type="submit" name="sumbit" value="update" ><br>

</form>
</td>

<td>
Change PIN:
<form action="./adminHome/form" method="Post" >

Account number <input type="text" name="id" > <br>

PIN<input type="text" name="pin"> <br>
<input type="submit" name="sumbit" value="update" ><br>

</form>

</td>
</tr>
</table>

<hr>

<form action="./adminHome/delete" method="GET" >

Account number <input type="text" name="id" >

<input type="submit" name="sumbit" value="delete" ><br>

</form>

<hr>
<form action="./adminHome/all" method="GET" >


All Accounts<input type="submit" name="sumbit" value="view" ><br>

</form>
<hr>
<form action="./adminHome/one" method="GET" >

Account number <input type="text" name="id" >

<input type="submit" name="sumbit" value="view" ><br>

</form>
<hr>

<form action="./adminHome/location" method="GET" >

Permanent Address<input type="text" name="permAddress" > 

<input type="submit" name="sumbit" value="findByLocation" ><br>

</form>


<c:forEach items="${reports}" var="customer">
<tr>  
<th>${customer.id}</th>
<th>${customer.type}</th>
<th>${customer.name}</th>
<th>${customer.tempAddress}</th>
<th>${customer.permAddress}</th>
<th>${customer.mobile}</th>
<th>${customer.joinDate}</th>
<th>${customer.balance}</th>
<th>${customer.pin}</th>
</tr>

</c:forEach>

</table>





</body>
</html>