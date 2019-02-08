<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
<title>Welcome</title>
 <spring:url value="/webjars/bootstrap/css/bootstrap.min.css" var="bootstrapCss" /> 
 <link rel="stylesheet" href="${bootstrapCss}">
 
  <spring:url value="/webjars/bootstrap/js/bootstrap.min.js" var="bootstrapJs" /> 
 <link rel="stylesheet" href="${bootstrapJs}">

</head>
<body>

<nav class="navbar navbar-expand-xl bg-dark navbar-dark">

  <!-- Links -->
  <ul class="navbar-nav">
    
    <li class="nav-item">
      <a class="nav-link" href="<c:url value = "addProfessor"/>">create_Professor</a>
    </li>    
  </ul>
  <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="static/j_spring_security_logout">logout</a>
            </li>            
        </ul>
    </div>
</nav>

<div class="container">






<c:if test="${!empty listOfUsers}">
<table class="table table-hover">
<tr>
		<th width="80">Id</th>
		<th width="120">firstname</th>
		<th width="120">lastname</th>
		<th width="60">username</th>
		<th width="80">password</th>
		<th width="60">role</th>
		<th width="60">course</th>
		
		
	</tr>

<c:forEach items="${listOfUsers}" var="user">

<tr>
<td width="80">${user.id}</td>
<td width="80">${user.userDetails.firstName}</td>
<td width="80">${user.userDetails.lastName}</td> 
<td width="80">${user.username}</td>
<td width="80">${user.password}</td>
<td width="80">${user.role.role}</td>
<td width="80">${user.courses[0].name}</td>

<td><a type="button" class="btn btn-primary" 
href="<c:url value ='/updateUser/${user.id}'/>">Edit</a></td>
<td><a type="button" class="btn btn-danger" 
href="<c:url value ='/deleteUser/${user.id}'/>">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>

<br>




<a role="button" class="btn btn-primary" href="<c:url value="/admin"/>">Back</a>
</div>
<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 -->
</body>
</html>