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
Hi,${customer.name}! No. ${customer.id}<br>
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
Account Number to Transfer:  <input type="text" name="tid" > 
Amount:  <input type="text" name="amount" > 
<input type="submit" name="submit" value="Transfer" ><br>
</form>

<form  action="./userHome/report" method="GET" >
Mini Statement Report:
<input type="submit" name="submit" value="Generate" ><br>
</form>



	
<table >


<thead>
<tr>
<th>Date</th>
<th>Transaction Type</th>
<th>Amount</th>
<th>Balance</th>
</tr>
</thead>

<tbody>
<c:forEach items="${reports}" var="tranx">
<tr>  
<td>${tranx.date}</td>
<td>${tranx.type}</td>
<td>${tranx.amount}</td>
<td>${tranx.balance}</td>
</tr>
</c:forEach>
</tbody>


</table>

<a href= userLogin> Log Out</a>



</body>
</html>