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

	function filesize() {
		var fileInput = $("#fileId")[0];
		byteSize = (fileInput.files[0].size / 1024).toFixed(2);
		alert(byteSize);
	}

	function commit(){
		
		
		//因为new FormData的参数需要一个HTMLElement类型的数据，
		//而jQuery得到的是个HTMLElement的集合，
		//哪怕只有一个元素。所以需要用[]取其第一个元素。
		var form = new FormData($("#formUpload")[0]);

        $.ajax({
	         url:"${pageContext.request.contextPath}/fireInfo/insert",
	         type:"post",
	         data:form,
	         processData:false,
	         contentType:false,
	         success:function(data){
	        	 
	        	 alert(data);
	            // window.clearInterval(timer);
	             //console.log("over..");
	         },
	         error:function(e){
	             alert("服务器错误！");
	             //window.clearInterval(timer);
	         }
	     });        
	    
	}
</script>
</head>
<body>
	<p style="font-weight: 900; color: red">${fireInfoMsg}</p>
	<form id="formUpload">
    	危险等级：<input  type="text" name="frRank"/><br/>
    	详细信息：<input  type="text" name="frDescr"/><br/>
    	位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置：<input id="locaId" type="text" name="frLocation"/><br/>
    	图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片：<input id="fileId" type="file" name="frImage" onchange="filesize()"/><br/>
    	<input id="com" type="button"  value="提交" onclick="commit()"/>
    </form>
   	
	
</body>
</html>