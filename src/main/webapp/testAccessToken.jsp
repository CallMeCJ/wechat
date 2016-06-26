<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.9.0/jquery.min.js"></script>
<title>获取accesstoken</title>
<script type="text/javascript">
	function getAccessToken(){
		$.ajax({
			url : 'test/getAccessToken',
			data:{
				appid:$('#appid').val(),
				secret:$('#secret').val()
			},
			dataType:'text',
			type : 'POST',
			timeout : 10000,
			error : function() {
				alert('提示','响应超时，请刷新页面！');
			},
			success : function(msg) {
				alert(msg);
			}
		});
	}
</script>
</head>
<body>
	输入appid：<input id="appid" type="text"/>
	输入appsecret：<input id="secret" type="text"/>
	<input type="button" value="点击获取access_token" onclick="getAccessToken();"/>
</body>
</html>