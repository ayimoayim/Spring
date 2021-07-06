<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <meta name="description" content="">
    <meta name="author" content="">	
	<!-- mobile specific metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- CSS -->
    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/main.css">
	
	<!-- script -->
    <script src="resources/js/modernizr.js"></script>
    <script defer src="resources/js/fontawesome/all.min.js"></script>
	
	<!-- favicons -->
    <link rel="apple-touch-icon" sizes="180x180" href="resources/Keep_it_simple_3_0_0/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="resources/Keep_it_simple_3_0_0/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/Keep_it_simple_3_0_0/favicon-16x16.png">
    <link rel="manifest" href="resources/Keep_it_simple_3_0_0/site.webmanifest">
    
    <!-- Java Script -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/main.js"></script>
</head>
<body id="top">

	<!-- preloader -->
    <div id="preloader">
        <div id="loader" class="dots-fade">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>
	<!-- 탑메뉴 : 네비게이션 바 -->
	<tiles:insertAttribute name="header"/>
	<!-- 바디 부분 -->
	<tiles:insertAttribute name="body"/>
	<!-- 푸터 부분 -->
	<tiles:insertAttribute name="footer"/>
</body>
</html>