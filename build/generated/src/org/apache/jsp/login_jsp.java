package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/logo.css\" type=\"text/css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("        \t\r\n");
      out.write("\t\t\t");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/logo.css\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"header_container\">\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write(" <a href=\"input.jsp\" id=\"logo\"></a>\r\n");
      out.write(" <!--<a href=\"\" id=\"settings\"><img src=\"\"></a>\r\n");
      out.write(" <a href=\"\" id=\"right\"><img src=\"\"></a>-->\r\n");
      out.write("</div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("       \r\n");
      out.write("        <form method=\"POST\" action=\"LoginAuthentication\" id=\"login\" name=\"actionForm\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>    \r\n");
      out.write("                    <td>Username</td><td><input type=\"text\" name=\"username\" value=\"\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Password</td><td><input type=\"password\" name=\"password\" value=\"\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type=\"submit\" value=\"Submit\" name=\"submit\">\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
