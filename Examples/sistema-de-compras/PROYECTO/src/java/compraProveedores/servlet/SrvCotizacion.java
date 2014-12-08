/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraProveedores.servlet;

import compraProveedores.beans.cotizacionBean;
import compraProveedores.beans.usuarioBean;
import compraProveedores.dao.cotizacionDAO;
import compraProveedores.dao.pedidoDAO;
import compraProveedores.dao.usuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SrvCotizacion extends HttpServlet {
    ArrayList<usuarioBean> proveedores = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "";
        
        if(request.getSession().getAttribute("usuario") != null) {
            
            if(request.getParameter("pedido_id") != null){
                int pedido_id = Integer.parseInt(request.getParameter("pedido_id"));
                usuarioDAO i_s = new usuarioDAO();
                
                try {
                    proveedores = i_s.obtenerProveedores();
                } catch (Exception ex) {}
                
                request.setAttribute("proveedores", proveedores);
                request.getSession().setAttribute("pedido_id", pedido_id);
                pagina="/cotizacion/crearCotizacion.jsp";
            } else {
                cotizacionDAO i_s = new cotizacionDAO();
                ArrayList<cotizacionBean> cotizaciones = i_s.listado();
                request.setAttribute("cotizaciones", cotizaciones);
                pagina="/cotizacion/listaCotizacion.jsp";
            }
            
        } else {
            pagina="/login.jsp";
            request.setAttribute("mensaje","Necesitas iniciar sesión!");
        }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "";
      int option = Integer.parseInt(request.getParameter("option"));
      int id_proveedor = Integer.parseInt(request.getParameter("proveedor"));
      int id_pedido = Integer.parseInt(request.getParameter("pedido_id"));
      
      
      switch(option) {
          case 1: {
            // CREAR
            int estado = 0;
            pagina="/cotizacion/crearCotizacion.jsp";
            
            //usuarioBean usuario = (usuarioBean) request.getSession().getAttribute("usuario");
            
            int id_fk_pedido = id_pedido;
            int id_fk_usuario = id_proveedor;
            String forma_pago = request.getParameter("forma_pago");
            String descripcion = request.getParameter("descripcion");
            float costo = 0;
            cotizacionBean objCotizacionBean=new cotizacionBean();
                     objCotizacionBean.setId_fk_pedido(id_fk_pedido);
                     objCotizacionBean.setId_fk_usuario(id_fk_usuario);
                     objCotizacionBean.setForma_pago(forma_pago);
                     objCotizacionBean.setDescripcion(descripcion);
                     objCotizacionBean.setCosto(costo);
                         
            cotizacionDAO  objcotizacionDAO=new cotizacionDAO();
            estado = objcotizacionDAO.InsertarCotizacion(objCotizacionBean);
            
            //VALIDAR NSERCION
            if(estado == 1) {
                request.setAttribute("mensaje","Se envio correctamente");
            }
            else {
                request.setAttribute("mensaje","Fallo al momento de crear");
            }
          }
          case 3: {
              //ACTUALIZAR
          }
          case 4: {
              //ELIMINAR
          }
      }
            
            getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
