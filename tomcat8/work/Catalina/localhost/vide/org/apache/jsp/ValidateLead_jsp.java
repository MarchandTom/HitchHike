/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.12
 * Generated at: 2018-10-18 09:55:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hitchhike.*;

public final class ValidateLead_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

Validation val;
	ValidationDAO valDAO=new ValidationDAO();
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/Nav.jspf", Long.valueOf(1529544959962L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>The Route</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("<style>\r\n");
      out.write("body{\r\n");
      out.write("\tbackground-image: url(\"./../../Ressources/auto-stop-homme.jpg\");\r\n");
      out.write("    background-repeat: no-repeat;\r\n");
      out.write("    background-size: cover;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\"\r\n");
      out.write("\tintegrity=\"sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark\">\r\n");
      out.write("  <a class=\"navbar-brand\" href=\"Index.jsp\">\r\n");
      out.write("    <img src=\"./../../Ressources/Logo.png\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\r\n");
      out.write("    HitchHike\r\n");
      out.write("  </a>\r\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("  </button>\r\n");
      out.write("  ");
String login=null;
	String textLien;
	Boolean logged=(Boolean)session.getAttribute( "logged" );
  
      out.write("\r\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarText\">\r\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("      <li class=\"nav-item active\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"Index.jsp\">Home</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"Redirect.jsp?url=YourRoute.jsp&lead=false\">HitchHike</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"Redirect.jsp?url=YourRoute.jsp&lead=true\">Lead Someone</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item dropdown\">\r\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown1\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("          Others\r\n");
      out.write("        </a>\r\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown1\">\r\n");
      out.write("          <a class=\"dropdown-item\" href=\"Redirect.jsp?url=ChooseHitch.jsp\">Everyone</a>\r\n");
      out.write("          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("          <a class=\"dropdown-item\" href=\"Redirect.jsp?url=ChooseHitch.jsp\">See map</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("\t");

		if(logged==null || !logged){
			textLien="<a href=\"Login.jsp\">Log in/register</a>";
		}else{
			login=(String)session.getAttribute( "login" );
			textLien=login+" (<a href=\"Logout.jsp\">Log out</a>)";
		}
	
      out.write("\r\n");
      out.write("      ");
if(logged!= null && logged){ 
      out.write("\r\n");
      out.write("      <li class=\"nav-item dropdown\">\r\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("          Account\r\n");
      out.write("        </a>\r\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("          <a class=\"dropdown-item\" href=\"RouteList.jsp\">My routes</a>\r\n");
      out.write("          <a class=\"dropdown-item\" href=\"Messages.jsp\" id=\"itemMessage\">Messages</a>\r\n");
      out.write("          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("          <a class=\"dropdown-item\" href=\"InfoUser.jsp?login=");
      out.print(login);
      out.write("\">My informations</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("      ");
} 
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("    <span class=\"navbar-text\">\r\n");
      out.write("\t");
      out.print( textLien );
      out.write("\r\n");
      out.write("    </span>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\" integrity=\"sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js\" integrity=\"sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
if(logged!=null && logged) {
      out.write("\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t$(document).ready(checkForNotifications);\r\n");
      out.write("\tsetInterval(checkForNotifications, 5000);\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkForNotifications(){\r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t        url: \"ReqAjax.jsp\", \r\n");
      out.write("\t        type: \"GET\",\r\n");
      out.write("\t        success: function( notification ) {\r\n");
      out.write("\t        \tvar tmp=notification.charAt(0);\r\n");
      out.write("\t        \tif(tmp=='0'){\r\n");
      out.write("\t\t            document.getElementById(\"navbarDropdown\").innerHTML=\"Account \";\r\n");
      out.write("\t\t            document.getElementById(\"itemMessage\").innerHTML=\"Messages \";\r\n");
      out.write("\t        \t}else{\r\n");
      out.write("\t\t            document.getElementById(\"navbarDropdown\").innerHTML=\"Account (\"+tmp+\")\";        \t\t\r\n");
      out.write("\t\t            document.getElementById(\"itemMessage\").innerHTML=\"Messages (\"+tmp+\")\";        \t\t\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        },\r\n");
      out.write("\t        error: function(data){\r\n");
      out.write("\t            //handle any error \r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
} 
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<div style=\"left: 15%; top: 25%; width: 500px; position: absolute;\">\r\n");
      out.write("\t");

		String rnoString=request.getParameter("rno");
			int rno=0;
			if(rnoString==null){
		response.sendRedirect("ChooseHitch.jsp");
			}else{
		rno=Integer.valueOf(request.getParameter("rno"));		
			}
			if (!response.isCommitted() && (logged == null || logged == false)) {
		session.setAttribute("page", "ValidateLead.jsp?rno="+rno);
		response.sendRedirect("Login.jsp");
			}
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write('\r');
      out.write('\n');
      out.write('	');

		val=new Validation(2, login, rno);
			boolean valAdded=false;
			if(!response.isCommitted()){
		valAdded=valDAO.addValidation(val);
			}
			
			if(valAdded){
	
      out.write("\r\n");
      out.write("\t\t<h1 class=\"display-4 text-success text-center\">Your request has\r\n");
      out.write("\t\t\tbeen sent</h1>\r\n");
      out.write("\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t<h1 class=\"display-4 text-danger text-center\">Sorry, there was a\r\n");
      out.write("\t\t\tmistake</h1>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t<button type=\"button\" class=\"btn btn-secondary mt-3 ml-5\"\r\n");
      out.write("\t\t\tstyle=\"width: 25rem; position: center;\" onclick=\"location.href='./Index.jsp'\">Back\r\n");
      out.write("\t\t\thome</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
