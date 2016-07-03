<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/Layout.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Category</title>
</head>
<body >

	<center>
	<a href="links">Home</a>
	<h3 style="color: teal">
			Add New Category
			</h3>
		<form:form id="insertCategory" action="insertCategory" method="POST"
			modelAttribute="linkTypeBean">

			<table border="0">
				<tr>
					<td><form:label path="linkType">Add Category</form:label></td>
					<td><form:input path="linkType" /></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit">Add Category</button></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>