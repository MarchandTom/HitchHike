<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="hitchhike.*, utilities.Others"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Choose your Hitch</title>
<script src='https://api.mapbox.com/mapbox.js/v3.0.1/mapbox.js'></script>
<link href='https://api.mapbox.com/mapbox.js/v3.0.1/mapbox.css'
	rel='stylesheet' />

</head>
<body>

	<%@ include file="WEB-INF/Nav.jspf"%>
	<div id='map-popups' class="m-2"
		style="height: 92%; width: 99%; position: absolute;"></div>
	<%! RouteDAO routeDAO=new RouteDAO();
	ArrayList<Route> routes;
	Adresse origin;
	Adresse dest;
%>
	<%
	
	String stringOrigin=request.getParameter("inputOrigin");
	String stringDestination=request.getParameter("inputDestination");
	if(stringOrigin==null || stringDestination==null){
		session.removeAttribute("routeLead");
		origin=null;
		dest=null;
		routes=routeDAO.findAllWaiting();		
	}else{
		origin=new Adresse(stringOrigin);
		dest=new Adresse(stringDestination);
		boolean genOrigin=origin.generateAdresse();
		boolean genDest=dest.generateAdresse();
		if(!genOrigin || !genDest){
			String url="YourRoute.jsp?origin="+origin.getAdresseEbauche()+"&destination="+dest.getAdresseEbauche()+"&error=Adresse";
			if(!genOrigin){
				url+="1";
			}
			if(!genDest){
				url+="2";
			}
			response.sendRedirect(url);
		}else{
			double coef=Others.Distance(origin.getCoordX(), origin.getCoordY(), dest.getCoordX(), dest.getCoordY())/10;
			double xMin=0;
			double xMax=0;
			double yMin=0;
			double yMax=0;
			if(origin.getCoordX()<=dest.getCoordX()){
				xMin=origin.getCoordX()-coef;
				xMax=dest.getCoordX()+coef;
			}else{
				xMin=dest.getCoordX()-coef;
				xMax=origin.getCoordX()+coef;
			}
			if(origin.getCoordY()<=dest.getCoordY()){
				yMin=origin.getCoordY()-coef;
				yMax=dest.getCoordY()+coef;
			}else{
				yMin=dest.getCoordY()-coef;
				yMax=origin.getCoordY()+coef;
			}
			routes=routeDAO.findWaitingBetweenCoord(xMin, xMax, yMin, yMax);
			Route routeLead=new Route(null, origin, dest, null);
			session.setAttribute("routeLead", routeLead);
		}
	}
%>
	<script>
L.mapbox.accessToken = 'pk.eyJ1Ijoic2lsdmVyYjAwIiwiYSI6ImNqZ3k2ZXB2NjI3N2syd21hYjJxdTgwZGMifQ.GwKMZ3MjtnPoLmuRR22SPQ';
var mapPopups = L.mapbox.map('map-popups', 'mapbox.light');
var myLayer = L.mapbox.featureLayer().addTo(mapPopups);

var geojson = [
	<%if(origin!=null && dest!=null){%>
	{
	    type: 'Feature',
	    geometry: {
	      type: 'Point',
	      coordinates: [<%=origin.getCoordReversed()%>]
	    },
	    properties: {
	      title: 'Departure',
	      description: "<b>Origin</b>: <%=origin.getAdresse()%>",
	      'marker-color': '#FF0000'
	    }
 	 },{
	    type: 'Feature',
	    geometry: {
	      type: 'Point',
	      coordinates: [<%=dest.getCoordReversed()%>]
	    },
	    properties: {
	      title: 'Arrival',
	      description: "<b>Destination</b>: <%=dest.getAdresse()%>",
	      'marker-color': '#00FF00'
	    }
 	 },
   	<%}
	for(Route r: routes){ %>
	{
	    type: 'Feature',
	    geometry: {
	      type: 'Point',
	      coordinates: [<%=r.getCoordReversedOrigin()%>]
	    },
	    properties: {
	      title: '<%=r.getLogin()%>',
	      description: "<b>Origin</b>: <%=r.getAdresseOrigin()%><br>"+
	      "<b>Destination</b>: <%=r.getAdresseDestination()%><br>"+
	      "<b>Number of persons</b>: <%=r.getNbrPers()%><br>"+
	      "<a href='http://localhost:8080/vide/YourLead.jsp?rno=<%=r.getRno()%>'>See Route</a>",
	      'marker-color': '#3bb2d0'
	    }
  },
  <%}%>
  ];
  myLayer.setGeoJSON(geojson);
  mapPopups.fitBounds([
  <%if (origin != null && dest != null) {%>
	[<%=origin.getCoord()%>],[<%=dest.getCoord()%>],  
	  
  <%}
			for (Route r : routes) {%>
  [
		<%=r.getCoordOrigin()%>
  ],
  <%}%>
  ]);
  
</script>
</body>
</html>