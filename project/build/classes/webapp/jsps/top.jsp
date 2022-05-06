<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
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
			background: #408559; 
		}
		a { 
			text-transform:none;
			text-decoration:none;
		} 
		a:hover {
			text-decoration:underline;
		}
		h1 { 
			color:white;
		}
	</style>
  </head>
  <body>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
		<center><h1>Home</h1></center>
		</c:when>
		<c:otherwise>
			    <!-- JavaScript Bundle with Popper -->
			<h1 style="color:white;">Good Day, ${sessionScope.session_user.username }</h1>
			<div class="btn-group" style='text-align:right;'>
  				<a style='font-size:24;'  class="btn btn-dark" href="<c:url value='/jsps/main.jsp'/>" target="_parent">Home</a>
				<a style='font-size:24;'  class="btn btn-dark" href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a>
  			</div>
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

