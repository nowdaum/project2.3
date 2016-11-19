<%@ page import="SSH.DTO.MEMDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MEMDTO bean = (MEMDTO)request.getAttribute("bean");
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
						<div>guest &gt; <a href="\project2/ALLMEM.do">list</a> &gt; <a href="\project2/ONEMEM.do?idx=<%=request.getParameter("idx")%>">detail</a> &gt; edit</div>
						<h1>수정 페이지</h1>
						<form action="UPDATEMEM.do">
						<input type="hidden" name="idx" value="<%=bean.getMem_num() %>">
						<p>
						<label for="mem_num">회원.no</label><input type="text" value="<%=bean.getMem_num() %>" name="mem_num" id="mem_num" readonly="readonly"/>
						</p>
						
						<p>
						<label for="ban_num">반.no</label><input type="text" value="<%=bean.getBan_num() %>" name="ban_num" id="ban_num" readonly="readonly"/>
						<label for="mem_name">이 름</label><input type="text" value="<%=bean.getMem_name() %>" name="mem_name" id="mem_name"/>
						</p>
						<p>
						<label for="mem_id">아이디</label><input type="text" value="<%=bean.getMem_id() %>" name="mem_id" id="mem_id"/>
						<label for="mem_pw">비밀번호</label><input type="text" value="<%=bean.getMem_pass() %>" name="mem_pw" id="mem_pw"/>
						</p>
						<p>
						<label for="mem_birth">생년월일</label><input type="text" value="<%=bean.getMem_birth() %>" name="mem_birth" id="mem_birth"/>
						<label for="mem_grade">등 급</label><input type="text" value="<%=bean.getMem_grade() %>" name="mem_grade" id="mem_grade"/>
						</p>
						
						<p>
						<label for="mem_ph">전화번호</label><input type="text" value="<%=bean.getMem_ph() %>" name="mem_ph" id="mem_ph" />
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