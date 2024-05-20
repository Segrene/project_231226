<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="bg-dark" id="productList">
	<div class="bg-light d-flex" id="productCategory">
		<div class="m-3 font-weight-bolder" id="PListCategory">카테고리</div>
		<div class="m-3 font-weight-lighter" id="PListSubCategory">세부 카테고리</div>
	</div>
	<div class="d-flex flex-wrap justify-content-around">
		<div class="PBox bg-warning border-dark rounded m-3">
			<div class="d-flex PThumbnail align-items-center justify-content-center">		
				<img src="#" class="rounded" width="200px" height="200px">
			</div>
			<div class="ml-3 mb-2 PName">상품이름</div>
			<div class="d-flex align-items-center mb-2">
				<div>
					<div class="ml-3 PPrice"><del>상품가격</del></div>
					<div class="ml-3 PPrice">상품가격</div>
				</div>
				<div class="ml-2 PDiscount">할인율</div>
			</div>
			<div class="ml-3 mb-2">배송유형</div>
		</div>
	</div>
</div>