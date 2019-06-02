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
<form:form class="form-group" method="post" modelAttribute="course" action="test/addProfessorToCourse">
<table>
<tr>
<th>Assing Professor</th>
</tr>
<tr>
<tr><td><form:hidden path="id"/></td></tr>
<tr><td><form:hidden path="name"/></td></tr>
<tr><td><form:hidden path="programme.id"/></td></tr>
<%-- <tr><td><form:hidden path="user.id"/></td></tr>--%>
<%-- <tr><td><form:hidden path="user.userDetails.id"/></td></tr> --%>
<%-- <tr><td><form:hidden path="user.userDetails.firstName"/></td></tr> --%>
<tr><td>professor's lastname:<form:input path="user.userDetails.lastName" class="form-control" ></form:input></td></tr>
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