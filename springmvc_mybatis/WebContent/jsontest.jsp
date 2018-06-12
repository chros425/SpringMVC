<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json数据测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">

	//请求json响应json
	function requestJson() {
		
		//不能使用$.post来实现了
		/* var url = "${pageContext.request.contextPath }/requestJson.action";
		var param = {"name" : "手机","price" : "30000"};
		
		$.post(url,param,function(data){
			alert(data);
		});	 */	
		
		//请求json，必须使用$.ajax，因为需要设置contentType="application/json;charset=UTF-8"
		$.ajax({
			url:"${pageContext.request.contextPath }/requestJson.action",
			type:"post",
			contentType:"application/json;charset=UTF-8",
			//注意，这里data的json格式，必须是里面双引号，否则400请求失败
			//参数名也必须是data，否则请求失败
			data:'{"name":"手机","price":"9000"}',
			success:function(data){
				alert(data);
			}
		});
	}
	
	//请求key/value响应json
	function responseJson() {
		
		var url = "${pageContext.request.contextPath }/responseJson.action";
		var param = "name=手机&price=7000"
		
		$.post(url,param,function(data){
			alert(data.name);
		});		
	}

</script>
</head>
<body>
	<input type="button" value="请求json响应json" onclick="requestJson()">
	<input type="button" value="请求key/value响应json" onclick="responseJson()">
</body>
</html>