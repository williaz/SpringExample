<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Homepage</title>
</head>
<body>

Your current balance:
${customer.balance}<br>

${message}<br>

<form  action="./userHome/deposit" method="GET" >
Deposit Amount:  <input type="text" name="deposit" > 
<input type="submit" name="submit" value="Deposit" ><br>
</form>

<form  action="./userHome/withdraw" method="GET" >
Withdraw Amount:  <input type="text" name="withdraw" > 
<input type="submit" name="submit" value="Withdraw" ><br>
</form>

<form  action="./userHome/transfer" method="GET" >
Account Number to Transfer:  <input type="text" name="id" > 
Amount:  <input type="text" name="amount" > 
<input type="submit" name="submit" value="Transfer" ><br>
</form>


</body>
</html>