package utilities;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.sql.*;

@WebServlet("/servlet/utilities/Select")

public class Select extends HttpServlet
{
	public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
		// cpt = new Integer( cpt == null ? 1 : cpt.intValue() + 1 );
		// session.setAttribute( "compteur", cpt );

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println( "<head><title>Select</title>" );
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\">");
		out.println( "</head>" );

		out.println( "<body><center>" );

		Connection con=null;
		Statement stmt;

		try{
			Class.forName("org.sqlite.JDBC");
			// Class.forName("org.postgresql.Driver"); 
			// String url = "jdbc:postgresql://psqlserv/n3p1";
			String url = "jdbc:sqlite:C:hitchhike.db";

			// con = DriverManager.getConnection(url,nom,mdp);
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();


			String nomTable=req.getParameter("table");
			String sql= "select * from "+nomTable;
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			int nbCol = metaData.getColumnCount();

			HttpSession session = req.getSession( true );
			Boolean logged=(Boolean)session.getAttribute( "logged" );
			logged=true;
			if(logged==null || !logged){
				session.setAttribute("nomTable", nomTable);
				res.sendRedirect("../Login.html");
			}
			out.println("<aside style=\"float:right\">"+session.getAttribute("id")+" (<a href=\"CloseSession\">deconnecter</a>)</aside>");

			out.println( "<h1>Select sur la classe "+nomTable+"</h1>" );

			String[] nomsCol=new String[nbCol];

			out.println("<table class=\"table table-striped table-hover\">");
			out.println("<thead class=\"thead-dark\">");
			out.println("<tr>");
			for (int i=0;i<nbCol;i++){
				out.println("<th scope=\"col\">");
				nomsCol[i]= metaData.getColumnName(i+1);
				out.println(nomsCol[i]);
				out.println("</th>");
			}
			out.println("<th>Supprimer</th>");
			out.println("<th>Modifier</th>");
			out.println("<tr>");
			out.println("</thead>");

			sql= "select * from "+nomTable+" order by "+nomsCol[0]+" asc";
			rs = stmt.executeQuery(sql);
			metaData = rs.getMetaData();

			while(rs.next()){
				out.println("<tr>");
				for(int i=0;i<nbCol;i++){
					out.println("<td>");
					out.println(rs.getString(nomsCol[i]));
					out.println("</td>");
				}
				out.println("<td>");
				out.println("<a href=\"Delete?table="+nomTable+"&"+nomsCol[0]+"="+rs.getString(nomsCol[0])+"\" class=\"badge badge-danger\">supprimer</a>");
				out.println("</td>");
				out.println("<td>");
				out.println("<a href=\"Update?table="+nomTable+"&"+nomsCol[0]+"="+rs.getString(nomsCol[0])+"\">modifer</a>");
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			

			out.println("</br></br>");

			out.println("<form method=\"post\" action=\"./Insert?table="+nomTable+"\">");
			for(int i=0;i<nbCol;i++){
				out.println(nomsCol[i]+" : <input type=\"text\" name=\""+nomsCol[i]+"\"></br></br>");	
			}
			out.println("<input type=\"submit\" value=\"Ajouter\">");
			out.println("</form> ");

			out.println("</br>");
	

			out.println("<form method=\"post\" action=\"./Delete?table="+nomTable+"\">");
			// for(int i=0;i<nbCol;i++){
				out.println(nomsCol[0]+" : <input type=\"text\" name=\""+nomsCol[0]+"\"></br></br>");	
			// }
			out.println("<input type=\"submit\" value=\"Supprimer\">");


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