<%@page import="com.Links.Beans.LinkTypeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/Layout.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Links</title>
</head>
<body>
	<form:form id="addLinks" modelAttribute ="linkBean" action="addLink"
		method="post">
		<center>
		<a href="links">Home</a>
		<h2 style="color: teal">Add Links</h2>
		<table>
			<tr>
				<td><form:label path="name">Title For Link</form:label></td>
				<td><form:input path="name" required= "required" /></td>
			</tr>
			<tr>
				<td><form:label path="links">Link</form:label></td>
				<td><form:input path="links" required= "required" /></td>
			</tr>
			<c:if test="${!empty linkTypeList}">
			<tr>
				<td>Category</td>
				<td><form:select path="linkType">
				<option value="NONE">--- Select ---</option>
				<c:forEach items="${linkTypeList}" var="linkType">				
				<option value="${linkType.id}">${linkType.linkType}</option>
				</c:forEach>
				</form:select> </td>
			</tr>
			</c:if>
			<tr>
				<td></td>
				<td><button type="submit">Add Link</button> </td>
			</tr>
		</table>
		</center>
	</form:form>
</body>
</html>