package hitchhike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO extends DAO<User>{
	
	public ArrayList<User> findAll(){
		ArrayList<User> users=new ArrayList<User>();
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from Users;");
			
			while(rs.next()){
				users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public ArrayList<User> findByName(String name) {
		ArrayList<User> users=new ArrayList<User>();
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from Users where nom ='"+name+"';");
			
			while(rs.next()){
				users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User findByLogin(String login) {
		User u;
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from Users where login = '"+login+"';");
			if(rs.next()){
				u=new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				con.close();
				return u;
			}else {
				con.close();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findByUno(int uno) {
		User u;
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from Users where uno = '"+uno+"';");
			if(rs.next()){
				u=new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				con.close();
				return u;
			}else {
				con.close();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addUser(User u) {
		try {
			Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			
			int i = stmt.executeUpdate("insert into Users (login, mdp, nom, prenom, tel, jourNaissance, moisNaissance, anneeNaissance) values ('"+u.getLogin()+"', '"+u.getMdp()+"', '"+u.getNom()+"', '"+u.getPrenom()+"', '"+u.getTel()+"', '"+u.getJourNaissance()+"', '"+u.getMoisNaissance()+"', '"+u.getAnneeNaissance()+"');");
			if(i>0) {                
				System.out.println("Inserted User Successfully"); 
				con.close();
				return true;            
			}else {                
				System.out.println("Insert User Unsuccessful");
				con.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean exist(String login) {
		return findByLogin(login)!=null;
	}
	
	public boolean exist(int uno) {
		return findByUno(uno)!=null;
	}
	
	public int size() {
		return findAll().size();
	}
}
