
package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.ActividadBean;
import java.sql.*;
import java.util.ArrayList;
import maristas.beans.PlanOperativoBean;
import maristas.conexion.conecctionBDMysql;
import maristas.interfaces.ActividadDAO;


public class MysqlActividadDAO implements ActividadDAO{
    
    ArrayList<ActividadBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<ActividadBean> getActividad(PlanOperativoBean objPlanOp){
       lista = new ArrayList<ActividadBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, id_plan_operativo,"
                    + "nombre, gastos,"
                    + "ingresos, id_sub_objetivo,"
                    + "id_presupuesto "
                    + "from actividad where id_plan_operativo = ?");
            pt.setInt(1, objPlanOp.getId());
            rs=pt.executeQuery();


            while(rs.next()){
                ActividadBean objPlan=new ActividadBean();

                objPlan.setId(rs.getInt(1));
                objPlan.setId_plan_operativo(rs.getInt(2));
                objPlan.setNombre(rs.getString(3));
                objPlan.setGastos(rs.getDouble(4));
                objPlan.setIngresos(rs.getDouble(5));
                objPlan.setId_sub_objetivo(rs.getInt(6));
                objPlan.setId_presupuesto(rs.getInt(7));
                

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
            pt=cnn.prepareStatement("INSERT INTO actividad (id_plan_operativo, nombre, gastos, ingresos, id_sub_objetivo, id_presupuesto )" +
                    "values(?,?,?,?,?,?)");
            pt.setInt(1, objPlanOp.getId_plan_operativo());
            pt.setString(2, objPlanOp.getNombre());
            pt.setDouble(3, objPlanOp.getGastos());
            pt.setDouble(4, objPlanOp.getIngresos());
            pt.setInt(5, objPlanOp.getId_sub_objetivo());
            pt.setInt(6, objPlanOp.getId_presupuesto());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){           
        }
        return estado;
    }
    
}
