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
import maristas.beans.UnidadOrganicaBean;
import maristas.dao.UnidadOrganicaDAO;

/**
 *
 * @author Aldair
 */
public class CreatePlanOperativoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
      
    }
       
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String pagina = "";
        int option = 0;
        if(request.getParameter("option") != null) {
            option = Integer.parseInt(request.getParameter("option"));
        }
        if(request.getSession().getAttribute("DatosUsuario") != null) {
            // Mostrar vista crear
            if(option == 1) {
                pagina="/views/PlanOperativo/CreatePlanOperativo.jsp";
                UnidadOrganicaDAO i_s2 = new UnidadOrganicaDAO();
                ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                request.setAttribute("areas", Areas);
            } else {
                //Mostrar vista lista plans
                pagina="/views/PlanOperativo/JefeArea.jsp";
                PlanOperativoDAO i_s = new PlanOperativoDAO();
                ArrayList<PlanOperativoBean> planope = i_s.getPlanO();
                request.setAttribute("plans", planope);
            }
        } else {
            pagina="/iniciarSesion.jsp";
            request.setAttribute("mensaje","Necesitas iniciar sesión!");
        }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = "";
      int option = 0;
      if(request.getParameter("option") != null) {
          option = Integer.parseInt(request.getParameter("option"));
      }
      switch(option) {
          case 0: {
              //variables
                    pagina="/views/PlanOperativo/JefeArea.jsp";
                    PlanOperativoDAO i_s = new PlanOperativoDAO();
                    ArrayList<PlanOperativoBean> planope = i_s.getPlanO();
                    request.setAttribute("plans", planope);
                    
                    break;
          }
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
            break;
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
