<%@ page import="SSH.DTO.MEMDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% MEMDTO bean=(MEMDTO)request.getAttribute("bean"); %>
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
			<div class="container">
				<div class="content row">
					<div class="grid12">
						<div>guest &gt; <a href="\project2/ALLMEM.do">list</a> &gt; detail</div>
						<h1>상세페이지</h1>
						<p><span class="label">회원 no</span><span><%=bean.getMem_num() %></span></p>
						<p><span class="label">반 no</span><span><%=bean.getBan_num() %></span></p>
						<p><span class="label">이 름</span><span><%=bean.getMem_name() %></span></p>
						<p><span class="label">아이디</span><span><%=bean.getMem_id() %></span></p>
						<p><span class="label">비번</span><span><%=bean.getMem_pass() %></span></p>
						<p><span class="label">생년월일</span><span><%=bean.getMem_birth() %></span></p>
						<p><span class="label">등급</span><span><%=bean.getMem_grade() %></span></p>
						<p><span class="label">전화번호</span><span><%=bean.getMem_ph() %></span></p>
						<p>
							<a href="\project2/EDITMEM.do?idx=<%=bean.getMem_num() %> ">수 정</a>
							<a href="\project2/DELETEMEM.do?idx=<%=bean.getMem_num() %>">삭 제</a>
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