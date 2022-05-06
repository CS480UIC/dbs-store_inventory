<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
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
    <h1>Table of Tables</h1>
    <br>
    <div class="container">
    	<center>
	    <table>
	    	<tr>
	    		<td>
				    <a href="<c:url value='/findAll'/>" class = "btn btn-outline-primary" target="body">List All Users</a>
				    <a href="<c:url value='/findAll'/>" class = "btn btn-outline-primary" target="body">List Inventory Table</a>
				    <a href="<c:url value='/findAll'/>" class = "btn btn-outline-primary" target="body">List Store Table</a>
				    <a href="<c:url value='/findAll'/>" class = "btn btn-outline-primary" target="body">List Donation Items Table</a>
				    <a href="<c:url value='/findAll'/>" class = "btn btn-outline-primary" target="body">List Location Table</a>
				    <a href="<c:url value='/findAll'/>" class = "btn btn-outline-primary" target="body">List Charity Table</a>
				</td>
			</tr>
		</table>
		</center>
    </div>
  </body>
</html>
