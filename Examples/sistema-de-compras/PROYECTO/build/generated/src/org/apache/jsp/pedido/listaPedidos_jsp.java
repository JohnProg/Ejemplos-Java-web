package org.apache.jsp.pedido;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import compraProveedores.dao.pedidoDAO;
import compraProveedores.beans.pedidoBean;
import java.util.ArrayList;

public final class listaPedidos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color:lemonchiffon\">\n");
      out.write("        <h2 style=\"color:black;text-align: center\">LISTA DE PEDIDOS </h2>\n");
      out.write("        \n");
      out.write("    <center>    <ttable>\n");
      out.write("            \n");
      out.write("                </ttable><table border=\"2px\">\n");
      out.write("                    <form name=\"form\"></form>\n");
      out.write("            <tbody><tr>\n");
      out.write("                \n");
      out.write("                    <th colspan=\"6\" style=\"font-size:40px\">\t<div style=\"width:px; height:50px; background-color:appworkspace\"><strong>PEDIDOS SOLICITADOS</strong></div>\n");
      out.write("<span></span></th>\n");
      out.write("                    \n");
      out.write("                      \n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("            </tbody><tbody>\n");
      out.write("                <tr>\n");
      out.write("                    \n");
      out.write("                    <td style=\"font-size:40px  ;color:red\">codigo</td>\n");
      out.write("                    <td style=\"font-size:40px  ;color:red\">estado</td>\n");
      out.write("                    <td style=\"font-size:40px ;color:red\">area</td>\n");
      out.write("                    <td style=\"font-size:40px ;color:red\">descripcion</td>\n");
      out.write("                    \n");
      out.write("            \n");
      out.write("                </tr>\n");
      out.write("                ");
  ArrayList<pedidoBean> pedidos = (ArrayList<pedidoBean>)request.getAttribute("pedidos");
                    
                
      out.write("\n");
      out.write("                 ");
  for(pedidoBean   obj:pedidos){   
      out.write("\n");
      out.write("             \n");
      out.write("              <tr>\n");
      out.write("                 <td>");
      out.print(obj.getId_pedido());
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(obj.getEstado());
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(obj.getArea());
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(obj.getDescripcion());
      out.write("</td>\n");
      out.write("             </tr>\n");
      out.write("            ");
   }
      out.write("\n");
      out.write("                \n");
      out.write("            </tbody>\n");
      out.write("       </table>\n");
      out.write("        </center>\n");
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
