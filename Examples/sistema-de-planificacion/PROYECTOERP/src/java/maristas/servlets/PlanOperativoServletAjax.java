/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maristas.beans.LineaBean;
import maristas.beans.ObjetivoBean;
import maristas.beans.PlanEstrategicoBean;
import maristas.beans.SubObjetivoBean;
import maristas.dao.lineaDAO;
import maristas.dao.objetivoDAO;
import maristas.dao.planDAO;
import maristas.dao.subObjetivoDAO;
import net.sf.json.JSONObject;

/**
 *
 * @author johnmachahuay
 */
public class PlanOperativoServletAjax extends HttpServlet {

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
            out.println("<title>Servlet PlanOperativoServletAjax</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PlanOperativoServletAjax at " + request.getContextPath() + "</h1>");
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
          
          String json = "";
          int accion = Integer.parseInt(request.getParameter("accion"));
          Map<String, String> options = new LinkedHashMap<String, String>();
          //JSONObject json = new JSONObject();
          switch(accion){
              //get plans
              case 1: {
                    
                    planDAO i_s = new planDAO();
                    ArrayList<PlanEstrategicoBean> plans = i_s.GetPlans();
                    json = new Gson().toJson(plans);
                    
               break;   
              }
              //get lineas
              case 2: {
                    int planE_id = Integer.parseInt(request.getParameter("planE_id"));
                    lineaDAO i_s = new lineaDAO();
                    ArrayList<LineaBean> lineas = i_s.GetLinesByPlanId(planE_id);
                    json = new Gson().toJson(lineas);
                  break;
              }
              //get objetivos
              case 3: {
                  int linea_id = Integer.parseInt(request.getParameter("linea_id"));
                    objetivoDAO i_s = new objetivoDAO();
                    ArrayList<ObjetivoBean> objetivos = i_s.GetObjetivesByLineId(linea_id);
                    json = new Gson().toJson(objetivos);
                  break;
              }
              //get subobjetivos
              case 4: {
                  int obj_id = Integer.parseInt(request.getParameter("obj_id"));
                    subObjetivoDAO i_s = new subObjetivoDAO();
                    ArrayList<SubObjetivoBean> subobjetivos = i_s.GetSubObjetivesByObjetiveId(obj_id);
                    json = new Gson().toJson(subobjetivos);
                  break;
              }
          }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        
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
