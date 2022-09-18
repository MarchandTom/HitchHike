package hitchhike;

import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class UserView {
	public String getTabAllUsers(ArrayList<User> al){
		String s="<table class=\"table table-striped  table-hover\"><thead class=\"thead-dark\">"
				+ "<tr>"
				+ "<th>Nom</th>"
				+ "<th>Prenom</th>"
				+ "<th>Date Naissance</th>"
				+ "<th>Age</th>"
				+ "<th>Login</th>"
				+ "<th>Password</th>"
				+ "</tr>";
		for(User u:al){
			String dateNaissance = setDate(u);
			int age=setAge(u, dateNaissance);
			s+="<tr><td>"+u.getNom()+"</td><td>"+u.getPrenom()+"</td><td>"+dateNaissance+"</td><td>"+age+"</td><td>"+u.getLogin()+"</td><td>"+u.getMdp()+"</td></tr>";
		}
		return s+"</thead></table>";	
	}

	private int setAge(User u, String date) {
		if(date.equals("non précisé")) {
			return -1;
		}
		LocalDate ld=LocalDate.of(u.getAnneeNaissance(), u.getMoisNaissance(), u.getJourNaissance());
		return Period.between(ld, LocalDate.now()).getYears();
	}

	private String setDate(User u) {
		String age;
		if(u.getJourNaissance()==0 || u.getMoisNaissance()==0 || u.getAnneeNaissance()==0) {
			age="not precised";
		}else {
			LocalDate ld=LocalDate.of(u.getAnneeNaissance(), u.getMoisNaissance(), u.getJourNaissance());
			age=Period.between(ld, LocalDate.now()).getYears()+" years old.";
		}
		return age;
	}
	
	public String getDetail(User u){
		String s="<table><tr><td>"+u.getNom()+
				"</td></tr><tr><td>"+u.getPrenom()+
				"</td></tr><tr><td>"+setDate(u)+
				"</td></tr><tr><td>"+u.getLogin()+
				"</td></tr></table>";
		return s;
	}
	
}
