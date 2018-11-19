<%@page import="kr.co.a.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
%>

<p>입고조회</p>
<table>

	<tr>
		<th>입고번호</th>
		<th>물품 이름</th>
		<th>입고 수량</th>
		<th>입고 일자</th>
	</tr>
	<% for(BoardVO vo : list) {%>
	<tr>
		<td><%=vo.getI_no() %></td>
		<td><%=vo.getP_name() %></td>
		<td><%=vo.getI_cnt() %></td>
		<td><%=vo.getI_date() %></td>
	</tr>
	<% } %>
</table>