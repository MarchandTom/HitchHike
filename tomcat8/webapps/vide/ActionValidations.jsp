<%@page import="hitchhike.ValidationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="WEB-INF/Nav.jspf"%>
<%
	if (!response.isCommitted() && (logged == null || logged == false)) {
	session.setAttribute("page", "Messages.jsp");
	response.sendRedirect("Login.jsp");
}
String action=request.getParameter("action");
String vnoString=request.getParameter("avno");
if(!response.isCommitted() && (action == null || vnoString==null)){
	response.sendRedirect("Messages.jsp");
}
if(!response.isCommitted()){
	int vno=Integer.valueOf(vnoString);
	ValidationDAO aDAO=new ValidationDAO();
	if(action.equals("delete")){
		aDAO.deleteFromvno(vno);
	}else{
		int newState= action.equals("accept")?1:0;
		aDAO.updateState(vno, newState);
	}
	response.sendRedirect("Messages.jsp");
	
}
%>
</body>
</html>