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
			<form action = "../INSERTMEM.do" method = "post">
				<h3 class = "membership">회원가입</h3>
					<div class = "members">
						<div class = "texts">
							<div>이름</div>
							<div>아이디</div>
							<div>비밀번호</div>
							<div>생년월일</div>
							<div>전화번호</div>
						</div>
						<div class = "inputs">
							<div class ="ins">
								<input type = "text" name = "name">
								<div class = "idform">
									<input type = "text" class = "id">
									<input type = "button" value = "중복 확인" class = "overlap">
									<div class = "mes"></div>
								</div>
								<input type = "password" name = "pass">
							</div>
							<div class = "selects">
								<select name = "year">
									<% for(int i = 1;i <= 100;i++){%>
									<option value = "<%=i + 1916%>"><%=i + 1916%></option>
									<% }; %>
								</select>
								<select name = "month">
									<% for(int i = 1;i <= 12;i++){%>
									<option value = "<%=i%>"><%=i%></option>
									<% }; %>
								</select>
								<select name = "day">
									<% for(int i = 1;i <= 31;i++){%>
									<option value = "<%=i%>"><%=i%></option>
									<% }; %>
								</select>
							</div>
							<div class = "phs">
								<input type = "text" name = "ph1">-
								<input type = "text" name = "ph2">-
								<input type = "text" name = "ph3">
							</div>
						</div>
					</div>
				<div class = "buttons">
					<input type = "submit" value = "생성">
					<input type = "reset" value = "취소">
				</div>
			</form>
		</div>
	</div>
	<div class = "foot">
		<%@ include file = "../footer/footer.jsp" %>
	</div>
</body>
</html>