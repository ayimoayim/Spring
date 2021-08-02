package com.my.blog.util;

import java.util.List;

import com.my.blog.post.vo.CommentVO;

public class MakeHtmlUtil {

	
	public static String makeCommentHtml(List<CommentVO> commentList) {
		
		String html = "";
		
		for(CommentVO commentVO:commentList) {
		
			if(commentVO.getDepth().equals("1")) {
				html += "<li class='thread-alt depth-1 comment'>";
				
				html += "<div class='comment__avatar'>";
				html += "<img class='avatar' src='/resources/images/avatars/user-01.jpg' alt='' width='50' height='50'>";
				html += "</div>";
				
				html += "<div class='comment__content'>";
				html += "<div class='comment__info'>";
				
				html += "<div class='comment__author'>"+commentVO.getName()+"</div>";
				
				html += "<div class='comment__meta'>";
				html += "<div class='comment__time'>"+commentVO.getReg_dt()+"</div>";
				html += "<div class='comment__reply'>";
				html += "<a class='comment-reply-link' onclick='commentDiv(this,"+commentVO.getParent_no()+","+commentVO.getPost_no()+");'>답글쓰기</a>";
				html += "<a class='comment-reply-link'>수정</a>";
				html += "<a class='comment-reply-link'>삭제</a>";
				
				html += "</div>";
				html += "</div>";
				html += "</div>";
				
				html += "<div class='comment__text'>";
				html += "<p>"+commentVO.getContent()+"</p>";
				
				
				html += "</div>";
				html += "</div>";
				
				for(CommentVO commentVO2:commentList) {
					if(commentVO2.getDepth().equals("2") && commentVO.getReg_no().equals(commentVO2.getParent_no())){
						html += "<ul class='children'>";
						html += "<li class='depth-2 comment'>";
						
						html += "<div class='comment__avatar'>";
						html += "<img class='avatar' src='/resources/images/avatars/user-02.jpg' alt='' width='50' height='50'>";
						html += "</div>";
						
						html += "<div class='comment__content'>";
						html += "<div class='comment__info'>";
						
						html += "<div class='comment__author'>"+commentVO2.getName()+"</div>";
						
						html += "<div class='comment__meta'>";
						html += "<div class='comment__time'>"+commentVO2.getReg_dt()+"</div>";
						html += "<div class='comment__reply'>";
						html += "<a class='comment-reply-link'>수정</a>";
						html += "<a class='comment-reply-link'>삭제</a>";
						html += "</div>";
						html += "</div>";
						
						
						html += "</div>";
						
						html += "<div class='comment__text'>";
						html += "<p>"+commentVO2.getContent()+"</p>";
						html += "</div>";
						
						html += "</div>";
						
						html += "</li>";
						html += "</ul>";
					}
				}
				html += "</li>";
			}
		}
		return html;
	}
	
}
