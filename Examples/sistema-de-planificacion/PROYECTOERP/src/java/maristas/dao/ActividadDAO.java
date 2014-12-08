
package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.ActividadBean;
import java.sql.*;
import java.util.ArrayList;


public class ActividadDAO {
    
    ArrayList<ActividadBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<ActividadBean> get_queryset(){
       lista = new ArrayList<ActividadBean>();
       
       try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, id_plan_operativo,"
                    + "nombre, gastos,"
                    + "ingresos,"
                    + "id_sub_objetivo, id_presupuesto"
                    + "from actividad");

            rs=pt.executeQuery();


            while(rs.next()){
                ActividadBean objPlan=new ActividadBean();

                objPlan.setId(rs.getInt(2));
                objPlan.setId_plan_operativo(rs.getInt(3));
                objPlan.setNombre(rs.getString(4));
                objPlan.setGastos(rs.getDouble(5));
                objPlan.setIngresos(rs.getDouble(6));
                objPlan.setId_sub_objetivo(rs.getInt(7));
                objPlan.setId_presupuesto(rs.getInt(8));

                lista.add(objPlan);                            
            }
            rs.close();
            pt.close();
            cnn.close();
            return lista;
       } 
       catch(Exception e){
           return lista;
       }
   }
    
}
