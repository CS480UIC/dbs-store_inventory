<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Inventory</title>
    
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
			<h1 style="text-align: center; font-size:50px;">DONATION</h1>
			
			<iframe frameborder="0" src="<c:url value='/jsps/topCRUD.jsp'/>" name="top"></iframe>
			
		</td>
	</tr>
	<tr>
		<td>
		<center>
			<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
				Donation Store (Primary Key):<input type="text" name="donation_store" value="${form.donation_store }"/>
				<span style="color: red; font-weight: 900">${errors.donation_store }</span>
				<br/>
				<br/>
				Donation SKU：<input type="text" name="donation_SKU" value="${form.donation_SKU }"/>
				<span style="color: red; font-weight: 900">${errors.donation_SKU }</span>
				<br/>
				<br/>
				Donation Amount：<input type="text" name="donation_amount" value="${form.donation_amount }"/>
				<span style="color: red; font-weight: 900">${errors.donation_amount }</span>
				<br/>
				<br/>
					Donation Date：<input type="text" name="donation_date" value="${form.donation_date }"/>
				<span style="color: red; font-weight: 900">${errors.donation_date }</span>
				<br/>
				<input type="submit" value="Create Donation"/>
			</form>
			</center>
		</td>
	</tr>
</table>
  </body>
</html>
