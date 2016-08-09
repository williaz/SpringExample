
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome, Customer!</title>
</head>
<body>

<form  method="POST" >


Account number <input type="text" name="id" maxlength="20"/> <br>
PIN<input type="password" name="pin" maxlength="4"/> <br>


<input type="submit" name="submit" value="Login" /><br>


</form>
<br>
<a href="home">Back to Home page</a>
</body>
</html>

-->

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
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="static/css/ie10-viewport-bug-workaround.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="static/css/signin.css" rel="stylesheet" type="text/css">
    
	<link href="navbar-fixed-top.css" rel="stylesheet" type="text/css">

  </head>

  <body>
  
  
    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="http://www.github.com/williaz/SpringExample/tree/master/SimpleATM">Simple ATM</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li ><a href="home">Home</a></li>
            <li class="active"><a href="userLogin">User Login</a></li>
            <li><a href="adminHome">Admin Home</a></li>
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
    </nav>
  

    <div class="container">
    
<!--      <div class="masthead clearfix"> -->
<!--             <div class="inner"> -->
<!--               <h3 class="masthead-brand">ATM</h3> -->
<!--               <nav> -->
<!--                 <ul class="nav masthead-nav"> -->
<!--                   <li ><a href="home">Home</a></li> -->
<!--                   <li class="active"><a href="userLogin">User Login</a></li> -->
<!--                   <li><a href="adminHome">Admin Login</a></li> -->
<!--                 </ul> -->
<!--               </nav> -->
<!--             </div> -->
<!--           </div> -->

      <form class="form-signin" method="POST">
        <h2 class="form-signin-heading">Customer Sign in</h2>
        <label for="id" class="sr-only">Account number</label>
        <input type="text" name="id" class="form-control" placeholder="Account number" maxlength="20" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="pin" class="form-control" placeholder="Password" maxlength="4" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"name="submit" >Sign in</button>
      </form>

    </div> <!-- /container -->

 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="static/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="static/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>







