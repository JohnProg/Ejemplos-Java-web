/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.servlets;

import maristas.beans.PlanOperativoBean;
import maristas.dao.PlanOperativoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aldair
 */
public class CreatePlanOperativoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
      String pagina = "";
      int option = Integer.parseInt(request.getParameter("option"));
      
      switch(option) {
          case 1: {
            // CREAR
            int estado = 0;
            pagina="views/PlanOperativo/CreatePlanOperativo.jsp";
            String nombre = request.getParameter("nombre");
            int id_unidad_organica = Integer.parseInt(request.getParameter("id_unidad_organica"));
            PlanOperativoBean objPlanOperativoBean=new PlanOperativoBean();
                     objPlanOperativoBean.setNombre(nombre);
                     objPlanOperativoBean.setId_unidad_organica(id_unidad_organica);
                     
            PlanOperativoDAO  objPlanOperativoDAO=new PlanOperativoDAO();
            estado = objPlanOperativoDAO.InsertarPlanOp(objPlanOperativoBean);
            
            //VALIDAR INSERCION
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
       
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "";
        if(request.getSession().getAttribute("user") != null) {
            PlanOperativoDAO i_s = new PlanOperativoDAO();
            ArrayList<PlanOperativoBean> planope = i_s.getPlanO();
            request.setAttribute("PlanOperativo", planope);
            pagina="/view/CreatePlanOperativo.jsp";
        } else {
            pagina="/iniciarSesion.jsp";
            request.setAttribute("mensaje","Necesitas iniciar sesión!");
        }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
