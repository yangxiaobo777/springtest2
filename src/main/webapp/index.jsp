<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/8/9
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>sfadfasdfsa</h1>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/upload">
    <input type="file" name="aaa"/>
    <input type="submit" value="提交sdf"/>
</form>
<a href="${pageContext.request.contextPath}/user/download?name=鼬神.jpg">狗.jpg</a>
</body>
</html>
