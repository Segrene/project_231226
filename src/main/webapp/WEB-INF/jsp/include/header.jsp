<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex">
	<div class="logo bg-danger" onclick="location.href='/main/main';" style="cursor: pointer;"></div>
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
				<c:if test="${!empty userId}">
					<img src="/static/img/ui/user_default.png" class="img-thumbnail" width="50px" height="50px">
					<span id="userName">${userLoginId}</span>
					<button type="button" class="btn btn-primary p-1 m-2" id="cart"	onclick="location.href='/cart/cart-view';">장바구니</button>
					<a href="/user/logout">로그아웃</a>
				</c:if>
				<c:if test="${empty userId}">
					<a href="/user/login-view">로그인</a>
				</c:if>
			</div>
		</div>
		<div class="d-flex align-items-center" id="lowerHeader">
			<ul class="nav nav-pills nav-fill">
				<li class="nav-item"><a class="nav-link" href="/product/category/0">전체</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/1">가전</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/2">가구</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/3">생활용품</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/4">식품</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/5">취미</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/6">차량</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/7">전자</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/8">도서/음반</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/9">주방용품</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/10">반려동물</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/category/11">여행/티켓/호텔</a></li>
			</ul>
		</div>
	</div>
</div>