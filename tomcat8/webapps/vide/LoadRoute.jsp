<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="hitchhike.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loading Route</title>
</head>
<body>

	<%@ include file="WEB-INF/Nav.jspf"%>
	<%
		/* if (logged == null || logged == false) {
			session.setAttribute("page", "YourRoute.jsp");
			response.sendRedirect("Login.jsp");
		} */
	%>
	<%!String login;
	String adresseOrigin;
	String adresseDestination;
	Adresse origin;
	Adresse destination;
	Itineraire itineraire;%>
	<%
		login = (String) session.getAttribute("login");
		adresseOrigin = request.getParameter("inputOrigin");
		adresseDestination = request.getParameter("inputDestination");
		origin = new Adresse(adresseOrigin);
		destination = new Adresse(adresseDestination);
		boolean generateAdresse1 = origin.generateAdresse();
		boolean generateAdresse2 = destination.generateAdresse();
		if (!generateAdresse1 && !generateAdresse2) {
			System.out.println("DEBUG LoadRoute ---- Erreur sur les deux adresses");
			response.sendRedirect("./YourRoute.jsp?origin=" + origin.getAdresseEbauche() + "&destination="
					+ destination.getAdresseEbauche() + "&error=Adresse12");
		} else if (!generateAdresse1) {
			System.out.println("DEBUG LoadRoute ---- Erreur sur l'adresse 1");
			response.sendRedirect("./YourRoute.jsp?origin=" + origin.getAdresseEbauche() + "&destination="
					+ destination.getAdresseEbauche() + "&error=Adresse1");
		} else if (!generateAdresse2) {
			System.out.println("DEBUG LoadRoute ---- Erreur sur l'adresse 2");
			response.sendRedirect("./YourRoute.jsp?origin=" + origin.getAdresseEbauche() + "&destination="
					+ destination.getAdresseEbauche() + "&error=Adresse2");
		}
		itineraire = new Itineraire(origin, destination);
		boolean result = itineraire.calculItineraire();
		if (generateAdresse1 && generateAdresse2 && !result) {
			System.out.println("DEBUG LoadRoute ---- Erreur sur l'itineraire");
			response.sendRedirect("./YourRoute.jsp?origin=" + origin.getAdresseEbauche() + "&destination="
					+ destination.getAdresseEbauche() + "&error=ZEROResult");
		} else if(generateAdresse1 && generateAdresse2 && result){
			session.setAttribute("route", new Route(login, origin, destination, itineraire, Integer.valueOf(request.getParameter("nbrPers"))));
		}
	%>
	<h1 class="ml-3 mt-3 display-4 text-white">Your route:</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div id="map" style="height: 700px;"></div>
			</div>
			<div class="col-md-auto">
				<div class="card text-white bg-primary mb-3" style="width: 25rem;">
					<div class="card-header">Departure</div>
					<div class="card-body">
						<h5 class="card-title">Address</h5>
						<p class="card-text"><%=origin.getAdresse()%></p>
					</div>
				</div>
				<div class="card text-white bg-info mb-3" style="width: 25rem;">
					<div class="card-header">Arrival</div>
					<div class="card-body">
						<h5 class="card-title">Address</h5>
						<p class="card-text"><%=destination.getAdresse()%></p>
					</div>
				</div>
				<div class="card bg-light mb-3" style="width: 25rem;">
					<div class="card-header">Informations</div>
					<div class="card-body">
						<h5 class="card-title">Duration</h5>
						<p class="card-text"><%=itineraire.getTemps()%></p>
						<h5 class="card-title">Distance</h5>
						<p class="card-text"><%=itineraire.getDistance()%></p>
					</div>
				</div>
				<button type="button" class="btn btn-secondary"
					style="width: 25rem;"
					onclick='location.href="./YourRoute.jsp?origin=<%=origin.getAdresseEbauche()%>&destination=<%=destination.getAdresseEbauche()%>"'>Modify</button>
				<br>
				<button type="button" class="btn btn-primary mt-3"
					style="width: 25rem;" onclick="location.href='./RouteAdded.jsp'">Validate</button>

			</div>
		</div>
	</div>
	<script>
		function initMap() {
			var uluru = {
				lat :<%=origin.getCoordX()%>,
				lng :<%=origin.getCoordY()%>
			};
			
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 4,
				center : uluru
			});
			
			bounds = new google.maps.LatLngBounds();
			
			var marker = new google.maps.Marker({
				position : {
					lat :<%=origin.getCoordX()%>,
					lng :<%=origin.getCoordY()%>
				},
				map : map,
				title: "Origin"
			});
			var infowindow = new google.maps.InfoWindow({
		          content: "<h6 id='firstHeading' class='firstHeading'>Origin</h6><%=origin.getAdresse()%>"
			});
			marker.addListener('click', function() {
				infowindow.open(map, marker);
				infowindow2.close();
			});
			
			loc = new google.maps.LatLng(marker.position.lat(), marker.position.lng());
			bounds.extend(loc);
			
			var marker2 = new google.maps.Marker({
				position : {
					lat :<%= destination.getCoordX() %>,
					lng :<%= destination.getCoordY() %>
				},
				map : map,
				title : "Destination"
			});
			var infowindow2 = new google.maps.InfoWindow({
		          content: "<h6 id='firstHeading' class='firstHeading'>Destination</h6><%=destination.getAdresse()%>"
			});
			marker2.addListener('click', function() {
				infowindow2.open(map, marker2);
				infowindow.close();
			});
			
			loc = new google.maps.LatLng(marker2.position.lat(),
					marker2.position.lng());
			bounds.extend(loc);
			map.fitBounds(bounds);
			map.panToBounds(bounds);

		}
	</script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBl6_ySLF3SbspBq_WXnatQxwr8Bw2Zwi0&callback=initMap">
		
	</script>
</body>
</html>