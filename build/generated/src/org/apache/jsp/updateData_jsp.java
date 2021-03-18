package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.UserDTO;
import dao.UserDAO;

public final class updateData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Updation Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

           String username=(String)session.getAttribute("username");
           System.out.println(username);
           if(username==null || username.trim().equals(""))
           {
               response.sendRedirect("login.jsp");
               return; //to avoid 'HTTP Status 500 - An exception occurred processing JSP page'
           }          
            UserDAO userDAO=new UserDAO();
            UserDTO userDTO=userDAO.getSpecificUserData(username);
        
      out.write("\n");
      out.write("        <center><h2>Update Details -</h2>\n");
      out.write("        <form action=\"UpdationChecker\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <tr><input type=\"hidden\" name=\"id\" value=\"");
      out.print(userDTO.getId());
      out.write("\"></tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>Username:</B></td>\n");
      out.write("                    <td><input type=\"text\" name=\"username\" value=\"");
      out.print(userDTO.getUsername());
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>Old Password:</B></td>\n");
      out.write("                    <td><input type=\"password\" name=\"oldPassword\" placeholder=\"Enter Old Password Here\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>New Password:</B></td>\n");
      out.write("                    <td><input type=\"password\" name=\"password\" placeholder=\"Enter New Password Here\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>Confirm Password:</B></td>\n");
      out.write("                    <td><input type=\"password\" name=\"conPassword\" placeholder=\"Re-enter Password Here\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>First Name:</B></td>\n");
      out.write("                    <td><input type=\"text\" name=\"fname\" value=\"");
      out.print(userDTO.getFname());
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>Last Name:</B></td>\n");
      out.write("                    <td><input type=\"text\" name=\"lname\" value=\"");
      out.print(userDTO.getLname());
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>Phone Number:</B></td>\n");
      out.write("                    <td><input type=\"text\" name=\"phone\" value=\"");
      out.print(userDTO.getPhone());
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>City:</B></td>\n");
      out.write("                    <td><input type=\"text\" name=\"city\" value=\"");
      out.print(userDTO.getCity());
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><B>Age:</B></td>\n");
      out.write("                    <td><input type=\"number\" name=\"age\" value=\"");
      out.print(userDTO.getAge());
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"submit\" value=\"Update\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form><br><br>\n");
      out.write("        <p><B>Note:</B> 1.Make sure your 'Password' and 'Confirm Password' fields contain same value.<br>\n");
      out.write("            2.Your username should be unique.<br>\n");
      out.write("            <B>Failure of above statements will lead to updation failure.</B></p>\n");
      out.write("        <br><br><h3>Changed your mind?... To go back to home page <a href=\"home.jsp\">Click here</a></h3>\n");
      out.write("        </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
