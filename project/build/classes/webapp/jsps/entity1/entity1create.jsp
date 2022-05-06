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
		    <!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<style type="text/css">
		*{
			background-color:#122D32;
			font-size:10pt;
		}
		body{
			background-color:#122D32;
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
		h1 { 
			color:white;
		}
	</style>
  </head>
  <body> 
   <table class="table" align="center">
		<tr style="background: #408559; height: 100px;" >
			<td align="center">
				<iframe frameborder="0" src="<c:url value='/jsps/top.jsp'/>" name="top"></iframe>
			</td>
		</tr>
		<tr>
			<td>
				<center>
					<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
						<h1>Inventory_ID (Primary Key):</h1>
						 <div class="form-group">
							<input type="text" class="form-control" style="width:200px;"  name="Inventory_ID" value="${form.Inventory_ID }"/>
						</div>
						<span style="color: red; font-weight: 900">${errors.Inventory_ID }</span>
						<br/>
						<br/>

						
						<h1>Item_SKU：</h1>
						 <div class="form-group">
						 	<input type="text" class="form-control" style="width:200px;" name="Item_SKU" value="${form.Item_SKU }"/>
						</div>
						
						<span style="color: red; font-weight: 900">${errors.Item_SKU }</span>
						<br/>
						<br/>
						<h1>Item_Expiration_Date：</h1><input type="text" class="form-control" style="width:200px;" name="item_expiration_date" value="${form.Item_Expiration_Date }"/>
						<span style="color: red; font-weight: 900">${errors.email }</span>
						<br/>
						<br/>
						<h1>Item_Aisle	：</h1><input type="text" class="form-control" style="width:200px;" name="Item_Aisle" value="${form.Item_Aisle}"/>
						<span style="color: red; font-weight: 900">${errors.Item_Aisle }</span>
						<br/>
						<br/>
						<h1> Item_Amount	：</h1><input type="text" class="form-control" style="width:200px;" name="Item_Amount" value="${form.Item_Amount }"/>
						<span style="color: red; font-weight: 900">${errors.Item_Amount }</span>
						<br/>
						<input class="btn btn-outline-primary" type="submit" value="Create Inventory"/>
					</form>
					</center>
			</td>
		</tr>
	</table>

  </body>
</html>
