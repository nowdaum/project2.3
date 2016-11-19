<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="SSH.DTO.BANDTO"%>
<%
	List<BANDTO> list=(List<BANDTO>)request.getAttribute("list");
%>

<!-- list.do page -->
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.logo{
		margin: 200px;
	}
	#in1>a{
		border: 1px gray solid;
		color:white;
		background-color:gray;
		text-weight:bold;
		margin-left: 300px;
	}
	.content>div{
		margin-top:500px;
	}
</style>
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
			<h1>정규 과정 소개</h1>
			<h3 class="programming">프로그래밍 과정</h3>
				<div id="in1">
					<a href="\project2/eduInsert.do">교육과정 추가하세요</a>
				</div>
			<div>
				<%
					System.out.println("11");
				%>
				<%
					for (BANDTO dto : list) {
						if((dto.getBan_num() >=20000) && (dto.getBan_num() < 30000)){
				%>
				<%
					System.out.println("22");
				%>
				<div class="logo">
					<img src="\project2/image/programming.jpg" alt="">
					<div>
						>교육장소 : <b>천호</b>점
					</div>
					<div>
						>교육과정 : <a href="\project2/DETAILBAN.do?idx=<%=dto.getBan_num()%>"><%=dto.getBan_name()%></a>
					</div>
					<div>
						>강사 :
						<%=dto.getBan_teacher()%>
						강사님
					</div>
					<div>
						>모집인원 :
						<%=dto.getBan_inone()%>명
					</div>
					<div>
						>신청마감 :
						<%=dto.getBan_period()%>까지
					</div>
					<a href="javascript:popupOpen();"><img
						src="\project2/image/btn/detail_btn.jpg" alt="자세히보기" /></a> <a
						href="javascript:button2_2_click();"><img
						src="\project2/image/btn/apply_btn.jpg" alt="신청하기" /></a>
				</div>
				<%
					}}
				%>
				<%
					System.out.println("33");
				%>
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