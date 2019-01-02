<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="post" modelAttribute="user" action="test">
<table>
<tr>
<th>Add User</th>
</tr>
<tr>
<!-- <tr><td><form:hidden path="id"/></td></tr>-->
<%-- <tr><td>First Name:<form:input path="userDetails.firstName"></form:input></td></tr>
<tr><td>Last Name:<form:input path="userDetails.lastName"></form:input></td></tr> --%>
<tr><td>Username:<form:input path="username"></form:input></td></tr>
<tr><td>Password:<form:input path="password"></form:input></td></tr>

<tr><td>Role:<form:input path="role.role"></form:input></td></tr>


<tr><td><input type="submit"/></td></tr>
<br>
<tr><td>
<a href="<c:url value="/professorsPage"/>">return to professorsList</a>
</td></tr>



</table>
</form:form>

</body>
</html>