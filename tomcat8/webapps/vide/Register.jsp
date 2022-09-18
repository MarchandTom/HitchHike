<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="hitchhike.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

</head>
<body>
<%@ include file="WEB-INF/Nav.jspf" %>
<%!String error, loginInput, nom, prenom, tel, birthDay, birthMonth, birthYear; %>
<%
error=request.getParameter("error");
loginInput=request.getParameter("login");
nom=request.getParameter("nom");
prenom=request.getParameter("prenom");
tel=request.getParameter("tel");
birthDay=request.getParameter("birthDay");
birthMonth=request.getParameter("birthMonth");
birthYear=request.getParameter("birthYear");

%>
<div class="card container card-container p-4 mt-5">
	<h1 class="display-2 text-center">Register</h1>
	<form action ="./Signup.jsp">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputNom">Last name</label>
	      <input name="nom" type="text" class="form-control" id="inputNom" placeholder="Last name" required <%if(nom!=null){ %>value=<%=nom %><%} %>>
	    </div>
	    <div class="form-group col-md-6">
	      <label for="inputPrenom">First name</label>
	      <input name="prenom" type="text" class="form-control" id="inputPrenom" placeholder="First name" required <%if(prenom!=null){ %>value=<%=prenom %><%} %>>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputLogin">Login</label>
	    
	    <%if(error==null || !error.equals("loginUsed")){ %>
		    <input name="login" type="text" class="form-control" id="inputLogin" placeholder="Login" required <%if(loginInput!=null){ %>value=<%=loginInput %><%} %>>
	    <%}else if(error.equals("loginUsed")){%>
		    <input name="login" type="text" class="form-control is-invalid" id="inputLogin" placeholder="Login" required <%if(loginInput!=null){ %>value=<%=loginInput %><%} %>>
	    	<div class="invalid-feedback">Login already used</div>
	    <%} %>
	    
	  </div>
	  
	  
	    
	    <%if(error==null || !error.equals("differentPassword")){ %>
	    
	  <div class="form-group">
	    <label for="inputPassword">Password</label>
	    <input name="mdp" type="password" class="form-control" id="inputPassword" placeholder="Passord" required>
	  </div>
	  <div class="form-group">
	    <label for="inputPasswordConf">Confirm password</label>
	    <input name="mdpConf" type="password" class="form-control" id="inputPasswordConf" placeholder="Passord" required>
	  </div>
	  
	  <%}else if(error.equals("differentPassword")){%>
	  
	  <div class="form-group">
	    <label for="inputPassword">Password</label>
	    <input name="mdp" type="password" class="form-control is-invalid" id="inputPassword" placeholder="Passord" required>
		<div class="invalid-feedback">The passwords are different</div>
	  </div>

	  <div class="form-group">
	    <label for="inputPasswordConf">Confirm password</label>
	    <input name="mdpConf" type="password" class="form-control is-invalid" id="inputPasswordConf" placeholder="Passord" required>
		<div class="invalid-feedback">The passwords are different</div>
	  </div>
	  <%} %>
	  
	  
	  
	  <%if(error==null || !error.equals("wrongNumber")){ %>
	  
	  <div class="form-group">
	    <label for="inputPhone">Phone number</label>
	    <input name="tel" type="tel" class="form-control" id="inputPhone" placeholder="Phone number" required <%if(tel!=null){ %>value=<%=tel %><%} %>>
	  </div>
	  
	  <%}else if(error.equals("wrongNumber")){%>
	  
	  <div class="form-group">
	    <label for="inputPhone">Phone number</label>
	    <input name="tel" type="tel" class="form-control is-invalid" id="inputPhone" placeholder="Phone number" required <%if(tel!=null){ %>value=<%=tel %><%} %>>
		<div class="invalid-feedback">Invalid phone number (only numbers and "()-+.")</div>
	  </div>
	  
		<%} %>




	  	  <label for="inputBirthMonth">Birth date</label>
	  <div class="form-row">
		  <div class="form-group col-md-2">
		    <input name="birthMonth" type="number" min="1" max="12" class="form-control" id="inputBirthMonth" placeholder="MM" required <%if(birthMonth!=null){ %>value=<%=birthMonth %><%} %>>
		  </div>
		  <div class="form-group col-md-2">
		    <input name="birthDay" type="number" min="1" max="31" class="form-control" id="inputBirthDay" placeholder="DD" required <%if(birthDay!=null){ %>value=<%=birthDay %><%} %>>
		  </div>
		  <div class="form-group col-md-2">
		    <input name="birthYear" type="number" min="1900" max="2000" class="form-control" id="inputBirthYear" placeholder="YYYY" required <%if(birthYear!=null){ %>value=<%=birthYear %><%} %>>
		  </div>
	  </div>
	  <button type="submit" class="btn btn-primary">Sign up</button>
	</form>
</div>

</body>
</html>
