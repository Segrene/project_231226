<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<img id="banner" src="/static/img/banner/Banner-1-test.jpg" width="1200px" height="400px">
<div class="d-flex">
	<div id="promotion">
		<img src="/static/img/promotion/Promotion-2-test.jpg" width="400px" height="400px">
	</div>
	<div id="best">
		<div class="d-flex justify-content-center align-content-center">
			<span>실시간 인기 글</span>
		</div>
		<div>
			<ul>
				<li>testText</li>
			</ul>
		</div>
	</div>
	<div id="gallery">
		<div class="d-flex justify-content-center align-content-center">
			<span>인기 게시판</span>
		</div>
		<div>
			<ul>
				<li>testText</li>
			</ul>
		</div>
	</div>
</div>
<script>
let imageNum = 0;
let images = ["/static/img/banner/Banner-1-test.jpg", "/static/img/banner/Banner-2-test.jpg"
	, "/static/img/banner/Banner-3-test.jpg", "/static/img/banner/Banner-4-test.jpg"];

	function banner() {
		if (imageNum >= images.length - 1) {
			imageNum = 0;
		} else {
			imageNum++;
		}
		$("#banner").attr("src", images[imageNum]);
	}
	$(document).ready(function() {
		let bannerShow;
        bannerShow = setInterval(banner, 3000);
	});
</script>