<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function(){
	$('#btn-check-email').click(function() {
		var email = $('#email').val();
		if(email === '') {
			return;
		}

		$.ajax({
			url: '${pageContext.request.contextPath }/api/user?email=' + email,
			type: 'get',
			dataType: 'json',
			success: function(response) {
				if(response.result !== 'success') {
					console.error(reponse.message);
					return;
				}
				
				if(response.data) {
					$("#dialog").dialog();
					$("#email").val('').focus();
					return;
				}
				
				$('#img-check-email').show();
				$('#btn-check-email').hide();
			},
			error: function(xhr, status, e) {
				console.error(status, e);
			}
		});
	});
});
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">
				<form:form
					modelAttribute="userVo" 
					id="join-form"
					name="joinForm"
					method="post"
					action="${pageContext.request.contextPath }/user/join">
					
					<label class="block-label" for="name">이름</label>
					<form:input path="name" />
					<p style="padding:3px 0 5px 0; text-align: left; color: #f00">
						<spring:hasBindErrors name="userVo">
							<c:if test="${errors.hasFieldErrors('name') }">
								<!--
								${errors.getFieldError("name").defaultMessage }
								-->
								<spring:message code='${errors.getFieldError("name").codes[0]}' />
							</c:if> 
						</spring:hasBindErrors>
					</p>
					
					<label class="block-label" for="email">이메일</label>
					<form:input path="email" />

					<input id='btn-check-email' type="button" value="중복체크">
					<img id='img-check-email' src='${pageContext.request.contextPath }/assets/images/check.png' style='width: 16px; vertical-align: middle; display:none'>
					
					<p style="padding:3px 0 5px 0; text-align: left; color: #f00">
						<form:errors path="email" />
					</p>
					
					<label class="block-label"><spring:message code="user.join.label.password" /></label>
					<form:password path="password" />
					<p style="padding:3px 0 5px 0; text-align: left; color: #f00">
						<form:errors path="password" />
					</p>
					
					<fieldset>
						<legend>성별</legend>
						<form:radiobutton path="gender" value="female" label="여" checked="checked" />
						<form:radiobutton path="gender" value="male" label="남" checked="checked" />
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form:form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
	<div id="dialog" title="이메일 중복 체크">
  		<p>사용중인 이메일입니다. 다른 이메일을 사용해 주세요.</p>
	</div>
</body>
</html>