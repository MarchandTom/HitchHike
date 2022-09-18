import hitchhike.Adresse;
import hitchhike.Itineraire;

public class tmp {

	private int rno;
	private String login;
	private int nbrPers;
	
	private String nomDepart;
	private double coordXDepart;
	private double coordYDepart;
	
	private String nomArrivee;
	private double coordXArrivee;
	private double coordYArrivee;
	
	private String temps;
	private int tempsSec;
	private String distance;
	private int distanceM;
	
	
	@Override
	public String toString() {
		return "tmp [rno=" + rno + ", login=" + login + ", nbrPers=" + nbrPers + ", nomDepart=" + nomDepart
				+ ", coordXDepart=" + coordXDepart + ", coordYDepart=" + coordYDepart + ", nomArrivee=" + nomArrivee
				+ ", coordXArrivee=" + coordXArrivee + ", coordYArrivee=" + coordYArrivee + ", temps=" + temps
				+ ", tempsSec=" + tempsSec + ", distance=" + distance + ", distanceM=" + distanceM + "]";
	}

	
	
	
}
