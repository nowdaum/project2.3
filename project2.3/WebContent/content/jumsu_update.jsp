<%@ page import="SSH.DTO.JUMSUDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JUMSUDTO bean = (JUMSUDTO)request.getAttribute("bean");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	height: 35px;
	margin-bottom: 10px;
	padding-top: 10px;
	color: white;
}

.label {
	display: inline-block;
	height: 100px;
	text-align: center;
	font-weight: bold;
	text-align: center;
	background-color: white;
	color: black;
}

p #s1, #s2{
	margin-top:5px;
}


p {
	width: 40%;
	margin: 5px auto;
	font-weight: bold;
	text-align: center;
}

p:last-child {
	text-align: center;
}

p>a {
	
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
						<h1>입력,수정 페이지</h1>
						<form action="UPDATEJUMSU.do">
						<input type="hidden" name="idx" value="<%=bean.getMem_num() %>">
						
					<p>
						<span><label for="Mem_name">회원이름</label></span>
						<span><input type="text"  value="<%=bean.getMem_name()%>" name="Mem_name" id="Mem_name" readonly="readonly"/></span>
					</p>
					<p>
						<span><label for="Jumsu_score1">성적1</label></span>
						<span><input type="text" value="<%=bean.getJumsu_score1() %>" name="Jumsu_score1" id="Jumsu_score1"/></span>
					</p>
					<p>
						<span><label for="Jumsu_score2">성적2</label></span>
						<span><input type="text" value="<%=bean.getJumsu_score2() %>" name="Jumsu_score2" id="Jumsu_score2"/></span>
					</p>
					<p>
						<span><label for="Jumsu_score3">성적3</label></span>
						<span><input type="text" value="<%=bean.getJumsu_score3() %>" name="Jumsu_score3" id="Jumsu_score3"/></span>
						</p>
						
						<p>
							<button type="submit" style="border: 0; background: transparent">
							<img id="i1" src="\project2/image/btn/edit_btn.jpg" alt="수정" />
							</button>
							<button type="reset" style="border: 0; background: transparent">
							<img id="i1" src="\project2/image/btn/cnc_btn.jpg" alt="취소" />
							</button>
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