package maristas.servlets;

import maristas.beans.PlanOperativoBean;
import maristas.dao.MysqlPlanOperativoDAO;
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
import maristas.dao.MysqlUnidadOrganicaDAO;
import maristas.beans.ActividadBean;
import maristas.beans.PlanEstrategicoBean;
import maristas.beans.UsuarioBean;
import maristas.dao.MysqlActividadDAO;
import maristas.dao.planDAO;
import maristas.dao.usuarioDAO;
import maristas.factoria.DAOFactory;
import maristas.interfaces.PlanOperativoDAO;

/**
 *
 * @author Aldair
 */
public class PlanOperativoServlet extends HttpServlet {
    PlanOperativoBean objPlanPr = null, objPlanPr2 = null;
    DAOFactory objDAOFactory = null;
    PlanOperativoDAO objPlanPrDAO = null;
    ArrayList<PlanOperativoBean> plans = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
      
    }
       
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String pagina = "";
        int op = 5;
        if(request.getParameter("option") != null) {
            op = Integer.parseInt(request.getParameter("option"));
        }
        
        int estado = 0;
        
        objDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        objPlanPrDAO = objDAOFactory.getPlanOperativoDAO();
        
        try {
            switch(op) {
                //IR VISTA PARA CREAR PLAN PLESUPUESTAL
                case 1: {
                    pagina="/views/PlanOperativo/CreatePlanOperativo.jsp";
                    MysqlUnidadOrganicaDAO i_s2 = new MysqlUnidadOrganicaDAO();
                    ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                    request.setAttribute("areas", Areas);

                    usuarioDAO i_s3 = new usuarioDAO();
                    ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
                    break;
                }
                //IR VISTA ACTIVIDADES DE DETERMINADO PLAN PRESUPUESTAL
                case 2: {
                    pagina="/views/PlanOperativo/EscogerActividades.jsp";
                    int id_plan_operativo = Integer.parseInt(request.getParameter("id_plan_operativo"));
                    objPlanPr = new PlanOperativoBean();
                    objPlanPr.setId(id_plan_operativo);

                    MysqlActividadDAO i_s = new MysqlActividadDAO();
                    ArrayList<ActividadBean> actividades = i_s.getActividad(objPlanPr);
                    request.setAttribute("actividad", actividades);
                    
                    objPlanPr2 = new PlanOperativoBean();
                    objPlanPr2 = objPlanPrDAO.getPlanO(objPlanPr);
                    request.setAttribute("planO", objPlanPr2);
                    
                    planDAO i_s4 = new planDAO();
                    ArrayList<PlanEstrategicoBean> plansE = i_s4.GetPlans();
                    request.setAttribute("plansE", plansE);
                    break;
                }
                //IR VISTA EDITAR DE DETERMINADO PLAN PRESUPUESTAL
                case 3: {
                    pagina="/views/PlanOperativo/editPlanOperativo.jsp";
                    int id_plan_operativo = Integer.parseInt(request.getParameter("id"));
                    objPlanPr = new PlanOperativoBean();
                    objPlanPr.setId(id_plan_operativo);
                    
                    objPlanPr2 = new PlanOperativoBean();
                    objPlanPr2 = objPlanPrDAO.getPlanO(objPlanPr);
                    request.setAttribute("planO", objPlanPr2);

                    MysqlUnidadOrganicaDAO i_s2 = new MysqlUnidadOrganicaDAO();
                    ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                    request.setAttribute("areas", Areas);

                    usuarioDAO i_s3 = new usuarioDAO();
                    ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
                    break;
                }
                //ELIMINAR DE DETERMINADO PLAN PRESUPUESTAL
                case 4: {
                    pagina="/views/PlanOperativo/JefeArea.jsp";
                    
                    int id_plan_operativo = Integer.parseInt(request.getParameter("id_plan_operativo"));
                    objPlanPr = new PlanOperativoBean();
                    objPlanPr.setId(id_plan_operativo);
                    estado  = objPlanPrDAO.EliminarPlanOperativo(objPlanPr);
                    ArrayList<PlanOperativoBean> planope = objPlanPrDAO.getPlansO();
                    request.setAttribute("plansO", planope);

                    MysqlUnidadOrganicaDAO i_s2 = new MysqlUnidadOrganicaDAO();
                    ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                    request.setAttribute("areas", Areas);

                    usuarioDAO i_s3 = new usuarioDAO();
                    ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);

                    planDAO i_s4 = new planDAO();
                    ArrayList<PlanEstrategicoBean> plansE = i_s4.GetPlans();
                    request.setAttribute("plansE", plansE);
                    
                    if(estado == 1){
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje", "Se elimino correctamente.");
                    }else {
                        request.setAttribute("status", "fail");
                        request.setAttribute("mensaje", "Hubo un error al momento de eliminar.");
                    }
                    break;
                }
                case 5: {
                    //Mostrar vista lista plans
                    pagina="/views/PlanOperativo/JefeArea.jsp";
                    ArrayList<PlanOperativoBean> planope = objPlanPrDAO.getPlansO();
                    request.setAttribute("plansO", planope);

                    MysqlUnidadOrganicaDAO i_s2 = new MysqlUnidadOrganicaDAO();
                    ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                    request.setAttribute("areas", Areas);

                    usuarioDAO i_s3 = new usuarioDAO();
                    ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);

                    planDAO i_s4 = new planDAO();
                    ArrayList<PlanEstrategicoBean> plansE = i_s4.GetPlans();
                    request.setAttribute("plansE", plansE);  
                    break;
                }
            }
        } catch (Exception ex) {}
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String pagina = "";
        int op = Integer.parseInt(request.getParameter("option"));
        int estado = 0;
        
        objDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        objPlanPrDAO = objDAOFactory.getPlanOperativoDAO();
        
      try {
            switch(op) {
                // CREAR
                case 1: {
                    pagina="/views/PlanOperativo/JefeArea.jsp";
                    String nombre = request.getParameter("nombre");
                    String descripcion = request.getParameter("descripcion");
                    int id_encargado = Integer.parseInt(request.getParameter("id_encargado"));
                    int id_unidad_org = Integer.parseInt(request.getParameter("id_unidad_org"));

                    objPlanPr = new PlanOperativoBean();
                    objPlanPr.setNombre(nombre);
                    objPlanPr.setDescripcion(descripcion);
                    objPlanPr.setId_encargado(id_encargado);
                    objPlanPr.setId_unidad_organica(id_unidad_org);
                    estado = objPlanPrDAO.InsertarPlanOp(objPlanPr);
                    
                    ArrayList<PlanOperativoBean> planope = objPlanPrDAO.getPlansO();
                    request.setAttribute("plansO", planope);

                    MysqlUnidadOrganicaDAO i_s2 = new MysqlUnidadOrganicaDAO();
                    ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                    request.setAttribute("areas", Areas);

                    usuarioDAO i_s3 = new usuarioDAO();
                    try {
                        ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                        request.setAttribute("usuarios", usuarios);
                    } catch (Exception ex) {}

                    planDAO i_s4 = new planDAO();
                    ArrayList<PlanEstrategicoBean> plansE = i_s4.GetPlans();
                    request.setAttribute("plansE", plansE);
                    
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
                    int id_plan_estrategico = 1;
                    String nombre = request.getParameter("nombre");
                    String descripcion = request.getParameter("descripcion");
                    int id_encargado = Integer.parseInt(request.getParameter("id_encargado"));
                    int id_unidad_org = Integer.parseInt(request.getParameter("id_unidad_org"));
                    if(request.getParameter("id_plan_estrategico") != null){
                        id_plan_estrategico = Integer.parseInt(request.getParameter("id_plan_estrategico"));
                    }
                    int id = Integer.parseInt(request.getParameter("id"));
                    
                    objPlanPr = new PlanOperativoBean();
                    objPlanPr.setNombre(nombre);
                    objPlanPr.setDescripcion(descripcion);
                    objPlanPr.setId_encargado(id_encargado);
                    objPlanPr.setId_unidad_organica(id_unidad_org);
                    objPlanPr.setId_plan_estrategico(id_plan_estrategico);
                    objPlanPr.setId(id);
                           
                    estado = objPlanPrDAO.ActualizarPlanOperativo(objPlanPr);
                    
                    objPlanPr2 = new PlanOperativoBean();
                    objPlanPr2 = objPlanPrDAO.getPlanO(objPlanPr);
                    request.setAttribute("planO", objPlanPr2);

                    MysqlUnidadOrganicaDAO i_s2 = new MysqlUnidadOrganicaDAO();
                    ArrayList<UnidadOrganicaBean> Areas = i_s2.lista();
                    request.setAttribute("areas", Areas);

                    usuarioDAO i_s3 = new usuarioDAO();
                    ArrayList<UsuarioBean> usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
                    
                    if(estado ==1) {
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se actualizo satisfactoriamente.");
                    }
                    else{
                        request.setAttribute("status", "fail"); 
                        request.setAttribute("mensaje","Hubo un error al momento de la actualizacion.");
                    }
                    break;
                  }
            }
      } catch (Exception ex) {}
            
            getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

