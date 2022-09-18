<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="hitchhike.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signing up</title>
</head>
<body>
<%
try{
	String login=request.getParameter("login");
	String mdp=request.getParameter("mdp");
	String mdpConf=request.getParameter("mdpConf");
	String nom=request.getParameter("nom").toUpperCase();
	String prenom=request.getParameter("prenom");
	String tel=request.getParameter("tel");
	int birthDay=Integer.valueOf(request.getParameter("birthDay"));
	int birthMonth=Integer.valueOf(request.getParameter("birthMonth"));
	int birthYear=Integer.valueOf(request.getParameter("birthYear"));
	
	String param="login="+login+"&nom="+nom+"&prenom="+prenom+"&tel="+tel+"&birthDay="+birthDay+"&birthMonth="+birthMonth+"&birthYear="+birthYear;
	
	UserDAO userDAO=new UserDAO();
	if(userDAO.exist(request.getParameter("login"))){
		response.sendRedirect("./Register.jsp?error=loginUsed&"+param);
	}else if(!mdp.equals(mdpConf)){
		response.sendRedirect("./Register.jsp?error=differentPassword&"+param);
	}else if(tel.replaceAll("[0-9+(). \\-]","").length()>0){
		response.sendRedirect("./Register.jsp?error=wrongNumber&"+param);
	}else{
		User u=new User(request.getParameter("login"), ""+User.hashPasswd(request.getParameter("mdp")), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("tel"), Integer.valueOf(request.getParameter("birthDay")), Integer.valueOf(request.getParameter("birthMonth")), Integer.valueOf(request.getParameter("birthYear")));
		boolean b=userDAO.addUser(u);
		if(b){
			response.sendRedirect("./Login.jsp");
		}else{
			response.sendRedirect("./Register.jsp?error=unknown&"+param);
		}		
	}

}catch(Exception e){
	response.sendRedirect("./Login.jsp");
	System.err.println(e);
}	
%>
</body>
</html>