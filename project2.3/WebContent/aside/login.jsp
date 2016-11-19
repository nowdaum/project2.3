<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "message">
		<div>
			<div id="idPassLogin" class = "corso">
			    <table>
			        <tr>
						<td>아 이 디</td><td><input type = "text" class = "id"></td>
					</tr>
					<tr>
						<td>패스워드</td><td><input type = "password" class = "pass"></td>
					</tr>
					<tr>
						<td colspan="2"><input id="login1" type = "button" value = "로그인"></td>
					</tr>
				</table>
			</div>
		</div>
		<div>
			<div class = "corso"><a href = "\project2/content/membership.jsp">회원가입</a></div>
			<div class = "corso"><a href = "javascript:idpopup();">아이디찾기</a></div>
			<div class = "corso"><a href = "javascript:pwpopup();">비밀번호찾기</a></div>
		</div>
	</div>
	<div class = "ms"></div>
</body>
</html>