<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>专业人士登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h1>专业人士登录页面</h1>
<hr/>
 <p style="font-weight: 900; color: red">${loginMsg}</p>
<form action="<c:url value='/manager/login'/>" method="post">
	用户名：<input type="text" name="mUserName" /><br/>
	密&nbsp&nbsp&nbsp码：<input type="password" name="mPassWord"/><br/>
	<input type="submit" value="登陆"/>
</form>
  </body>
</html>
