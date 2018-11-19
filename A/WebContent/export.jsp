<%@page import="kr.co.a.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<BoardVO> list = (List<BoardVO>)request.getAttribute("list"); %>

<script type="text/javascript">

	function frmSubmit() {
		var frm = document.frm;
		
		if(frm.e_cnt.value == ""){
			alert("출고수량을 입력해주세요");
			return false
		}else if(frm.e_cnt.value <= 0){
			alert("0이상의 숫자를 입력하세요")
			return false
		}
		return true
	}

</script>

<p>출고화면</p>

    <form action="export" method="post" name="frm" onsubmit="return frmSubmit()">
    
    <table>
    	<tr>
    		<th>물품목록</th>
    		<td>
    		<select name ="p_no">
    		<% for( BoardVO vo : list) {%>
   				<option value="<%=vo.getP_no()%>"><%=vo.getP_name() %></option>
   			<%} %>
    			</select>
    		</td>
    	</tr>
    	
    	<tr>
    		<th>출고수량</th>
    		<td>
    			<input type="text" name="e_cnt" >
    		</td>
    	</tr>
    </table>
    
    <input type="submit" value="출고" >
    <input type="button" value="조회" onclick="location.href='exportList'">
    </form>