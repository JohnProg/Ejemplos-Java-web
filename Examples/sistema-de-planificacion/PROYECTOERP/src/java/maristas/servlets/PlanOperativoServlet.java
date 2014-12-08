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
import maristas.beans.ActividadBean;
import maristas.dao.ActividadDAO;

/**
 *
 * @author Aldair
 */
public class PlanOperativoServlet extends HttpServlet {

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
                pagina="/views/PlanOperativo/CreatePlanOperativo.jsp";
                UnidadOrganicaDAO i_s2 = new UnidadOrganicaDAO();
                ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                request.setAttribute("areas", Areas);
            } 
            else if(option == 2) {
                //Mostrar vista crear actividades
                pagina="/views/PlanOperativo/EscogerActividades.jsp";
                ActividadDAO i_s = new ActividadDAO();
                ArrayList<ActividadBean> planope = i_s.getActividad();
                request.setAttribute("actividad", planope);
            }
            
            else{
                //Mostrar vista lista plans
                pagina="/views/PlanOperativo/JefeArea.jsp";
                PlanOperativoDAO i_s = new PlanOperativoDAO();
                ArrayList<PlanOperativoBean> planope = i_s.getPlanO();
                request.setAttribute("plans", planope);
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
            pagina="/views/PlanOperativo/CreatePlanOperativo.jsp";
            String nombre = request.getParameter("nombre");
            int id_unidad_organica = Integer.parseInt(request.getParameter("id_unidad_organica"));
            PlanOperativoBean objPlanOperativoBean=new PlanOperativoBean();
                     objPlanOperativoBean.setNombre(nombre);
                     objPlanOperativoBean.setId_unidad_organica(id_unidad_organica);
                     
            PlanOperativoDAO  objPlanOperativoDAO=new PlanOperativoDAO();
            estado = objPlanOperativoDAO.InsertarPlanOp(objPlanOperativoBean);
            
            //VALIDAR INSERCION
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
              
               PlanOperativoDAO dao = new PlanOperativoDAO();
               PlanOperativoBean objplanOp = new PlanOperativoBean();
                        String a = request.getParameter("id");
                        if(request.getParameter("id") != null) objplanOp.setId(Integer.parseInt(request.getParameter("id")));
                        else objplanOp.setId(0);
               
                        objplanOp.setNombre(request.getParameter("nombre"));
                        objplanOp.setId_unidad_organica(Integer.parseInt(request.getParameter("id_unidad_org")));
                       
                        
                int estado = dao.ActualizarPlanOperativo(objplanOp);
                //verificar estado de la insercion
                if(estado ==1) {
                    request.setAttribute("status", "ok");
                    request.setAttribute("mensaje","Se actualizo satisfactoriamente.");
                }
                else{
                  request.setAttribute("status", "fail"); 
                  request.setAttribute("mensaje","Hubo un error al momento de la actualizacion.");
                }
                
        
            }
            // Buscar
            case 3: {
                pagina = "/BusquedaPostulante.jsp";
                break;
            }
            //Eliminar
            case 4: {
                
                PlanOperativoDAO dao = new PlanOperativoDAO();
                int id = Integer.parseInt(request.getParameter("id"));
                int estado  = dao.EliminarPlanOperativo(id);
                if(estado == 1)request.setAttribute("mensaje", "Se elimino correctamente.");
                else request.setAttribute("mensaje", "Hubo un error al momento de eliminar.");
                
                ArrayList<PlanOperativoBean> lista= dao.getPlanO();
            
                request.setAttribute("id", lista);
                
                break;
            }
      }
            
            getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

