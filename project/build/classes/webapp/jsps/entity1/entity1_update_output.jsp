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
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
	<form>
		ID    :<input type="text" name="id" value="${entity1.getInventory_ID()}" disabled/>
		<br>
		SKU:<input type="text" name="id" value="${entity1.getItem_SKU()}" disabled/>
		<br>
		Expiration Date    :<input type="text" name="id" value="${entity1.getItem_Expiration_Date()}" disabled/>
		<br>
		Aisle    :<input type="text" name="id" value="${entity1.getItem_Aisle()}" disabled/>
		<br>
		Amount    :<input type="text" name="id" value="${entity1.getItem_Amount()}" disabled/>
		<br>
	</form>

<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		ID    :<input type="text" name="id" value="${entity1.getInventory_ID()}" />
		<br>
		SKU:<input type="text" name="id" value="${entity1.getItem_SKU()}" />
		<br>
		Expiration Date    :<input type="text" name="id" value="${entity1.getItem_Expiration_Date()}" />
		<br>
		Aisle    :<input type="text" name="id" value="${entity1.getItem_Aisle()}" />
		<br>
		Amount    :<input type="text" name="id" value="${entity1.getItem_Amount()}" />
		<br>
	<input type="submit" value="Update Entity1"/>
</form>

</body>
</html>
