<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex">
	<div id="PRImage">
		<img id="thumbnail" src="" width="600px" height="600px">
		<div class="d-flex justify-content-center">
			<button type="button" id="btn-thumbnail" class="btn btn-primary">상품 이미지 등록</button>
		</div>
		<input type="file" id="thumbnail-selector" class="d-none" onchange="readURL(this);" accept=".png, .jpg, .jpeg"> 
	</div>
	<div id="PROption" class="bg-light border rounded-lg">
		<div>
			<input type="text" class="form-control m-3 PROptionInput" id="name" placeholder="상품명">
			<hr>
			<input type="text" class="form-control m-3 PROptionInput" id="price" placeholder="상품가격">
			<input type="text" class="form-control m-3 PROptionInput" id="discount" placeholder="할인율">
			<hr>
			<select class="custom-select m-3 PROptionInput" id="PRCategory">
	    		<option selectedc>카테고리1</option>
	    		<option value="1">카테고리2</option>
	    		<option value="2">카테고리3</option>
	    		<option value="3">카테고리4</option>
	  		</select>
	  		<select class="custom-select m-3 PROptionInput" id="PRSubCategory">
	    		<option selected value="0">세부 카테고리1</option>
	    		<option value="1">세부 카테고리2</option>
	    		<option value="2">세부 카테고리3</option>
	    		<option value="3">세부 카테고리4</option>
	  		</select>
			<hr>
			<select class="custom-select m-3 PROptionInput" id="PRDeliveryOption">
	    		<option selected value="당일 배송">당일 배송</option>
	    		<option value="즉시 배송">미사일 배송</option>
	    		<option value="일반 배송">일반 배송</option>
	    		<option value="자체 배송">자체 배송</option>
	  		</select>
		</div>
		<div class="d-flex justify-content-center align-itemsm-end">
			<button type="button" id="register" class="btn btn-primary">상품 등록</button>
		</div>
	</div>
</div>
<div>
	<div class="d-flex justify-content-start align-items-end">
		<button type="button" id="btn-image" class="btn btn-primary ml-2">상품 상세설명 이미지</button>
		<input type="file" id="img-selector" class="btn btn-primary ml-2 d-none" accept=".png, .jpg, .jpeg">
		<div class="editor-menu ml-2">
			<button id="btn-bold" class="btn btn-outline-primary btn-sm"><b>B</b></button>
			<button id="btn-italic" class="btn btn-outline-primary btn-sm"><i>I</i></button>
			<button id="btn-underline" class="btn btn-outline-primary btn-sm"><u>U</u></button>
			<button id="btn-strike" class="btn btn-outline-primary btn-sm"><del>del</del></button>
			<button id="btn-ordered-list" class="btn btn-outline-primary btn-sm">OL</button>
			<button id="btn-unordered-list" class="btn btn-outline-primary btn-sm">UL</button>
		</div>
	</div>
	<div contenteditable="true" class="editor border rounded-lg p-2" id="editor"></div>
