<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

<title>Welcome</title>
</head>
<body>

<table>
<tr>
<th>professors</th>
<th><a href = "<c:url value = "addProfessor"/>">create professor</a></th>
</tr>

</table>
<c:if test="${!empty listOfUsers}">
<table>
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
<td width="80">${user.firstName}</td>
<td width="80">${user.lastName}</td>
<td width="80">${user.username}</td>
<td width="80">${user.password}</td>
<td width="80">${user.role}</td>
<td width="80">${user.course}</td>
<td><a href="<c:url value ='/updateUser/${user.id}'/>">Edit</a></td>
<td><a href="<c:url value ='/deleteUser/${user.id}'/>">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>

<a href="<c:url value="/admin"/>">return to main page</a>
</body>
</html>