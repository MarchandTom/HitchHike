<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String url=request.getParameter("url"); 
String lead=request.getParameter("lead");
if(url==null){
	response.sendRedirect("Index.jsp");
}else{
	if(lead!=null){
		session.setAttribute("lead", lead);
	}
	response.sendRedirect(url);	
}
%>

</body>
</html>