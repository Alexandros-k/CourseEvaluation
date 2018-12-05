<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Hello World!</h2>

<%-- <security:authorize
access="isAuthenticated() and principal.username=='prof'">
<a href="lala/professorHomePage">Administration</a>
</security:authorize> --%>

<table>
<tr>
<td><a href = "<c:url value = "professorsPage"/>">professors</a></td>
<td><a href = "<c:url value = ""/>">modules</a></td>
<td><a href = "<c:url value = ""/>">statistics</a></td>
</tr>
</table>
<a href="<c:url value="/static/j_spring_security_logout"/>">Logout</a>

</body>
</html>
