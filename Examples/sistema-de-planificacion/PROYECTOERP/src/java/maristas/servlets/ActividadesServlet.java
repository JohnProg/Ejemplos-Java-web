
package maristas.servlets;

import maristas.beans.ActividadBean;
import maristas.dao.ActividadDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Autonoma
 */
public class ActividadesServlet extends HttpServlet {

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
        
            // Mostrar vista crear
            if(option == 1) {
                pagina="/views/PlanOperativo/CreateActividades.jsp";
                
            } 
            else if(option == 2) {
                //Mostrar vista crear actividades
                pagina="/views/PlanOperativo/EscogerActividades.jsp";
                
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
                    pagina="/views/PlanOperativo/EscogerActividades.jsp";
                    ActividadDAO i_s = new ActividadDAO();
                    ArrayList<ActividadBean> planope = i_s.getActividad();
                    request.setAttribute("actividad", planope);
                    
                    
                    break;
          }
          case 1: {
            // CREAR
            int estado = 0;
            pagina="/views/PlanOperativo/CreateActividades.jsp";
            String nombre = request.getParameter("nombre");
            float gastos = Float.parseFloat(request.getParameter("gastos"));
            float ingresos = Float.parseFloat(request.getParameter("ingresos"));
            int id_plan_operativo = Integer.parseInt(request.getParameter("id_plan_operativo"));
            int id_sub_objetivo = Integer.parseInt(request.getParameter("id_sub_objetivo"));
            int id_presupuesto = Integer.parseInt(request.getParameter("id_presupuesto"));
            
            ActividadBean objActividadBean=new ActividadBean();
                     objActividadBean.setNombre(nombre);
                     objActividadBean.setId_plan_operativo(id_plan_operativo);
                     
            ActividadDAO  objActividadDAO=new ActividadDAO();
            estado = objActividadDAO.InsertarActividad(objActividadBean);
            
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

}
