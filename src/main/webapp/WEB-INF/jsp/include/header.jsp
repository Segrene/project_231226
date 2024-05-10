<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex">
	<div class="logo bg-danger"></div>
	<div>
		<div class="d-flex align-items-center bg-light" id="upperHeader">
			<div class="input-group m-1 col-4">
				<input type="text" class="form-control"
					placeholder="검색하기">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="button"
						id="button-addon2">Button</button>
				</div>
			</div>
			<div class="d-flex align-items-center col-4" id="suggestion">
				<ul class="m-0 p-0">
					<li>검색어1</li>
					<li>검색어2</li>
					<li>검색어3</li>
				</ul>
			</div>
			<div class="d-flex align-items-center col-4 bg-light" id="login">
				<img src="/static/img/ui/user_default.png" class="img-thumbnail" width="50px" height="50px">
				<span id="userName">USER1</span>
				<button type="button" class="btn btn-primary p-1 m-2" id="mypage">마이페이지</button>
				<a href="#">로그아웃</a>
			</div>
		</div>
		<div class="d-flex align-items-center" id="lowerHeader">
			<ul class="nav nav-pills nav-fill">
				<li class="nav-item"><a class="nav-link" href="#">카테고리1</a></li>
				<li class="nav-item"><a class="nav-link" href="#">카테고리2</a></li>
				<li class="nav-item"><a class="nav-link" href="#">카테고리3</a></li>
				<li class="nav-item"><a class="nav-link" href="#">카테고리4</a></li>
				<li class="nav-item"><a class="nav-link" href="#">카테고리5</a></li>
				<li class="nav-item"><a class="nav-link" href="#">카테고리6</a></li>
				<li class="nav-item"><a class="nav-link" href="#">카테고리7</a></li>
				<li class="nav-item"><a class="nav-link" href="#">카테고리8</a></li>
				<li class="nav-item"><a class="nav-link" href="#">카테고리9</a></li>
			</ul>
		</div>
	</div>
</div>