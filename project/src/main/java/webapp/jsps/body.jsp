<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body A</title>
    
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
  
  <body>
    	<c:choose>
			<c:when test="${empty sessionScope.session_user }">
			<h1>Please Sign In</h1>
			</c:when>
		<c:otherwise>
		    <h1>Inventory</h1>
			<a href="<c:url value='/jsps/entity1/entity1create.jsp'/>" target="_parent">Create Inventory</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/entity1read.jsp'/>" target="_parent">Read Inventory</a> |&nbsp;
			<a href="<c:url value='/jsps/entity1/entity1update.jsp'/>" target="_parent">Update Inventory</a> |&nbsp;	 
			<a href="<c:url value='/jsps/entity1/entity1delete.jsp'/>" target="_parent">Delete Inventory</a>	
			</br>
		    <h1>Store</h1>
			<a href="<c:url value='/jsps/entity2/storecreate.jsp'/>" target="_parent">Create Store </a> |&nbsp; 
			<a href="<c:url value='/jsps/entity2/storeread.jsp'/>" target="_parent">Read Store</a> |&nbsp;
			<a href="<c:url value='/jsps/entity2/storeupdate.jsp'/>" target="_parent">Update Store</a> |&nbsp;	 
			<a href="<c:url value='/jsps/entity2/storedelete.jsp'/>" target="_parent">Delete Store</a>	
			</br>
		    <h1>Donation Items</h1>
			<a href="<c:url value='/jsps/entity3/donationcreate.jsp'/>" target="_parent">Create Donation Items </a> |&nbsp; 
			<a href="<c:url value='/jsps/entity3/donationread.jsp'/>" target="_parent">Read Donation Items</a> |&nbsp;
			<a href="<c:url value='/jsps/entity3/donationupdate.jsp'/>" target="_parent">Update Donation Items</a> |&nbsp;	 
			<a href="<c:url value='/jsps/entity3/donationdelete.jsp'/>" target="_parent">Delete Donation Items</a>	
			</br>
		    <h1>Location</h1>
			<a href="<c:url value='/jsps/entity4/location_create.jsp'/>" target="_parent">Create Location </a> |&nbsp; 
			<a href="<c:url value='/jsps/entity4/location_read.jsp'/>" target="_parent">Read Location</a> |&nbsp;
			<a href="<c:url value='/jsps/entity4/location_update.jsp'/>" target="_parent">Update Location</a> |&nbsp;	 
			<a href="<c:url value='/jsps/entity4/location_delete.jsp'/>" target="_parent">Delete Location</a>	
			</br>
		    <h1>Charity</h1>
			<a href="<c:url value='/jsps/entity5/charity_create.jsp'/>" target="_parent">Create Charity </a> |&nbsp; 
			<a href="<c:url value='/jsps/entity5/charity_read.jsp'/>" target="_parent">Read Create Charity </a> |&nbsp;
			<a href="<c:url value='/jsps/entity5/charity_update.jsp'/>" target="_parent">Update Create Charity </a> |&nbsp;	 
			<a href="<c:url value='/jsps/entity5/charity_delete.jsp'/>" target="_parent">Delete Create Charity </a>

		</c:otherwise>
	</c:choose>
    
    
  </body>
</html>
