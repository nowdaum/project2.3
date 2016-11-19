<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	*{
            margin: 0px;
            padding: 0px;
        }
        .container{
					margin: 0px auto;
		}	
        .gride12{	
        			
        			maigin:0px auto;
        }
        .grid0,.grid0-1,.grid1,.grid1-1,.grid1-2,.grid2,.grid2-1,.grid3
                ,.grid4,.grid5,.grid5-1,.grid6
                ,.grid7,.grid8,.grid9
                ,.grid10,.grid11,.grid12{
                    float: left;
                    border: 1px white solid;
                    box-sizing: border-box;
                }
        
        @media screen and (max-width:400px){
            /*모바일*/    
            .container{
					width: 100%;
				}	
            .container .mgrid1{width: 8.333%;}
            .container .mgrid2{width: 16.666%;}
            .container .mgrid3{width: 25%;}
            .container .mgrid4{width: 33.333%;}
            .container .mgrid5{width: 41.666%;}
            .container .mgrid6{width: 50%;}
            .container .mgrid7{width: 58.333%;}
            .container .mgrid8{width: 66.666%;}
            .container .mgrid9{width: 75%;}
            .container .mgrid10{width: 83.333%;}
            .container .mgrid11{width: 91.666%;}
            .container .mgrid12{width: 100%;}
            .mrow{clear: both;}
            .mclear{
                display: none;
            }
           
        }
        
         @media screen and (min-width:401px){
             /*pc용*/
            .container{
                width: 100%;
            }
            .container .grid0{width: 2.222%;}
            .container .grid0-1{width: 4.444%;}
            .container .grid1{width: 8.333%;}
            .container .grid1-1{width: 10%;}
            .container .grid2{width: 150%;}
            .container .grid2-1{width: 16.666%;}
            .container .grid5-1{width: 44.444%;}
            .container .grid12{width: 100%;}
            .row{clear: both;}
        }
   *{
      font-family: '맑은 고딕';
	}
	
	.menu>div>div>ul{
		background-color:white;
		list-style:none;
		font-size:15px;	
		/*float:none;*/
}
	}
	.menu>div>div{
		color: rgb(192, 200, 187);
		font-weight: bold;
	}
	
	.submenu{
		border: 1px rgb(192, 200, 187) solid;
        box-sizing: border-box;
		display:none;
	}
	
	 a:link { color: black; text-decoration: none; font-size:17px; } /* a:link : 클릭하지 않은 링크 */
 	 a:visited { color: black; text-decoration: none; font-size:17px;}/*a:active : 링크부분에서 마우스를 누르고 있는 동안의 상태 */
	 a:hover {color: rgb(185,57,58); text-decoration: none; font-size:17px; font-weight:bold} /*a:hover : 링크를 클릭하려고 마우스를 가져갔을 때*/

</style>
<%@ include file = "../js/js.jsp" %>
	<div class="container">
		<div class="grid12">
			<div class="menu row">
				<div class="grid1" id="i1"><img alt="" src="\project2/image/2.png" />
					<div class="grid2 submenu" id="i1-1">
						<ul style="text-align:left">
							<li><a href="\project2/content/outline.jsp">소개</a></li>
							<li><a href="\project2/content/greeting.jsp">인사말</a></li>
							<li><a href="\project2/content/road.jsp">오시는길</a></li>
						</ul>
					</div>
				</div>	
				<div class="grid2-1" ><img alt="" src="\project2/image/1.png" /></div>
				<div class="grid5-1">&nbsp;</div>		
				<div class="grid1"><a href="\project2/content/main.jsp">HOME</a></div>
				<div class="grid1"><a href="\project2/content/login.jsp">LOGIN</a></div>
				<div class="grid1"><a href="\project2/content/membership.jsp">JOIN US</a></div>
				<div class="grid1">&nbsp;</div>	
				<div class="grid1-1" id="i2" style="font-weight: bold; text-align:center" >소개		
					<div class="grid2 submenu" id="i2-1"> 
						<ul style="text-align:left">
							<li><a href="\project2/content/outline.jsp">소개</a></li>
							<li><a href="\project2/content/greeting.jsp">인사말</a></li>
							<li><a href="\project2/content/history.jsp">연혁</a></li>
							<li><a href="\project2/content/instructor.jsp">강사진소개</a></li>
							<li><a href="\project2/content/road.jsp">오시는길</a></li>
						</ul>
					</div>
				</div>
			<div class="grid0">&nbsp;</div>		
			<div class="grid1-1" id="i3" style="font-weight: bold; text-align:center">교육 과목      
				<div class="grid2 submenu" id="i3-1">
					<ul style= "text-align:left">
						<li><a href="\project2/Swlist.do">응용SW 과정</a></li>
						<li><a href="\project2/list.do">프로그래밍 과정</a></li>
						<li><a href="\project2/Pulist.do">퍼블리셔 과정</a></li>
					</ul>
				</div>
			</div>
			<div class="grid0-1">&nbsp;</div>	
			<div class="grid1-1" id="i4" style="font-weight: bold; text-align:center">게시판
				<div class="grid2 submenu" id="i4-1">
					<ul>
						<li style="text-align:left">
						<a href="\project2/ALLBRD.do" >게시판</a></li>
					</ul>
				</div>
			</div>
		</div>
		</div>
	</div><!-- container end -->