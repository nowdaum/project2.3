<%@page import="java.net.URLEncoder"%>
<%@ page import="SSH.DTO.JUMSUDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% JUMSUDTO bean=(JUMSUDTO)request.getAttribute("bean"); 

%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css"/>
<style type="text/css">

h3 {
	margin: 50px;
	text-align: center;
}
span {
	background-color: #ddd;
	display: inline-block;
	width: 50%;
	height: 30px;
	color: white;
}

.label {
	width: 40%;
	text-align: center;
	font-weight: bold;
	text-align: center;
	background-color: white;
	color: black;
}

p {
	margin: 5px auto;
	font-weight: bold;
	text-align: center;
}

p:last-child {
	text-align: center;
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
					<div class="grid12">
						<h1>상세페이지</h1>
						
						<p><span class="label">반</span><span><%=bean.getBan_num() %></span></p>
						<p><span class="label">회원번호</span><span><%=bean.getMem_num() %></span></p>
						<p><span class="label">학생이름</span><span><%=bean.getMem_name() %></span></p>
						<p><span class="label">프로젝트1</span><span><%=bean.getJumsu_score1() %></span></p>
						<p><span class="label">프로젝트2</span><span><%=bean.getJumsu_score2() %></span></p>
						<p><span class="label">프로젝트3</span><span><%=bean.getJumsu_score3() %></span></p>
						
						<p>
							<!--<a href="ADDJUMSU.do?idx=<%=bean.getMem_num()%>&mem_name=<%=bean.getMem_name()%>&score1=<%=bean.getJumsu_score1()%>&score2=<%=bean.getJumsu_score2()%>&score3=<%=bean.getJumsu_score3()%> ">입 력</a>-->
					<a href="EDITJUMSU.do?idx=<%=bean.getMem_num()%>"> <img id="i1"
						src="\project2/image/btn/insert_edit_btn.jpg" alt="수정/삭제" /></a> 
					<a href="DELETEJUMSU.do?idx=<%=bean.getMem_num()%>"> <img id="i1"
						src="\project2/image/btn/del_btn.jpg" alt="삭제" /></a>
						</p>
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