<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select class="custom-select m-3 PROptionInput" id="PRSubCategory">
	<option selected value="-1">세부 카테고리를 선택하세요</option>
	<c:forEach items="${subCategoryList}" var="subCategory">
		<option value="${subCategory.id}">${subCategory.name}</option>
	</c:forEach>
</select>