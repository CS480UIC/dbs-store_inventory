<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		    border-collapse: collapse;
		}
		iframe {
			width: 100%;
			height: 100%;
		}
		h1 { 
			color:white;
		}
		th {
			font-size:36px;
			color:white;
		}
		td {
  			font-size: 20px;
  			color:white;
		}
	</style>

</head>
<body>
	<h1 align="center"> Charity Table </h1>
	<table class="table" border="1" width="40%" align="center">
	<tr>
			<th>id</th>
		<th>name</th>
		<th>location</th>
	</tr>
<c:forEach items="${CharityList}" var="user">
	<tr>
			<td>${user.charity_id}</td>
		<td>${user.charity_name}</td>
		<td>${user.charity_location}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