</div>
<script>
    const editor = document.getElementById('editor');
    const btnBold = document.getElementById('btn-bold');
    const btnItalic = document.getElementById('btn-italic');
    const btnUnderline = document.getElementById('btn-underline');
    const btnStrike = document.getElementById('btn-strike');
    const btnOrderedList = document.getElementById('btn-ordered-list');
    const btnUnorderedList = document.getElementById('btn-unordered-list');
    const btnThumbnail = document.getElementById('btn-thumbnail');
    const thumbnailSelector = document.getElementById('thumbnail-selector');
    const btnImage = document.getElementById('btn-image');
    const imageSelector = document.getElementById('img-selector');

    btnBold.addEventListener('click', function () {
        setStyle('bold');
    });

    btnItalic.addEventListener('click', function () {
        setStyle('italic');
    });

    btnUnderline.addEventListener('click', function () {
        setStyle('underline');
    });

    btnStrike.addEventListener('click', function () {
        setStyle('strikeThrough')
    });

    btnOrderedList.addEventListener('click', function () {
        setStyle('insertOrderedList');
    });

    btnUnorderedList.addEventListener('click', function () {
        setStyle('insertUnorderedList');
    });
    
    editor.addEventListener('keydown', function () {
        checkStyle();
    });

    editor.addEventListener('mousedown', function () {
        checkStyle();
    });

    function setStyle(style) {
        document.execCommand(style);
        focusEditor();
        checkStyle();
    }
    
    function checkStyle() {
        if (isStyle('bold')) {
            btnBold.classList.add('btn-primary');
            btnBold.classList.replace('btn-outline-primary', 'btn-outline-light');
        } else {
            btnBold.classList.remove('btn-primary');
            btnBold.classList.replace('btn-outline-light', 'btn-outline-primary');
        }
        if (isStyle('italic')) {
            btnItalic.classList.add('btn-primary');
            btnItalic.classList.replace('btn-outline-primary', 'btn-outline-light');
        } else {
            btnItalic.classList.remove('btn-primary');
            btnItalic.classList.replace('btn-outline-light', 'btn-outline-primary');
        }
        if (isStyle('underline')) {
            btnUnderline.classList.add('btn-primary');
            btnUnderline.classList.replace('btn-outline-primary', 'btn-outline-light');
        } else {
            btnUnderline.classList.remove('btn-primary');
            btnUnderline.classList.replace('btn-outline-light', 'btn-outline-primary');
        }
        if (isStyle('strikeThrough')) {
            btnStrike.classList.add('btn-primary');
            btnStrike.classList.replace('btn-outline-primary', 'btn-outline-light');
        } else {
            btnStrike.classList.remove('btn-primary');
            btnStrike.classList.replace('btn-outline-light', 'btn-outline-primary');
        }
        if (isStyle('insertOrderedList')) {
            btnOrderedList.classList.add('btn-primary');
            btnOrderedList.classList.replace('btn-outline-primary', 'btn-outline-light');
        } else {
            btnOrderedList.classList.remove('btn-primary');
            btnOrderedList.classList.replace('btn-outline-light', 'btn-outline-primary');
        }
        if (isStyle('insertUnorderedList')) {
            btnUnorderedList.classList.add('btn-primary');
            btnUnorderedList.classList.replace('btn-outline-primary', 'btn-outline-light');
        } else {
            btnUnorderedList.classList.remove('btn-primary');
            btnUnorderedList.classList.replace('btn-outline-light', 'btn-outline-primary');
        }
    }

    function isStyle(style) {
        return document.queryCommandState(style);
    }

    function focusEditor() {
        editor.focus({preventScroll: true});
    }
    
    btnThumbnail.addEventListener('click', function () {
    	thumbnailSelector.click();
    });
    
    function readURL(input) {
    	if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				document.getElementById('thumbnail').src = e.target.result;
			};
			reader.readAsDataURL(input.files[0]);
			var thumbnailName = input.files[0].name;
			console.log(thumbnailName);
			var ext = thumbnailName.split(".").pop().toLowerCase();
			console.log(ext);
			if ($.inArray(ext, [ 'jpg', 'jpeg', 'png']) == -1) {
				alert("지정된 형식의 이미지 파일만 업로드 할 수 있습니다");
				document.getElementById('thumbnail').src = "";
				document.getElementById('thumbnail-selector').val = "";
				return;
			}
		} else {
			document.getElementById('thumbnail').src = "";
			document.getElementById('thumbnail-selector').val = "";
		}
	}

    btnImage.addEventListener('click', function () {
        imageSelector.click();
    });

    imageSelector.addEventListener('change', function (e) {
        const files = e.target.files;
        if (!!files) {
            insertImageDate(files[0]);
        }
    });
    
	function insertImageDate(file) {
		const reader = new FileReader();
		reader.addEventListener('load', function(e) {
			focusEditor();
			document.execCommand('insertImage', false, reader.result);
		});
		reader.readAsDataURL(file);
	}
	
	
	
	$(document).ready(function() {
		$("#register").on('click', function() {
			let name = $("#name").val().trim();
			let price = $("#price").val();
			let discount = $("#discount").val();
			let category = $("#PRCategory").val();
			let subCategory = $("#PRSubCategory").val();
			let content = $("#content").val();
			let fileName = $("#thumbnail-selector").val();
			console.log(fileName);
			if (fileName) {
				let extension = fileName.split(".")
						.pop().toLowerCase();
				if ($.inArray(extension, [ 'jpg',
						'jpeg', 'png', 'heic', 'heif',
						'bmp', 'webp' ]) == -1) {
					alert("지원되는 이미지 파일만 업로드 가능합니다");
					$('#thumbnail-selector').val("");
					return;
				}
			}
			let formData = new FormData();
			formData.append("name", name);
			formData.append("price", price);
			formData.append("discount", discount);
			formData.append("category", category);
			formData.append("subCategory", subCategory);
			formData.append("content", content);
			formData.append("file",
					$("#thumbnail-selector")[0].files[0]);
			$.ajax({
				type : "POST",
				url : "/post/postCreate",
				data : formData,
				enctype : "multipart/form-data" // 파일업로드를 위한 필수 설정
				,
				processData : false // 파일업로드를 위한 필수 설정
				,
				contentType : false // 파일업로드를 위한 필수 설정
				,
				success : function(data) {
					if (data.code == 200) {
						alert("저장되었습니다");
						location.reload(true);
					} else {
						alert(data.error_message);
					}
				},
				error : function(e) {
					alert("저장 실패");
				}
			});
		});
	});
</script>