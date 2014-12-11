

package maristas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maristas.beans.PlanEstrategicoBean;
import maristas.beans.UsuarioBean;
import maristas.dao.planDAO;
import maristas.dao.usuarioDAO;

public class PlanEstrategicoServlet extends HttpServlet {
    PlanEstrategicoBean objPlE = null, objPlE2 = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //variables
        
        String pagina="/views/planEstrategico/listPlan.jsp";
        int option = 0;
        int estado = 0;
        if(request.getParameter("option") != null) {
            option = Integer.parseInt(request.getParameter("option"));
        }
        try {
            // Mostrar vista crear
            if(option == 1) {
                pagina="/views/planEstrategico/createPlan.jsp";
                usuarioDAO i_s3 = new usuarioDAO();
                ArrayList<UsuarioBean> usuarios;
                usuarios = i_s3.getUsers();
                request.setAttribute("usuarios", usuarios);
            } 
            else if(option == 2) {
                pagina="/views/planEstrategico/listPlan.jsp";
                int id = Integer.parseInt(request.getParameter("id_plan"));
                planDAO i_s = new planDAO();
                
                objPlE = new PlanEstrategicoBean();
                objPlE.setId(id);
                estado = i_s.EliminarPlan(objPlE);
                 if(estado ==1) {
                    request.setAttribute("status", "ok");
                    request.setAttribute("mensaje","Se elimino satisfactoriamente.");
                }
                else{
                  request.setAttribute("status", "fail"); 
                  request.setAttribute("mensaje","Hubo un error al momento de eliminar.");
                }
                 
                ArrayList<PlanEstrategicoBean> planope = i_s.GetPlans();
                request.setAttribute("plans", planope);

                usuarioDAO i_s3 = new usuarioDAO();
                ArrayList<UsuarioBean> usuarios;
                usuarios = i_s3.getUsers();
                request.setAttribute("usuarios", usuarios);
            }
            else if(option == 3) {
                pagina="/views/planEstrategico/updatePlan.jsp";
                int id = Integer.parseInt(request.getParameter("id_plan"));
                planDAO i_s = new planDAO();
                
                objPlE = new PlanEstrategicoBean();
                objPlE2 = new PlanEstrategicoBean();
                objPlE.setId(id);
                PlanEstrategicoBean objPlE3 = i_s.GetPlan(objPlE);
                request.setAttribute("planE", objPlE3);
                
                usuarioDAO i_s3 = new usuarioDAO();
                ArrayList<UsuarioBean> usuarios;
                usuarios = i_s3.getUsers();
                request.setAttribute("usuarios", usuarios);
            }
            else {
                //Mostrar vista lista plans
                pagina="/views/planEstrategico/listPlan.jsp";
                planDAO i_s = new planDAO();
                ArrayList<PlanEstrategicoBean> planope = i_s.GetPlans();
                request.setAttribute("plans", planope);

                usuarioDAO i_s3 = new usuarioDAO();
                ArrayList<UsuarioBean> usuarios;
                usuarios = i_s3.getUsers();
                request.setAttribute("usuarios", usuarios);
            }
        } catch (Exception ex) {
                Logger.getLogger(PlanEstrategicoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcad = request.getParameter("accion"),
            pagina = "";
        int estado = 0;
        int op;
            if(opcad != null) op = Integer.parseInt(opcad);
            else op = 5;
        try{
        switch (op) {
            case 1: { 
                    pagina = "/views/planEstrategico/createPlan.jsp";
                    String nombre=request.getParameter("nombre");
                    String fec_inicio=request.getParameter("fec_inicio");
                    String fec_termino=request.getParameter("fec_termino");
                    String anio_inicio=request.getParameter("anio_inicio");
                    String anio_termino=request.getParameter("anio_termino");
                    int aprobado_por=Integer.parseInt(request.getParameter("aprobado_por"));
                    String descripcion=request.getParameter("descripcion");
                    PlanEstrategicoBean objPlanBean=new PlanEstrategicoBean();
                                objPlanBean.setNombre(nombre);
                                objPlanBean.setFec_vigencia(fec_inicio);
                                objPlanBean.setFec_termino(fec_termino);
                                objPlanBean.setAnio_inicio(anio_inicio);
                                objPlanBean.setAnio_termino(anio_termino);
                                objPlanBean.setAprobado_por(aprobado_por);
                                objPlanBean.setDescripcion(descripcion);
                    planDAO  objPlanDAO=new planDAO();
                    estado=objPlanDAO.InsertarPlan(objPlanBean);

                    usuarioDAO i_s3 = new usuarioDAO();
                    ArrayList<UsuarioBean> usuarios;
                    usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
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
            case 2: { 

                    pagina = "/views/planEstrategico/updatePlan.jsp";
                    int id = Integer.parseInt(request.getParameter("id_plan"));
                    String nombre=request.getParameter("nombre");
                    String fec_vigencia=request.getParameter("fec_inicio");
                    String fec_termino=request.getParameter("fec_termino");
                    String anio_inicio=request.getParameter("anio_inicio");
                    String anio_termino=request.getParameter("anio_termino");
                    int aprobado_por=Integer.parseInt(request.getParameter("aprobado_por"));
                    String descripcion=request.getParameter("descripcion");

                    PlanEstrategicoBean objPlanBean=new PlanEstrategicoBean();
                                objPlanBean.setNombre(nombre);
                                objPlanBean.setFec_vigencia(fec_vigencia);
                                objPlanBean.setFec_termino(fec_termino);
                                objPlanBean.setAnio_inicio(anio_inicio);
                                objPlanBean.setAnio_termino(anio_termino);
                                objPlanBean.setAprobado_por(aprobado_por);
                                objPlanBean.setDescripcion(descripcion);
                                objPlanBean.setId(id);
                    planDAO  objPlanDAO=new planDAO();
                    estado=objPlanDAO.ActualizarPlan(objPlanBean);
                    
                    objPlE = new PlanEstrategicoBean();
                    objPlE2 = new PlanEstrategicoBean();
                    objPlE.setId(id);
                    PlanEstrategicoBean objPlE3 = objPlanDAO.GetPlan(objPlE);
                    request.setAttribute("planE", objPlE3);
                    
                    usuarioDAO i_s3 = new usuarioDAO();
                    ArrayList<UsuarioBean> usuarios;
                    usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
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
            case 3: { 
                    pagina = "/views/planEstrategico/listPlan.jsp";
                    int id = Integer.parseInt(request.getParameter("id"));
                    PlanEstrategicoBean objPlanBean=new PlanEstrategicoBean();
                                        objPlanBean.setId(id);
                    planDAO  objPlanDAO=new planDAO();
                    estado = objPlanDAO.EliminarPlan(objPlanBean);
                    
                    usuarioDAO i_s3 = new usuarioDAO();
                    ArrayList<UsuarioBean> usuarios;
                    usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
                    
                    //verificar estado de la eliminacion
                    if(estado == 1) {
                        request.setAttribute("status", "ok"); 
                        request.setAttribute("mensaje","Se elimino correctamente.");
                    }
                    else {
                        request.setAttribute("status", "fail"); 
                        request.setAttribute("mensaje","Hubo un error al momento de eliminar.");
                    }
                    break;
            }
            case 5: {
                    //variables
                    pagina="/views/planEstrategico/listPlan.jsp";

                    planDAO i_s = new planDAO();
                    ArrayList<PlanEstrategicoBean> plans = i_s.GetPlans();
                    request.setAttribute("plans", plans);
                    
                    usuarioDAO i_s3 = new usuarioDAO();
                    ArrayList<UsuarioBean> usuarios;
                    usuarios = i_s3.getUsers();
                    request.setAttribute("usuarios", usuarios);
            }
        }
        } catch (Exception ex) {
                Logger.getLogger(PlanEstrategicoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
