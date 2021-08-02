function findFormObject(caller) {
    for (var obj = caller; obj; obj = obj.parentNode) if ("FORM" == obj.nodeName) return obj;
    return null;
}

function addParentComment(caller, id) {
	
	var ol = $(".commentlist");
	var oForm = findFormObject(caller);
	
	var data = {
		depth: "1",
		post_no: id,
    }
	
	if (oForm["name"]) {
  		data.name = oForm["name"].value
    }

    if (oForm["password"]) {
  		var passwd = oForm["password"].value.trim();
      	if (passwd.length == 0) {
    		alert('비밀번호를 입력해 주세요.');
    		return false;
      	}

      	var shaObj = new jsSHA("SHA-256", "TEXT");
      	shaObj.update(encodeURIComponent(passwd));
      	data.password = shaObj.getHash("HEX");
    }
    
    if (oForm["content"]) {
    	data.content = oForm["content"].value
  	}

    $.ajax({
		type:'POST',
		url:'/api/comment',
		data : JSON.stringify(data),
	    dataType : "json",
	    contentType: "application/json",
		success : function(data){
			var html = data.commentBlock;
			$('.commentlist .comment-respond').remove();
			ol.html(html);
		}
	});
    
}

function addChildComment(caller, id) {
	
	var ol = $(".commentlist");
	var oForm = findFormObject(caller);
	
	var data = {
		depth: "2",
		post_no: id,
    }
	
	if (oForm["name"]) {
  		data.name = oForm["name"].value
    }

    if (oForm["password"]) {
  		var passwd = oForm["password"].value.trim();
      	if (passwd.length == 0) {
    		alert('비밀번호를 입력해 주세요.');
    		return false;
      	}

      	var shaObj = new jsSHA("SHA-256", "TEXT");
      	shaObj.update(encodeURIComponent(passwd));
      	data.password = shaObj.getHash("HEX");
    }
    
    if (oForm["content"]) {
    	data.content = oForm["content"].value
  	}
    
    if (oForm["parent_no"]) {
    	data.parent_no = oForm["parent_no"].value
  	}
    
    $.ajax({
		type:'POST',
		url:'/api/comment',
		data : JSON.stringify(data),
	    dataType : "json",
	    contentType: "application/json",
		success : function(data){
			var html = data.commentBlock;
			$('.commentlist .comment-respond').remove();
			ol.html(html);
		}
	});
    
}