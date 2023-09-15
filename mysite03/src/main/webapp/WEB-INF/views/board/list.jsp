<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>				
					<tr>
						<td>3</td>
						<td style="padding-left: ${(1-1)*30 }px">
							<a href="">세 번째 글입니다.</a>
						</td>
						<td>안대혁</td>
						<td>3</td>
						<td>2015-10-11 12:04:20</td>
						<td><a href="" class="del">삭제</a></td>
					</tr>
					<tr>
						<td>2</td>
						<td style="padding-left: ${(2-1)*30 }px">
							<img src="${pageContext.request.contextPath }/assets/images/reply.png">
							<a href="">두 번째 글입니다.</a>
						</td>
						<td>안대혁</td>
						<td>3</td>
						<td>2015-10-02 12:04:12</td>
						<td><a href="" class="del">삭제</a></td>
					</tr>
					<tr>
						<td>1</td>
						<td style="padding-left: ${(3-1)*30 }px">
							<img src="${pageContext.request.contextPath }/assets/images/reply.png">
							<a href="">첫 번째 글입니다.</a>
						</td>
						<td>안대혁</td>
						<td>3</td>
						<td>2015-09-25 07:24:32</td>
						<td><a href="" class="del">삭제</a></td>
					</tr>
				</table>
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li class="selected">2</li>
						<li><a href="">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>					
				<!-- pager 추가 -->				
				<div class="bottom">
					<a href="" id="new-book">글쓰기</a>
				</div>				
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>