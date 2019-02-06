<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> -->
 <spring:url value="/resources/bootstrap-4.0.0-dist/css/bootstrap.css" var="bootstrapCss" /> 
 <link rel="stylesheet" href="${bootstrapCss}">
 
  <spring:url value="/resources/bootstrap-4.0.0-dist/js/bootstrap.js" var="bootstrapJs" /> 
 <link rel="stylesheet" href="${bootstrapJs}">

</head>
<body>
<div class="container">
<form:form class="form-group" method="post" modelAttribute="user" action="test">
<table>
<tr>
<th>Add User</th>
</tr>
<tr>
<tr><td><form:hidden path="id"/></td></tr>
<tr><td><form:hidden path="userDetails.id"/></td></tr>
<tr><td><form:hidden path="courses[0].id"/></td></tr>
<tr><td>First Name:<form:input path="userDetails.firstName" class="form-control"></form:input></td></tr>
<tr><td>Last Name:<form:input path="userDetails.lastName" class="form-control"></form:input></td></tr>
<tr><td>Username:<form:input path="username" class="form-control"></form:input></td></tr>
<tr><td>Password:<form:input path="password" class="form-control"></form:input></td></tr>
<tr><td>course:<form:input path="courses[0].name" class="form-control" ></form:input></td></tr>

<tr>
    <td>
        <ul>Role:
            <form:select path="role.id">
            <form:option value="0" label="--Select Role"/>
                <form:option value="1">ADMIN</form:option>
                <form:option value="2">USER</form:option>             
            </form:select>
        </ul>
    </td>
</tr>

<tr><td><input type="submit" class="btn btn-primary"></td></tr>
<br>
<tr><td>
<a  class="btn btn-primary" href="<c:url value="/professorsPage"/>">Back </a>
</td></tr>



</table>
</form:form>
</div>
<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 --></body>
</html>