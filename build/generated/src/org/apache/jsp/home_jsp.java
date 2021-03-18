package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.UserDTO;
import dao.UserDAO;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("    <body><center>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

           String username=(String)session.getAttribute("username");
           if(username==null || username.trim().equals(""))
           {
               response.sendRedirect("login.jsp");
               return; //to avoid 'HTTP Status 500 - An exception occurred processing JSP page', as java code after this line shouldn't be excuted.
           }
        
      out.write("\n");
      out.write("        <a href=\"logout.jsp\">Sign Out</a>\n");
      out.write("        <h3>Login successful!</h3>\n");
      out.write("        <h2>Hello ");
      out.print(username);
      out.write("!</h2>\n");
      out.write("        ");
           
            UserDAO userDAO=new UserDAO();
            UserDTO userDTO=userDAO.getSpecificUserData(username);
        
      out.write("\n");
      out.write("        <table style=\"font-size: 20px\">\n");
      out.write("            <tr>\n");
      out.write("                <td><b>Username:</b></td>\n");
      out.write("                <td>");
      out.print(userDTO.getUsername());
      out.write("</td>        \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><b>Password:</b></td>\n");
      out.write("                <td>");
      out.print(userDTO.getPassword());
      out.write("</td>        \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><b>First Name:</b></td>\n");
      out.write("                <td>");
      out.print(userDTO.getFname());
      out.write("</td>        \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><b>Last Name:</b></td>\n");
      out.write("                <td>");
      out.print(userDTO.getLname());
      out.write("</td>        \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><b>Phone:</b></td>\n");
      out.write("                <td>");
      out.print(userDTO.getPhone());
      out.write("</td>        \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><b>City:</b></td>\n");
      out.write("                <td>");
      out.print(userDTO.getCity());
      out.write("</td>        \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><b>Age:</b></td>\n");
      out.write("                <td>");
      out.print(userDTO.getAge());
      out.write("</td>        \n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("            <br>\n");
      out.write("            <b>To update data <a href=\"updateData.jsp\">Click here</a></b><br><br>\n");
      out.write("            <b>To delete your profile <a href=\"deleteProfile.jsp\">Click here</a></b>\n");
      out.write("    </centre></body>\n");
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
