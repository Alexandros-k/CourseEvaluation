<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/css/bootstrap.css"/> ">

 <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/js/bootstrap.js"/>">


</head>
<body>
<nav class="navbar navbar-expand-xl bg-dark navbar-dark">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<c:url value = "username"/>"> </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value = "password"/>"></a>
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

<script>




</script>


 <div class="container"><br/>
        
<c:if test="${!empty message}">
 <div class="alert alert-success" >
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  ${message}
  </div>
</c:if> 
<c:if test="${!empty errorMessage}">
 <div class="alert alert-danger">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  ${errorMessage}
  </div>
</c:if>  
        
        
      <h2>Welcome ${user.userDetails.firstName} ${user.userDetails.lastName}</h2><br>
      

      


<c:if test="${!empty user}">
<table class="table table-hover">
 <h3>Select course to upload Syllabus</h3><br>
	<tr>
		<th width="80">Id</th>
		<th width="120">Programme Course</th>		
		<th width="120">Syllabus Name</th>	
				
	</tr>

<c:forEach items="${newCourses}" var="course">

<tr>
<td width="80">${course.id}</td>
<td width="80">${course.name}</td>
<td width="80">${course.syllabus.name}</td>

<c:if test="${empty course.syllabus.name}">
<td><a type="button" class="btn btn-primary" 
href="<c:url value ='/addSyllabus/${course.id}'/>">add syllabus</a></td>
</c:if>
</tr>
</c:forEach>
</table>
</c:if>








  </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>