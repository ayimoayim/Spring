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
		</script>
		
	</head>
	
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
	        
	                            <li class="depth-1 comment">
	        
	                                <div class="comment__avatar">
	                                    <img class="avatar" src="images/avatars/user-01.jpg" alt="" width="50" height="50">
	                                </div>
	        
	                                <div class="comment__content">
	        
	                                    <div class="comment__info">
	                                        <div class="comment__author">Itachi Uchiha</div>
	        
	                                        <div class="comment__meta">
	                                            <div class="comment__time">July 12, 2019</div>
	                                            <div class="comment__reply">
	                                                <a class="comment-reply-link" href="#0">Reply</a>
	                                            </div>
	                                        </div>
	                                    </div>
	        
	                                    <div class="comment__text">
	                                    <p>Adhuc quaerendum est ne, vis ut harum tantas noluisse, id suas iisque mei. Nec te inani ponderum vulputate,
	                                    facilisi expetenda has et. Iudico dictas scriptorem an vim, ei alia mentitum est, ne has voluptua praesent.</p>
	                                    </div>
	        
	                                </div>
	        
	                            </li> <!-- end comment level 1 -->
	        
	                            <li class="thread-alt depth-1 comment">
	        
	                                <div class="comment__avatar">
	                                    <img class="avatar" src="images/avatars/user-04.jpg" alt="" width="50" height="50">
	                                </div>
	        
	                                <div class="comment__content">
	        
	                                    <div class="comment__info">
	                                        <div class="comment__author">John Doe</div>
	        
	                                        <div class="comment__meta">
	                                            <div class="comment__time">July 12, 2019</div>
	                                            <div class="comment__reply">
	                                                <a class="comment-reply-link" href="#0">Reply</a>
	                                            </div>
	                                        </div>
	                                    </div>
	        
	                                    <div class="comment__text">
	                                    <p>Sumo euismod dissentiunt ne sit, ad eos iudico qualisque adversarium, tota falli et mei. Esse euismod
	                                    urbanitas ut sed, et duo scaevola pericula splendide. Primis veritus contentiones nec ad, nec et
	                                    tantas semper delicatissimi.</p>
	                                    </div>
	        
	                                </div>
	        
	                                <ul class="children">
	        
	                                    <li class="depth-2 comment">
	        
	                                        <div class="comment__avatar">
	                                            <img class="avatar" src="images/avatars/user-03.jpg" alt="" width="50" height="50">
	                                        </div>
	        
	                                        <div class="comment__content">
	        
	                                            <div class="comment__info">
	                                                <div class="comment__author">Kakashi Hatake</div>
	        
	                                                <div class="comment__meta">
	                                                    <div class="comment__time">July 12, 2019</div>
	                                                    <div class="comment__reply">
	                                                        <a class="comment-reply-link" href="#0">Reply</a>
	                                                    </div>
	                                                </div>
	                                            </div>
	        
	                                            <div class="comment__text">
	                                                <p>Duis sed odio sit amet nibh vulputate
	                                                cursus a sit amet mauris. Morbi accumsan ipsum velit. Duis sed odio sit amet nibh vulputate
	                                                cursus a sit amet mauris</p>
	                                            </div>
	        
	                                        </div>
	        
	                                        <ul class="children">
	        
	                                            <li class="depth-3 comment">
	        
	                                                <div class="comment__avatar">
	                                                    <img class="avatar" src="images/avatars/user-04.jpg" alt="" width="50" height="50">
	                                                </div>
	        
	                                                <div class="comment__content">
	        
	                                                    <div class="comment__info">
	                                                        <div class="comment__author">John Doe</div>
	        
	                                                        <div class="comment__meta">
	                                                            <div class="comment__time">july 11, 2019</div>
	                                                            <div class="comment__reply">
	                                                                <a class="comment-reply-link" href="#0">Reply</a>
	                                                            </div>
	                                                        </div>
	                                                    </div>
	        
	                                                    <div class="comment__text">
	                                                    <p>Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est
	                                                    etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
	                                                    </div>
	        
	                                                </div>
	        
	                                            </li>
	        
	                                        </ul>
	        
	                                    </li>
	        
	                                </ul>
	        
	                            </li> <!-- end comment level 1 -->
	        
	                            <li class="depth-1 comment">
	        
	                                <div class="comment__avatar">
	                                    <img class="avatar" src="images/avatars/user-02.jpg" alt="" width="50" height="50">
	                                </div>
	        
	                                <div class="comment__content">
	        
	                                    <div class="comment__info">
	                                        <div class="comment__author">Shikamaru Nara</div>
	        
	                                        <div class="comment__meta">
	                                            <div class="comment__time">July 11, 2019</div>
	                                            <div class="comment__reply">
	                                                <a class="comment-reply-link" href="#0">Reply</a>
	                                            </div>
	                                        </div>
	                                    </div>
	        
	                                    <div class="comment__text">
	                                    <p>Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem.</p>
	                                    </div>
	        
	                                </div>
	        
	                            </li>  <!-- end comment level 1 -->
	        
	                        </ol>
	                        <!-- END commentlist -->
	
                    	</div> <!-- end comments -->
	                </div> <!-- end comments-wrap -->
	            </div> <!-- end main -->
			</div>
		</div> 
		<!-- end content-wrap -->
		<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	</body>
</html>