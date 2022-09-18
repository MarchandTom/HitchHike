<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="hitchhike.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src='https://api.mapbox.com/mapbox.js/v3.0.1/mapbox.js'></script>
<link href='https://api.mapbox.com/mapbox.js/v3.0.1/mapbox.css'
	rel='stylesheet' />
<title>Loading Lead</title>
</head>
<body>
	<%@ include file="WEB-INF/Nav.jspf"%>
	<%
		String rnoString=request.getParameter("rno");
		int rno=0;
		if(rnoString==null && !response.isCommitted()){
			response.sendRedirect("ChooseHitch.jsp");
		}else{
			rno=Integer.valueOf(request.getParameter("rno"));		
		}
		if (!response.isCommitted() &&  (logged == null || logged == false)) {
			session.setAttribute("page", "YourLead.jsp?rno="+rno);
			response.sendRedirect("Login.jsp");
		}
	%>
	<%!
		Route routeLead;
		Route routeClient;
		RouteDAO routeDAO=new RouteDAO();
		Route routeCalc;
		Adresse departure=null;
		Adresse arrival=null;
		Adresse clientArrival=null;
		Adresse yourArrival=null;
	%>
	<%
		routeLead=(Route)session.getAttribute("routeLead");
		routeClient=routeDAO.findByRno(rno);
		if(routeLead== null && routeClient==null && !response.isCommitted()){
			response.sendRedirect("ChooseHitch.jsp");
		}else if(routeLead==null){
			routeCalc=routeClient;
			departure=routeClient.getOrigin();
			arrival=routeClient.getDestination();
			clientArrival=null;
			yourArrival=null;
		}else{
			Itineraire i=new Itineraire(routeLead.getOrigin(), routeClient.getOrigin());
			boolean b=i.calculItineraire();
			if(!response.isCommitted() && !b){
				response.sendRedirect("ChooseHitch.jsp?inputOrigin="+routeLead.getAdresseOrigin()+"&inputDestination="+routeLead.getAdresseDestination());
			}
			routeCalc=new Route(null, routeLead.getOrigin(), routeClient.getOrigin(), i);
			departure=routeLead.getOrigin();
			arrival=routeClient.getOrigin();
			clientArrival=routeClient.getDestination();
			yourArrival=routeLead.getDestination();
		}
	%>
	<h2 class="ml-3 mt-3 display-4 text-white">Your route:</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				
				<div id='map-popups' class="m-2" style="height: 700px;/*  width: 99%; position: absolute; */"></div>
			</div>
			<div class="col-md-auto">
				<div class="card text-white bg-danger mb-3" style="width: 25rem;">
					<div class="card-header">Departure</div>
					<div class="card-body">
						<h5 class="card-title">Address</h5>
						<p class="card-text"><%=routeCalc.getOrigin().getAdresse()%></p>
					</div>
				</div>
				<div class="card text-white bg-success mb-3" style="width: 25rem;">
					<div class="card-header">Arrival</div>
					<div class="card-body">
						<h5 class="card-title">Address</h5>
						<p class="card-text"><%=routeCalc.getDestination().getAdresse()%></p>
					</div>
				</div>
				<div class="card bg-light mb-3" style="width: 25rem;">
					<div class="card-header">Informations</div>
					<div class="card-body">
						<h5 class="card-title">Duration</h5>
						<p class="card-text"><%=routeCalc.getDureeTxt()%></p>
						<h5 class="card-title">Distance</h5>
						<p class="card-text"><%=routeCalc.getDistanceTxt()%></p>
					</div>
				</div>
				<%if(yourArrival!=null){ %>
				<button type="button" class="btn btn-secondary"
					style="width: 25rem;"
					onclick='location.href="./ChooseHitch.jsp?inputOrigin=<%=departure.getAdresseSpe()%>&inputDestination=<%=yourArrival.getAdresseSpe()%>"'>Someone else</button>
				<%}else{ %>
				<button type="button" class="btn btn-secondary"
					style="width: 25rem;"
					onclick='location.href="./ChooseHitch.jsp"'>Someone else</button>				
				<%} %>
				<br>
				<button type="button" class="btn btn-success mt-3"
					style="width: 25rem;" onclick="location.href='./ValidateLead.jsp?rno=<%=rno%>'">Validate</button>

			</div>
		</div>
	</div>
	<script>
	L.mapbox.accessToken = 'pk.eyJ1Ijoic2lsdmVyYjAwIiwiYSI6ImNqZ3k2ZXB2NjI3N2syd21hYjJxdTgwZGMifQ.GwKMZ3MjtnPoLmuRR22SPQ';
	var mapPopups = L.mapbox.map('map-popups', 'mapbox.light');
	var myLayer = L.mapbox.featureLayer().addTo(mapPopups);
	
	var geojson = [
		{
		    type: 'Feature',
		    geometry: {
		      type: 'Point',
		      coordinates: [<%=departure.getCoordReversed()%>]
		    },
		    properties: {
		      title: 'Departure',
		      description: "<b>address</b>: <%=departure.getAdresse()%><br>",
		      'marker-color': '#dc3545'
		    }
	  },
	  {
		    type: 'Feature',
		    geometry: {
		      type: 'Point',
		      coordinates: [<%=arrival.getCoordReversed()%>]
		    },
		    properties: {
		      title: 'Arrival',
		      description: "<b>address</b>: <%=arrival.getAdresse()%><br>",
		      'marker-color': '#28a745'
		    }
	  },
	  <% if(clientArrival!=null && yourArrival!=null){%>
	  {
		    type: 'Feature',
		    geometry: {
		      type: 'Point',
		      coordinates: [<%=clientArrival.getCoordReversed()%>]
		    },
		    properties: {
		      title: 'His destination',
		      description: "<b>address</b>: <%=clientArrival.getAdresse()%><br>",
		      'marker-color': '#3bb2d0'
		    }
	  },{
		    type: 'Feature',
		    geometry: {
		      type: 'Point',
		      coordinates: [<%=yourArrival.getCoordReversed()%>]
		    },
		    properties: {
		      title: 'Your destination',
		      description: "<b>address</b>: <%=yourArrival.getAdresse()%><br>",
		      'marker-color': '#3bb2d0'
		    }
	  }
	  <%}%>
	  ];
	  myLayer.setGeoJSON(geojson);
	  mapPopups.fitBounds([
		  [<%=departure.getCoord()%>],
		  [<%=arrival.getCoord()%>],
	  <%if (clientArrival != null && yourArrival != null) {%>
		[<%=clientArrival.getCoord()%>],[<%=yourArrival.getCoord()%>],  
		  
	  <%}%>
	  ]);
	  
	</script>
</body>
</html>