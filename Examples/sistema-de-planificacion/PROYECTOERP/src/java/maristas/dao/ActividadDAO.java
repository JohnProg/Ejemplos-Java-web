
package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.ActividadBean;
import java.sql.*;
import java.util.ArrayList;
import maristas.conexion.conecctionBDMysql;


public class ActividadDAO {
    
    ArrayList<ActividadBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<ActividadBean> getActividad(){
       lista = new ArrayList<ActividadBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, id_plan_operativo,"
                    + "nombre, gastos,"
                    + "ingresos, id_sub_objetivo,"
                    + "id_presupuesto, descripcion"
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
                objPlan.setDescripcion(rs.getString(9));
                

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
    
   public int InsertarActividad(ActividadBean objPlanOp) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("INSERT INTO actividad (id_plan_operativo, nombre, gastos, ingresos, id_sub_objetivo, id_presupuesto, descripcion )" +
                    "values(?,?,?,?,?,?,?)");
            pt.setInt(1, objPlanOp.getId_plan_operativo());
            pt.setString(2, objPlanOp.getNombre());
            pt.setDouble(3, objPlanOp.getGastos());
            pt.setDouble(4, objPlanOp.getIngresos());
            pt.setInt(5, objPlanOp.getId_sub_objetivo());
            pt.setInt(6, objPlanOp.getId_presupuesto());
            pt.setString(7, objPlanOp.getDescripcion());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){           
        }
        return estado;
    }
    
}
