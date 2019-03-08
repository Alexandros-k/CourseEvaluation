<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/login.css"/> " />

 <link rel="stylesheet" href="<c:url value="/webjars/font-awesome/css/all.css"/>">

<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/css/bootstrap.min.css"/> ">

 <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/js/bootstrap.js"/>">
  <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/js/bootstrap.bundle.min.js"/>">
 
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
            <spring:url var="authUrl" value="/static/j_spring_security_check" />
			<form method="post" action="${authUrl}" class="form-signin">
            
              <div class="form-label-group">
                <input type="text" id="inputEmail" name="j_username" class="form-control" placeholder="Username" required autofocus>
                <label for="inputEmail">Username</label>
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword"  name="j_password" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>

              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Remember password</label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              <hr class="my-4">         
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
