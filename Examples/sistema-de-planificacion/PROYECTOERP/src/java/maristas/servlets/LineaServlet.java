
package maristas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maristas.beans.LineaBean;
import maristas.dao.lineaDAO;

public class LineaServlet extends HttpServlet {

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
            lineaDAO i_s = new lineaDAO();
            ArrayList<LineaBean> lineaobj = i_s.GetLineas(Integer.parseInt(request.getParameter("id_plan")));
            request.setAttribute("id_plan",request.getParameter("id_plan"));
            request.setAttribute("lineas", lineaobj);
        }  
        // Mostrar vista crear
        if(option == 2) {
            request.setAttribute("id_plan", request.getParameter("id_plan"));
            pagina="/views/planEstrategico/linea/createLinea.jsp";
        }
        //Mostrar vista actualizar plans
        if(option == 3) {
            pagina="/views/planEstrategico/linea/updateLinea.jsp";
        }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcad = request.getParameter("option"),
        pagina = "";
        int estado = 0;
        int op;
        op = Integer.parseInt(opcad);
        
        switch (op) {
            case 1: {
                    pagina = "/views/planEstrategico/linea/createLinea.jsp";
                    int id_plan=Integer.parseInt(request.getParameter("id_plan"));
                    String nombre=request.getParameter("nombre");
                    String descripcion=request.getParameter("descripcion");
                    LineaBean objLineaBean=new LineaBean();
                                objLineaBean.setId_plan(id_plan);
                                objLineaBean.setNombre(nombre);
                                objLineaBean.setDescripcion(descripcion);
                    lineaDAO  objLineaDAO=new lineaDAO();
                    estado=objLineaDAO.InsertarPlan(objLineaBean);

                    //verificar estado de la insercion
                    if(estado ==1) {
                        request.setAttribute("id_plan", request.getParameter("id_plan"));
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se creo satisfactoriamente.");
                    }
                    else{
                        request.setAttribute("id_plan", request.getParameter("id_plan"));
                        request.setAttribute("status", "fail"); 
                        request.setAttribute("mensaje","Hubo un error al momento de creacion.");
                    }
                    break;
            }
            case 2: { 
                    pagina = "/views/planEstrategico/linea/updateLinea.jsp";
                    int id = Integer.parseInt(request.getParameter("id"));
                    int id_plan=Integer.parseInt(request.getParameter("id_plan"));
                    String nombre=request.getParameter("nombre");
                    String descripcion=request.getParameter("descripcion");

                    LineaBean objLineaBean=new LineaBean();
                                objLineaBean.setNombre(nombre);
                                objLineaBean.setId_plan(id_plan);
                                objLineaBean.setDescripcion(descripcion);
                                objLineaBean.setId(id);
                    lineaDAO  objLineaDAO=new lineaDAO();
                    estado=objLineaDAO.ActualizarPlan(objLineaBean);
                    //verificar estado de la actualizacion
                    if(estado ==1) {
                        request.setAttribute("id_plan", request.getParameter("id_plan"));
                        request.setAttribute("status", "ok");
                        request.setAttribute("mensaje","Se actualizo satisfactoriamente.");
                    }
                    else{
                        request.setAttribute("id_plan", request.getParameter("id_plan"));
                        request.setAttribute("status", "fail"); 
                        request.setAttribute("mensaje","Hubo un error al momento de actualizar.");
                    }
                    break;
            }
            case 3: { 
                    pagina = "/views/planEstrategico/objetivo/listLinea.jsp";
                    int id = Integer.parseInt(request.getParameter("id"));
                    LineaBean objLineaBean=new LineaBean();
                              objLineaBean.setId(id);
                    lineaDAO  objLineaDAO=new lineaDAO();
                    estado = objLineaDAO.EliminarLinea(objLineaBean);
                    //verificar estado de la eliminacion
                    if(estado == 1) {
                        request.setAttribute("id_plan", request.getParameter("id_plan"));
                        request.setAttribute("status", "ok"); 
                        request.setAttribute("mensaje","Se elimino correctamente.");
                    }
                    else {
                        request.setAttribute("id_plan", request.getParameter("id_plan"));
                        request.setAttribute("status", "fail"); 
                        request.setAttribute("mensaje","Hubo un error al momento de eliminar.");
                    }
                    break;
            }
            case 5: {
                    //variables
                    pagina = "/views/planEstrategico/objetivo/listObjetivo.jsp";
                    
                    lineaDAO i_s = new lineaDAO();
                    ArrayList<LineaBean> lineas = i_s.GetLineas(Integer.parseInt(request.getParameter("id_plan")));
                    request.setAttribute("lineas", lineas); 
                    request.setAttribute("id_plan", request.getParameter("id_plan"));
            }
        }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
