<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "header">
		<%@ include file = "../header/header.jsp" %>
	</div>
	<div class = "clear"></div>
	<div class = "mainc">
		<div class = "content">
			<h3 class = "login">로그인</h3>
	<form action = "login.do" method="post">
		<div>
			<div>
				<div class = "corso">
					<div>아이디</div>
					<div>패스워드</div>
				</div>
				<div class = "corso">
					<div><input type = "text" name = "id"></div>
					<div><input type = "password" name = "pass"></div>
				</div>
				<div class = "corso">
					<div><input type = "submit" value = "로그인"></div>
				</div>
				</div>
			<div>
				<div class = "corso"><a href = "\project2/membership.jsp">회원가입</a></div>
				<div class = "corso"><a href = "javascript:idpopup();">아이디찾기</a></div>
				<div class = "corso"><a href = "javascript:pwpopup();">비밀번호찾기</a></div>
			</div>
		</div>
	</form>
		</div>
	</div>
	<div class = "foot">
		<%@ include file = "../footer/footer.jsp" %>
	</div>
</body>
</html>