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
		<script src="/resources/js/common/comment.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jsSHA/3.2.0/sha.min.js"></script>
		<script>
			var updatePost = function() {
				location.href='/admin/post/editor?reg_no='+reg_no
			}
			
			var commentDiv = function(reply,parent,post) {
				var parentComment = $(reply).parents('.thread-alt.depth-1.comment');
				$('.commentlist .comment-respond').remove();
				var html = "";
				
				html +="<div class='comment-respond'>";
				html +="<div id='respond'>";
				html +="<form name='childForm' id='childForm' method='post' action='/api/comment'>";
				html +="<input name='parent_no' id='parent_no' value='"+parent+"' type='hidden'>";
				
				<sec:authorize access="isAnonymous()">
					html += "<div class='form-field'>";
					html += "<input name='name' id='name' placeholder='Your Name' type='text'>";
					html += "<input name='password' id='password' placeholder='Your Password' type='password'>";
					html += "</div>"
				</sec:authorize>
				html += "<div class='message form-field'>"
				html += "<textarea name='content' id='content' class='h-full-width' placeholder='Your Message' cols rows='4'></textarea>";
				html += "<button onclick='addChildComment(this,"+post+");' type='button' class='button button-success'>입력</button>";
				html += "</div>"
				html +="</form>";
				html +="</div>";
				html +="</div>";
				
				parentComment.append(html);
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
		.form-field{
			margin-bottom: 10px;
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
	                            <a href="single.html" title="">${postInfo.title}</a>
	                        </h2>
	
	                        <div class="entry__meta">
	                            <ul>
	                            	<fmt:formatDate var="date" value="${postInfo.reg_dt}" pattern="yyyy-MM-dd"/>
	                              	<li>${date}</li>
	                                <li>${postInfo.name}</li>
	                            	<sec:authorize access="hasRole('ROLE_ADMIN')">
	                            		<sec:authentication property="principal.reg_no" var="reg_no" />
	                            		<c:if test="${reg_no eq postInfo.user_no }">
	                                		<li style="cursor: pointer"><a onclick="updatePost(${postInfo.reg_no})">수정</a></li>
	                                		<li style="cursor: pointer"><a onclick="deletePost(${postInfo.reg_no})">삭제</a></li>
	                            		</c:if>
	                            	</sec:authorize>
	                            </ul>
	                        </div>
	                     
	                    </header> <!-- entry__header -->
	
	                    <div class="entry__content">
	                        ${postInfo.content}
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
			                                                <a class="comment-reply-link" onclick="commentDiv(this,${commentVO.reg_no},${commentVO.post_no});">답글쓰기</a>
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
	                            <form name="parentForm" id="parentForm" method="post" action="/api/comment/${postInfo.reg_no}">
            						<sec:authorize access="isAnonymous()">
            							<div class="form-field">
                                        	<input name="name" id="name" class="h-full-width" placeholder="Your Name" type="text">
	                                        <input name="password" id="password" class="h-full-width" placeholder="Your Password" type="password">
                                    	</div>
            						</sec:authorize>
            
                                    <div class="message form-field">
                                        <textarea name="content" id="content" class="h-full-width" placeholder="Your Message" cols rows="4"></textarea>
            							<button onclick="addParentComment(this,${postInfo.reg_no });" type="button" class="button button-success">입력</button>
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