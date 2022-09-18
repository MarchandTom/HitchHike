<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Index</title>
</head>
<body>

<%@ include file="WEB-INF/Nav.jspf" %>

<div class="" style="left:15%; top: 25%; width: 500px; position: absolute;">
	<h1 class="display-1 font-italic text-white">Hitchhike</h1>
	<p class="lead my-3 text-white">Hitchhike is a free website for free courses based on communitarianism. Simply tell us where you want to go and maybe someone will pick you up! Also you can go through the list of waiting people and send them a request in order to pick them up!</p>
 	<a href="Redirect.jsp?url=YourRoute.jsp&lead=false"><button class="btn btn-primary">HitchHike</button></a>
	<a href="Redirect.jsp?url=YourRoute.jsp&lead=true"><button class="btn btn-secondary ml-3">Pick someone up</button></a>
</div>
</body>
</html>