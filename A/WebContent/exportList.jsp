<%@page import="kr.co.a.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
%>

<p>출고 조회</p>
<table>

	<tr>
		<th>출고번호</th>
		<th>물품 이름</th>
		<th>출고 수량</th>
		<th>출고 일자</th>
	</tr>
	<% for(BoardVO vo : list) {%>
	<tr>
		<td><%=vo.getE_no() %></td>
		<td><%=vo.getP_name() %></td>
		<td><%=vo.getE_cnt() %></td>
		<td><%=vo.getE_date() %></td>
	</tr>
	<% } %>
</table>