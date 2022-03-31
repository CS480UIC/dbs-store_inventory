
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Inventory</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			font-size:10pt;
		}
		body{
			text-align:center;
		}
		.table{
			width:1024px;
			height:100%;
			border:1px solid gray;
		    border-collapse: collapse;
		}
		.table td{
			border:1px solid gray;
		}
		iframe {
			width: 100%;
			height: 100%;
		}
	</style>
  </head>
  
  <body>
<table class="table" align="center">
	<tr style="background: #68d415; height: 120px; ">
		<td colspan="2" align="center">
			<h1 style="text-align: center; font-size:50px;">DELETE DONATION</h1>
			
			<iframe frameborder="0" src="<c:url value='/jsps/topCRUD.jsp'/>" name="top"></iframe>
			
		</td>
	</tr>
	<tr>
		<td>
		<center>
		<form action="<c:url value='/Entity1ServletRead'/>" method="post">
			<input type="hidden" name="method" value="regist"/>
			Donation Store    :<input type="text" name="Store_Number" value="${form.Store_Number }"/>
			<span style="color: red; font-weight: 900">${errors.Store_Number }</span>
			<br/>
		<%-- 	Password：<input type="password" name="password" value="${form.password }"/>
			<span style="color: red; font-weight: 900">${errors.password }</span>
			<br/>
			Email	：<input type="text" name="email" value="${form.email }"/>
			<span style="color: red; font-weight: 900">${errors.email }</span>
			<br/> --%>
			<input type="submit" value="Delete Donation"/>
		</form>
			</center>
		</td>
	</tr>
</table>
  </body>
</html>
