<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<!DOCTYPE html>

<html>  
	<head>  
		<title><tiles:getAsString name="title" /></title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">		
	</head>  
	
	<body>  
		<div id="content-body">
			<tiles:insertAttribute name="content-body" />
		</div>  
			
	</body>  
</html>