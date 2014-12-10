
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
import maristas.beans.PlanOperativoBean;
import maristas.beans.PresupuestoBean;
import maristas.dao.PlanOperativoDAO;
import maristas.dao.MysqlPresupuestoDAO;

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
                MysqlPresupuestoDAO p_pre = new MysqlPresupuestoDAO();
                ArrayList<PresupuestoBean> plans = p_pre.ListaPlanPr();
                request.setAttribute("plansP", plans);
                pagina="/views/PlanOperativo/CreateActividades.jsp";
                int id_plan_operativo = Integer.parseInt(request.getParameter("id_plan_operativo"));
                PlanOperativoDAO i_s2 = new PlanOperativoDAO();
                PlanOperativoBean objOB = new PlanOperativoBean();
                                    objOB.setId(id_plan_operativo);
                PlanOperativoBean planope2 = i_s2.getPlanO(objOB);
                request.setAttribute("planO", planope2);
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
                    int id_plan_operativo = Integer.parseInt(request.getParameter("id_plan_operativo"));
                    ActividadDAO i_s = new ActividadDAO();
                PlanOperativoDAO i_s3 = new PlanOperativoDAO();
                PlanOperativoBean objOB2 = new PlanOperativoBean();
                                    objOB2.setId(id_plan_operativo);
                                    
                ArrayList<ActividadBean> actividades = i_s.getActividad(objOB2);
                request.setAttribute("actividad", actividades);
                    
                    
                    break;
          }
          case 1: {
            // CREAR
            int estado = 0;
            pagina="/views/PlanOperativo/EscogerActividades.jsp";
            String nombre = request.getParameter("nombre");
            float gastos = Float.parseFloat(request.getParameter("gastos"));
            float ingresos = Float.parseFloat(request.getParameter("ingresos"));
            int id_plan_operativo = Integer.parseInt(request.getParameter("id_plan_operativo"));
            int id_sub_objetivo = Integer.parseInt(request.getParameter("id_sub_objetivo"));
            int id_presupuesto = Integer.parseInt(request.getParameter("id_presupuesto"));
            
            ActividadBean objActividadBean=new ActividadBean();
                     objActividadBean.setNombre(nombre);
                     objActividadBean.setGastos(gastos);
                     objActividadBean.setIngresos(ingresos);
                     objActividadBean.setId_plan_operativo(id_plan_operativo);
                     objActividadBean.setId_sub_objetivo(id_sub_objetivo);
                     objActividadBean.setId_presupuesto(id_presupuesto);
                     
            ActividadDAO  objActividadDAO=new ActividadDAO();
            estado = objActividadDAO.InsertarActividad(objActividadBean);
            
            //VALIDAR INSERCION
            if(estado == 1) {
                PlanOperativoDAO i_s2 = new PlanOperativoDAO();
                PlanOperativoBean objOB = new PlanOperativoBean();
                                    objOB.setId(id_plan_operativo);
                PlanOperativoBean planope2 = i_s2.getPlanO(objOB);
                request.setAttribute("planO", planope2);
                
                ActividadDAO i_s = new ActividadDAO();
                PlanOperativoDAO i_s3 = new PlanOperativoDAO();
                PlanOperativoBean objOB2 = new PlanOperativoBean();
                                    objOB2.setId(id_plan_operativo);
                                    
                ArrayList<ActividadBean> actividades = i_s.getActividad(objOB2);
                request.setAttribute("actividad", actividades);
                request.setAttribute("status","ok");
            }
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
