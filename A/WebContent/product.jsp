<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">

function clkSubmit() {
	
	var frm = document.frm;		//document 네임을 해주고
	
	//조건
	if(frm.p_name.value == ""){	//frm의 선택 p_name에 값이 ""면 	
		alert("물품이름을 입력하세요");	// 알림창을 띄어준다
		return false	// false면 다시 입력하게
	}
	return true	// 참이라서 그다음을 실행한다
	
}

</script>

물품등록
<br />

<form action="product" method="post" name="frm" onsubmit="return clkSubmit()" >
	
	
	<label for="aa">물품 이름</label>
	<input id="aa" type="text" name="p_name" /> 
	<input type="submit" value="등록" />
</form>