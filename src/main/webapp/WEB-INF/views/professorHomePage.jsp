<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  
 -->
 <spring:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.css" var="bootstrapCss" /> 
 <link rel="stylesheet" href="${bootstrapCss}">
 
  <spring:url value="/resources/bootstrap-4.0.0-dist/js/bootstrap.js" var="bootstrapJs" /> 
 <link rel="stylesheet" href="${bootstrapJs}">
 
<spring:url value="/resources/testingCss.css" var="testingCss1" /><!-- this is from resources local files  -->
<link href="${testingCss1}" rel="stylesheet" />

<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-xl bg-dark navbar-dark">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<c:url value = ""/>"> </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value = ""/>"></a>
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

 <div class="container"><br/>
        
      <h2>Welcome ${firstname}</h2><br>


	<form method="POST" action="uploadFile" enctype="multipart/form-data">
	
		File to upload:<input type="file" class="form-control-file" id="exampleFormControlFile1">
		
		
		Name: <input type="text" name="name" class="form-control"><br /> 
		
		
		
		<input type="submit" value="Upload"  class="btn btn-primary"> Press here to upload the file!
		
		
	</form>
	
	
	
<form:form method="post" class="form-group" action="addSyllabus">
<table>
<tr>
<th>submit Syllabus</th>
</tr>


<tr><td><input type="submit"  class="btn btn-primary"/></td></tr>




</table>
</form:form>



  </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>