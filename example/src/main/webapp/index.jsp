<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=basePath%>insertUser" method="post">
	<h2>Hello World SpingMvc+ibatis</h2>

	<h3>
		userName:<input type="text" name="userName"> <br>
		passWord:<input type="text" name="passWord"> <br>
		<input type="submit" value="submit">
	</h3>
	</form>
</body>
</html>
