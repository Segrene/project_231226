<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex">
	<div id="PRImage">
		<img src="#" width="600px" height="600px">
		<div class="d-flex justify-content-center">
			<button type="button" class="btn btn-primary">상품 이미지 등록</button>
		</div>
	</div>
	<div id="PROption" class="bg-light">
		<div>
			<input type="text" class="form-control m-3" placeholder="상품명">
			<hr>
			<input type="text" class="form-control m-3" placeholder="상품가격">
			<input type="text" class="form-control m-3" placeholder="할인율">
			<hr>
			<select class="custom-select m-3" id="PRCategory">
	    		<option selected>카테고리1</option>
	    		<option value="1">카테고리2</option>
	    		<option value="2">카테고리3</option>
	    		<option value="3">카테고리4</option>
	  		</select>
	  		<select class="custom-select m-3" id="PRSubCategory">
	    		<option selected>세부 카테고리1</option>
	    		<option value="1">세부 카테고리2</option>
	    		<option value="2">세부 카테고리3</option>
	    		<option value="3">세부 카테고리4</option>
	  		</select>
			<hr>
			<select class="custom-select m-3" id="PRDeliveryOption">
	    		<option selected>당일 배송</option>
	    		<option value="1">미사일 배송</option>
	    		<option value="2">일반 배송</option>
	    		<option value="3">자체 배송</option>
	  		</select>
		</div>
	</div>
</div>
<div class="d-flex justify-content-center">
	<button type="button" class="btn btn-primary">상품 상세정보 이미지 등록</button>
</div>