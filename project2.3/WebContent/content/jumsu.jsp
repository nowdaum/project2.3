<%@ page import="java.util.List" %>
<%@ page import="SSH.DTO.JUMSUDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<JUMSUDTO> list=(List<JUMSUDTO>)request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

h3 {
	margin: 50px;
	text-align: center;
}

.content table{
	margin-left: 200px;
}


.content table th {
	background-color: #d13434;
	color: white;
}

.content table td:nth-child(3) {
	font-weight: bold;
}

.content table tr:nth-child(2n-1) {
	background-color: #ddd;
}

.content table td:nth-child(1) {
	width: 10%;
}

.content table td:nth-child(2) {
	width: 10%;
}

.content p {
	margin: 20px 0px;
	width: 80%;
	text-align: right;
}

.content ul {
	list-style: none;
	width: 300px;
	margin: 0px auto;
}

.content ul>li {
	float: left;
	margin: 0px 5px;
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
						<h1>리스트 페이지</h1>
						
						<table>
							<tr>
								<th>반</th>
								<th>회원번호</th>
								<th>학생이름</th>
								<th>프로젝트1</th>
								<th>프로젝트2</th>
								<th>프로젝트3</th>
								<th>총점</th>
								<th>평균</th>
								<th>등급</th>
							</tr>
							<%for(JUMSUDTO bean:list){  %>
							<tr>
								<td><%=bean.getBan_num() %></td><!-- 반번호 -->
								<td><%=bean.getMem_num() %></td><!-- 회원번호 -->
								<td><a href="\project2/DETAILJUMSU.do?idx=<%=bean.getMem_num() %>"><%=bean.getMem_name() %></a></td><!-- 학생이름 -->
								
								<% 
								int s1 = bean.getJumsu_score1();
								int s2 = bean.getJumsu_score2();
								int s3 = bean.getJumsu_score3();
								
								if((s1==0&&s2==0)&&s3==0){ %>
								<td>입력전</td>
								<td>입력전</td>
								<td>입력전</td>
								
								<% }else if((s1!=0&&s2==0)&&s3==0){ %>
								<td><%=bean.getJumsu_score1() %></td>
								<td>입력전</td>
								<td>입력전</td>
								
								<% }else if((s1!=0&&s2!=0)&&s3==0){ %>
								<td><%=bean.getJumsu_score1() %></td>
								<td><%=bean.getJumsu_score2() %></td>
								<td>입력전</td>
								
								<%}else if((s1!=0&&s2!=0)&&s3!=0){ %>
								<td><%=bean.getJumsu_score1() %></td>
								<td><%=bean.getJumsu_score2() %></td>
								<td><%=bean.getJumsu_score3() %></td>
								
								<%}else if(s1==0&&(s2==0&&s3!=0)){ %>
								<td>입력전</td>
								<td>입력전</td>
								<td><%=bean.getJumsu_score3() %></td>
								
								<%}else if(s1==0&&(s2!=0&&s3==0)){ %>
								<td>입력전</td>
								<td><%=bean.getJumsu_score2() %></td>
								<td>입력전</td>
							
								<%}else if(s1==0&&(s2!=0&&s3!=0)){ %>
								<td>입력전</td>
								<td><%=bean.getJumsu_score2() %></td>
								<td><%=bean.getJumsu_score3() %></td>
								
								<%}else if(s1!=0&&(s2==0&&s3!=0)){ %>
								<td><%=bean.getJumsu_score1() %></td>
								<td>입력전</td>
								<td><%=bean.getJumsu_score3() %></td>
								
							
								<%} %><!-- 점수1,2,3 -->
								
								<% 
								int tot=0;
								tot=s1+s2+s3; %>
								<td><%=tot %></td><!-- 총점 -->
								
								
								<% 
								double avg1 = bean.getJumsu_score1();
								double avg2 = bean.getJumsu_score2();
								double avg3 = bean.getJumsu_score3();
								
								double avgtot=avg1+avg2+avg3;
								double avg=avgtot/3;
								%> 
		
								<td><%= Double.parseDouble(String.format("%.2f", avg))%></td><!-- 평균 -->
								
								
								<% if(avg>=95){ %>
								<td>S</td>
								<%}else if(avg>=90){ %>
								<td>A</td>	
								<%}else if(avg>=80){ %>
								<td>B</td>	
								<%}else if(avg>=70){ %>
								<td>C</td>	
								<%}else if(avg>=60){ %>
								<td>D</td>
								<%}else{ %>
								<td>F</td>		
								<%} %><!-- 등급 -->
								
							<%} %> <!-- 전체 if,for문  -->
							</tr>
						</table>
					</div>
				</div>
			</div><!-- container end -->
		<div class = "aside">
			<div class = "login">
				<%@ include file = "../aside/login.jsp" %>
			</div>
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









