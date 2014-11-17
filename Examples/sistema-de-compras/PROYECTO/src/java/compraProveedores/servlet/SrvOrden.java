/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraProveedores.servlet;

import compraProveedores.beans.pedidoBean;
import compraProveedores.beans.usuarioBean;
import compraProveedores.dao.pedidoDAO;
import compraProveedores.dao.usuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SrvOrden extends HttpServlet {
    ArrayList<usuarioBean> proveedores = null;
    ArrayList<pedidoBean> pedidos = null;
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SrvOrden</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SrvOrden at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
            pedidoDAO i_s = new pedidoDAO();
            pedidos = i_s.listado();
            request.setAttribute("pedidos", pedidos);
            
            usuarioDAO i_s2 = new usuarioDAO();
            try {
                proveedores = i_s2.obtenerProveedores();
            } catch (Exception ex) {}

            request.setAttribute("proveedores", proveedores);
            
            pagina="/ordenCompra/crearOrdenCompra.jsp";
            
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
