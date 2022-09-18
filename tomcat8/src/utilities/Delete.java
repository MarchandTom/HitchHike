package utilities;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.sql.*;

@WebServlet("/servlet/utilities/Delete")

public class Delete extends HttpServlet
{
	public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println( "<head><title>servlet first</title>" );
		out.println( "<META content=\"charset=UTF-8\"></head>" );
		

		out.println( "<body><center>" );


		Connection con=null;
		Statement stmt;

		String nomTable="";

		try{
			Class.forName("org.sqlite.JDBC");
			// Class.forName("org.postgresql.Driver"); 
			// String url = "jdbc:postgresql://psqlserv/n3p1";
			String url = "jdbc:sqlite:C:hitchhike.db";

			// con = DriverManager.getConnection(url,nom,mdp);
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();

		
			nomTable=req.getParameter("table");
			String sql= "select * from "+nomTable;
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			int nbCol = metaData.getColumnCount();
			String[] nomsCol=new String[nbCol];
			
			for (int i=0;i<nbCol;i++){
				nomsCol[i]= metaData.getColumnName(i+1);
			}

			
			// String insert = "insert into "+nomTable+" VALUES (";
			// for(int i=0;i<nbCol;i++){
			// 	insert+="'"+req.getParameter(nomsCol[i])+"',";

			// }
			// insert=insert.substring(0, insert.length()-1);
			// insert+=")";

			String delete="delete from "+nomTable+" where "+nomsCol[0]+"='"+req.getParameter(nomsCol[0])+"'";
			stmt.executeUpdate(delete);




		}catch(Exception e){
			System.err.println(e);
		}	

		res.sendRedirect("Select?table="+nomTable);

		try{
			con.close();
		}catch(Exception e){
			System.err.println(e);
		}

		out.println( "</center> </body>" );
	}
}