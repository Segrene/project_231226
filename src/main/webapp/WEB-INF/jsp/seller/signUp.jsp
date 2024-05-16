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
					<h1 class="m-3">판매자 회원가입</h1>
				</div>
				<div class="d-flex justify-content-center">
					<form id="signUpForm" method="post" action="/seller/sign-up"
						class="col-8">
						<div class="form-group mt-3">
							<input type="text" id="email" name="email"
								class="form-control" placeholder="이메일">
						</div>
						<div class="form-group mt-3">
							<div class="d-flex align-items-center">
								<input type="text" id="loginId" name="loginId" class="form-control" placeholder="아이디">
								<button type="button" class="btn btn-primary col-3 ml-1" id="idCheck" name="idCheck">중복확인</button>
							</div>
							<div id="idCheckLength" class="small text-danger d-none">ID를 4자 이상 입력해주세요.</div>
							<div id="idCheckDuplicated" class="small text-danger d-none">사용중인 ID입니다.</div>
							<div id="idCheckOk" class="small text-success d-none">사용 가능한 ID 입니다.</div>
						</div>
						<div class="form-group mt-3">
							<input type="password" id="password" name="password"
								class="form-control" placeholder="비밀번호">
						</div>
						<div class="form-group mt-3">
							<input type="password" id="passwordCheck" name="passwordCheck"
								class="form-control" placeholder="비밀번호 확인">
						</div>
						<div class="form-group mt-3">
							<input type="text" id="name" name="name"
								class="form-control" placeholder="이름">
						</div>
						<div class="form-group mt-3">
							<input type="text" id="phone" name="phone"
								class="form-control" placeholder="전화번호">
						</div>
						<div class="form-group mt-3">
							<input type="text" id="businessName" name="businessName"
								class="form-control" placeholder="사업체명">
						</div>
						<div class="form-group mt-3">
							<input type="text" id="businessNumber" name="businessNumber"
								class="form-control" placeholder="사업자 등록번호">
						</div>
						<div class="form-group mt-3">
							<input type="text" id="businessType" name="businessType"
								class="form-control" placeholder="업종">
						</div>
						<div class="d-flex justify-content-center mt-3">
							<input type="submit" id="signUpBtn" name="signUpBtn" class="btn btn-primary ml-1" value="회원가입">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<script>
	$(document).ready(function() {
		$("#idCheck").on('click', function() {
			
			$("#idCheckLength").addClass("d-none");
			$("#idCheckDuplicated").addClass("d-none");
			$("#idCheckOk").addClass("d-none");
			
			let loginId = $("input[name=loginId]").val().trim();
			if (loginId.length < 4) {
				$("#idCheckLength").removeClass("d-none");
				return;
			}
			
			$.get("/user/is-duplicated-id", {"loginId":loginId})
			.done(function(data) {
				// {"code":200, "is_duplicated_id":true} true:중복
				if (data.code == 200) {
					if (data.is_duplicated_id) {
						$("#idCheckDuplicated").removeClass("d-none");
					} else {
						$("#idCheckOk").removeClass("d-none");
					}
				} else {
					alert(data.error_message);
				}
			});
		});
		
		$("#signUpBtn").on('click', function(e) {
			e.preventDefault();
			let email = $("#email").val().trim();
			let loginId = $("input[name=loginId]").val().trim();
			let password = $("#password").val();
			let passwordCheck = $("#passwordCheck").val();
			let name = $("#name").val().trim();
			let phone = $("#phone").val().trim();
			let businessName = $("#businessName").val().trim();
			let businesseNumber = $("#businessNumber").val().trim();
			let businessType = $("#businessType").val().trim();
			if (!email) {
				alert("이메일을 입력하세요");
				return false;
			}
			if (!loginId) {
				alert("아이디를 입력하세요");
				return false;
			}
			if (!password || !passwordCheck) {
				alert("비밀번호를 입력하세요");
				return false;
			}
			if (password != passwordCheck) {
				alert("비밀번호를 다시 확인하세요");
				return false;
			}
			if (!name) {
				alert("이름을 입력하세요");
				return false;
			}
			if (!phone) {
				alert("전화번호를 입력하세요");
				return false;
			}
			if (!businessName) {
				alert("사업체명을 입력하세요");
				return false;
			}
			if (!businessNumber) {
				alert("사업자 등록번호를 입력하세요");
				return false;
			}
			if (!businessType) {
				alert("업종을 선택하세요");
				return false;
			}
			
			if ($("#idCheckOk").hasClass("d-none")) {
				alert("아이디 중복확인을 해주세요");
				return false;
			}
			
			let url = $("#signUpForm").attr("action");
			console.log(url);
			let params = $("#signUpForm").serialize();
			console.log(params);
			
			$.post(url, params)
			.done(function(data) {
				if (data.code == 200) {
					alert("가입을 환영합니다. 로그인 해주세요.");
					location.href = "/user/login-view";
				} else {
					alert(data.error_message);
				}
			});
		});
	});
	</script>
</body>
</html>