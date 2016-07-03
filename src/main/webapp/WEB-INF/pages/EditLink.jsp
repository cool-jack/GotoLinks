<%@page import="com.Links.Beans.LinkTypeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/Layout.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Link</title>
</head>
<body>
<form:form id="addLinks" modelAttribute ="linkBean" action="updateLink"
		method="post">
		<center>
		<a href="links">Home</a>
		<h2 style="color: teal">Edit Links</h2>
		<form:hidden path="id" value= "${editLinkObjectMap.LinksObject.id}"/>
		<table>
			<tr>
				<td><form:label path="name">Title For Link</form:label></td>
				<td><form:input path="name" value= "${editLinkObjectMap.LinksObject.name}" /></td>
			</tr>
			<tr>
				<td><form:label path="links">Link</form:label></td>
				<td><form:input path="links" value= "${editLinkObjectMap.LinksObject.links}" /></td>
			</tr>
			<c:if test="${!empty editLinkObjectMap.linkTypeList}">
			<tr>
				<td>Category</td>
				<td><form:select path="linkType">
				<option value="${editLinkObjectMap.LinksObject.linkType}">${editLinkObjectMap.linkTypeFromLinkType}</option>
				<c:forEach items="${editLinkObjectMap.linkTypeList}" var="linkType">				
				<c:choose>
				<c:when test="${linkType.linkType == editLinkObjectMap.linkTypeFromLinkType}">
				</c:when>
				<c:otherwise>
				<option value="${linkType.id}">${linkType.linkType}</option>
				</c:otherwise>
				</c:choose>
				</c:forEach>
				</form:select> </td>
			</tr>
			</c:if>
			<tr>
				<td></td>
				<td><input type="submit" value="Update Link"></td>
			</tr>
		</table>
		</center>
	</form:form>
</body>
</html>