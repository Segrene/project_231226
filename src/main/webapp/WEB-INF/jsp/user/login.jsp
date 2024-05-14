<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/static/css/style.css">
<title>ProjectSC</title>
</head>
<body>
	<div class="container d-flex justify-content-center p-0">
		<div id="wrap">
			<div class="login-form bg-light">
				<div class="d-flex justify-content-center">
					<h1 class="m-3">로그인</h1>
				</div>
				<div class="d-flex justify-content-center">
					<form id="loginForm" method="post" action="/user/login"
						class="col-8">
						<div class="form-group mt-3">
							<input type="text" id="loginId" name="loginId"
								class="form-control" placeholder="아이디 혹은 이메일">
						</div>
						<div class="form-group mt-3">
							<input type="password" id="password" name="password"
								class="form-control" placeholder="비밀번호">
						</div>
						<div class="d-flex justify-content-between mt-3">
							<a class="btn btn-dark mr-1" href="/user/sign-up-view">회원가입</a>
							<a class="btn btn-dark mr-1" href="/user/seller-sign-up-view">판매자 회원가입</a>
							<input type="submit" id="loginBtn" name="loginBtn" class="btn btn-primary ml-1" value="로그인">
						</div>
						<div class="mt-3">
							<a href="#">아이디를 잊으셨나요?</a><br>
							<a href="#">비밀번호를 잊으셨나요?</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function() {
		$("#loginBtn").on('click', function(e) {
			e.preventDefault();
			let loginId = $("input[name=loginId]").val().trim();
			let password = $("#password").val();
			if (!loginId) {
				alert("아이디를 입력하세요");
				return false;
			}
			if (!password) {
				alert("비밀번호를 입력하세요");
				return false;
			}
			
			let url = $("#loginForm").attr("action");
			console.log(url);
			let params = $("#loginForm").serialize();
			console.log(params);
			
			$.post(url, params)
			.done(function(data) {
				if (data.result == "성공") {
					location.href = "/main/main";
				} else {
					alert(data.error_message);
				}
			});
		});
	});
	</script>
</body>
</html>