package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<title>Iniciar sesión</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"static/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"static/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"static/css/main.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"jumbotron\">\n");
      out.write("\t\t\t<header>\n");
      out.write("\t\t\t\t<h1 class=\"text-center\">Iniciar sesión</h1>\n");
      out.write("\t\t\t</header>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<section class=\"row col-sm-offset-0\">\n");
      out.write("\t\t\t\t<div class=\"alert alert-danger\">Escribe correctamente los datos <i class=\"fa fa-remove\"></i></div>\n");
      out.write("\t\t\t\t<form class=\"col-sm-12\">\n");
      out.write("\t\t\t\t\t<fieldset class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"label-control\" >Usuario: </label>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-10 col-sm-offset-0\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"txtUsername\" autofocus placeholder=\" Ingresa tu usuario\">\n");
      out.write("\t\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"label-control\">Password: </label>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"txtPassword\" placeholder=\" Ingresa tu password\">\n");
      out.write("\t\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<div class=\"row text-center\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-12\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-hot text-uppercase btn-lg\" id=\"btnEnter\" value=\"Iniciar Sesión\">\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</section>\n");
      out.write("\t\t</div>\t\n");
      out.write("\t</div>\n");
      out.write("\t<script type=\"text/javascript\" src=\"static/js/login.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"\"></script>\n");
      out.write("</body>\n");
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
