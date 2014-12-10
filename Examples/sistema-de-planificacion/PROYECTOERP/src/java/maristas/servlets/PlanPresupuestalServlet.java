/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maristas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maristas.beans.PresupuestoBean;
import maristas.dao.MysqlPresupuestoDAO;
import maristas.factoria.DAOFactory;
import maristas.interfaces.PresupuestoDAO;

/**
 *
 * @author Autonoma
 */
public class PlanPresupuestalServlet extends HttpServlet {
    PresupuestoBean objPlanPr = null;
    DAOFactory objDAOFactory = null;
    PresupuestoDAO objPlanPrDAO = null;
    ArrayList<PresupuestoBean> plans = null;
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
            out.println("<title>Servlet PlanPresupuestalServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PlanPresupuestalServlet at " + request.getContextPath() + "</h1>");
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
       //variables
        String pagina="/views/PlanPresupuestal/listPlan.jsp";
        int opt = Integer.parseInt(request.getParameter("accion"));
        int estado = 0;
        
        objDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        objPlanPrDAO = objDAOFactory.getPresupuestoDAO();
        try {
            switch(opt) {
                //LIST
                case 1: {                
                    plans = objPlanPrDAO.ListaPlanPr();
                    request.setAttribute("plans", plans);
                    getServletContext().getRequestDispatcher(pagina).forward(request, response);
                    break;
                }
                //DELETE
                case 2: {
                    int id = Integer.parseInt(request.getParameter("plan_id"));
                            objPlanPr = new PresupuestoBean();
                            objPlanPr.setId(id);
                            estado = objPlanPrDAO.EliminarPlanPr(objPlanPr);
                    plans = new ArrayList<PresupuestoBean>();
                    plans = objPlanPrDAO.ListaPlanPr();
                    request.setAttribute("plans", plans);
                    if(estado == 1) {
                        request.setAttribute("status", "ok"); 
                        request.setAttribute("mensaje","Se elimino correctamente.");
                    }
                    else {
                        request.setAttribute("status", "fail"); 
                        request.setAttribute("mensaje","Hubo un error al momento de eliminar.");
                    }
                    getServletContext().getRequestDispatcher(pagina).forward(request, response);
                    break;
                }
                //GET ITEM TO EDIT
                case 3: {
                    pagina="/views/PlanPresupuestal/updatePlan.jsp";
                    int id = Integer.parseInt(request.getParameter("plan_id"));
                        objPlanPr = new PresupuestoBean();
                        objPlanPr.setId(id);
                        objPlanPr = objPlanPrDAO.obtenerPlanPr(objPlanPr);
                    request.setAttribute("plan", objPlanPr);
                    getServletContext().getRequestDispatcher(pagina).forward(request, response);
                    break;
                }
            }
        } catch (SQLException ex) {}       
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
        int op = Integer.parseInt(request.getParameter("accion"));
        String pagina="/views/PlanPresupuestal/listPlan.jsp";
        int estado = 0;
        
        objDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        objPlanPrDAO = objDAOFactory.getPresupuestoDAO();
        
    try {
        switch (op) {
            //CREATE
            case 1: { 
                    String nombre=request.getParameter("nombre");
                    float monto= Float.parseFloat(request.getParameter("monto"));
                    String fec_inicio=request.getParameter("fec_inicio");
                    String fecha_final=request.getParameter("fecha_final");
                            objPlanPr = new PresupuestoBean();
                            objPlanPr.setNombre(nombre);
                            objPlanPr.setMonto(monto);
                            objPlanPr.setFecha_inicio(fec_inicio);
                            objPlanPr.setFecha_final(fecha_final);
                    estado = objPlanPrDAO.InsertarPlanPr(objPlanPr);
                    
                    plans = new ArrayList<PresupuestoBean>();
                    plans = objPlanPrDAO.ListaPlanPr();
                    request.setAttribute("plans", plans);
                    if(estado ==1) {
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se creo satisfactoriamente.");
                    }
                    else{
                      request.setAttribute("status", "fail"); 
                      request.setAttribute("mensaje","Hubo un error al momento de creacion.");
                    }
                    break;
            }
            //UPDATE
            case 2: { 
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nombre=request.getParameter("nombre");
                    float monto= Float.parseFloat(request.getParameter("monto"));
                    String fec_inicio=request.getParameter("fec_inicio");
                    String fecha_final=request.getParameter("fecha_final");
                            objPlanPr = new PresupuestoBean();
                            objPlanPr.setId(id);
                            objPlanPr.setNombre(nombre);
                            objPlanPr.setMonto(monto);
                            objPlanPr.setFecha_inicio(fec_inicio);
                            objPlanPr.setFecha_final(fecha_final);
                    estado = objPlanPrDAO.ActualizaPlanPr(objPlanPr);
                    
                    plans = new ArrayList<PresupuestoBean>();
                    plans = objPlanPrDAO.ListaPlanPr();
                    request.setAttribute("plans", plans);
                    if(estado ==1) {
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se actualizo satisfactoriamente.");
                    }
                    else{
                      request.setAttribute("status", "fail"); 
                      request.setAttribute("mensaje","Hubo un error al momento de actualizar.");
                    }
                    break;
                    
            }
        }
    } catch (SQLException ex) {}
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
