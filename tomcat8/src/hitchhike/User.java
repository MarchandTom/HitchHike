package hitchhike;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4885804766690868909L;
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private String tel;
	private int jourNaissance;
	private int moisNaissance;
	private int anneeNaissance;
	
	
	public User(String login, String mdp, String nom, String prenom, String tel, int jourNaissance, int moisNaissance, int anneeNaissance) {
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.tel=tel;
		this.jourNaissance = jourNaissance;
		this.moisNaissance = moisNaissance;
		this.anneeNaissance = anneeNaissance;
		
	}
	
	public User(String login, String mdp, String nom, String prenom, String tel) {
		this.login=login;
		this.mdp=mdp;
		this.nom=nom;
		this.prenom=prenom;
		this.tel=tel;
	}
	
	public String getLogin() {
		return login;
	}
	
	
	public String getMdp() {
		return mdp;
	}

	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}
	
	public String getTel() {
		return tel;
	}


	public int getJourNaissance() {
		return jourNaissance;
	}


	public int getMoisNaissance() {
		return moisNaissance;
	}


	public int getAnneeNaissance() {
		return anneeNaissance;
	}
	
	public static int hashPasswd(String mdp) {
		int pwd=0;
		for(int i=0;i<=mdp.length();i++) {
			for(int j=0;j<=i;j++) {
				pwd+=mdp.substring(0, j).hashCode();
			}
		}
		return pwd;
	}
	
	
}
