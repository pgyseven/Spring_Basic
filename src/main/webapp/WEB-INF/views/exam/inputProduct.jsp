<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>제품 입력페이지</h1>
	</div>
	<form action="inputProduct" method="post"> <!-- 상대적 경로로 써야 한다. 처음에 /exam/inputProduct로 쓰는데 지금 현재 intputProduct가 exam 안에 있기 때문에 지워야한다. -->
		<div class="mb-3 mt-3">
			<label for="productNo">제품번호:</label> <input type="text"
				class="form-control" id="productNo" placeholder="제품번호를 입력하세요..."
				name="productNo">
		</div>
		<div class="mb-3">
			<label for="productName">제품명:</label> <input type="text"
				class="form-control" id="productName" placeholder="제품명 입력..."
				name="productName">
		</div>
		<div class="mb-3">
			<label for="qty">수량:</label> <input type="number"
				class="form-control" id="qty" name="qty">
		</div>
		<div class="mb-3">
			<label for="price">가격:</label> <input type="number"
				class="form-control" id="price" name="price">
		</div>
		<div class="mb-3">
			<label for="productNickName">제품별명:</label> <input type="text"
				class="form-control" id="productNickName" placeholder="제품별칭 입력..."
				name="productNickName">
		</div>

		<button type="submit" class="btn btn-primary">제품 저장</button>
	</form>
</body>
</html>