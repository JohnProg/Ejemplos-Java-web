package maristas.servlets;

import maristas.beans.PlanOperativoBean;
import maristas.dao.PlanOperativoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maristas.beans.UnidadOrganicaBean;
import maristas.dao.UnidadOrganicaDAO;
import maristas.beans.ActividadBean;
import maristas.beans.PlanEstrategicoBean;
import maristas.beans.UsuarioBean;
import maristas.dao.ActividadDAO;
import maristas.dao.planDAO;
import maristas.dao.usuarioDAO;

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
                
                usuarioDAO i_s3 = new usuarioDAO();
                try {
                    ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
                } catch (Exception ex) {}
                
            } 
            else if(option == 2) {
                //Mostrar vista crear actividades
                pagina="/views/PlanOperativo/EscogerActividades.jsp";
                int id_plan_operativo = Integer.parseInt(request.getParameter("id_plan_operativo"));
                PlanOperativoDAO i_s2 = new PlanOperativoDAO();
                PlanOperativoBean objOB = new PlanOperativoBean();
                                    objOB.setId(id_plan_operativo);
                                    
                ActividadDAO i_s = new ActividadDAO();
                ArrayList<ActividadBean> actividades = i_s.getActividad(objOB);
                request.setAttribute("actividad", actividades);
                
                PlanOperativoBean planope2 = i_s2.getPlanO(objOB);
                request.setAttribute("planO", planope2);
            }
            else if(option == 3) {
                pagina="/views/PlanOperativo/editPlanOperativo.jsp";
                int id = Integer.parseInt(request.getParameter("id"));
                PlanOperativoDAO i_s = new PlanOperativoDAO();
                PlanOperativoBean objOB = new PlanOperativoBean();
                                    objOB.setId(id);
                PlanOperativoBean planope = i_s.getPlanO(objOB);
                request.setAttribute("planO", planope);
                
                UnidadOrganicaDAO i_s2 = new UnidadOrganicaDAO();
                ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                request.setAttribute("areas", Areas);
                
                usuarioDAO i_s3 = new usuarioDAO();
                try {
                    ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
                } catch (Exception ex) {}
            }
            //Eliminar
            else if(option == 4) {
                pagina="/views/PlanOperativo/JefeArea.jsp";
                PlanOperativoDAO dao = new PlanOperativoDAO();
                int id_plan_operativo = Integer.parseInt(request.getParameter("id_plan_operativo"));
                int estado  = dao.EliminarPlanOperativo(id_plan_operativo);
                if(estado == 1){
                    PlanOperativoDAO i_s = new PlanOperativoDAO();
                    ArrayList<PlanOperativoBean> planope = i_s.getPlansO();
                    request.setAttribute("plansO", planope);

                    UnidadOrganicaDAO i_s2 = new UnidadOrganicaDAO();
                    ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                    request.setAttribute("areas", Areas);

                    usuarioDAO i_s3 = new usuarioDAO();
                    try {
                        ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                        request.setAttribute("usuarios", usuarios);
                    } catch (Exception ex) {}

                    planDAO i_s4 = new planDAO();
                    ArrayList<PlanEstrategicoBean> plans = i_s4.GetPlans();
                    request.setAttribute("plansE", plans); 
                    request.setAttribute("status", "ok");
                    request.setAttribute("mensaje", "Se elimino correctamente.");
                }
                else {
                    request.setAttribute("status", "fail");
                    request.setAttribute("mensaje", "Hubo un error al momento de eliminar.");
                }
                
                
                
            }
            else{
                //Mostrar vista lista plans
                pagina="/views/PlanOperativo/JefeArea.jsp";
                PlanOperativoDAO i_s = new PlanOperativoDAO();
                ArrayList<PlanOperativoBean> planope = i_s.getPlansO();
                request.setAttribute("plansO", planope);
                
                UnidadOrganicaDAO i_s2 = new UnidadOrganicaDAO();
                ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                request.setAttribute("areas", Areas);
                
                usuarioDAO i_s3 = new usuarioDAO();
                try {
                    ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
                } catch (Exception ex) {}
                
                planDAO i_s4 = new planDAO();
                ArrayList<PlanEstrategicoBean> plans = i_s4.GetPlans();
                request.setAttribute("plansE", plans);  
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
          case 1: {
            // CREAR
            int estado = 0;
            pagina="/views/PlanOperativo/CreatePlanOperativo.jsp";
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            int id_encargado = Integer.parseInt(request.getParameter("id_encargado"));
            int id_unidad_org = Integer.parseInt(request.getParameter("id_unidad_org"));
            
            PlanOperativoBean objPlanOperativoBean=new PlanOperativoBean();
                     objPlanOperativoBean.setNombre(nombre);
                     objPlanOperativoBean.setDescripcion(descripcion);
                     objPlanOperativoBean.setId_encargado(id_encargado);
                     objPlanOperativoBean.setId_unidad_organica(id_unidad_org);
                     
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
              pagina="/views/PlanOperativo/editPlanOperativo.jsp";
               PlanOperativoDAO dao = new PlanOperativoDAO();
               int id_plan_estrategico = 1;
               String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            int id_encargado = Integer.parseInt(request.getParameter("id_encargado"));
            int id_unidad_org = Integer.parseInt(request.getParameter("id_unidad_org"));
            if(request.getParameter("id_plan_estrategico") != null){
                id_plan_estrategico = Integer.parseInt(request.getParameter("id_plan_estrategico"));
            }
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            PlanOperativoBean objPlanOperativoBean=new PlanOperativoBean();
                     objPlanOperativoBean.setNombre(nombre);
                     objPlanOperativoBean.setDescripcion(descripcion);
                     objPlanOperativoBean.setId_encargado(id_encargado);
                     objPlanOperativoBean.setId_unidad_organica(id_unidad_org);
                     objPlanOperativoBean.setId_plan_estrategico(id_plan_estrategico);
                     objPlanOperativoBean.setId(id);
                
                int estado = dao.ActualizarPlanOperativo(objPlanOperativoBean);
                //verificar estado de la insercion
                if(estado ==1) {
                    PlanOperativoDAO i_s = new PlanOperativoDAO();
                PlanOperativoBean objOB = new PlanOperativoBean();
                                    objOB.setId(id);
                PlanOperativoBean planope = i_s.getPlanO(objOB);
                request.setAttribute("planO", planope);
                
                UnidadOrganicaDAO i_s2 = new UnidadOrganicaDAO();
                ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                request.setAttribute("areas", Areas);
                
                usuarioDAO i_s3 = new usuarioDAO();
                try {
                    ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
                } catch (Exception ex) {}
                    request.setAttribute("status", "ok");
                    request.setAttribute("mensaje","Se actualizo satisfactoriamente.");
                }
                else{
                  request.setAttribute("status", "fail"); 
                  request.setAttribute("mensaje","Hubo un error al momento de la actualizacion.");
                }
                break;
        
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
                
                ArrayList<PlanOperativoBean> lista= dao.getPlansO();
            
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

