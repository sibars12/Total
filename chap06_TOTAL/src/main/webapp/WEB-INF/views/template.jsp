<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><t:getAsString name="title" /></title>
</head>
<body>
	<header>
		<t:insertAttribute name="header" />
	</header>
	<nav>
		<t:insertAttribute name="nav" />
	</nav>
	<section style="min-height: 70%;">
		<t:insertAttribute name="section" />
	</section>
	<footer>
		<t:insertAttribute name="footer" />
	</footer>
</body>
</html>


