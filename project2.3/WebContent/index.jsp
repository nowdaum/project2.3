<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% session.setAttribute("login", "0"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "header">
		<%@ include file = "./header/header.jsp" %>
	</div>
	<div class = "clear"></div>
	<div class = "mainc">
		<div class = "content">
			<%@ include file = "./content/intro.jsp" %>
		</div>
		<div class = "aside">
			<div class = "login">
				<%@ include file = "./aside/login.jsp" %>
			</div>
			<div class = "banner">
				<%@ include file = "./aside/aside2.jsp" %>
			</div>
		</div>
	</div>
	<div class = "foot">
		<%@ include file = "/footer/footer.jsp" %>
	</div>
</body>
</html>