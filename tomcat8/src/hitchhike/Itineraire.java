package hitchhike;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Itineraire {
	private Adresse origin;
	private Adresse destination;
	private String temps;
	private int tempsSec;
	private String distance;
	private int distanceM;
	
	public Itineraire() {
	}

	public Itineraire(Adresse origin, Adresse destination) {
		this.origin = origin;
		this.destination = destination;
	}

	public Itineraire(Adresse origin, Adresse destination, String temps, int tempsSec, String distance,
			int distanceM) {
		this.origin = origin;
		this.destination = destination;
		this.temps = temps;
		this.tempsSec = tempsSec;
		this.distance = distance;
		this.distanceM = distanceM;
	}
	
	public Itineraire(Adresse origin, Adresse destination, int tempsSec, int distanceM) {
		this.origin = origin;
		this.destination = destination;
		this.tempsSec = tempsSec;
		this.distanceM = distanceM;
	}

	public boolean calculItineraire() throws IOException, JSONException {
		  
	    JSONObject json = JsonReader.readJsonFromUrl("https://maps.googleapis.com/maps/api/distancematrix/json"
	    		+ "?origins="+origin.getCoord()
	    		+ "&destinations="+destination.getCoord()
	    		+ "&mode=car"
	    		+ "&language=en-GB"
	    		+ "&key=AIzaSyBl6_ySLF3SbspBq_WXnatQxwr8Bw2Zwi0");
	    
	    String status=json.getString("status");
	    if(!status.equals("OK")) {
	    	return false;
	    }
	    
	    String s =""+json.getJSONArray("rows").get(0);
	    
	    JSONObject jo=new JSONObject(s);
	    
	    JSONArray ja=jo.getJSONArray("elements");
	    
	    s=""+ja.get(0);
	    
	    jo=new JSONObject(s);
	    
	    status=jo.getString("status");
	    if(!status.equals("OK")) {
	    	return false;
	    }
	    
	    JSONObject jo2=jo.getJSONObject("duration");
	    JSONObject jo3=jo.getJSONObject("distance");
	    
	    this.temps=jo2.getString("text");
	    this.tempsSec=jo2.getInt("value");
	    this.distance=jo3.getString("text");
	    this.distanceM=jo3.getInt("value");
	    return true;
	}


	public Adresse getOrigin() {
		return origin;
	}

	public void setOrigin(Adresse origin) {
		this.origin = origin;
	}

	public Adresse getDestination() {
		return destination;
	}

	public void setDestination(Adresse destination) {
		this.destination = destination;
	}
	
	public String getTemps() {
		return temps;
	}

	public void setTemps(String temps) {
		this.temps = temps;
	}

	public int getTempsSec() {
		return tempsSec;
	}

	public void setTempsSec(int tempsSec) {
		this.tempsSec = tempsSec;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getdistanceM() {
		return distanceM;
	}

	public void setdistanceM(int distanceM) {
		this.distanceM = distanceM;
	}

	@Override
	public String toString() {
		return "Itineraire [origin=" + origin + ", destination=" + destination + ", temps=" + temps + ", tempsSec="
				+ tempsSec + ", distance=" + distance + ", distanceM=" + distanceM+ "]";
	}

	
}
