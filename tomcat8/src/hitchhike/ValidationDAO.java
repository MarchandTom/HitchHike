package hitchhike;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ValidationDAO extends DAO<Validation>{

	public ArrayList<Validation> findAll() {
		ArrayList<Validation> askV=new ArrayList<Validation>();
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from Validations;");
			
			while(rs.next()){
				askV.add(new Validation(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return askV;
	}
	
	public ArrayList<Validation> findByRno(int rno) {
		ArrayList<Validation> askV=new ArrayList<Validation>();
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from Validations where rno="+rno+";");
			
			while(rs.next()){
				askV.add(new Validation(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return askV;
	}
	
	public ArrayList<Validation> findByDriverLogin(String login) {
		ArrayList<Validation> askV=new ArrayList<Validation>();
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from Validations where loginDriver='"+login+"' order by vno desc;");
			
			while(rs.next()){
				askV.add(new Validation(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return askV;
	}
	
	public ArrayList<Validation> findByClientLogin(String login) {
		ArrayList<Validation> askV=new ArrayList<Validation>();
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select vno, accepted, loginDriver, rno from Validations join Routes using(rno) where login='"+login+"' order by vno desc;");
			
			while(rs.next()){
				askV.add(new Validation(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), null, null));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return askV;
	}
	
	public ArrayList<Validation> findByLoginAndState(String login, boolean accepted) {
		ArrayList<Validation> tmp=findByClientLogin(login);
		ArrayList<Validation> askV=new ArrayList<Validation>();
		for(Validation av: tmp) {
			if(accepted && (av.getAccepted()==0 || av.getAccepted()==1)) {
				askV.add(av);
			}else if(!accepted && (av.getAccepted()==2)) {
				askV.add(av);
			}
		}
		return askV;
	}
	
	public int findNbrWaitingByLogin(String login) {
		int nbrWaiting=0;
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select count(accepted) from Validations join Routes using(rno) where login='"+login+"' and accepted = 2;");
			
			if(rs.next()){
				nbrWaiting=rs.getInt(1);
				con.close();
				return nbrWaiting;
			}else {
				con.close();
				return nbrWaiting;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nbrWaiting;
	}
	
	public boolean addValidation(Validation av) {
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			int i = stmt.executeUpdate("insert into Validations (accepted, loginDriver, rno, origin, destination) values ("+av.getAccepted()+", '"+av.getLoginDriver()+"', "+av.getRno()+", '"+av.getOrigin()+"', '"+av.getDestination()+"');");
			if(i>0) {                
				System.out.println("Inserted Validations Successfully"); 
				con.close();
				return true;            
			}else {                
				System.out.println("Insert Validations Unsuccessful");
				con.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateState(int vno, int newState) {
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			int i = stmt.executeUpdate("UPDATE Validations SET accepted = "+newState+" WHERE vno = "+vno+";");
			if(i>0) {                
				System.out.println("updated Validations Successfully"); 
				con.close();
				return true;            
			}else {                
				System.out.println("updated Validations Unsuccessful");
				con.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteFromvno(int vno) {
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			int i = stmt.executeUpdate("delete from Validations WHERE vno = "+vno+";");
			if(i>0) {                
				System.out.println("deleted Validations Successfully"); 
				con.close();
				return true;            
			}else {                
				System.out.println("deleted Validations Unsuccessful");
				con.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int size() {
		return findAll().size();
	}

}
