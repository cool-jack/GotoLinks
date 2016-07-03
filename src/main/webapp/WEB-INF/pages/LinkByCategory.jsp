<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/Layout.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Link By Category</title>
</head>
<body>
	<center>
	<c:if test="${!empty linkbyCategoryMap.linkTypeBean }">
		<h3 style="color: teal">
			
			${linkbyCategoryMap.linkTypeBean.linkType} &nbsp;
			
			Links
		</h3>
		<table>
			<tr>
				<td><a href="manageCategories?id=${linkbyCategoryMap.linkTypeBean.id}&task=edit"><button>Edit</button></a></td>
				<td><a href="manageCategories?id=${linkbyCategoryMap.linkTypeBean.id}&task=delete"><button>Delete</button></a></td>
			</tr>
		</table>
		</c:if>
	<a href="links">Home</a>&emsp;
		<c:if test="${!empty linkbyCategoryMap.linkTypeList}">
			<c:forEach items="${linkbyCategoryMap.linkTypeList}" var="linkType">
				<a href="linkByCaregory?linkTypeId=${linkType.id}">${linkType.linkType}</a>
				&emsp;
			</c:forEach>
		</c:if>
		<a href="addCategory">Add New Category</a> <br> <br> <a
			href="AddLinks"><b>Add New Link</b></a><br> <br>
		<c:if test="${!empty linkbyCategoryMap.linkBeanList}">
			<table border="0">

				<c:forEach items="${linkbyCategoryMap.linkBeanList}" var="link">
					<tr>
						<td><a href="${link.links}" target="_blank"><h4>
									<b><c:out value="${link.name}" /></b>
								</h4> </a></td>
						<td><a href="editLink?id=${link.id}"><button>Edit</button></a></td>
						<td><a href="delete?id=${link.id}"><button>Delete</button></a></td>


					</tr>
				</c:forEach>

			</table>

		</c:if>
	</center>

</body>
</html>