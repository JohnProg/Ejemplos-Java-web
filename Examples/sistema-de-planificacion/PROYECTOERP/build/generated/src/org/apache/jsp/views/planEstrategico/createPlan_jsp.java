package org.apache.jsp.views.planEstrategico;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createPlan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t\t<title>Bienvenido</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/static/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/static/css/font-awesome.min.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<header>\n");
      out.write("\t\t\t<a href=\"list.html\" class=\"pull-right btn btn-info btn-lg\">Regresar</a>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<h1>Crear plan estratégico:</h1>\n");
      out.write("\t\t\t<hr>\n");
      out.write("\t\t</header>\t\t\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<section class=\"row\">\n");
      out.write("                    <form class=\"col-sm-12\" action=\"");
      out.print(request.getContextPath());
      out.write("/createPlanServlet\">\n");
      out.write("\t\t\t\t<fieldset class=\"form-group\">\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t<label class=\"label-control\" >Nombre: </label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"nombre\" class=\"form-control\" autofocus=\"true\" id=\"txtName\" placeholder=\" Ingresa el nombre\">\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t<label class=\"label-control\" >Fecha de vigencia: </label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"date\" name=\"fecha_inicio\"class=\"form-control\" id=\"txtVigency\" placeholder=\" \">\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t<label class=\"label-control\" >Fecha de término: </label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"date\" name=\"fecha_termino\"class=\"form-control\" id=\"txtFinish\" placeholder=\" \">\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t<label class=\"label-control\" >Año de inicio: </label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" name=\"anio_inicio\"class=\"form-control\" id=\"txtYearStart\" placeholder=\" \">\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t</div>\t\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t<label class=\"label-control\" >Año de término: </label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" name=\"anio_termino\"class=\"form-control\" id=\"txtYearFinish\" placeholder=\" \">\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t<label class=\"label-control\" >Aprobado por: </label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\n");
      out.write("                                                    <input type=\"text\" name=\"aprobado_por\"class=\"form-control\" id=\"txtApprovedBy\" placeholder=\" \">\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t<label class=\"label-control\" >Descripción: </label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\n");
      out.write("                                                    <textarea class=\"form-control\" name=\"descripcion\"id=\"txtDescription\" col=\"3\" placeholder=\"Ingresa la descripcion\"></textarea>\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-offset-2 col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"Crear\" id=\"btnAdd\" class=\"btn btn-block btn-lg btn-success\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t\t\t\t\t<a href=\"list.html\" class=\"btn btn-block btn-lg btn-danger\">Cancelar</a>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</fieldset>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</section>\n");
      out.write("\t</div>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../static/js/strategy.js\"></script>\n");
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
