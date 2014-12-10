
package maristas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maristas.beans.ObjetivoBean;
import maristas.dao.objetivoDAO;


public class ObjetivoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pagina="/views/planEstrategico/objetivo/listObjetivo.jsp";
        int option = 0;
        if(request.getParameter("option") != null) {
            option = Integer.parseInt(request.getParameter("option"));
        }
        
        //Mostrar vista lista plans
        if(option == 1) {
            pagina="/views/planEstrategico/linea/listObjetivo.jsp";
            objetivoDAO i_s = new objetivoDAO();
            ArrayList<ObjetivoBean> objetivoobj = i_s.GetObjetivos(Integer.parseInt(request.getParameter("id_linea")));
            request.setAttribute("id_linea",request.getParameter("id_linea"));
            request.setAttribute("objetivos", objetivoobj);
        }  
        // Mostrar vista crear
        if(option == 2) {
            request.setAttribute("id_linea", request.getParameter("id_linea"));
            pagina="/views/planEstrategico/linea/createObjetivo.jsp";
        }
        //Mostrar vista actualizar plans
        if(option == 3) {
            pagina="/views/planEstrategico/linea/updateObjetivo.jsp";
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
                    pagina = "/views/planEstrategico/objetivo/createObjetivo.jsp";
                    int id_linea=Integer.parseInt(request.getParameter("id_linea"));
                    String nombre=request.getParameter("nombre");
                    String descripcion=request.getParameter("descripcion");
                    ObjetivoBean objObjetivoBean=new ObjetivoBean();
                                objObjetivoBean.setId_linea(id_linea);
                                objObjetivoBean.setNombre(nombre);
                                objObjetivoBean.setDescripcion(descripcion);
                    objetivoDAO  objObjetivoDAO=new objetivoDAO();
                    estado=objObjetivoDAO.InsertarObjetivo(objObjetivoBean);

                    //verificar estado de la insercion
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
                    pagina = "/views/planEstrategico/objetivo/updateObjetivo.jsp";
                    int id = Integer.parseInt(request.getParameter("id"));
                    int id_linea=Integer.parseInt(request.getParameter("id_linea"));
                    String nombre=request.getParameter("nombre");
                    String descripcion=request.getParameter("descripcion");

                    ObjetivoBean objPlanBean=new ObjetivoBean();
                                objPlanBean.setNombre(nombre);
                                objPlanBean.setId_linea(id_linea);
                                objPlanBean.setDescripcion(descripcion);
                                objPlanBean.setId(id);
                    objetivoDAO  objObjetivoDAO=new objetivoDAO();
                    estado=objObjetivoDAO.ActualizarObjetivo(objPlanBean);
                    //verificar estado de la actualizacion
                    if(estado ==1) {
                        request.setAttribute("id_linea", request.getParameter("id_linea"));
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se actualizo satisfactoriamente.");
                    }
                    else{
                        request.setAttribute("id_linea", request.getParameter("id_linea"));
                      request.setAttribute("status", "fail"); 
                      request.setAttribute("mensaje","Hubo un error al momento de actualizar.");
                    }
                    break;
            }
            case 3: { 
                    pagina = "/views/planEstrategico/objetivo/listObjetivo.jsp";
                    int id = Integer.parseInt(request.getParameter("id"));
                    ObjetivoBean objObjetivoBean=new ObjetivoBean();
                                 objObjetivoBean.setId(id);
                    objetivoDAO  objObjetivoDAO=new objetivoDAO();
                    estado = objObjetivoDAO.EliminarObjetivo(objObjetivoBean);
                    //verificar estado de la eliminacion
                    if(estado == 1) {
                        request.setAttribute("id_linea", request.getParameter("id_linea"));
                        request.setAttribute("status", "ok"); 
                        request.setAttribute("mensaje","Se elimino correctamente.");
                    }
                    else {
                        request.setAttribute("id_linea", request.getParameter("id_linea"));
                        request.setAttribute("status", "fail"); 
                        request.setAttribute("mensaje","Hubo un error al momento de eliminar.");
                    }
                    break;
            }
            case 5: {
                    //variables
                    pagina = "/views/planEstrategico/objetivo/listObjetivo.jsp";

                    objetivoDAO i_s = new objetivoDAO();
                    ArrayList<ObjetivoBean> objetivos = i_s.GetObjetivos(Integer.parseInt(request.getParameter("id_linea")));
                    request.setAttribute("objetivos", objetivos); 
                    request.setAttribute("id_linea", request.getParameter("id_linea"));
            }
        }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
