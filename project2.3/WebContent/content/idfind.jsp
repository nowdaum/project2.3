<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type = "text/javascript" src = "\project2/js/jquery-1.11.3.js"></script>
<script>
	$(document).ready(function(){
		$('.corso').css('display','inline-block');
		$('.idfind').click(function(){
			var action = "../IDFIND.do";
			var data = "name=" + $('.name').val() + "&birth=" + $('.birth').val();
			
			$.ajax({
				type: "POST",
				url: action,
				data: data,
				datatype: "JSON",
				success: function(msg){
					$('.idfindform').html(msg.id[0].mem_id);
				},
				error: function(ms){
					$('.message').html("이름 혹은 생년월일이 틀리셨습니다.");
				}
			});
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "idfindform">
		<div class = "corso">
			<div>이름</div>
			<div>생년월일</div>
		</div>
		<div class = "corso">
			<div><input class = "name" type = "text"></div>
			<div><input class = "birth" type = "text" value = "ex)20161115"></div>
		</div>
		<div class = "corso"><input class = "idfind" type = "button" value = "ID찾기"/></div>
		<div class = "message"></div>
	</div>
</body>
</html>