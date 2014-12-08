/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maristas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maristas.beans.PresupuestoBean;
import maristas.dao.presupuestoDAO;

/**
 *
 * @author Autonoma
 */
public class PlanPresupuestalServlet extends HttpServlet {

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
        switch(opt) {
            //LIST
            case 1: {
                presupuestoDAO p_pre = new presupuestoDAO();
                ArrayList<PresupuestoBean> plans = p_pre.ListaPlanPr();
                request.setAttribute("plans", plans);
                getServletContext().getRequestDispatcher(pagina).forward(request, response);
                break;
            }
            //DELETE
            case 2: {
                pagina="/PROYECTOERP/PlanPresupuestalServlet?accion=1";
                int id = Integer.parseInt(request.getParameter("plan_id"));

                presupuestoDAO  objPlanDAO=new presupuestoDAO();
                int estado = objPlanDAO.EliminarPlanPr(id);
                //verificar estado de la eliminacion
                if(estado == 1) {
                    request.setAttribute("status", "ok"); 
                    request.setAttribute("mensaje","Se elimino correctamente.");
                }
                else {
                    request.setAttribute("status", "fail"); 
                    request.setAttribute("mensaje","Hubo un error al momento de eliminar.");
                }
                response.sendRedirect(pagina);
                break;
            }
            //GET ITEM TO EDIT
            case 3: {
                pagina="/views/PlanPresupuestal/updatePlan.jsp";
                int id = Integer.parseInt(request.getParameter("plan_id"));
                presupuestoDAO p_pre = new presupuestoDAO();
                PresupuestoBean plan = p_pre.obtenerPlanPr(id);
                request.setAttribute("plan", plan);
                getServletContext().getRequestDispatcher(pagina).forward(request, response);
                break;
            }
        }        
        
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
        String opcad = request.getParameter("accion"),
            pagina = "";
        int estado = 0;
        int op;
            if(opcad != null) op = Integer.parseInt(opcad);
            else op = 5;
        
        switch (op) {
            //CREATE
            case 1: { 
                    pagina="/PROYECTOERP/PlanPresupuestalServlet?accion=1";
                    String nombre=request.getParameter("nombre");
                    float monto= Float.parseFloat(request.getParameter("monto"));
                    String fec_inicio=request.getParameter("fec_inicio");
                    String fecha_final=request.getParameter("fecha_final");
                    
                    PresupuestoBean objPlanBean=new PresupuestoBean();
                                objPlanBean.setNombre(nombre);
                                objPlanBean.setMonto(monto);
                                objPlanBean.setFecha_inicio(fec_inicio);
                                objPlanBean.setFecha_final(fecha_final);
                    presupuestoDAO  objPlanDAO=new presupuestoDAO();
                    estado=objPlanDAO.InsertarPlanPr(objPlanBean);

                    //verificar estado de la insercion
                    if(estado ==1) {
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se creo satisfactoriamente.");
                    }
                    else{
                      request.setAttribute("status", "fail"); 
                      request.setAttribute("mensaje","Hubo un error al momento de creacion.");
                    }
                    response.sendRedirect(pagina);
                    break;
            }
            //UPDATE
            case 2: { 

                    pagina="/PROYECTOERP/PlanPresupuestalServlet?accion=1";
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nombre=request.getParameter("nombre");
                    float monto= Float.parseFloat(request.getParameter("monto"));
                    String fec_inicio=request.getParameter("fec_inicio");
                    String fecha_final=request.getParameter("fecha_final");
                    
                    PresupuestoBean objPlanBean=new PresupuestoBean();
                    objPlanBean.setId(id);
                                objPlanBean.setNombre(nombre);
                                objPlanBean.setMonto(monto);
                                objPlanBean.setFecha_inicio(fec_inicio);
                                objPlanBean.setFecha_final(fecha_final);
                    presupuestoDAO  objPlanDAO=new presupuestoDAO();
                    estado=objPlanDAO.ActualizaPlanPr(objPlanBean);
                    //verificar estado de la actualizacion
                    if(estado ==1) {
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se actualizo satisfactoriamente.");
                    }
                    else{
                      request.setAttribute("status", "fail"); 
                      request.setAttribute("mensaje","Hubo un error al momento de actualizar.");
                    }
                    response.sendRedirect(pagina);
                    break;
                    
            }
            case 5: {
                    //variables
                    pagina="/views/PlanPresupuestal/listPlan.jsp";

                    presupuestoDAO i_s = new presupuestoDAO();
                    ArrayList<PresupuestoBean> plans = i_s.ListaPlanPr();
                    request.setAttribute("plans", plans);  
                    getServletContext().getRequestDispatcher(pagina).forward(request, response);
            }
        }
        
        
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
