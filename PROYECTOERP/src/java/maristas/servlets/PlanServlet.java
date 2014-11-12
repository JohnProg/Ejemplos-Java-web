

package maristas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maristas.beans.PlanEstrategicoBean;
import maristas.dao.planDAO;

public class PlanServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*Opcion del POST
            1: Crear
            2: Actualizar
            3: Eliminar
        */
        
        String opcad=request.getParameter("op");
        int estado = 0;
        
        
        int op=Integer.parseInt(opcad);
        String pagina="";
        switch (op)
        {
            case 1:
            { 
                pagina="/views/rest/plan/response.jsp";
                String nombre=request.getParameter("nombre");
                String fec_vigencia=request.getParameter("fec_vigencia");
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
                planDAO  objPlanDAO=new planDAO();
                estado=objPlanDAO.InsertarPlan(objPlanBean);
                break;
            }
            case 2:
            { 
                pagina="/views/rest/plan/response.jsp";
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre=request.getParameter("nombre");
                String fec_vigencia=request.getParameter("fec_vigencia");
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
                break;
            }
            case 3:
            { 
                pagina="/views/rest/plan/response.jsp";
                int id = Integer.parseInt(request.getParameter("id"));
                PlanEstrategicoBean objPlanBean=new PlanEstrategicoBean();
                                    objPlanBean.setId(id);
                planDAO  objPlanDAO=new planDAO();
                estado = objPlanDAO.EliminarPlan(objPlanBean);
                break;
            }
        }
        if(estado ==1)
            request.setAttribute("status","ok");
        else
            request.setAttribute("status","fail");
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
