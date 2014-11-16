package org.apache.jsp.cotizacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import compraProveedores.beans.cotizacionBean;
import java.util.ArrayList;

public final class listaCotizacion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color:antiquewhite\">\n");
      out.write("        <h2 style=\"color:black;text-align: center\">LISTA DE COTIZACIONES </h2>\n");
      out.write("        \n");
      out.write("        <table style=\"align-text: center \" border=\"2px\">\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"6\" style=\"font-size:40px\">\t\n");
      out.write("                        <div style=\"width:px; height:50px; background-color:appworkspace\">\n");
      out.write("                            <strong>cotizaciones pendientes</strong>\n");
      out.write("                        </div>\n");
      out.write("                        <span></span>\n");
      out.write("                    </th>  \n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("            </tbody>\n");
      out.write("            <tbody>\n");
      out.write("                 <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td style=\"font-size:40px  ;color:red\">id pedido</td>\n");
      out.write("                    <td style=\"font-size:40px ;color:red\">id proveedor</td>\n");
      out.write("                    <td style=\"font-size:40px ;color:red\">forma de pago</td>\n");
      out.write("                    <td style=\"font-size:40px ;color:red\">descripcion</td>\n");
      out.write("                    <td style=\"font-size:40px ;color:red\">costo</td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                ");
  ArrayList<cotizacionBean> cotizaciones = (ArrayList<cotizacionBean>)request.getAttribute("cotizaciones");
                    
                
      out.write("\n");
      out.write("                 ");
  for(cotizacionBean   obj:cotizaciones){   
      out.write("\n");
      out.write("             \n");
      out.write("              <tr>\n");
      out.write("                  <td><input type=\"checkbox\" name=\"seleccionar\" value=\"1\"> \n");
      out.write("                    <br></td>\n");
      out.write("                 <td style=\"font-size:40px\">");
      out.print(obj.getId_fk_pedido());
      out.write("</td>\n");
      out.write("                 <td style=\"font-size:40px\">");
      out.print(obj.getId_fk_usuario());
      out.write("</td>\n");
      out.write("                 <td style=\"font-size:40px\">");
      out.print(obj.getForma_pago());
      out.write("</td>\n");
      out.write("                 <td style=\"font-size:40px\">");
      out.print(obj.getDescripcion());
      out.write("</td>\n");
      out.write("                 <td style=\"font-size:40px\">");
      out.print(obj.getCosto());
      out.write("</td>\n");
      out.write("             </tr>\n");
      out.write("            ");
   }
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("       </table>\n");
      out.write("       <br><br>\n");
      out.write("    \n");
      out.write("</body>\n");
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
