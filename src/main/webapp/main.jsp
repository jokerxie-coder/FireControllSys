<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

	function facility() {
		
		//alert("hhah");
		window.location.href='${pageContext.request.contextPath}/facility/findFacility.jsp';
		
	}
	
	function fire() {
		
		var value="";
		
		var radio = document.getElementsByName("user");  
		
		for(var i = 0;i<radio.length;i++){  
            if(radio[i].checked==true){
            	value = radio[i].value;  
            	break;
            }  
        }  
    	//alert(value);
    	if(value=="pro"){
    		window.location.href='${pageContext.request.contextPath}/manager/login.jsp';
    	}else if(value=="normal"){
    		
    		window.location.href='${pageContext.request.contextPath}/fire/fireInfo.jsp';
    	}
		
		
	}
</script>

<body>
	
		<button id="fire" type="button" onclick="fire()">火情上报</button>
		
		<input type="radio" name="user" id="pro" value="pro">专业人士
		<input type="radio" checked="true" name="user" id="normal" value="normal">普通用户<br/>
		
		<button id="alarm" type="button" onclick="alarm()">快速报警</button><br/>
		<button id="facility" type="button" onclick="facility()">产品防伪</button><br/>
		<button id="company" type="button" >公司简介</button><br/>
</body>
</html>