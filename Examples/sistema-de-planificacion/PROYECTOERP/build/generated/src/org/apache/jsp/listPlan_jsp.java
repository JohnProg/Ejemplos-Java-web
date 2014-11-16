package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import maristas.dao.planDAO;
import maristas.beans.PlanEstrategicoBean;
import java.util.ArrayList;

public final class listPlan_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");

PlanEstrategicoBean  objEmpleBean=null;
ArrayList<PlanEstrategicoBean>          plans=null;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t\t<title>Bienvenido</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../../static/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../../static/css/font-awesome.min.css\">\n");
      out.write("</head>\n");
      out.write("<body onload=\"visualizar()\">\n");
      out.write("    <script>\n");
      out.write("        function visualizar(){\n");
      out.write("\n");
      out.write("           document.form.action=\"");
      out.print(request.getContextPath());
      out.write("/listPlanServlet\";\n");
      out.write("           document.form.method=\"GET\";\n");
      out.write("           document.form.submit();\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    }\n");
      out.write("    </script>\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<header>\n");
      out.write("\t\t\t<a href=\"../../index.html\" class=\"pull-right btn btn-danger btn-lg\" id=\"btnSalir\">Salir</a>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<h1>Planes estratégicos: <a href=\"create.html\" class=\"pull-right btn btn-primary btn-lg\">+ Crear</a></h1>\n");
      out.write("\t\t\t<hr>\n");
      out.write("\t\t</header>\t\t\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<section class=\"row\">\n");
      out.write("                    <form class=\"col-sm-12\" name=\"form\">\n");
      out.write("\t\t\t\t<fieldset class=\"form-group\">\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-1\">\n");
      out.write("\t\t\t\t\t\t\t<label class=\"label-control\" >Buscar: </label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" autofocus=\"true\" id=\"txtSearch\" placeholder=\"Buscando...\">\n");
      out.write("\t\t\t\t\t\t</div>\t\t\t\n");
      out.write("\t\t\t\t\t</div>\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t<br>\n");
      out.write("\t\t\t\t<fieldset>\n");
      out.write("\t\t\t\t\t<table class=\"table table-stripped table-responsive\">\n");
      out.write("\t\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<th>#</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th>Nombre</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th>Fecha de Vigencia</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th>Fecha de Término</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th>Año de inicio</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th>Año de término</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th>Aprobado por</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th>Descripción</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th>Opciones</th>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t\t<tbody id=\"table\">\n");
      out.write("                                                    ");
      out.print(request.getAttribute("plans") );
      out.write("\n");
      out.write("                                                     ");
  
                                                          //planDAO i_s = new planDAO();
                                                        //ArrayList<PlanEstrategicoBean> plans = i_s.GetPlans();
                                                        plans = (ArrayList<PlanEstrategicoBean>)request.getAttribute("plans");   
                                                        
                                                        out.println(plans);  
                                                        if(plans != null) {
                                                            for(PlanEstrategicoBean   obj:plans) {   
      out.write("\n");
      out.write("                                                            <tr>\n");
      out.write("                                                               <td>");
      out.print(obj.getNombre());
      out.write("</td>\n");
      out.write("                                                               <td>");
      out.print(obj.getFec_vigencia());
      out.write("</td>\n");
      out.write("                                                               <td>");
      out.print(obj.getFec_termino());
      out.write("</td>\n");
      out.write("                                                               <td>");
      out.print(obj.getAnio_inicio());
      out.write("</td>\n");
      out.write("                                                               <td>");
      out.print(obj.getAnio_termino());
      out.write("</td>\n");
      out.write("                                                               <td>");
      out.print(obj.getAprobado_por());
      out.write("</td>\n");
      out.write("                                                               <td>");
      out.print(obj.getDescripcion());
      out.write("</td>\n");
      out.write("                                                               <td><a href=\"/update/\">Actualizar</a> <a href=\"/lineas/\">Lineas</a></td>\n");
      out.write("                                                           </tr>\n");
      out.write("                                                          ");
   }
                                                          }
      out.write("\n");
      out.write("\t\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</fieldset>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</section>\n");
      out.write("\t</div>\n");
      out.write("                                                \n");
      out.write("\t<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-2.1.0.min.js\"></script>\n");
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
