/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.12
 * Generated at: 2018-05-29 17:11:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import hitchhike.*;

public final class Signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<title>Signing up</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

try{
	String login=request.getParameter("login");
	String mdp=request.getParameter("mdp");
	String mdpConf=request.getParameter("mdpConf");
	String nom=request.getParameter("nom").toUpperCase();
	String prenom=request.getParameter("prenom");
	String tel=request.getParameter("tel");
	int birthDay=Integer.valueOf(request.getParameter("birthDay"));
	int birthMonth=Integer.valueOf(request.getParameter("birthMonth"));
	int birthYear=Integer.valueOf(request.getParameter("birthYear"));
	
	String param="login="+login+"&nom="+nom+"&prenom="+prenom+"&tel="+tel+"&birthDay="+birthDay+"&birthMonth="+birthMonth+"&birthYear="+birthYear;
	
	UserDAO userDAO=new UserDAO();
	if(userDAO.exist(request.getParameter("login"))){
		response.sendRedirect("./Register.jsp?error=loginUsed&"+param);
	}else if(!mdp.equals(mdpConf)){
		response.sendRedirect("./Register.jsp?error=differentPassword&"+param);
	}else if(tel.replaceAll("[0-9+(). \\-]","").length()>0){
		response.sendRedirect("./Register.jsp?error=wrongNumber&"+param);
	}else{
		User u=new User(request.getParameter("login"), ""+User.hashPasswd(request.getParameter("mdp")), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("tel"), Integer.valueOf(request.getParameter("birthDay")), Integer.valueOf(request.getParameter("birthMonth")), Integer.valueOf(request.getParameter("birthYear")));
		boolean b=userDAO.addUser(u);
		if(b){
			response.sendRedirect("./Login.jsp");
		}else{
			response.sendRedirect("./Register.jsp?error=unknown&"+param);
		}		
	}

}catch(Exception e){
	response.sendRedirect("./Login.jsp");
	System.err.println(e);
}	

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
