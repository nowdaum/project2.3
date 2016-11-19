<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type = "text/javascript" src = "\project2/js/jquery-1.11.3.js"></script>
<script>
	$(document).ready(function(){
		$('#i2').mouseover(function(){
			$('#i2').css('background-color','black')
			$('#i2').css('color','white')
			
		}).mouseout(function(){
	        	$('#i2').css('background-color','white')
	        	$('#i2').css('color','black')
	  	});
		
		$('#i3').mouseover(function(){
			$('#i3').css('background-color','black')
			$('#i3').css('color','white')
		}).mouseout(function(){
			$('#i3').css('background-color','white')
	          	$('#i3').css('color','black')
	    	});
		
		$('#i4').mouseover(function(){
			$('#i4').css('background-color','black')
			$('#i4').css('color','white')
		}).mouseout(function(){
	         	$('#i4').css('background-color','white')
	         	$('#i4').css('color','black')
	    	});
		
	
		$('#i1').mouseover(function(){
			$('#i1-1').css('display',"block")
		}).mouseout(function(){
			$('#i1-1').css('display',"none")
		});
			
	   	$('#i2').mouseover(function(){
	      		$('#i2-1').css('display',"block");
	    	}).mouseout(function(){
	        	$('#i2-1').css('display',"none")
	    	});

	    	$('#i3').mouseover(function(){
	      		$('#i3-1').css('display',"block");
	    	}).mouseout(function(){
	        	$('#i3-1').css('display',"none")
	    	});

	    	$('#i4').mouseover(function(){
	        	$('#i4-1').css('display',"block");
	    	}).mouseout(function(){
	        	$('#i4-1').css('display',"none")
	     	});
	    
	    
	   	$('#i1-1>ul>li>:eq(0)').mouseover(function(){
	    		$('#i1-1>ul>li:eq(0)').css("background-color",'rgb(192, 200, 187)');	
	    	}).mouseout(function(){
	         	$('#i1-1>ul>li:eq(0)').css('background-color','white')
	    	});
	    	$('#i1-1>ul>li>:eq(1)').mouseover(function(){
	    		$('#i1-1>ul>li:eq(1)').css("background-color",'rgb(192, 200, 187)');
	   	}).mouseout(function(){
	        	$('#i1-1>ul>li:eq(1)').css('background-color','white')
	    	});
	    	$('#i1-1>ul>li>:eq(2)').mouseover(function(){
	    		$('#i1-1>ul>li:eq(2)').css("background-color",'rgb(192, 200, 187)');
	    	}).mouseout(function(){
	        	$('#i1-1>ul>li:eq(2)').css('background-color','white')
	    	});
	    	$('#i1-1>ul>li>:eq(3)').mouseover(function(){
	    		$('#i1-1>ul>li:eq(3)').css("background-color",'rgb(192, 200, 187)');
	    	}).mouseout(function(){
	         	$('#i1-1>ul>li:eq(3)').css('background-color','white')
	    	});

	    	$('#i2-1>ul>li>:eq(0)').mouseover(function(){
	    		$('#i2-1>ul>li:eq(0)').css("background-color",'rgb(192, 200, 187)');	
	    	}).mouseout(function(){
	         	$('#i2-1>ul>li:eq(0)').css('background-color','white')
	   	 });

	    	$('#i2-1>ul>li>:eq(1)').mouseover(function(){
	    		$('#i2-1>ul>li:eq(1)').css("background-color",'rgb(192, 200, 187)');
	    	}).mouseout(function(){
	         	$('#i2-1>ul>li:eq(1)').css('background-color','white')
	   	});

	    	$('#i2-1>ul>li>:eq(2)').mouseover(function(){
	    		$('#i2-1>ul>li:eq(2)').css("background-color",'rgb(192, 200, 187)');
	   	}).mouseout(function(){
	         	$('#i2-1>ul>li:eq(2)').css('background-color','white')
	    	});

	    	$('#i2-1>ul>li>:eq(3)').mouseover(function(){
	    		$('#i2-1>ul>li:eq(3)').css("background-color",'rgb(192, 200, 187)');
	    	}).mouseout(function(){
	         	$('#i2-1>ul>li:eq(3)').css('background-color','white')
	    	});

	    	$('#i3-1>ul>li>:eq(0)').mouseover(function(){
	    		$('#i3-1>ul>li:eq(0)').css("background-color",'rgb(192, 200, 187)');	
	    	}).mouseout(function(){
	         	$('#i3-1>ul>li:eq(0)').css('background-color','white')
	    	});

	    	$('#i3-1>ul>li>:eq(1)').mouseover(function(){
	    		$('#i3-1>ul>li:eq(1)').css("background-color",'rgb(192, 200, 187)');
	   	}).mouseout(function(){
	         	$('#i3-1>ul>li:eq(1)').css('background-color','white')
	    	});

	    	$('#i3-1>ul>li>:eq(2)').mouseover(function(){
	    		$('#i3-1>ul>li:eq(2)').css("background-color",'rgb(192, 200, 187)');
	    	}).mouseout(function(){
	         	$('#i3-1>ul>li:eq(2)').css('background-color','white')
	    	});
	    
	    	$('#i4-1>ul>li>:eq(0)').mouseover(function(){
	    		$('#i4-1>ul>li:eq(0)').css("background-color",'rgb(192, 200, 187)');	
	    	}).mouseout(function(){
	         	$('#i4-1>ul>li:eq(0)').css('background-color','white')
	    	});
	    	
		<%if(session.getAttribute("login").equals("0")){%>
			$('.login1').click(function(){
				var action = "\\project2/LOGIN.do";
				var data = "id=" + $('.id').val() + "&pass=" + $('.pass').val();
				
				$.ajax({
					type: "POST",
					url: action,
					data: data,
					datatype: "JSON",
					success: function(msg){
						var loginDiv = $("#idPassLogin");
						loginDiv.empty();
						loginDiv.html(msg.mem_id + "("+ msg.mem_name +")님 로그인");
						
					},
					error: function(ms){
						$(".ms").html("아이디 혹은 비밀번호가 틀리셨습니다.");
					}
				});
			});
		<%}else if(session.getAttribute("login").equals("1")){
			if(session.getAttribute("login_grade").equals("1")){%>
				$(".message").html("<%=session.getAttribute("login_name")%>" + "<a href=\"\\project2/LOGOUT.do\" method=\"post\">로그 아웃</a>"
					+ "<br><a href=\"\\project2/ONEEDIT.do?idx=<%=session.getAttribute("login_mnum")%>\">회원 정보 수정</a>"
					+ "<br><a href=\"#\">성적 확인</a>"
					+ "<br><a href=\"#\">출석 확인</a>");
			<%}else if(session.getAttribute("login_grade").equals("2")){%>
				$(".message").html("<%=session.getAttribute("login_name")%>" + "<a href=\"#\">로그 아웃</a>"
					+ "<br><a href=\"\\project2/ONEEDIT.do?idx=<%=session.getAttribute("login_mnum")%>\">회원 정보 수정</a>"
					+ "<br><a href=\"#\">신청 확인</a>");
			<%}else if(session.getAttribute("login_grade").equals("3")){%>
				$(".message").html("<%=session.getAttribute("login_name")%>" + "<a href=\"#\">로그 아웃</a>"
					+ "<br><a href=\"\\project2/ONEEDIT.do?idx=<%=session.getAttribute("login_mnum")%>\">회원 정보 수정</a>"
					+ "<br><a href=\"#\">반 생성</a>"
					+ "<br><a href=\"#\">출석 확인</a>");
			<%}else if(session.getAttribute("login_grade").equals("4")){%>
				$(".message").html("<%=session.getAttribute("login_name")%>" + "<a href=\"#\">로그 아웃</a>"
					+ "<br><a href=\"\\project2/ONEEDIT.do?idx=<%=session.getAttribute("login_mnum")%>\">회원 정보 수정</a>"
					+ "<br><a href=\"#\">성적 등록</a>");
			<%}else if(session.getAttribute("login_grade").equals("5")){%>
				$(".message").html("<%=session.getAttribute("login_name")%>" + "<a href=\"#\">로그 아웃</a>"
					+ "<br><a href=\"\\project2/ONEEDIT.do?idx=<%=session.getAttribute("login_mnum")%>\">회원 정보 수정</a>"
					+ "<br><a href=\"\\project2/ALLMEM.do\">회원 확인</a>");
			<%}
		}%>
		
		function idpopup(){
			window.open("./idfind.jsp", "아이디찾기" , "width = 300, height = 80, resizeble = no");
		}
		
		function pwpopup(){
			window.open("./passfind.jsp", "비밀번호찾기", "width = 350, height = 120, resizeble = no");
		}
	
		var del=$('.content p>a').eq(1);
	
		del.on("click",function(){
			var num=$('.content p>span').eq(1).text();
			var result=window.confirm('게시.no:'+num+'번을\n삭제하시겠습니까?');
			return result;
		});
	
		$(document).on("click","#search",function(){//여기줄에서 버튼 id를잡아 
			var name = $('#mem_name').val();
		
			alert("name="+name);
			brdNameLoad(name);
		});
	

		function brdNameLoad(name){
	
			var param="mem_name="+name;
			$.ajax({
				'url':'NAMEFIND.do',
				'type':'post',
				'data': param,
				'datatype':'json',
				'success':function(dataBrd){
					$("#table tr").each(function() {
						$("#table tr:eq(1)").remove();
					});
			
					for(var idx=0;idx< dataBrd.mlist.length; idx++){
						$("#table").append("<tr>" 
							+ "<td>"+dataBrd.mlist[idx].num  +"</td>"
							+ "<td><a href='TITLEBRD.do?idx2=" + dataBrd.mlist[idx].num + "'>" 
							+ dataBrd.mlist[idx].name  +"</td>"
							+ "<td>"+dataBrd.mlist[idx].title  +"</td>"	
							+ "<td>"+dataBrd.mlist[idx].date  +"</td>"
							+ "</tr>");
					}
				}
			});
		}
	
		var del=$('.content p>a').eq(1);
		
		del.on("click",function(){
			var num=$('.content p>span').eq(1).text();
			var result=window.confirm('게시.no:'+num+'번을\n삭제하시겠습니까?');
			return result;
		});
	
		$(document).on("click","#search",function(){//여기줄에서 버튼 id를잡아 
			var name = $('#mem_name').val();
			
			alert("name="+name);
			brdNameLoad(name);
		});
		
		$(document).on("click","#search",function(){//여기줄에서 버튼 id를잡아 
			var name = $('#mem_name').val();
			
			alert("name="+name);
			brdNameLoad(name);
		});
	
		var del=$('.content p>a').eq(1);
		
		del.on("click",function(){
			var num=$('.content p>span').eq(3).text();
			var result=window.confirm(+num+'번 학생의 성적을\n삭제하시겠습니까?');
			return result;
		});
	
		$('.overlap').click(function(){
			var action = "../IDCHECK.do";
			var data = "id=" + $('.id').val();
			var id = $('.id').val();
			
			$.ajax({
				type: "POST",
				url: action,
				data: data,
				datatype: "JSON",
				success: function(msg){
					$('.idform').html("<input type = \"text\" class = \"id\" value = \"" + msg.mem_id + "\" readonly/>");
				},
				error: function(ms){
					$('.mes').html("아이디가 중복되셨습니다.");
				}
			});
		});
	
		var menu=$('.menu');
		menu.on('mouseover',function(){
			$('.menu2').css('display','block');
		}).on('mouseout',function(){
			$('.menu2').css('display','none');
		});
	
		$('.pwfind').click(function(){
			var action = "../PASSFIND.do";
			var data = "name=" + $('.name').val() + "&birth=" + $('.birth').val() + "&pw=" + $('.pw').val();
			
			$.ajax({
				type: "POST",
				url: action,
				data: data,
				datatype: "JSON",
				success: function(msg){
					$('.pwfindform').html(msg.pw[0].mem_pw);
				},
				error: function(ms){
					$('.message').html("이름 혹은 생년월일, 아이디가 틀리셨습니다.");
				}
			});
		});
	
		$('.softwear').css('border-bottom', '2px solid black');
		$('.logo').css('display', 'inline-block');
		$('.logo > img').css('width', '80px');
		$('.logo > img').css('heigth', '80px');

		function popupOpen() {
			var popUrl = "content/edu_description.html"; //팝업창에 출력될 페이지 URL
			var popOption = " width=1000, height=1000, location=no;"; //팝업창 옵션(optoin)
			window.open(popUrl, "", popOption);
		}
		function button2_2_click() {
			alert("수강신청이 되었습니다");
		}
	});
</script>