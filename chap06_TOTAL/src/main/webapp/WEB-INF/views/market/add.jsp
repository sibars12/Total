<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <div align="center">
<h2>경매 상품 등록</h2>
<form action="/market/add" method="post">
	<p>
		상품명 : <input type="text" name="name">
	</p>
	<p id="pa">
		시작가: <input type="text" name="start">
	</p>
	<p>
		즉구설정이 필요하면
		 <button type="button" id="popen">클릭</button>
		 <br/> <span id="p"></span>
	</p>
	<p>
		마감일 설정이 필요하면 
		<button type="button" id="ddate">click</button>
		<br/> <span id="pp"></span>
	</p>
	<button type="submit">등록</button>
</form>
</div>
<script>
	document.getElementById("popen").onclick=function(){
		document.getElementById("p").innerHTML="즉구가 : <input type=\"text\" name=\"fast\">";
		
		
	}
	document.getElementById("ddate").onclick=function(){
		document.getElementById("pp").innerHTML="마감일 : <input type=\"date\" name=\"date\" >";
		
		
	}
	
</script>