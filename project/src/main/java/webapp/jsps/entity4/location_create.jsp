<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Location</title>
    
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
	<tr style="background: #4682B4; height: 120px; ">
		<td colspan="2" align="center">
			<h1 style="text-align: center; font-size:50px;">LOCATION</h1>
			
			<iframe frameborder="0" src="<c:url value='/jsps/topCRUD.jsp'/>" name="top"></iframe>
			
		</td>
	</tr>
	<tr>
		<td>
		<center>
			<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
				Location_ID (Primary Key):<input type="text" name="Location_ID" value="${form.Location_ID }"/>
				<span style="color: red; font-weight: 900">${errors.Location_ID }</span>
				<br/>
				<br/>
				Location_City：<input type="text" name="Location_City" value="${form.Location_City }"/>
				<span style="color: red; font-weight: 900">${errors.Location_City }</span>
				<br/>
				<br/>
				Location_State	：<input type="text" name="Location_State" value="${form.Location_State }"/>
				<span style="color: red; font-weight: 900">${errors.Location_State }</span>
				<br/>
				<br/>

				<input type="submit" value="Create Location"/>
			</form>
			</center>
		</td>
	</tr>
</table>
  </body>
</html>
