<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="java.util.*"%>
    
    <style>
th {
	border-bottom: 1px solid;
	text-align: left;
}
th, td {
	padding: 10px;
}
</style>

<div align="center" style="line-height: 35px">
<h2>사용자목록</h2>
	<h2>총 인원수 : ${list}</h2>
	
	<table style="width: 95%">
		<thead>
			<tr>
				<th style="width: 20%">프로필 사진</th>
				<th style="width: 30%">ID</th>
				<th style="width: 30%">EMAIL</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${all }">
				<tr>
					<td>
					<c:choose>
					<c:when test="${empty obj.URL}">
						<img id="pre" src="/profiles/dep.png" alt="기본이미지"
						style="width: 50; height: 50"/>
					</c:when>
				<c:otherwise>
				
					<img id="pre" src="${obj.URL }" alt="사용자프로필"
					style="width: 50; height: 50" />
				</c:otherwise>
				</c:choose>
				</td>
					<td>${obj.ID}</td>
					<td>${obj.EMAIL }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div>
		<c:if test="${param.page ne 1 }"><a href="/my/allpro?page=${param.page-1 }">◁</a></c:if>
		<c:forEach var="i" begin="1" end="${size}" varStatus="vs">
			<c:choose>
				<c:when test="${i eq param.page }">
					<b style="color: #ff9800;">${i }</b>
				</c:when>
				<c:otherwise>
					<a href="/my/allpro?page=${i }" style="text-decoration: none"
						><b style="color: #9c9892;">${i }</b></a>	
				</c:otherwise>
			</c:choose>
			<c:if test="${!vs.last }">|</c:if>
		</c:forEach>
		<c:if test="${param.page ne size }"><a href="/my/allpro?page=${param.page+1 }">▷</a></c:if>
	</div>
