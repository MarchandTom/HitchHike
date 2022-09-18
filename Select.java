import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;

public class Select
{
  public static void main(String args[]) throws Exception
  {
      Connection con=null;
      Statement stmt;
      try{
		Class.forName("org.postgresql.Driver");

		String url = "jdbc:postgresql://psqlserv/n3p1";
		String nom = "marchant";
		String mdp = "moi";
		con = DriverManager.getConnection(url,nom,mdp);
		stmt = con.createStatement();
		String query = "select * from Personne;";
		ResultSet rs = stmt.executeQuery(query);


		ResultSetMetaData rsmd = rs.getMetaData();
		int nbCol=rsmd.getColumnCount();
		for(int i=1;i<=nbCol;i++){
			System.out.print(rsmd.getColumnName(i)+"  |  ");	
		}
		System.out.println("");
     	while (rs.next()){
     		for(int i=1;i<=nbCol;i++){
     			System.out.print(rs.getString(i)+"  |  ");
     		}
			System.out.println("");
		}
/*            String n = rs.getString("nom");
            String p = rs.getString("prenom");
            int a = rs.getInt("age");
            System.out.println(n + " " + p + " " + a);*/
  	    



	}catch(Exception e){
		System.err.println(e);
	}	
	
	try{
		con.close();
	}catch(Exception e){
		System.err.println(e);
	}

	} 
}
