<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="productDetail" method="post">

	<table>
		<tr>
			<th>물품번호</th>
			<td><input name="p_no" value="${vo.p_no}"></td>
		</tr>
		<tr>
			<th>물품이름</th>
			<td><input name="p_name" value="${vo.p_name}"></td>
		</tr>
		<tr>

			<th>수량</th>
			<td><input name="p_cnt" value="${vo.p_cnt}"></td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td><input name="p_regdate" value="${vo.p_regdate}"></td>
		</tr>
	</table>

	<input type="submit" value="수정" >
	 <input type="button" value="조회 " onclick="location.href='productList'">


</form>