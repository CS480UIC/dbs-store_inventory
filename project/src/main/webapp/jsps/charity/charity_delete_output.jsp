<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

  </head>
  
  <body>
  <h1>Delete Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/CharityServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="charity_id" value="${charity.charity_id }"/>
	charity_id    :<input type="text" name="charity_id" value="${charity.charity_id }" disabled/>
	<br/>
	
	charity_name：<input type="text" name="password" value="${charity.charity_name }" disabled/>
	<br/>
	charity_location	：<input type="text" name="email" value="${charity.charity_location }" disabled/>
	<br/>
	<input type="submit" value="Delete Charity"/>
</form>

</body>
</html>
