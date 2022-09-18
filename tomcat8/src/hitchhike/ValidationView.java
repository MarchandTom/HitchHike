package hitchhike;

import java.util.ArrayList;

public class ValidationView {
	public static String getTableValidationMessages(ArrayList<Validation> al) {
		String table="<table class=\"table table-striped table-light mt-5\">";
		table+="<thead class=\"thead-light\">" + 
				"    <tr>" + 
				"      <th scope=\"col\">Driver</th>" + 
				"      <th scope=\"col\">Departure</th>" + 
				"      <th scope=\"col\">Arrival</th>" + 
				"      <th scope=\"col\">State</th>" + 
				"      <th scope=\"col\">Commands</th>" + 
				"    </tr>" + 
				"  </thead>"+
				"  <tbody>";
		User u;
		UserDAO uDAO=new UserDAO();
		Route r;
		RouteDAO rDAO=new RouteDAO();
		for(Validation a: al) {
			String state="";
			String command="";
			int intState=a.getAccepted();
			if(intState==2) {
				command="<a href=\"ActionValidations.jsp?action=accept&avno="+a.getAvno()+"\" class=\"badge badge-success\">Accept</a>  " + 
						"<a href=\"ActionValidations.jsp?action=decline&avno="+a.getAvno()+"\" class=\"badge badge-danger\">Decline</a>";
				state="Waiting";
			}else if(intState==1) {
				command="<a href=\"ActionValidations.jsp?action=delete&avno="+a.getAvno()+"\" class=\"badge badge-danger\">Delete</a>";
				state="Accepted";
			}else {
				command="<a href=\"ActionValidations.jsp?action=delete&avno="+a.getAvno()+"\" class=\"badge badge-danger\">Delete</a>";
				state="Declined";
			}
			u=uDAO.findByLogin(a.getLoginDriver());
			r=rDAO.findByRno(a.getRno());
			table+="<tr>"
					+ "<td><a href=InfoUser.jsp?login="+u.getLogin()+">"+u.getLogin()+"</a></td>"
					+ "<td>"+r.getAdresseOrigin()+"</td>"
					+ "<td>"+r.getAdresseDestination()+"</td>"
					+ "<td>"+state+"</td>"
					+ "<td>"+command+"</td>"
					+ "</tr>";
		}
		table+="</tbody></table>";
		return table;
	}
	
	public static String getTableValidation(ArrayList<Validation> al) {
		String table="<table class=\"table table-striped table-light mt-5\">";
		table+="<thead class=\"thead-light\">" + 
				"    <tr>" + 
				"      <th scope=\"col\">Hitchhicker</th>" + 
				"      <th scope=\"col\">State</th>" + 
				"      <th scope=\"col\">His departure</th>" + 
				"      <th scope=\"col\">His arrival</th>" + 
				"      <th scope=\"col\">Contact (phone no)</th>" + 
				"    </tr>" + 
				"  </thead>"+
				"  <tbody>";
		Route r;
		RouteDAO rDAO=new RouteDAO();
		User u;
		UserDAO uDAO=new UserDAO();
		for(Validation a: al) {
			String state="";
			String number="";
			
			r=rDAO.findByRno(a.getRno());
			u=uDAO.findByLogin(r.getLogin());

			int intState=a.getAccepted();
			
			if(intState==2) {
				number="Waiting for validation";
				state="Request sent";
			}else if(intState==1) {
				number=u.getTel();
				state="Accepted";
			}else {
				number="Request declined";
				state="Declined";
			}
			table+="<tr>"
					+ "<td><a href=InfoUser.jsp?login="+u.getLogin()+">"+u.getLogin()+"</a></td>"
					+ "<td>"+state+"</td>"
					+ "<td>"+r.getAdresseOrigin()+"</td>"
					+ "<td>"+r.getAdresseDestination()+"</td>"
					+ "<td>"+number+"</td>"
					+ "</tr>";
		}
		table+="</tbody></table>";
		return table;
	}
}
