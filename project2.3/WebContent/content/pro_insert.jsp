<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	.content>form>s{
	
  border: 1px solid #bcbcbc;
  border-radius: 0px;

	}
</style>
<body>
	<div class = "header">
		<%@ include file = "../header/header.jsp" %>
	</div>
	<div class = "clear"></div>
	<div class = "mainc">
		<div class = "content">
			<h1>교육과목 추가</h1>
			<h2>천호점 교육과정 및 상세내용을 선택하세요</h2>
			<form action="\project2/INSERTBAN.do" method="post">
				<div>
					<label> 교육과목</label>
						<input type="radio" name="ban_name" value="응용SW" style="height:30px" ><label>응용SW</label>
						<input type="radio" name="ban_name" value="프로그래밍" style="height:30px" ><label>프로그래밍</label>
						<input type="radio" name="ban_name" value="퍼블리셔" style="height:30px" ><label>프레임워크</label>
				</div>
						<!-- 교육 과목 -->
						
				<div>
					<label>수강인원수</label>
					<select name="ban_inone" style="width:80px; height:40px">
						  <option value="10">10</option>
						  <option value="15">15</option>
						  <option value="20">20</option>
						  <option value="25">25</option>
					 	  <option value="30" selected>30</option>
						  <option value="35">35</option>
						  <option value="40">40</option>
						  <option value="45">45</option>
						  <option value="50">50</option>
					</select>
				</div>
						<!-- 교육 인원수 -->
						
				<div>
					<label>신청마감</label>
					<input class="date" type="text" name="ban_period" size="30" style="width=100%" value="20161025">e.g)20161025 
				</div>
						<!-- 수강 마감 날짜 -->
						
				<div>
					<label>강사</label>
					<select name="ban_teacher" style="width:80px; height:40px">
						  <option value="김영조" selected>김영조</option>
						  <option value="양기석">양기석</option>
						  <option value="유영진">유영진</option>
						  <option value="양유진">양유진</option>							 
					</select>
				</div>
						<!-- 수강 강사 -->
					
				<input type="submit" value="신청하기">
				<input type="reset" value="취소">
				</form>
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