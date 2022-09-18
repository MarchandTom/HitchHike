<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>

<head><title>Login</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		</head>

		<body>
			<%@ include file="WEB-INF/Nav.jspf" %>
			<div class="card container card-container p-4 mt-5">
				<h3 class="display-2 text-center">Login</h3>
				<form class="px-4 py-3" action="./servlet/hitchhike/Authent">
				    <div class="form-group">
				      	<label for="inputLogin">Login</label>
				      	<%
				      		String error=request.getParameter("error");
				      		login=request.getParameter("login");
				      		String inputName;
				      		if(login==null){
				      	%>
				      	<input type="text" class="form-control" id="inputLogin" placeholder="Login" name="login" autofocus required>
				      	<% }else{ %>
						<input type="text" class="form-control" id="inputLogin" value=<%=login %> name="login" required>
						<% } %>
				      	<!-- <input type="text" class="form-control" id="inputLogin" placeholder="Login" name="login"> -->
				    </div>
				    <div class="form-group">
				      	<label for="inputPasswd">Password</label>
				      	<%
				      		if(error!=null && error.equals("password")){
				      	%>
				      	<input type="password" class="form-control is-invalid" id="inputPasswd" placeholder="Password" name="mdp" autofocus required>
					    <div class="invalid-feedback">
					        Invalid password.
					    </div>
				      	<% }else{ %>
				      	<input type="password" class="form-control" id="inputPasswd" placeholder="Password" name="mdp" required>
					    <%} %>
				    </div>
    
				    <button type="submit" class="btn btn-primary">Sign in</button>
				</form>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="./Register.jsp">New around here? Sign up</a>
				<a class="dropdown-item" href="#">Forgot password?</a>
			</div>
			 <!-- <form method="post" action="./servlet/hitchhike/Authent">
			login : <input type="text" name="login"></br></br>
			mot de passe : <input type="password" name="mdp"></br></br>
			<input type="submit" value="Se connecter">
			</form> -->
		</body>
</HTML>
<!--     <div class="form-check">
      <input type="checkbox" class="form-check-input" id="dropdownCheck">
      <label class="form-check-label" for="dropdownCheck">
        Remember me
      </label>
    </div> -->