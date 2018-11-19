<%@page import="kr.co.a.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% List<BoardVO> list = (List<BoardVO>)request.getAttribute("list"); %>


<script type="text/javascript">

function clkSumbit() {
	var frm = document.frm;
	
	if(frm.i_cnt.value == ""){
		alert("숫자를 입력하세요");
		return false
	}else if(frm.i_cnt.value <= 0){
		alert("0이상의 숫자를 입력하세요");
		return false
	}
	return true
}

</script>

<p>입고화면</p>

<form action="import" method="post" name="frm" onsubmit="return clkSumbit()">
	<table>
		<tr>
			<th>물품 목록</th>
			<td>
			
			<select name="p_no"> <!-- 서버에서 디비에 넣을 때 -->
				<% for( BoardVO vo : list){ %>
					<option value="<%=vo.getP_no() %>"><%=vo.getP_name() %></option>
				<%} %>
			</select>
			</td>
			
		</tr>
		
		<tr>
			<th>입고수량</th>
			<td>
				<input type="text" name="i_cnt" >
			</td>
		</tr>
	</table>
	
	<input type="submit" value="입고" >
	<input type="button" value="조회" onclick="location.href='importList'" >
	
</form>
