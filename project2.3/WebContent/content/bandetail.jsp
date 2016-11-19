<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import= "SSH.DTO.BANDTO" %>
<% BANDTO dto=(BANDTO)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	p:last-child{
		text-align: center;	
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
		color: red;
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
			<img src="\project2/image/logo.gif" alt="" width="50px" height="50px" />
			<h1>교육과목 추가</h1>
			<h2>천호점 교육과정 및 상세내용을 선택하세요</h2>
				<div class="container">
					<div class="content row">
						<div class="grid12">
							<div>educations &gt; <a href="\project2/list.do">list</a> &gt; detail</div>
							<h1>상세페이지</h1>
							<p><span class="label">반번호</span><span><%=dto.getBan_num() %></span></p>
							<p><span class="label">반이름</span><span><%=dto.getBan_name() %></span></p>
							<p><span class="label">반인원</span><span><%=dto.getBan_inone() %></span></p>
							<p><span class="label">마감일</span><span><%=dto.getBan_period() %></span></p>
							<p><span class="label">강사</span><span><%=dto.getBan_teacher() %></span></p>
							<p>
								<a href="\project2/EDITBAN.do?num=<%=dto.getBan_num() %> ">수 정</a>
								<a href="\project2/DELETEBAN.do?num=<%=dto.getBan_num() %>">삭 제</a>
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