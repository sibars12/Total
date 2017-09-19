<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <div align="center">
<div style="width: 80%; height: 70%; background-color: #D5D5D5; text-align: left; padding: 1px;  overflow-y: scroll; word-break: break-all" align="left" id="log">
</div>
	<input type="text" id="f" style="width: 80%; margin-top:5px; padding: 4px"/>
</div>
<script>
	var cws=new WebSocket("ws://192.168.10.86/ws/chat");
	cws.onopen=function(e){
		document.getElementById("log").innerHTML+="<p><b>오픈채팅 서버 접속 성공</b></p></br>";
	}
	document.getElementById("f").onchange=function(e){
		if(this.value.length!=0){
		cws.send(this.value);
		this.value="";
		}
	}
	cws.onmessage=function(e){
		var obj=JSON.parse(e.data);
		switch(obj.mode){
		case "chat":
		document.getElementById("log").innerHTML+="<p><b>"+obj.sender+" : "+obj.msg+"</p></b></br>";

	
		break;
		case "cnt":
			document.getElementById("log").innerHTML+="<p><b>현재 인원 :"+obj.cnt+"</p></b>"
			break;
		}
		document.getElementById("log").scrollTop=
			document.getElementById("log").scrollHeight+25;
		}
</script>