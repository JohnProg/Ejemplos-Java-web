/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import maristas.beans.UsuarioBean;
import maristas.dao.usuarioDAO;

/**
 *
 * @author johnmachahuay
 */
public class UsuarioServlet extends HttpServlet {

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
            out.println("<title>Servlet UsarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsarioServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("accion");
        
        if(request.getSession().getAttribute("DatosUsuario") != null) {
            if("SALIR".equals(action)) {
                HttpSession  miSesion = request.getSession();
                miSesion.setAttribute("DatosUsuario", null);
                pagina="/iniciarSesion.jsp";
            } else {
                pagina = "/PlanServlet";
            }
            
        } else {
            pagina="/iniciarSesion.jsp";

        }
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioBean user = null;
        String pagina = "";
        String username = request.getParameter("username");
        String contrasena = request.getParameter("contra");
        
        usuarioDAO i_s = new usuarioDAO();
        try{
            user = i_s.getUser(username, contrasena);
        }catch(Exception e){}
        
        if(user != null) {
            HttpSession  miSesion = request.getSession();
            miSesion.setAttribute("DatosUsuario", user);
            pagina = "/PlanServlet";
        } else {
            pagina="/iniciarSesion.jsp";
            request.setAttribute("mensaje", "Ingresar correctamente sus datos!");
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
