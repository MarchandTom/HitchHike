<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<title>Your Route</title>
</head>
<body>
	<%@ include file="WEB-INF/Nav.jspf"%>
	<%
		String erreur = request.getParameter("error");
	%>
	
	
<div class="card container card-container p-4 mt-5" style="top:150px;">
	<h1 class="display-2 text-center">What is your Route?</h1>
	<script type="text/javascript"
		src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDO7pu-k2JujrlYKC-kk-2Z1M4rPczJbZQ&libraries=places&language=en-GB&amp;sensor=false"></script>
	<%!String action = "./LoadRoute.jsp";%>
	<%
		Boolean lead = Boolean.valueOf((String)session.getAttribute("lead"));
		if (lead!=null && lead) {
			action = "./ChooseHitch.jsp";
		}else if (lead!=null && !lead) {
			action = "./LoadRoute.jsp";			
		}
	%>
	<form action="<%=action%>">
		<div class="form-group">
			<label for="inputOrigin">Where are you?</label>

			<%
				String adresseOrigin = request.getParameter("origin");
				if (adresseOrigin == null) {
			%>

			<input type="text" class="form-control" id="inputOrigin"
				name="inputOrigin" placeholder="Write a place" autofocus required>

			<%
				} else {
					if (erreur != null && (erreur.equals("Adresse12") || erreur.equals("Adresse1"))) {
			%>
			<input type="text" class="form-control is-invalid" id="inputOrigin"
				name="inputOrigin" placeholder="Write a place"
				value="<%=adresseOrigin%>" required>
			<div class="invalid-feedback">Please enter a valid address. (Do
				not use special characters)</div>
			<%
					} else {
			%>
			<input type="text" class="form-control" id="inputOrigin"
				name="inputOrigin" placeholder="Write a place"
				value="<%=adresseOrigin%>" required>

			<%
					}
				}
			%>

		</div>
		<div class="form-group">
			<label for="inputDestination">Where are you going?</label>

			<%
				String adresseDestination = request.getParameter("destination");
				if (adresseDestination == null) {
			%>
			<input type="text" class="form-control" id="inputDestination"
				name="inputDestination" placeholder="Write a place" required>
			<%
				} else {
					if (erreur != null && (erreur.equals("Adresse12") || erreur.equals("Adresse2"))) {
			%>
			<input type="text" class="form-control is-invalid"
				id="inputDestination" name="inputDestination"
				placeholder="Write a place" value="<%=adresseDestination%>" required>
			<div class="invalid-feedback">Please enter a valid address. (Do
				not use special characters)</div>
			<%
				} else {
			%>
			<input type="text" class="form-control" id="inputDestination"
				name="inputDestination" placeholder="Write a place"
				value="<%=adresseDestination%>" required>
			<%
				}
				}
			%>
		</div>
		<% if(lead!=null && !lead){ %>
		<div class="form-group col-md-2">
			<label for="inputNbrPers">Number of person</label>
		   	<input type="number" class="form-control"  min="1" max="4" id="inputNbrPers" name="nbrPers" value="1" autofocus required>
		</div>
		<%
			}
			if (erreur != null && erreur.equals("ZEROResult")) {
		%>
		<div class="alert alert-danger">
			<strong>Error!</strong> Make sure there is a route between these two
			addresses.
		</div>
		<%
			}
		%>
		<button type="submit" class="btn btn-primary">Validate</button>
	</form>
</div>
	<script>
		var input = document.getElementById('inputOrigin');
		autocomplete = new google.maps.places.Autocomplete(input);
		var input2 = document.getElementById('inputDestination');
		autocomplete = new google.maps.places.Autocomplete(input2);
	</script>

</body>
</html>