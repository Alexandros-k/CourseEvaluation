<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/css/bootstrap.css"/> ">

 <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/js/bootstrap.js"/>">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-xl bg-dark navbar-dark">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<c:url value = "professorsPage"/>">professors</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value = "programmePage"/>">modules</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value = "statistics"/>">statistics</a>
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


<c:if test="${!empty SyllabusList}">
<table class="table table-hover">
<tr>
		<th width="120">Programme Name</th>		
		<th width="120">remember</th>
		<th width="120">understand</th>
		<th width="60">apply</th>
		<th width="80">analyze</th>
		<th width="60">evaluate</th>
		<th width="60">create</th>
		
		
	</tr>

<c:forEach items="${VerbList}" var="syllabus">
<tr>





<td width="80">${syllabus.name}</td>
<td width="80">${syllabus.remeberCounter}</td>
<td width="80">${syllabus.understandCounter}</td>
<td width="80">${syllabus.applyCounter}</td>
<td width="80">${syllabus.analyzeCounter}</td>
<td width="80">${syllabus.evaluateCounter}</td>
<td width="80">${syllabus.createCounter}</td>
<td><a type="button" class="btn btn-danger" 
href="<c:url value ='/deleteSyllabus/${syllabus.id}'/>">Delete</a></td>

</tr>


</c:forEach>




<tr>
<td width="80">Total</td>
<c:forEach items="${Verb}" var="syll">

  <td> ${syll.value}</td>
  
</c:forEach>

</tr>
</table>


</c:if>
<a role="button" class="btn btn-primary" href="<c:url value="/statistics"/>">Back</a>
</div>



</body>
</html>