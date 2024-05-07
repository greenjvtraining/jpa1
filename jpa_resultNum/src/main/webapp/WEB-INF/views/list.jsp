<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SimpleBbs List Page</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<h1>List Page <span>(${total })</span></h1>
<hr>
<p>
	<a href="writeForm">글 작성하기</a>
</p>
<div>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th><th>작성자</th><th>제목</th><th>내용</th><th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.id }</td>
				<td>${dto.writer }</td>
				<td><a href="view?id=${dto.id }">${dto.title }</a></td>
				<td>${dto.content }</td>
				<td><a href="delete?id=${dto.id }">X</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>