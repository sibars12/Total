<%@ page import="java.util.Map"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div align="center" style="line-height: 25px;">
	<h2>${auth.ID} 's INFO
	</h2>
	<div>
		<h3>프로필사진</h3>
		<form action="/my/pic_update.jsp" method="post" enctype="multipart/form-data">
			<p>
				<img src="=imgPath " style="border-radius: 100%; width: 150px; height: 150px;"/>
			</p>
			<p>
				<input type="file" name="pic"/><button type="submit">변경</button>
			</p>
		</form>
	</div>
	<div>	
		<h3>세부정보</h3>
		<form action="/my/info.jsp" method="get">
			<p>
				<b>NAME</b><br /> <input type="text"
					value= ${auth }  name="name" required />
			</p>
			
			<p>
				<b>BIRTH</b><br /> <select name="birth">
				</select>
			</p>
			<p>
				<b>ADDRESS</b><br /> <input type="text" name="address" size="50"
					value="${auth.ADDRESS} " required />
			</p>
			<button type="submit">정보변경</button>
			<a href="/my/drop.jsp"><button type="button">회원탈퇴</button></a>
		</form>
	</div>
</div>



























