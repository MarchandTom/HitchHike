<%@page import="hitchhike.ValidationView"%>
<%@page import="hitchhike.ValidationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Messages</title>
</head>
<body>
<%@ include file="WEB-INF/Nav.jspf" %>
<h1 class="display-2 text-center text-white">Your messages</h1>
<%
	if (!response.isCommitted() && (logged == null || logged == false)) {
	session.setAttribute("page", "Messages.jsp");
	response.sendRedirect("Login.jsp");
}
ValidationDAO aDAO=new ValidationDAO();
%>
<%=ValidationView.getTableValidationMessages(aDAO.findByClientLogin(login))%>


</body>
</html>