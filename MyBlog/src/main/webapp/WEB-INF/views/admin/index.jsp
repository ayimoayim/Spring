<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
   		<meta name="description" content="">
   		<meta name="author" content="">	
		<!-- mobile specific metas -->
   		<meta name="viewport" content="width=device-width, initial-scale=1">
   		
		<title>Insert title here</title>
		<%@ include file="/WEB-INF/views/layout/common.jsp"%>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" integrity="sha384-wESLQ85D6gbsF459vf1CiZ2+rr+CsxRY0RpiF1tLlQpDnAgg6rwdsUF1+Ics2bni" crossorigin="anonymous">
	</head>
	<style>
		.menu{
			border:1px solid black;
		}
		.sub_menu{
			border-bottom:1px solid black;
		}
		.menu_list{
			margin-bottom:0px;
			padding-bottom:14px;
		}
		.menu_list a{
			padding-left:30px;
		}
	</style>
	<body id="top">
		
		<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	
		<!-- Content -->
		<div class="s-content">
			<div class="row">
				<div class="column large-4 tab-full">
					<div style="width:216px;" id="sidebar" class="s-content__sidebar">
						<div class="menu">
							<div class="sub_menu">
								<ul class="menu_list">
									<li><a href="/admin/post/editor">글쓰기</a></li>
									<li><a>TEST1</a></li>
									<li><a>TEST1</a></li>
								</ul>
							</div>
							<div class="sub_menu">
								<ul class="menu_list">
									<li><a>TEST2</a></li>
								</ul>
							</div>
							<div class="sub_menu">
								<ul class="menu_list">
									<li><a>TEST3</a></li>
								</ul>
							</div>
						</div>
	               
	       			</div> <!-- end sidebar -->
          		</div>
          		<div class="column large-8 tab-full">
          			<div class="list">
          				<ul>
          					
          				</ul>
          			</div>
          		</div>
			</div>
		</div> <!-- end content-wrap -->
		
		<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	</body>
</html>