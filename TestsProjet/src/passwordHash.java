
public class passwordHash {
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	
	public passwordHash(String nom, String prenom, String login, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
	}
	
	public int hashPasswd(String mdp) {
		int pwd=0;
		for(int i=0;i<=mdp.length();i++) {
//			pwd+=mdp.substring(0, i).hashCode();
			for(int j=1;j<=i;j++) {
				pwd+=mdp.substring(0, j).hashCode();
				System.out.println("mdp= "+mdp.substring(0, j)+"  hash= "+mdp.substring(0, j).hashCode());
			}
		}
		
		return pwd;
	}
	

	public static void main(String[] args) {
		passwordHash ph=new passwordHash("Marchand", "Tom", "marchant", "mdp");
		int i=ph.hashPasswd("Hello");
		System.out.println(i);
	}
}
