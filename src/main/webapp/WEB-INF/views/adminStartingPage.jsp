<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/testingCss.css"/> " />
<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/css/bootstrap.css"/> ">

 <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/js/bootstrap.js"/>">
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
<h2>Hello Admin!</h2>

<%-- <security:authorize
access="isAuthenticated() and principal.username=='prof'">
<a href="lala/professorHomePage">Administration</a>
</security:authorize> --%>








</div>

 
</body>
</html>
