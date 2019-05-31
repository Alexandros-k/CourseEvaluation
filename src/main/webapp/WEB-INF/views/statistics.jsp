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
      <a class="nav-link" href="<c:url value = ""/>">modules</a>
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

<form:form class="form-group" method="post" modelAttribute="programme" action="statistics2">

  <td align="right">select programme to view statistics</td>
        <td>
            
            
    <form:select path="programme_name" >
                <c:forEach items="${listOfProgrammes}" var="programme">
                    <option value="${programme.programme_name}">${programme.programme_name}</option>
                </c:forEach>
            </form:select> 
            
    
            
            <tr><td><input type="submit" class="btn btn-primary"></td></tr>
</td>
</form:form>

 








<a role="button" class="btn btn-primary" href="<c:url value="/admin"/>">Back</a>
</div>


</body>
</html>
