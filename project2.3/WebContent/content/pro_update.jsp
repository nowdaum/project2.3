<%@ page import="SSH.DTO.BANDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BANDTO dto = (BANDTO)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css"/>
<style type="text/css"></style>
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
						<div>BanList &gt; <a href="\project2/list.do">list</a> &gt; <a href="\project2/DETAILBAN.do?num=<%=request.getParameter("num")%>">detail</a> &gt; edit</div>
						<h1>수정 페이지</h1>
						<form action="\project2/UPDATEBAN.do">
						<input type="hidden" name="num" value="<%=dto.getBan_num() %>">
						
						<p>
						
						<label for="ban_inone">반인원</label>
						<input type="text" value="<%=dto.getBan_inone() %>" name="ban_inone" id="ban_inone"/>
						<label for="ban_period">마감 날짜</label>
						<input type="text" value="<%=dto.getBan_period() %>" name="ban_period" id="ban_period"/>
						<label for="ban_teacher">강 사</label>
						<input type="text" value="<%=dto.getBan_teacher() %>" name="ban_teacher" id="ban_teacher"/>
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






