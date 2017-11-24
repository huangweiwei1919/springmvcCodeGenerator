<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" import="com.earlyzen.crm.common.Config" %>
<c:set var="fileUploadUrl" value="<%=Config.fileUploadUrl %>"/>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE >
<html>
<head>
	<title>测试文件上传</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
<body style="text-align: center;margin-top: 200px;">
	<form action="${fileUploadUrl}" method="post" enctype="multipart/form-data">
		<input type="file" name="test"/>
		<input type="submit" />
	</form>
</body>
</html>
