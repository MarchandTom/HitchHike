package hitchhike;

public class Validation {
	private int avno;
	private int accepted;
	private String loginDriver;
	private int rno;
	private String origin;
	private String destination;
	
	public Validation() {
	}
	
	public Validation(int accepted, String loginDriver, int rno) {
		this.accepted = accepted;
		this.loginDriver = loginDriver;
		this.rno = rno;
	}

	public Validation(int accepted, String loginDriver, int rno, String origin, String destination) {
		this.accepted = accepted;
		this.loginDriver = loginDriver;
		this.rno = rno;
		this.origin = origin;
		this.destination = destination;
	}
	
	public Validation(int avno, int accepted, String loginDriver, int rno, String origin, String destination) {
		this.avno = avno;
		this.accepted = accepted;
		this.loginDriver = loginDriver;
		this.rno = rno;
		this.origin = origin;
		this.destination = destination;
	}

	public int getAvno() {
		return avno;
	}

	public void setAvno(int avno) {
		this.avno = avno;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	public String getLoginDriver() {
		return loginDriver;
	}

	public void setLoginDriver(String loginDriver) {
		this.loginDriver = loginDriver;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	
	
	
	
}
