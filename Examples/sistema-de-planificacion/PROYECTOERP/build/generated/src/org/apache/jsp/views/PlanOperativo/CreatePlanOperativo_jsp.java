package org.apache.jsp.views.PlanOperativo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import maristas.beans.PlanOperativoBean;
import java.util.ArrayList;

public final class CreatePlanOperativo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 ArrayList<PlanOperativoBean> PlanOperativo = (ArrayList<PlanOperativoBean>)request.getAttribute("PlanOperativo");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/static/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/static/css/font-awesome.min.css\">\r\n");
      out.write("        <title> Plan Operativo </title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <a class=\"btn btn-lg btn-danger\" href=\"");
      out.print(request.getContextPath());
      out.write("/views/JefeArea.jsp\"> Salir </a>\r\n");
      out.write("            <br><br><br>\r\n");
      out.write("            <section class=\"row col-sm-4 col-sm-offset-4\" style=\"\">\r\n");
      out.write("                <div class=\"col-sm-4 col-sm-offset-1\" id=\"plan-operativo\">\r\n");
      out.write("                    <h2 style=\"width:200px; text-align:center;\">Plan Operativo</h2>\r\n");
      out.write("                    <br><br>\r\n");
      out.write("\r\n");
      out.write("                    <form role=\"form\" name=\"form\" method=\"post\" id=\"miFormulario\" action=\"");
      out.print(request.getContextPath());
      out.write("/CreatePlanOperativoServlet\">\r\n");
      out.write("                        <div class=\"form-group\" style=\"width: 300px;\">\r\n");
      out.write("                            <label for=\"nombre\">Nombre :</label>\r\n");
      out.write("                            <input id=\"nombre\" type=\"text\" name=\"nombre\" class=\"form-control\" placeholder=\"Nombre y Apellido\"  required=\"\"/>                  \r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\" style=\"width: 300px;\">\r\n");
      out.write("                            <label for=\"cboarea\">Email :</label>\r\n");
      out.write("                            <select class=\"form-control\" required=\"true\" name=\"cboarea\">\r\n");
      out.write("                                <option value=\"\" selected> --- Escoge un area ---</option>\r\n");
      out.write("                                <option> Area 1 </option>\r\n");
      out.write("                                <option> Area 2 </option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                        <br>\r\n");
      out.write("                        <button class=\"btn btn-lg btn-info\" id=\"btnCrear\"> Crear Plan Operativo </button>\r\n");
      out.write("\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>   \r\n");
      out.write("        </div>\r\n");
      out.write("            <script src=\"http://code.jquery.com/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("            <script src=\"");
      out.print(request.getContextPath());
      out.write("/static/js/ValidacionAldo.js\"></script> \r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
