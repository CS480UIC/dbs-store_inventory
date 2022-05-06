<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		    <!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	    <!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<style type="text/css">
		body {
			background-color:#122D32;
		}
		a { 
			text-transform:none;
			text-decoration:none;
		} 
		a:hover {
			text-decoration:underline;
		}
	</style>
  </head>
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
  <body>
	<table class="table" align="center">
		<tr style=" height: 100px;" >
			<td colspan="2" align="center">
				<iframe src="<c:url value='/jsps/topRegister.jsp'/>" name="top"></iframe>
			</td>
		</tr>
		<tr>
			<td>
			<center>
				<p style="color: red; font-weight: 900"> ${msg}</p>
			<form action="<c:url value='/UserServletRegister'/>" method="post">
				<input type="hidden" name="method" value="regist"/>
				<h1 style="color:white;">User    :</h1><input type="text" name="username" value="${form.username }"/>
				<span style="color: red; font-weight: 900">${errors.username }</span>
				<br/>
				<h1 style="color:white;">Password：</h1><input type="password" name="password" value="${form.password }"/>
				<span style="color: red; font-weight: 900">${errors.password }</span>
				<br/>
				<h1 style="color:white;">Email	：</h1><input type="text" name="email" value="${form.email }"/>
				<span style="color: red; font-weight: 900">${errors.email }</span>
				<br/>
				<input type="submit" value="Register"/>
			</form>
			</center>

			</td>
		</tr>
	</table>
  </body>
</html>




