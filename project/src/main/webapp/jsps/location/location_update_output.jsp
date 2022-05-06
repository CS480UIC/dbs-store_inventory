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

  </head>
  
  <body>
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	ID    :<input type="text" name="location_id1" value="${location.location_id }" disabled/>
	<br/>
	
	City：<input type="text" name="location_city1=" value="${location.location_city }" disabled />
	<br/>
	State	：<input type="text" name="location_state1" value="${location.location_state }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/LocationServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="location_id" value="${location.location_id }"/>
	City：<input type="location_city" name="location_city" value="${form.location_city }"/>
	<span style="color: red; font-weight: 900">${errors.location_city }</span>
	<br/>
	State	：<input type="text" name="email" value="${form.location_state }"/>
	<span style="color: red; font-weight: 900">${errors.location_state }</span>
	<br/>
	<input type="submit" value="Update Location"/>
</form>

</body>
</html>
