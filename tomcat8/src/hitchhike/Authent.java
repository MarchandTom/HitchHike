package hitchhike;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.sql.*;

@WebServlet("/servlet/hitchhike/Authent")

public class Authent extends HttpServlet
{
	public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
		// HttpSession session = req.getSession( true );
		// Integer cpt = (Integer)session.getAttribute( "compteur" );
		// cpt = new Integer( cpt == null ? 1 : cpt.intValue() + 1 );
		// session.setAttribute( "compteur", cpt );

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println( "<head><title>Verification</title>" );
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\">");
		out.println( "</head>" );

		out.println( "<body><center>" );


		try{
			HttpSession session = req.getSession( true );
			
			UserDAO userDAO=new UserDAO();
			String login=req.getParameter("login");
			User u=userDAO.findByLogin(login);
			if(u==null) {
				session.setAttribute( "logged", new Boolean(false) );
				res.sendRedirect("../../Login.jsp");
			}else {
				String mdpEntre=""+User.hashPasswd(req.getParameter("mdp"));
				if(!u.getMdp().equals(""+mdpEntre)) {
					session.setAttribute( "logged", new Boolean(false) );
					res.sendRedirect("../../Login.jsp?login="+login+"&error=password");
				}else {
					String page=(String)session.getAttribute("page");
					session.setAttribute( "logged", new Boolean(true) );
					session.setAttribute( "login", login);
					session.setMaxInactiveInterval(6000);
					if(page==null) {
						res.sendRedirect("../../Index.jsp");
					}else {
						session.removeAttribute("page");
						res.sendRedirect("../../"+page);
					}
				}
			}

		}catch(Exception e){
			System.err.println(e);
		}	


		out.println( "</center> </body>" );
	}
}