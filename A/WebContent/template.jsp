<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/common.css" type="text/css" >
</head>
<body>

	<header>물품재고 관리ver1.0</header>
	<div class="wrap">
		<nav>
			<a href="product">물품등록</a>
			<a href="import">입고</a> 
			<a href="export">출고</a>
			<a href="productList">물품조회</a> 
			<a href="importList">입고조회</a> 
			<a href="exportList">출고조회</a>
			<a href="home">홈으로</a>
		</nav>

		<div>
			<jsp:include page="${template}.jsp"></jsp:include>
		</div>
	</div>

	<footer>저작권 관련</footer>



</body>
</html>