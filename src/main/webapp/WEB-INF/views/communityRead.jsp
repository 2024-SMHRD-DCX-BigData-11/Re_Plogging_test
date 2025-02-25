<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="header.jsp"%>
<%@ include file="modal.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RE:PLOGGING COMMUNITYREAD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/communityRead.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<div class="comRead-container">
		<div class="comRead-innner">
			<div class="post-details">
				<span class="post-category">${community.category}&nbsp;&gt;</span>
				<h2 class="post-title">${community.title}</h2>
				<div class="post-meta">
					<div class="meta-left">
						<span class="post-meta-userNick">${community.writer.userNick}</span>
						<fmt:formatDate value="${community.indate}" pattern="yyyy.MM.dd" />
					</div>
					<div class="meta-right">
						조회수 ${community.count}&nbsp;&nbsp;|&nbsp;
						<form id="likeForm"
							action="${pageContext.request.contextPath}/likePost"
							method="post" style="display: inline;">
							<input type="hidden" name="idx" value="${community.idx}" /> <i
								class="fas fa-heart"
								onclick="likePost(${sessionScope.user.userIdx})"></i>
							${community.likes}
						</form>
					</div>
				</div>
				<div class="post-content">
					<c:if test="${community.img != null}">
						<img
							src="${pageContext.request.contextPath}/image/${community.idx}">
					</c:if>
					<p>${community.content}</p>
				</div>
			</div>

			<div class="comments-section">
				<c:forEach var="comment" items="${community.comments}">
					<div class="comment">
						<div class="comment-inner">
							<span class="comment-user">${comment.user.userNick}</span>
							<span class="comment-date"><fmt:formatDate value="${comment.indate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></span>
						<!-- 삭제 버튼 (댓글 작성자와 로그인한 사용자가 동일한 경우에만 보임) -->
						<c:if
							test="${sessionScope.user != null && comment.user.userIdx == sessionScope.user.userIdx}">
							<form
								action="${pageContext.request.contextPath}/comments/deleteComment"
								method="post" style="display: inline;">
								<input type="hidden" name="commentId" value="${comment.idx}">
								<button type="submit" class="comment-delete">삭제</button>
							</form>
						</c:if>
						</div>
						<p>${comment.message}</p>
					</div>
				</c:forEach>

				<c:if test="${sessionScope.user != null}">
					<form class="comment-form"
						action="${pageContext.request.contextPath}/comments/addComment"
						method="post" onsubmit="return validateCommentForm();">
						<input type="hidden" name="communityId" value="${community.idx}">
						<textarea name="commentContent" placeholder="댓글을 남겨보세요."></textarea>
						<button type="submit">등록</button>
					</form>
				</c:if>
				<c:if test="${sessionScope.user == null}">
					<p class="comment-login">댓글을 작성하려면 <a href="#" onclick="openModal()">로그인</a> 해주세요.</p>
				</c:if>
			</div>
		</div>

		<div class="navigation">
			<div class="navigation-left">
				<c:if
					test="${community.writer.userIdx == sessionScope.user.userIdx}">
					<a
						href="${pageContext.request.contextPath}/editPost?idx=${community.idx}"
						class="nav-modify">수정</a>
					<a
						href="${pageContext.request.contextPath}/deletePost?idx=${community.idx}"
						class="nav-delete">삭제</a>
				</c:if>
			</div>
			<div class="navigation-right">
				<a href="${pageContext.request.contextPath}/community"
					class="nav-list">목록</a>
				<c:if test="${sessionScope.user != null}">
					<a href="${pageContext.request.contextPath}/communityWriter"
						class="nav-write">글쓰기</a>
				</c:if>
			</div>
		</div>
	</div>
	
	<footer> © 2024 지구수호대 Korea Corporation All Rights Reserved. </footer>
	
	<script src="assets/js/communityRead.js"></script>
</body>
</html>
