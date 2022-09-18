<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="hitchhike.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Route Added</title>
</head>
<body>
	<%@ include file="WEB-INF/Nav.jspf"%>
	<div style="left: 15%; top: 25%; width: 500px; position: absolute;">
		<%
			Route route = (Route) session.getAttribute("route");
			if (logged == null || logged == false) {
				if (route == null) {
					session.setAttribute("page", "YourRoute.jsp");
				} else {
					session.setAttribute("page", "RouteAdded.jsp");
				}
				response.sendRedirect("Login.jsp");
			} else {
				if (route.getLogin() == null) {
					route.setLogin((String) session.getAttribute("login"));
				}
				RouteDAO routeDAO = new RouteDAO();
				boolean added = routeDAO.addRoute(route);
				if (added) {
		%>
		<h1 class="display-4 text-success text-center">Your route has
			been added</h1>
		<%
				} else {
		%>
		<h1 class="display-4 text-danger text-center">Sorry, there was a
			mistake</h1>
		<%
				}
			}
		%>
		<button type="button" class="btn btn-secondary mt-3 ml-5"
			style="width: 25rem; position: center;" onclick="location.href='./Index.jsp'">Back
			home</button>
	</div>
</body>
</html>