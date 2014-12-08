/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraProveedores.servlet;

import compraProveedores.beans.usuarioBean;
import compraProveedores.dao.usuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author johnmachahuay
 */
public class SrvUsario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception { 
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "";
        if(request.getSession().getAttribute("usuario") != null) {
            pagina="/menu.jsp";
        } else {
            pagina="/login.jsp";
        }
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

   
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        usuarioBean user = null;
        String pagina = "";
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        
        usuarioDAO i_s = new usuarioDAO();
        try{
            user = i_s.obtenerJefeCompra(usuario, contrasena);
        }catch(Exception e){}
        
        if(user != null) {
            pagina="/menu.jsp";
            request.setAttribute("mensaje","Bienvenido al sistema");
            request.getSession().setAttribute("usuario", usuario);
        } else {
            pagina="/login.jsp";
            request.setAttribute("mensaje","Ingresar correctamente sus datos!");
        }
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
