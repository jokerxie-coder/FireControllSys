<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.7.2.min.js">
</script>
<script type="text/javascript">
function update(){


	//封装表单数据
	var form = new FormData(document.getElementById("fr"));

	//请求的时候默认为
	//contentType:"application/x-www-form-urlencoded"
    $.ajax({
        url:"${pageContext.request.contextPath}/facility/update",
        type:"POST",
        data:$("#fr").serialize(),//序列化表单提交input值
        success:function(data){
        	alert(data);
           
        },
        error:function(e){
            alert("服务器错误！");
        }
    });        
 
}


/**
 * 查询按钮的点击事件
 */
 
function search(){

	var id=$("#indexId").val();
	/*
	
	if(id==""){
	alert("请输入产品编号！");
	return;
}
	*/
	
	
	$.ajax({
	    url:"${pageContext.request.contextPath}/facility/search",
	    type:"POST",
	    data:{"fId":id},
	    dataType:"json",
	    success:function(data){
	        
	    	alert(data);
	    	//将从后台获取的数据显示在控件中
	    	
	    	$("#fProDate").val(data.fProDate);
	    	$("#fName").val(data.fName);
	    	$("#fModelNumber").val(data.fModelNumber);
	    	$("#fId").val(data.fId);
	    
	    	// 将disabled属性的值设置为”disabled”后，form表单提交后得不到该值
	    	// 改为 readonly= “readonly” 即可
	    	$("#fId").attr("readonly","readonly");
	    	
	    	$("#fProDate").val(data.fProDate);
	    	$("#fExpTime").val(data.fExpTime);
	    	
	    	//alert(data.fImageUrl);
	    	
	    
	    },
	    error:function(e){
	        alert("获取数据失败！");
	    
	    }
	});        
	
}


</script>
</head>

<body>

	<p style="font-weight: 900; color: red">${facilityMsg}</p>
	产品编号：<input id="indexId" placeholder="请输入产品编号" type="text" name="indexId">
	<button  id="search" onclick="search()">查询</button><br/>
	<form id="fr" >
		名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：<input id="fName" type="text" name="fName"/><br/>
		型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input id="fModelNumber" type="text" name="fModelNumber"/><br/>
		编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input id="fId" type="text" name="fId"/><br/>
		出厂日期：<input id="fProDate" type="date" name="fProDate" value="2014-01-13" /><br/>
		保&nbsp;&nbsp;质&nbsp;&nbsp;期：<input id="fExpTime" type="text" name="fExpTime"/><br/>
		<input id="modify" type="button" value="修改" onclick="update()"/>
	</form>


</body>
</html>