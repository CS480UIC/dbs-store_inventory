<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body A</title>
	    <!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	    <!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
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
  	<style>
  		body {
			background: #122D32; 
		}
		a { 
			text-transform:none;
			text-decoration:none;
		} 
		a:hover {
			text-decoration:underline;
		}
  	</style>
  <body>
    	<c:choose>
			<c:when test="${empty sessionScope.session_user }">
			<br>
			<h1 style="text-align:center;">Please Sign In</h1>
			<center>			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> -&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> -&nbsp; 
			<a href="<c:url value='/jsps/user/initialize.jsp'/>" target="_parent">Initialize Database</a></center>
			
			</c:when>
		<c:otherwise>
			<div class="container">
					    <h1 style="color:white;">Inventory</h1>
					    <table>
					    	<tr>
					    		<td>
									<a href="<c:url value='/jsps/entity1/entity1create.jsp'/>" class="btn btn-primary" target="_parent">Create Inventory</a> 
									<a href="<c:url value='/jsps/entity1/entity1read.jsp'/>" class="btn btn-primary" target="_parent">Read Inventory</a>		
					    			<a href="<c:url value='/jsps/entity1/entity1update.jsp'/>" class="btn btn-primary" target="_parent">Update Inventory</a>	 
									<a href="<c:url value='/jsps/entity1/entity1delete.jsp'/>" class="btn btn-primary" target="_parent">Delete Inventory</a>	
						    	</td>
					    	</tr>
					    </table>
					    <h1 style="color:white;">Store</h1>
					    <table>
			   		    	<tr>
					    		<td>
									<a href="<c:url value='/jsps/entity2/storecreate.jsp'/>" class="btn btn-success" target="_parent">Create Store </a>  
									<a href="<c:url value='/jsps/entity2/storeread.jsp'/>" class="btn btn-success" target="_parent">Read Store</a>
									<a href="<c:url value='/jsps/entity2/storeupdate.jsp'/>" class="btn btn-success" target="_parent">Update Store</a>
									<a href="<c:url value='/jsps/entity2/storedelete.jsp'/>" class="btn btn-success" target="_parent">Delete Store</a>	
								</td>
							</tr>
						</table>
					</div>			
			<div class="container">
					    <h1 style="color:white;">Donation Items</h1>
					    <table>
			   		    	<tr>
					    		<td>
									<a href="<c:url value='/jsps/entity3/donationcreate.jsp'/>" class="btn btn-danger" target="_parent">Create Donation Items </a>
									<a href="<c:url value='/jsps/entity3/donationread.jsp'/>" class="btn btn-danger"  target="_parent">Read Donation Items</a>
									<a href="<c:url value='/jsps/entity3/donationupdate.jsp'/>" class="btn btn-danger" target="_parent">Update Donation Items</a> 
									<a href="<c:url value='/jsps/entity3/donationdelete.jsp'/>" class="btn btn-danger" target="_parent">Delete Donation Items</a>	
								</td>
							</tr>
						</table>
					   <h1 style="color:white;">Location</h1>
					    <table>
			   		    	<tr>
					    		<td>
									<a href="<c:url value='/jsps/location/location_create.jsp'/>" class="btn btn-warning"  target="_parent">Create Location </a> 
									<a href="<c:url value='/jsps/location/location_read.jsp'/>"  class="btn btn-warning" target="_parent">Read Location</a> 
									<a href="<c:url value='/jsps/location/location_update.jsp'/>" class="btn btn-warning"  target="_parent">Update Location</a>
									<a href="<c:url value='/jsps/location/location_delete.jsp'/>" class="btn btn-warning"  target="_parent">Delete Location</a>	
								</td>
							</tr>
						</table>
		    			<h1 style="color:white;">Charity</h1>
					    <table>
			   		    	<tr>
					    		<td>
									<a href="<c:url value='/jsps/charity/charity_create.jsp'/>" class="btn btn-info" target="_parent">Create Charity </a>
									<a href="<c:url value='/jsps/charity/charity_read.jsp'/>" class="btn btn-info" target="_parent">Read Charity </a>
									<a href="<c:url value='/jsps/charity/charity_update.jsp'/>" class="btn btn-info" target="_parent">Update Create Charity </a>	 
									<a href="<c:url value='/jsps/charity/charity_delete.jsp'/>" class="btn btn-info" target="_parent">Delete Create Charity </a>
								</td>
							</tr>
						</table>
				</div>
			</div>
			</c:otherwise>
	</c:choose>
    
    
  </body>
</html>
