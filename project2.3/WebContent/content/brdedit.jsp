<%@ page import="SSH.DTO.BRDDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BRDDTO bean = (BRDDTO)request.getAttribute("bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css"/>
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
					<div class="grid12">
						<div>guest &gt; <a href="\project2/ALLBRD.do">list</a> &gt; <a href="\project2/TITLEBRD.do?idx=<%=request.getParameter("idx")%>">detail</a> &gt; edit</div>
						<h1>수정 페이지</h1>
						<form action="UPDATEBRD.do">
						<input type="hidden" name="idx" value="<%=bean.getBrd_num() %>">
						<p>
						<label for="brd_num">게시.no</label><input type="text" value="<%=bean.getBrd_num() %>" name="brd_num" id="brd_num" readonly="readonly"/>
						</p>
						
						<p>
						<label for="brd_title">제 목</label><input type="text" value="<%=bean.getBrd_title() %>" name="brd_title" id="brd_title"/>
						<label for="brd_content">내 용</label><input type="text" value="<%=bean.getBrd_content() %>" name="brd_content" id="brd_content"/>
						</p>
						<p>
							<button type="submit">수 정</button>
							<button type="reset">취 소</button>
						</p>
						</form>
					</div>
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






