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
		
		<link href="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/css/suneditor.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/codemirror@5.49.0/lib/codemirror.min.css">
		
		<script src="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/suneditor.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/suneditor@latest/src/lang/ko.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/codemirror@5.49.0/lib/codemirror.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/codemirror@5.49.0/mode/htmlmixed/htmlmixed.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/codemirror@5.49.0/mode/xml/xml.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/codemirror@5.49.0/mode/css/css.js"></script>
	</head>
	<style>
		.input-title{
			border-radius:5px; 
			width:100%; 
			padding:5px; 
			margin-bottom:5px;
		}
	
		.button {
		  background-color: #4CAF50; /* Green */
		  border: none;
		  color: white;
		  padding: 15px 32px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		  margin: 4px 2px;
		  cursor: pointer;
		}
		
		.button-success {background-color: #008CBA;} /* Blue */
		.button-success:hover {
		  background-color: white; 
		  color: black; 
		  padding: 14px 31px;
		  border: 1px solid #008CBA;
		}
	</style>
	<body id="top">
		<%@ include file="/WEB-INF/views/layout/header.jsp"%>
		<!-- Content -->
		<div class="s-content">
			<form id="frm" name="frm">
				<div class="row">
					<input type="text" name="title" placeholder="제목을 입력하세요" class="input-title"> 

					<textarea id="sample">Hi</textarea>
					<div style="float:left;">
						<button onclick="insertQa();" type="button" class="button button-success">등록</button>
					</div>
			    </div> <!-- end row -->
			</form>
		</div> <!-- end content-wrap -->
		<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	</body>
	<script>
		var suneditor = null;
	    
		function sun_create() {	
			suneditor = SUNEDITOR.create('sample',{
				display: 'block',
		        width: '100%',
		        height: '450px',
		        popupDisplay: 'full',
		        charCounter: true,
		        charCounterLabel: 'Characters :',
			    lang: SUNEDITOR_LANG['ko'],
			    buttonList: [
			   		['fontSize'],
			    	[
		    			'bold', 'italic', 'underline', 'strike',
			    		'fontColor', 'hiliteColor', 'textStyle',
			    		'removeFormat','image', 'video', 'link', 'table',
			    		'align', 'horizontalRule', 'list', 'lineHeight',
			    		'undo', 'redo','fullScreen', 'codeView'
			    	]
		        ],
			});
		}
		
		sun_create();
		
		insertQa = function () {
		 	var form = $("#frm");
		  	//form.attr("action", "/u-old-report");
		  	//form.attr("method", "GET");
		  	//form.submit();
			console.log(suneditor.getContents());
		}
	</script>
</html>