<%@ page import="java.util.List" %>
<%@ page import="SSH.DTO.MEMDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<MEMDTO> list=(List<MEMDTO>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css"/>
<style type="text/css">
	
	.content table{
		margin: 0px auto;
		width: 70%;
	}
	.content table th{
		background-color: gray;
	}
	.content table tr:nth-child(2n-1){
		background-color: #ddd;
	}
	.content table td:nth-child(1){
		width: 20%;
	}
	.content table td:nth-child(2){
		width: 30%;
	}
	.content p{
		margin:20px 0px;
		width:80%;
		text-align: right;
	}
	.content p>#btn{
		text-decoration: none;
		display: inline-block;
		width: 120px;
		height: 50px;
		background:linear-gradient(#999,#aaa,#666);
		border-radius:25px;
		text-align: center;
		line-height: 50px;
		color: white;
		font-weight: bold;
		
	}
	.content ul{
		list-style: none;
		width: 300px;
		margin: 0px auto;
	}
	.content ul>li{
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
						<div>guest &gt; list</div>
						<h1>리스트 페이지</h1>
						<p>
						<select name="row">
							<option value="10">10씩보기</option>
							<option value="25">25씩보기</option>
							<option value="50">50씩보기</option>
						</select>
						</p>
						<table>
							<tr>
								<th>회원번호</th>
								<th>반 번호</th>
								<th>회원 이름</th>
								<th>아이디</th>
								<th>패스워드</th>
								<th>생년월일</th>
								<th>등 급</th>
								<th>전화번호</th>
								<!--  <th>내용</th>-->
							</tr>
							<%for(MEMDTO bean:list){ %>
							<tr>
								<td><%=bean.getMem_num() %></td>
								<td><%=bean.getBan_num() %></td>
								<td><a href="\project2/ONEMEM.do?idx=<%=bean.getMem_num() %>"><%=bean.getMem_name() %></a></td>
								<td><%=bean.getMem_id() %></td>
								<td><%=bean.getMem_pass() %></td>
								<td><%=bean.getMem_birth() %></td>
								<td><%=bean.getMem_grade() %></td>
								<td><%=bean.getMem_ph() %></td>
							</tr>
							<%} %>
						</table>
						<p><ul>
						<%
						int tot=(Integer)request.getAttribute("ptot");
						for(int i=1; i<=tot; i++){
						%>
						<li><a href="\project2/ALLMEM.do?p=<%=i %>"><%=i %></a></li>
						<%} %>
						</ul>
						</p>
						<p><a href="\project2/ADDBRD.do" id="btn">회원 입력</a></p>
					</div>
				</div>
			</div><!-- container end -->
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









