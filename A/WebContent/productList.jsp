<%@page import="kr.co.a.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% List<BoardVO> list = (List<BoardVO>)request.getAttribute("list"); %>

<table>

	<tr>
		<th>물품 번호</th>
		<th>물품 이름</th>
		<th>수량</th>
		<th>등록일자</th>
	</tr>
	
	<% for(BoardVO vo : list){ %>
	<tr onclick="location.href='productDetail?p_no=<%=vo.getP_no() %>'">
		<td> <%=vo.getP_no() %></td>
		<td> <%=vo.getP_name() %></td>
		<td> <%=vo.getP_cnt() %></td>
		<td> <%=vo.getP_regdate() %></td>	
	</tr>
	<%} %>
</table>