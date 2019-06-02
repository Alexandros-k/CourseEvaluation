<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/css/bootstrap.css"/> ">

 <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/js/bootstrap.js"/>">
</head>
<body>

<nav class="navbar navbar-expand-xl bg-dark navbar-dark">

  <!-- Links -->
  <ul class="navbar-nav">
    
    <li class="nav-item">
      <a class="nav-link" href="<c:url value = "addProgramme"/>">create Programme</a>
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






<c:if test="${!empty listOfProgrammes}">
<table class="table table-hover">
<tr>
		<th width="80">Id</th>
		<th width="80">Programme Name</th>		
		<th width="80">Course</th>
		<th width="150">Professor</th>
		<th>Actions</th>
		
	</tr>

<c:forEach items="${listOfProgrammes}" var="programme">

<tr>
<td width="80">${programme.id}</td>
<td width="80">${programme.programme_name}</td>
<td width="80"></td>
<td width="80"></td>

<td><a type="button" class="btn btn-primary" 
href="<c:url value = "/addCourse/${programme.id}"/>">Add Course</a></td>

<td><a type="button" class="btn btn-danger" 
href="<c:url value ='/deleteProgramme/${programme.id}'/>">Delete</a></td>

<td><a type="button" class="btn btn-primary" 
href="<c:url value ='/updateProgramme/${programme.id}'/>">Edit</a></td>



</tr>

<c:forEach items="${programme.courses}" var="course">
<tr>
<td width="80"></td>
<td width="80"></td>
<td width="80">${course.name}</td>
<td width="80">${course.user.userDetails.firstName} ${course.user.userDetails.lastName}</td>

<c:if test="${empty course.user.userDetails.firstName }">
<td width="80"><a type="button" class="btn btn-primary" 
href="<c:url value ='/addProfessorToCourse/${course.id}'/>">assign Professor</a></td>
</c:if>

<td width="80"><a type="button" class="btn btn-danger" 
href="<c:url value ='/deleteCourse/${course.id}'/>">Delete</a></td>

<td width="80"><a type="button" class="btn btn-primary" 
href="<c:url value ='/editCourse/${course.id}'/>">Edit Course</a></td>

 <td width="80"><a type="button" class="btn btn-primary" 
href="<c:url value ='/reAssignProfessor/${course.id}'/>">reassign Professor</a></td>
 
</tr>
</c:forEach>


</c:forEach>
</table>
</c:if>

<br> 




<a role="button" class="btn btn-primary" href="<c:url value="/admin"/>">Back</a>
</div>

</body>
</html>