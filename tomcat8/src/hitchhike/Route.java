package hitchhike;


public class Route{
	private int rno;
	private Adresse origin;
	private Adresse destination;
	private Itineraire itineraire;
	private String login;
	private int nbrPers;

	
	
	public Route(String login) {
		this.login=login;
	}


	public Route(String login, String origin, double coordXOrigin, double coordYOrigin, String destination,
			double coordXDest, double coordYDest) {
		this.origin=new Adresse(origin, coordXOrigin, coordYOrigin);
		this.destination=new Adresse(destination, coordXDest, coordYDest);
		this.itineraire=new Itineraire(this.origin, this.destination);
		this.login = login;
	}
	
	
	public Route(String login, String origin, double coordXOrigin, double coordYOrigin, String destination,
			double coordXDest, double coordYDest, int dureeSec) {
		this(login, origin, coordXOrigin, coordYOrigin, destination, coordXDest, coordYDest);
		itineraire.setTempsSec(dureeSec);
	}
	
	public Route(String login, String origin, double coordXOrigin, double coordYOrigin, String destination,
			double coordXDest, double coordYDest, int dureeSec, int distanceM) {
		this(login, origin, coordXOrigin, coordYOrigin, destination, coordXDest, coordYDest);
		itineraire.setTempsSec(dureeSec);
		itineraire.setdistanceM(distanceM);
	}
	
	public Route(int rno, String login, String origin, double coordXOrigin, double coordYOrigin, String destination,
			double coordXDest, double coordYDest, int dureeSec) {
		this(login, origin, coordXOrigin, coordYOrigin, destination, coordXDest, coordYDest);
		this.rno=rno;
	}
	
	public Route(int rno, String login, String origin, double coordXOrigin, double coordYOrigin, String destination,
			double coordXDest, double coordYDest, String dureeTxt, int dureeSec, String distanceTxt, int distanceM, int nbrPers) {
		this(login, origin, coordXOrigin, coordYOrigin, destination, coordXDest, coordYDest);
		itineraire.setTemps(dureeTxt);
		itineraire.setTempsSec(dureeSec);
		itineraire.setDistance(distanceTxt);
		itineraire.setdistanceM(distanceM);
		this.rno=rno;
		this.nbrPers=nbrPers;
	}
	
	public Route(String login, Adresse origin, Adresse destination, Itineraire i) {
		this.login = login;
		this.origin=origin;
		this.destination=destination;
		this.itineraire=i;
	}
	
	public Route(String login, Adresse origin, Adresse destination, Itineraire i, int nbrPers) {
		this.login = login;
		this.origin=origin;
		this.destination=destination;
		this.itineraire=i;
		this.nbrPers=nbrPers;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Adresse getOrigin() {
		return origin;
	}
	public String getAdresseOrigin() {
		return origin.getAdresse();
	}
	public String getAdresseSpeOrigin() {
		return origin.getAdresseSpe();
	}
	public String getCoordOrigin() {
		return origin.getCoord();
	}
	public String getCoordReversedOrigin() {
		return origin.getCoordReversed();
	}
	public double getCoordXOrigin() {
		return origin.getCoordX();
	}
	public double getCoordYOrigin() {
		return origin.getCoordY();
	}
	public Adresse getDestination() {
		return destination;
	}
	public String getAdresseDestination() {
		return destination.getAdresse();
	}
	public String getAdresseSpeDestination() {
		return destination.getAdresseSpe();
	}
	public String getCoordDest() {
		return destination.getCoord();
	}
	public String getCoordReversedDest() {
		return destination.getCoordReversed();
	}
	public double getCoordXDest() {
		return destination.getCoordX();
	}
	public double getCoordYDest() {
		return destination.getCoordY();
	}
	public String getDureeTxt() {
		return itineraire.getTemps();
	}
	public int getDureeSec() {
		return itineraire.getTempsSec();
	}
	public String getDistanceTxt() {
		return itineraire.getDistance();
	}
	public int getDistanceMetre() {
		return itineraire.getdistanceM();
	}
	public int getRno() {
		return rno;
	}
	public int getNbrPers() {
		return nbrPers;
	}
	
	
	
	
}
