<%@page import="hitchhike.UserDAO"%>
<%@page import="hitchhike.UserView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informations</title>
</head>
<body>
<%@ include file="WEB-INF/Nav.jspf"%>
<%
	if (!response.isCommitted() && (logged == null || logged == false)) {
	session.setAttribute("page", "Messages.jsp");
	response.sendRedirect("Login.jsp");
}
String loginUser=request.getParameter("login");
if(!response.isCommitted() && loginUser == null){
	response.sendRedirect("Index.jsp");
}

UserView uview=new UserView();
UserDAO uDAO=new UserDAO();
%>
<div class="card container card-container p-4 mt-5">
<%=uview.getDetail(uDAO.findByLogin(loginUser)) %>
</div>


</body>
</html>