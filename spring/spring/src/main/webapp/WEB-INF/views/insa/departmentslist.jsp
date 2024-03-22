<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>부서아이디</th>
			<th>부서명</th>
			<th>메니저아이디</th>
			<th>지역</th>
		</tr>
		<c:forEach var="obj" items="${list }">
			<tr>
				<td>${obj.departmentId }</td>
				<td>${obj.departmentName }</td>
				<td>${obj.managerId }</td>
				<td>${obj.locationId }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>