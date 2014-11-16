/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraProveedores.servlet;

import compraProveedores.beans.cotizacionBean;
import compraProveedores.dao.cotizacionDAO;
import compraProveedores.dao.pedidoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author johnmachahuay
 */
public class SrvCotizacion extends HttpServlet {

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
      String pagina = "";
      int option = Integer.parseInt(request.getParameter("option"));
      
      switch(option) {
          case 1: {
            // CREAR
            int estado = 0;
            pagina="/cotizacion/crearCotizacion.jsp";
            int id_fk_pedido = Integer.parseInt(request.getParameter("id_fk_pedido"));
            int id_fk_usuario = Integer.parseInt(request.getParameter("id_fk_usuario"));
            String forma_pago = request.getParameter("forma_pago");
            String descripcion = request.getParameter("descripcion");
            float costo = Float.parseFloat(request.getParameter("costo"));
            cotizacionBean objCotizacionBean=new cotizacionBean();
                     objCotizacionBean.setId_fk_pedido(id_fk_pedido);
                     objCotizacionBean.setId_fk_usuario(id_fk_usuario);
                     objCotizacionBean.setForma_pago(forma_pago);
                     objCotizacionBean.setDescripcion(descripcion);
                     objCotizacionBean.setCosto(costo);
                         
            cotizacionDAO  objcotizacionDAO=new cotizacionDAO();
            estado = objcotizacionDAO.InsertarCotizacion(objCotizacionBean);
            
            //VALIDAR NSERCION
            if(estado == 1) request.setAttribute("status","ok");
            else request.setAttribute("status","fail");
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
        if(request.getSession().getAttribute("user") != null) {
            cotizacionDAO i_s = new cotizacionDAO();
            ArrayList<cotizacionBean> cotizaciones = i_s.listado();
            request.setAttribute("cotizaciones", cotizaciones);
            pagina="/cotizacion/listaCotizacion.jsp";
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
        processRequest(request, response);
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
