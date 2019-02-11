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

<c:if test="${!empty SyllabusList}">
<table class="table table-hover">
<tr>
		<th width="80">id</th>
		<th width="120">CourseName</th>
		<th width="120">remember</th>
		<th width="120">understand</th>
		<th width="60">apply</th>
		<th width="80">analyze</th>
		<th width="60">evaluate</th>
		<th width="60">create</th>
		
		
	</tr>

<c:forEach items="${SyllabusList}" var="syllabus">
 <c:set var="count" value="0"/>
<tr>
<td width="80">${syllabus.id}</td>
<td width="80">${syllabus.name}</td>
<td width="80">${VerbList} </td>
<%-- <c:forEach items="${VerbList}" var="syll">

<td></br>${syll.key} ${syll.value}</br></td>
</c:forEach> --%>

</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>