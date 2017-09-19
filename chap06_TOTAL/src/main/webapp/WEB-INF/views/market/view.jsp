<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- ---------------------------------------------------- --%>


<div align="center" style="line-height: 35px">
	<h2>
		<a href="/market/list">경매장</a>
	</h2>
	<c:choose>
		<c:when test="${empty map }">
			이미 삭제된 글입니다.
		</c:when>
		<c:otherwise>
			<div
				style="width: 80%; "
				align="left">
				<input type="hidden" id="no" value="${map.NO }" />
				<h3>${map.NAME }</h3>
				<p style="padding-left: 10px;">
					<small>시작가 :<fmt:formatNumber value="${map.STRATS }" pattern="#,###" /> |
					 마감일 : <fmt:formatDate pattern="MM.dd.yyyy HH:mm:ss" value="${map.DATEE }" /> | 
					즉구가: <fmt:formatNumber value="${map.FAST }" pattern="#,###" />
					</small>
				</p>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
	
	<div style="width: 60%">
		<div align="left">
			<input type="text" id="writer" placeholder="작성자" /> <input
				type="number" id="buy" placeholder="구매할 가격" />
		</div>
		<div align="left" style="padding-top: 3px;">
			<textarea style="width: 100%" rows="3" id="content"
				placeholder="남길내용"></textarea>
			<br />
			<button type="button" id="send" style="width: 100%;">댓글남기기</button>
		</div>
		</div>
		<script>
			document.getElementById("send").onclick = function() {
				var xhr = new XMLHttpRequest();
				xhr.open("post", "/reply/add", true);
				var data = {
					"parent" : ${map.NO} ,
					"writer" : document.getElementById("writer").value,
					"pass" : document.getElementById("pass").value,
					"content" : document.getElementById("content").value,
				};
				xhr.send(JSON.stringify(data));
</script>