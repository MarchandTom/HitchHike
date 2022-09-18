package hitchhike;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Adresse {
	private String adresseEbauche;
	private String adresse;
	private double coordX=-1;
	private double coordY=-1;
	
	public Adresse() {
	}

	public Adresse(String adresseEbauche) {
		this.adresseEbauche = adresseEbauche;
	}

	public Adresse(double coordX, double coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public Adresse(String adresse, double coordX, double coordY) {
		this.adresse = adresse;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public boolean generateAdresse() throws IOException, JSONException {
		if(adresseEbauche!=null) {
			return generateAdresse(adresseEbauche.replace(" ", "%20"));
		}else if(coordX!=-1 && coordY!=-1) {
			return generateAdresse(coordX+","+coordY);
		}else {
			return false;
		}
	}
	
	public boolean generateAdresse(String adresse) throws JSONException{
		JSONObject json;
		try {
			json = JsonReader.readJsonFromUrl("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyBl6_ySLF3SbspBq_WXnatQxwr8Bw2Zwi0&address="+adresse+"&language=en-GB");
		} catch (IOException | JSONException e) {
			return false;
		}
		if(!json.getString("status").equals("OK")) {
			return false;
		}
		json=json.getJSONArray("results").getJSONObject(0);
		this.adresse=json.getString("formatted_address");
		json=json.getJSONObject("geometry");
		json=json.getJSONObject("location");
		this.coordX=json.getDouble("lat");
		this.coordY=json.getDouble("lng");
		return true;
	}
	
	public static void main(String[] agrs) throws IOException, JSONException {
		Adresse a=new Adresse(50.5547733,3.0174664);
		a.generateAdresse();
		
	}

	public String getAdresseEbauche() {
		return adresseEbauche;
	}

	public void setAdresseEbauche(String adresseEbauche) {
		this.adresseEbauche = adresseEbauche;
	}

	public String getAdresse() {
		return adresse;
	}
	
	public String getAdresseSpe() {
		return adresse.replace(" ", "%20");
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getCoordX() {
		return coordX;
	}

	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}
	
	public String getCoord() {
		return coordX+","+coordY;
	}
	
	public String getCoordReversed() {
		return coordY+","+coordX;
	}

	public String toString() {
		return "Adresse [adresseEbauche=" + adresseEbauche + ", adresse=" + adresse + ", coordX=" + coordX + ", coordY="
				+ coordY + "]";
	}
}
