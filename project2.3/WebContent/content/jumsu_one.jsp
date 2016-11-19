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
	span{
		background-color: #ccc;
		display: inline-block;
		width: 70%;
		height: 30px;
	}
	.label{
		width: 30%;
		text-align: center;
		font-weight:bold;
		text-align:center;
		background-color: gray;
		color: white;
	}
	p{
		width:70%;
		margin: 5px auto;
	}
	p>a{
		text-decoration: none;
		display:inline-block;
		width: 120px;
		height: 50px;
		background: linear-gradient(#999,#aaa,#666);
		border-radius:25px;
		text-align: center;
		line-height: 50px;
		color: white;
		font-weight: bold;
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
						<h1>학생개인확인페이지</h1>
						
						<p><span class="label">반</span><span><%=bean.getBan_num() %></span></p>
						<p><span class="label">학생이름</span><span><%=bean.getMem_name() %></span></p>
						<p><span class="label">프로젝트1</span><span><%=bean.getJumsu_score1() %></span></p>
						<p><span class="label">프로젝트2</span><span><%=bean.getJumsu_score2() %></span></p>
						<p><span class="label">프로젝트3</span><span><%=bean.getJumsu_score3() %></span></p>
						
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