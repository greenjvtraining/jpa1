<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Write Form</h1>
<hr>
<div>
	<form action="write2" method="POST">
	<table border="1">
	<tbody>
		<tr>
			<th>작성자 :</th>
			<td><input type="text" name="writer" size="20"></td>
		</tr>
		<tr>
			<th>제목 :</th>
			<td><input type="text" name="title" size="20"></td>
		</tr>
		<tr>
			<th>내용 :</th>
			<td><textarea name="content" cols="22" row="5"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Regist" ></td>
		</tr>
	</tbody>
	</table>
	</form>
</div>
<hr>
<a href="list">목록보기</a>
</body>
</html>