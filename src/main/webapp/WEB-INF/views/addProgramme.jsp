<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/css/bootstrap.css"/> ">

 <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/js/bootstrap.js"/>">
</head>
<body>
<div class="container">
<form:form class="form-group" method="post" modelAttribute="programme" action="addProgrammeToDb">
<table>
<tr>
<th>Add Programme</th>
</tr>
<tr>
<tr><td><form:hidden path="id"/></td></tr>

<tr><td>Add Programme Name:<form:input path="programme_name" class="form-control"></form:input></td></tr>


<tr><td><input type="submit" class="btn btn-primary"></td></tr>
<br>
<tr><td>
<a  class="btn btn-primary" href="<c:url value="/programmePage"/>">Back </a>
</td></tr>



</table>
</form:form>
</div>
</body>
</html>