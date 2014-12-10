
package maristas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maristas.beans.SubObjetivoBean;
import maristas.dao.subObjetivoDAO;


public class SubObjetivoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pagina="/views/planEstrategico/linea/listLinea.jsp";
        int option = 0;
        if(request.getParameter("option") != null) {
            option = Integer.parseInt(request.getParameter("option"));
        }
        
        //Mostrar vista lista plans
        if(option == 1) {
            pagina="/views/planEstrategico/linea/listLinea.jsp";
            subObjetivoDAO i_s = new subObjetivoDAO();
            ArrayList<SubObjetivoBean> lineaobj = i_s.GetSubObjetivos(Integer.parseInt(request.getParameter("id_plan")));
            request.setAttribute("id_objetivo",request.getParameter("id_objetivo"));
            request.setAttribute("sub_objetivos", lineaobj);
        }  
        // Mostrar vista crear
        if(option == 2) {
            request.setAttribute("id_objetivo", request.getParameter("id_objetivo"));
            pagina="/views/planEstrategico/subobjetivo/createSubObjetivo.jsp";
        }
        //Mostrar vista actualizar plans
        if(option == 3) {
            pagina="/views/planEstrategico/subobjetivo/updateSubObjetivo.jsp";
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
        
        switch (op) {
            case 1: {
                    pagina = "/views/planEstrategico/sub_objetivo/createSubObjetivo.jsp";
                    int id_objetivo=Integer.parseInt(request.getParameter("id_objetivo"));
                    String nombre=request.getParameter("nombre");
                    String descripcion=request.getParameter("descripcion");
                    SubObjetivoBean objSubObjetivoBean=new SubObjetivoBean();
                                objSubObjetivoBean.setId_objetivo(id_objetivo);
                                objSubObjetivoBean.setNombre(nombre);
                                objSubObjetivoBean.setDescripcion(descripcion);
                    subObjetivoDAO  objSubObjetivoDAO=new subObjetivoDAO();
                    estado=objSubObjetivoDAO.InsertarObjetivo(objSubObjetivoBean);

                    //verificar estado de la insercion
                    if(estado ==1) {
                        request.setAttribute("id_objetivo", request.getParameter("id_objetivo"));
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se creo satisfactoriamente.");
                    }
                    else{
                      request.setAttribute("id_objetivo", request.getParameter("id_objetivo"));
                      request.setAttribute("status", "fail"); 
                      request.setAttribute("mensaje","Hubo un error al momento de creacion.");
                    }
                    break;
            }
            case 2: { 
                    pagina = "/views/planEstrategico/objetivo/updateSubObjetivo.jsp";
                    int id = Integer.parseInt(request.getParameter("id"));
                    int id_objetivo=Integer.parseInt(request.getParameter("id_objetivo"));
                    String nombre=request.getParameter("nombre");
                    String descripcion=request.getParameter("descripcion");

                    SubObjetivoBean objSubObjetivoBean=new SubObjetivoBean();
                                objSubObjetivoBean.setNombre(nombre);
                                objSubObjetivoBean.setId_objetivo(id_objetivo);
                                objSubObjetivoBean.setDescripcion(descripcion);
                                objSubObjetivoBean.setId(id);
                    subObjetivoDAO  objObjetivoDAO=new subObjetivoDAO();
                    estado=objObjetivoDAO.ActualizarObjetivo(objSubObjetivoBean);
                    //verificar estado de la actualizacion
                    if(estado ==1) {
                        request.setAttribute("id_objetivo", request.getParameter("id_objetivo"));
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se actualizo satisfactoriamente.");
                    }
                    else{
                      request.setAttribute("id_objetivo", request.getParameter("id_objetivo"));
                      request.setAttribute("status", "fail"); 
                      request.setAttribute("mensaje","Hubo un error al momento de actualizar.");
                    }
                    break;
            }
            case 3: { 
                    pagina = "/views/planEstrategico/sub_objetivo/listSubObjetivo.jsp";
                    int id = Integer.parseInt(request.getParameter("id"));
                    SubObjetivoBean objSubObjetivoBean=new SubObjetivoBean();
                                 objSubObjetivoBean.setId(id);
                    subObjetivoDAO  objSubObjetivoDAO=new subObjetivoDAO();
                    estado = objSubObjetivoDAO.EliminarObjetivo(objSubObjetivoBean);
                    //verificar estado de la eliminacion
                    if(estado == 1) {
                        request.setAttribute("id_objetivo", request.getParameter("id_objetivo"));
                        request.setAttribute("status", "ok"); 
                        request.setAttribute("mensaje","Se elimino correctamente.");
                    }
                    else {
                        request.setAttribute("id_objetivo", request.getParameter("id_objetivo"));
                        request.setAttribute("status", "fail"); 
                        request.setAttribute("mensaje","Hubo un error al momento de eliminar.");
                    }
                    break;
            }
            case 5: {
                    //variables
                    pagina = "/views/planEstrategico/sub_objetivo/listSubObjetivo.jsp";

                    subObjetivoDAO i_s = new subObjetivoDAO();
                    ArrayList<SubObjetivoBean> objetivos = i_s.GetSubObjetivos(Integer.parseInt(request.getParameter("id_objetivo")));
                    request.setAttribute("sub_objetivos", objetivos);  
            }
        }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
