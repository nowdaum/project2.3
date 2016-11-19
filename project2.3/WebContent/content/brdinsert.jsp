<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css"/>
<style type="text/css">
	.err{
		color: red;
	}
</style>
</head>
<body>
	<div class = "header">
		<%@ include file = "../header/header.jsp" %>
	</div>
	<div class = "clear"></div>
	<div class = "mainc">
		<div class = "content">
			<div class="container">
				<div class="content row">
					<div>guest &gt; <a href="\project2/ALLBRD.do">list</a> &gt; add</div>
					<h1>입력페이지</h1>
					<form action="INSERTBRD.do">
					
					<p>
						<label for="brd_title">제 목</label>
						<input type="text" name="brd_title" id="brd_title"/>
					</p>
					<p>
						<label for="brd_content">내 용</label>
						<input type="text" name="brd_content" id="brd_content"/>
					</p>
					<p>
						<button type="submit">입 력</button>
						<button type="reset">취 소</button>
					</p>
					</form>
				</div>
			</div>
		</div>
		<div class = "aside">
			<div class = "login">
				<%@ include file = "../aside/login.jsp" %>
			</div>
			<div class = "banner">
				<%@ include file = "../aside/aside2.jsp" %>
			</div>
		</div>
	</div>
	<div class = "foot">
		<%@ include file = "../footer/footer.jsp" %>
	</div>
</body>
</html>








