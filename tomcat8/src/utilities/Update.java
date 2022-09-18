package utilities;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.sql.*;

@WebServlet("/servlet/utilities/Update")

public class Update extends HttpServlet
{
	public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println( "<head><title>Update</title>" );
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\">");
		out.println( "</head>" );

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

			HttpSession session = req.getSession( true );
			Boolean logged=(Boolean)session.getAttribute( "logged" );
			if(logged==null || !logged){
				session.setAttribute("nomTable", nomTable);
				res.sendRedirect("../Login.html");
			}
			out.println("<aside style=\"float:right\">"+session.getAttribute("id")+" (<a href=\"CloseSession\">deconnecter</a>)</aside>");

			String[] nomsCol=new String[nbCol];
			
			for (int i=0;i<nbCol;i++){
				nomsCol[i]= metaData.getColumnName(i+1);
			}


			sql= "select * from "+nomTable+" where "+nomsCol[0]+"='"+req.getParameter(nomsCol[0])+"'";
			rs = stmt.executeQuery(sql);
			metaData = rs.getMetaData();	

			// out.println("<form method=\"post\" action=\"./Updating?table="+nomTable+"\">");

			rs.next();
			out.println("<p>"+nomsCol[0]+" : "+rs.getString(nomsCol[0])+"</p>");
			out.println("<form method=\"post\" action=\"./Updating?table="+nomTable+"&"+nomsCol[0]+"="+req.getParameter(nomsCol[0])+"\">");
			for(int i=1;i<nbCol;i++){
				out.println(nomsCol[i]+" : <input type=\"text\" name=\""+nomsCol[i]+"\" value=\""+rs.getString(nomsCol[i])+"\"></br></br>");	
			}
			out.println("<input type=\"submit\" value=\"Modifier\">");
			out.println("</form> ");

			
			// String insert = "insert into "+nomTable+" VALUES (";
			// for(int i=0;i<nbCol;i++){
			// 	insert+="'"+req.getParameter(nomsCol[i])+"',";

			// }
			// insert=insert.substring(0, insert.length()-1);
			// insert+=")";

			// stmt.executeUpdate(insert);




		}catch(Exception e){
			System.err.println(e);
		}	


		try{
			con.close();
		}catch(Exception e){
			System.err.println(e);
		}

		out.println( "</center> </body>" );
	}
}