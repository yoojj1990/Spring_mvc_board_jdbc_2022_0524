<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글쓰기</title>
</head>
<body>
	<h2>자유게시판 글쓰기</h2>
	<hr>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write">
			<tr>
				<td>이 름</td>
				<td><input type="text" name="bname" size="60"></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="btitle" size="60"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><textarea name="bcontent" rows="10" cols=45"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글입력">&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;
					<a href="list">글 목록보기</a>&nbsp;&nbsp;
				</td>
			</tr>
			
			
		</form>
		
	</table>
</body>
</html>