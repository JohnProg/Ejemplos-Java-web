
package maristas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import maristas.beans.ObjetivoBean;
import maristas.beans.PresupuestoBean;
import maristas.conexion.conecctionBDMysql;
import maristas.conexion.connectionBD;
import maristas.interfaces.PresupuestoDAO;

public class MysqlPresupuestoDAO implements PresupuestoDAO{
    ArrayList<PresupuestoBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<PresupuestoBean> ListaPlanPr(){
       lista = new ArrayList<PresupuestoBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, nombre,"
                    + " monto, fecha_inicio,"
                    + " fecha_final"
                    + " from PlanPresupuestal");

            rs=pt.executeQuery();


            while(rs.next()){
                PresupuestoBean objPlanP = new PresupuestoBean();

                objPlanP.setId(rs.getInt(1));
                objPlanP.setNombre(rs.getString(2));
                objPlanP.setMonto(rs.getFloat(3));
                objPlanP.setFecha_inicio(rs.getString(4));
                objPlanP.setFecha_final(rs.getString(5));

                lista.add(objPlanP);                            
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
    public PresupuestoBean obtenerPlanPr(PresupuestoBean objPlanP){
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, nombre,"
                    + " monto, fecha_inicio,"
                    + " fecha_final"
                    + " from PlanPresupuestal where id = ?");
            pt.setInt(1, objPlanP.getId());
            rs=pt.executeQuery();


            if(rs.next()){
                
                objPlanP.setId(rs.getInt(1));
                objPlanP.setNombre(rs.getString(2));
                objPlanP.setMonto(rs.getFloat(3));
                objPlanP.setFecha_inicio(rs.getString(4));
                objPlanP.setFecha_final(rs.getString(5));
                           
            }
            rs.close();
            pt.close();
            cnn.close();
            return objPlanP;
       } 
       catch(Exception e){
           return objPlanP;
       }
   }
   
   public int InsertarPlanPr(PresupuestoBean objPlanP) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into PlanPresupuestal(nombre,monto,fecha_inicio,fecha_final)" +
                    "values(?,?,?,?)");            
            pt.setString(1, objPlanP.getNombre());
            pt.setFloat(2, objPlanP.getMonto());
            pt.setString(3, objPlanP.getFecha_inicio());
            pt.setString(4, objPlanP.getFecha_final());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
            return estado;
        } catch(Exception e){           
            return estado;
        }
        
    }
   public int ActualizaPlanPr(PresupuestoBean objPlanP) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("update PlanPresupuestal set "
                    + " nombre = ?,"
                    + " monto=?,"
                    + " fecha_inicio=?,"
                    + " fecha_final=? "
                    + " where id = ?");
            pt.setString(1, objPlanP.getNombre());
            pt.setFloat(2, objPlanP.getMonto());
            pt.setString(3, objPlanP.getFecha_inicio());
            pt.setString(4, objPlanP.getFecha_final());
            pt.setInt(5, objPlanP.getId());            
            
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
            return estado;
        } catch(Exception e){
            return estado;
        }
    }
    public int EliminarPlanPr(PresupuestoBean objPlanP) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("delete from PlanPresupuestal where id=?");
            pt.setInt(1, objPlanP.getId());
            estado = pt.executeUpdate();
            pt.close();
            return estado;
        } catch(Exception e){
            return estado;
        }
        
    }
}
