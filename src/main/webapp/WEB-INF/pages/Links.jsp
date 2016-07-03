<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/Layout.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Links</title>
</head>
<!--  body background="backgroung.jpg" bgcolor="#ffffe6" -->
<body>
<script type="text/javascript">
function deleteHistory(){
	chrome.history.deleteAll();
	document.getElementById("pid").innerHTML = "history removed";
}
</script>
	<center>
		<h3 style="color: teal">
			All Links
			</h3>
			<a href="links">Home</a>&emsp;
			<c:if test="${!empty linksMap.linkTypeList}">
			<c:forEach items="${linksMap.linkTypeList}" var="linkType" >
			<a href="linkByCaregory?linkTypeId=${linkType.id}">${linkType.linkType}</a>&emsp;
			</c:forEach>
			</c:if>
			<a href="addCategory">Add New Category</a>
			<!--  a href="chrome://history/" onclick="chrome.tabs.create({url:'google.com'});">Delete History</a -->
			<p id="pid"></p>
			<br>
			<br>
			 <a href="AddLinks"><b>Add New Link</b></a><br> <br>
			<c:if test="${!empty linksMap.linksList}">
				<table border="0">

					<c:forEach items="${linksMap.linksList}" var="link">
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