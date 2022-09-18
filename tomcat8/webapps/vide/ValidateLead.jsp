<%@page import="hitchhike.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Route</title>
</head>
<body>
	<%@ include file="WEB-INF/Nav.jspf"%>
<div style="left: 15%; top: 25%; width: 500px; position: absolute;">
	<%
		String rnoString=request.getParameter("rno");
			int rno=0;
			if(rnoString==null){
		response.sendRedirect("ChooseHitch.jsp");
			}else{
		rno=Integer.valueOf(request.getParameter("rno"));		
			}
			if (!response.isCommitted() && (logged == null || logged == false)) {
		session.setAttribute("page", "ValidateLead.jsp?rno="+rno);
		response.sendRedirect("Login.jsp");
			}
	%>
	<%!Validation val;
	ValidationDAO valDAO=new ValidationDAO();%>
	<%
		val=new Validation(2, login, rno);
			boolean valAdded=false;
			if(!response.isCommitted()){
		valAdded=valDAO.addValidation(val);
			}
			
			if(valAdded){
	%>
		<h1 class="display-4 text-success text-center">Your request has
			been sent</h1>
	<%}else{ %>
		<h1 class="display-4 text-danger text-center">Sorry, there was a
			mistake</h1>
	<%} %>
	<button type="button" class="btn btn-secondary mt-3 ml-5"
			style="width: 25rem; position: center;" onclick="location.href='./Index.jsp'">Back
			home</button>
	</div>
	
	
	<%-- <%! RouteDAO routeDAO=new RouteDAO();
		Route r;
	%>
	<%r=routeDAO.findByRno(rno); %> --%>
	


</body>
</html>