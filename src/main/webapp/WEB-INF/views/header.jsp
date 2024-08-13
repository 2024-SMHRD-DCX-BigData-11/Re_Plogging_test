<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>RE: PLOGGING</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="assets/css/header.css">
</head>
<body>
	<div class="header">
		<div class="user-icon" onclick="openModal()">
			<img src="img/비로그인.png">
		</div>
		<div class="logo">
			<a href="${pageContext.request.contextPath}/main"><img
				src="img/Re_Plogging_로고.png" alt=""></a>
		</div>
		<button class="menu-icon" id="menu-icon">
			<span class="burgur" id="burgur"> <span class="top-line"></span>
				<span class="bot-line"></span>
			</span>
		</button>
		<ul class="menu">
			<li><a href="#">플로코스</a></li>
			<li><a href="#">분리배출</a></li>
			<li><a href="${pageContext.request.contextPath}/community">커뮤니티</a></li>
			<li><a href="#">그린마켓</a></li>
			<c:choose>
				<c:when test="${loginSuccess}">
					<li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="#" onclick="openModal()">로그인</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

	<div id="overlay"></div>

	<div id="aside" class="aside">
		<div class="aside_inner_container">
			<li>소희님</li>
			<li>보유 마일리지: 1000p</li>
			<div class="line"></div>
			<ul class="aside_category">
				<li>플로코스</li>
				<li>분리배출</li>
				<a href="${pageContext.request.contextPath}/community"
					style="text-decoration: none; color: inherit;"><li>커뮤니티</li></a>
				<li>그린마켓</li>
		</div>
		</ul>
		<div class="aside_footer">
			<div class="aside_innser_footer">
				<li><a href="">로그아웃</a></li>
			</div>
		</div>
	</div>
	<!-- Scripts -->
	<script src="assets/js/header.js"></script>
</body>
</html>