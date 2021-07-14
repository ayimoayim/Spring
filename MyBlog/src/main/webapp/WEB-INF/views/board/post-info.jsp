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
		
		<script>
			var updatePost = function() {
				location.href='/admin/post/editor?reg_no='+reg_no
			}
		
			var deletePost = function(reg_no) {
				
				if(confirm("정말로 삭제 하시겠습니까?")){
					var form = document.createElement('form');
					var input = document.createElement('input');
					
					form.setAttribute('method','POST');
					form.setAttribute('action','/admin/post/delete');
					
					input.setAttribute('type','hidden');
					input.setAttribute('name','reg_no');
					input.setAttribute('value',reg_no);
					
					form.appendChild(input);
					document.body.appendChild(form);
					form.submit();
				}
			}
			
			var addParentComment = function() {
				var form = $("#parentForm");
				var input = document.createElement('input');
				input.setAttribute('type','hidden');
				input.setAttribute('name','depth');
				input.setAttribute('value','1');
				
				form.append(input);
				
				$.ajax({
					type:'POST',
					url:'/comment/insert',
					dataType : 'json',
					data : form.serialize(),
					success : function(data){
						addHtml(data);
					}
				});
			}
			
			var addChildComment = function(button) {
				var form = $("#childForm");
				var input = document.createElement('input');
				input.setAttribute('type','hidden');
				input.setAttribute('name','depth');
				input.setAttribute('value','2');
				
				form.append(input);
				
				var board_no = form.find("#board_no");
				var parent_no = form.find("#parent_no");
				var content = form.find("#content");
				
				var parentComment = $(button).parents('.thread-alt.depth-1.comment');
				
				$.ajax({
					type:'POST',
					url:'/comment/insert',
					data : form.serialize(),
					dataType: 'json',
					success : function(data){
						addHtml(data);
					}
				});
			}
			
			function addHtml(data){
				var html = "";
				var ol = $(".commentlist");
				data.forEach(function (item) {
					var reg_no = item.reg_no;
					var reg_dt = item.reg_dt;
					var board_no = item.board_no;
 					var name = item.name;
					var content = item.content;
					var depth = item.depth;
					
					if(depth == 1){
						
						html += "<li class='thread-alt depth-1 comment'>";
						
						html += "<div class='comment__avatar'>";
						html += "<img class='avatar' src='/resources/images/avatars/user-01.jpg' alt='' width='50' height='50'>";
						html += "</div>"
						
						html += "<div class='comment__content'>";
						html += "<div class='comment__info'>";
						
						html += "<div class='comment__author'>"+name+"</div>";
						
						html += "<div class='comment__meta'>";
						html += "<div class='comment__time'>"+reg_dt+"</div>";
						html += "<div class='comment__reply'>";
						html += "<a class='comment-reply-link' onclick='commentDiv(this,"+reg_no+");'>답글쓰기</a>";
						html += "<a class='comment-reply-link'>수정</a>";
						html += "<a class='comment-reply-link'>삭제</a>";
						
						html += "</div>"
						html += "</div>"
						html += "</div>"
						
						html += "<div class='comment__text'>";
						html += "<p>"+content+"</p>";
						
						
						html += "</div>"
						html += "</div>"
						
						
						data.forEach(function (item2) {
							var reg_no2 = item2.reg_no;
							var reg_dt2 = item2.reg_dt;
							var board_no2 = item2.board_no;
							var parent_no = item2.parent_no;
		 					var name2 = item2.name;
							var content2 = item2.content;
							var depth2 = item2.depth;
							
							if(depth2 == 2 && reg_no == parent_no){
								html += "<ul class='children'>";
								html += "<li class='depth-2 comment'>";
								
								html += "<div class='comment__avatar'>";
								html += "<img class='avatar' src='/resources/images/avatars/user-01.jpg' alt='' width='50' height='50'>";
								html += "</div>"
								
								html += "<div class='comment__content'>";
								html += "<div class='comment__info'>";
								
								html += "<div class='comment__author'>"+name2+"</div>";
								
								html += "<div class='comment__meta'>";
								html += "<div class='comment__time'>"+reg_dt2+"</div>";
								html += "<div class='comment__reply'>";
								html += "<a class='comment-reply-link'>수정</a>";
								html += "<a class='comment-reply-link'>삭제</a>";
								html += "</div>"
								html += "</div>";
								
								
								html += "</div>";
								
								html += "<div class='comment__text'>";
								html += "<p>"+content2+"</p>";
								html += "</div>";
								
								html += "</div>";
								
								html += "</li>";
								html += "</ul>";
							}
						});
						
						html += "</li>";
					}
				});
				ol.empty();
				ol.append(html);
			}
			
			var commentDiv = function(reply,parent) {
				var parentComment = $(reply).parents('.thread-alt.depth-1.comment');
				$('.commentlist .comment-respond').remove();
				var html = "";
				
				html +="<div class='comment-respond'>";
				html +="<div id='respond'>";
				html +="<form name='childForm' id='childForm' method='post' action='/comment/insert'>";
				html +="<input name='board_no' id='board_no' value='${boardInfo.reg_no }' type='hidden'>";
				html +="<input name='parent_no' id='parent_no' value='"+parent+"' type='hidden'>";
				
				<sec:authorize access="isAnonymous()">
					html += "<div class='form-field'>";
					html += "<input name='name' id='name' placeholder='Your Name' type='text'>";
					html += "<input name='password' id='password' placeholder='Your Password' type='password'>";
					html += "</div>"
				</sec:authorize>
				html += "<div class='message form-field'>"
				html += "<textarea name='content' id='content' class='h-full-width' placeholder='Your Message' cols rows='4'></textarea>";
				html += "<button onclick='addChildComment(this);' type='button' class='button button-success'>입력</button>";
				html += "</div>"
				html +="</form>";
				html +="</div>";
				html +="</div>";
				
				parentComment.append(html);
			}
			
		</script>
		
	</head>
	<style>
		.depth-1{
			margin-bottom:5px;
		}
		.comment__reply{
			cursor:pointer;
		}
		#comments{
			padding-bottom:0px;
		}
		#respond{
    		background-color: rgba(0,0,0,.02);
    		padding-left: 15px;
    		padding-right: 15px;
    		padding-top: 10px;
		}
		#name, #password{
			width:140px;
			height:52px;
			margin-right: 6px;
		}
		#content{
			display: block;
	    	margin-bottom: 5px;
	    	padding: 10px;
	    	resize: none;
	    	box-sizing: border-box;
		}
	</style>
	<body id="top">
		<%@ include file="/WEB-INF/views/layout/header.jsp"%>
		<!-- Content -->
		<div class="s-content">
			<div class="row">
				<div id="main" class="s-content__main large-8 column">
	                <article class="entry">
	
	                    <header class="entry__header">
	
	                        <h2 class="entry__title h1">
	                            <a href="single.html" title="">${boardInfo.title}</a>
	                        </h2>
	
	                        <div class="entry__meta">
	                            <ul>
	                            	<fmt:formatDate var="date" value="${boardInfo.reg_dt}" pattern="yyyy-MM-dd"/>
	                              	<li>${date}</li>
	                                <li>${boardInfo.name}</li>
	                            	<sec:authorize access="hasRole('ROLE_ADMIN')">
	                            		<sec:authentication property="principal.reg_no" var="reg_no" />
	                            		<c:if test="${reg_no eq boardInfo.user_no }">
	                                		<li style="cursor: pointer"><a onclick="updatePost(${boardInfo.reg_no})">수정</a></li>
	                                		<li style="cursor: pointer"><a onclick="deletePost(${boardInfo.reg_no})">삭제</a></li>
	                            		</c:if>
	                            	</sec:authorize>
	                            </ul>
	                        </div>
	                     
	                    </header> <!-- entry__header -->
	
	                    <div class="entry__content">
	                        ${boardInfo.content}
	                    </div>
	
	                    <p class="entry__tags">
	                        <span>Tagged in </span>:
	                        <a href="#0">orci</a>, <a href="#0">lectus</a>, <a href="#0">varius</a>, <a href="#0">turpis</a>
	                    </p>
	
	                    <ul class="entry__post-nav h-group">
	                        <li class="prev"><a rel="prev" href="#0"><strong class="h6">Previous Article</strong> Duis Sed Odio Sit Amet Nibh Vulputate</a></li>
	                        <li class="next"><a rel="next" href="#0"><strong class="h6">Next Article</strong> Morbi Elit Consequat Ipsum</a></li>
	                    </ul>
	
	                </article> <!-- end entry -->
	
	                <div class="comments-wrap">
	
	                    <div id="comments">
	
	                        <h3>5 Comments</h3>
	        
	                        <!-- START commentlist -->
	                        <ol class="commentlist">
	                        	<c:forEach var="commentVO" items="${commentList}">
	                        		<c:if test="${1 eq  commentVO.depth}">
	                        			<li class="thread-alt depth-1 comment">
			                                <div class="comment__avatar">
			                                    <img class="avatar" src="/resources/images/avatars/user-01.jpg" alt="" width="50" height="50">
			                                </div>
			                                <div class="comment__content">
			                                    <div class="comment__info">
			                                        <div class="comment__author">${commentVO.name}</div>
			        
			                                        <div class="comment__meta">
			                                        	<fmt:formatDate var="date" value="${commentVO.reg_dt}" pattern="yyyy-MM-dd HH:mm:ss"/>
			                                            <div class="comment__time">${date}</div>
			                                            <div class="comment__reply"">
			                                                <a class="comment-reply-link">수정</a>
			                                                <a class="comment-reply-link">삭제</a>
			                                                <a class="comment-reply-link" onclick="commentDiv(this,${commentVO.reg_no});">답글쓰기</a>
			                                            </div>
			                                        </div>
			                                    </div>
			        
			                                    <div class="comment__text">
			                                    	<p>${commentVO.content}</p>
			                                    </div>
			                                </div>
			                                <c:forEach var="commentVO2" items="${commentList}">
		                               			<c:if test="${2 eq  commentVO2.depth and commentVO.reg_no eq  commentVO2.parent_no}">
				                        			<ul class="children">
					                                    <li class="depth-2 comment">
					                                        <div class="comment__avatar">
					                                            <img class="avatar" src="/resources/images/avatars/user-02.jpg" alt="" width="50" height="50">
					                                        </div>
					                                        <div class="comment__content">
					                                            <div class="comment__info">
					                                                <div class="comment__author">${commentVO2.name}</div>
					                                                <div class="comment__meta">
					                                                	<fmt:formatDate var="date2" value="${commentVO2.reg_dt}" pattern="yyyy-MM-dd HH:mm:ss"/>
					                                                    <div class="comment__time">${date2}</div>
					                                                    <div class="comment__reply"">
							                                                <a class="comment-reply-link">수정</a>
							                                                <a class="comment-reply-link">삭제</a>
							                                            </div>
					                                                </div>
					                                            </div>
					                                            <div class="comment__text">
					                                                <p>${commentVO2.content}</p>
					                                            </div>
					                                        </div>
				                                    	</li>
				                                	</ul>
				                        		</c:if>
	                               			</c:forEach>
	                               		</li>
	                        		</c:if>
	                        	</c:forEach>
	                        </ol>
	                        <!-- END commentlist -->
	
                    	</div> <!-- end comments -->
                    	
                    	<div class="comment-respond">
	                        <!-- START respond -->
	                        <div id="respond">
	                            <form name="parentForm" id="parentForm" method="post" action="/comment/insert">
            						<input name="board_no" id="board_no" value="${boardInfo.reg_no }" type="hidden">
            						<sec:authorize access="isAnonymous()">
            							<div class="form-field">
                                        	<input name="name" id="name" class="h-full-width" placeholder="Your Name" type="text">
	                                        <input name="password" id="password" class="h-full-width" placeholder="Your Password" type="password">
                                    	</div>
            						</sec:authorize>
            
                                    <div class="message form-field">
                                        <textarea name="content" id="content" class="h-full-width" placeholder="Your Message" cols rows="4"></textarea>
            							<button onclick="addParentComment();" type="button" class="button button-success">입력</button>
                                    </div>
            
	                            </form> <!-- end form -->
	                        </div>
	                        <!-- END respond-->
                    	</div> 
                    	<!-- end comment-respond -->
                	</div> <!-- end comments-wrap -->
	            </div> <!-- end main -->
			</div>
		</div> 
		<!-- end content-wrap -->
		<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	</body>
</html>