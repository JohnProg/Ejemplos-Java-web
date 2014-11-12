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
import maristas.beans.PlanEstrategicoBean;
import maristas.dao.planDAO;

/**
 *
 * @author johnp
 */
public class createPlanServlet extends HttpServlet {

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
        //variables
        String pagina = "/views/rest/plan/response.jsp";
        int estado = 0;
        
                
                String nombre=request.getParameter("nombre");
                String fec_vigencia=request.getParameter("fec_vigencia");
                String fec_termino=request.getParameter("fec_termino");
                String anio_inicio=request.getParameter("anio_inicio");
                String anio_termino=request.getParameter("anio_termino");
                int aprobado_por=Integer.parseInt(request.getParameter("aprobado_por"));
                String descripcion=request.getParameter("descripcion");
                PlanEstrategicoBean objPlanBean=new PlanEstrategicoBean();
                            objPlanBean.setNombre(nombre);
                            objPlanBean.setFec_vigencia(fec_vigencia);
                            objPlanBean.setFec_termino(fec_termino);
                            objPlanBean.setAnio_inicio(anio_inicio);
                            objPlanBean.setAnio_termino(anio_termino);
                            objPlanBean.setAprobado_por(aprobado_por);
                            objPlanBean.setDescripcion(descripcion);
                planDAO  objPlanDAO=new planDAO();
                estado=objPlanDAO.InsertarPlan(objPlanBean);
                
        //verificar estado de insercion
        if(estado ==1)
            request.setAttribute("status","ok");
        else
            request.setAttribute("status","fail");
        
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
        processRequest(request, response);
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
