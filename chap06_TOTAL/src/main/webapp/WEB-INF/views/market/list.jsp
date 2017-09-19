<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
th {
	border-bottom: 1px solid;
	text-align: left;
}

th, td {
	padding: 10px;
}
</style>
<div align="right"></div>
<div align="center" style="line-height: 35px">
	<h2>경매장</h2>

	<p align="right" style="margin-right: 30px;">
		총 <b>${cnt }</b> 개의 글이 등록되어있습니다.
	</p>



	<table style="width: 95%">
		<thead>
			<tr>
				<th style="width: 20%">상품명</th>
				<th style="width: 20%">남은일수</th>
				<th style="width: 20%">시작가</th>
				<th style="width: 20%">즉구가</th>
				<th style="width: 20%">마감일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${list}">
				<tr>
					<td><a href="/market/view/${obj.NO}">${obj.NAME}</a></td> 
					<td><fmt:formatNumber value="${obj.GAB}" pattern="#,##0" /></td>
					<td>${obj.STARTS}</td>
					<td>${obj.FAST}</td>
					<td>${obj.DATEE}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<form action="/market/search">
		시작가 <input type="number" name="START" style="width: 300px;">
		이하 (<input type="checkbox" name="mode" />경매물품만)
		<button type="submit">검색</button>
	</form>
</div>
<script>
	
</script>