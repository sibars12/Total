<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	<div style="width: 10%; height: 10%;" align="center" id="cnt">
    </div>
<div align="right">
	<c:choose>
		<c:when test="${empty auth }">
			<a href="/login">로그인</a> | <a href="/join">회원가입</a>
		</c:when>
		<c:otherwise>
			<p>
				<b>${auth}, LOG ON</b>
			</p>
			<p>
				<a href="/my/info">내정보</a> | <a href="/my/profile">프로필</a> | <a href="/my/allpro">전체 사용자</a>
			</p>
		</c:otherwise>
	</c:choose>
</div>
<script>
	var aws=new WebSocket("ws://192.168.10.86/ws/alert");
	aws.onmessage=function(e){
		console.log(e.data);
		document.getElementById("cnt").innerHTML="<b>"+e.data +"</b>"
	}

</script>