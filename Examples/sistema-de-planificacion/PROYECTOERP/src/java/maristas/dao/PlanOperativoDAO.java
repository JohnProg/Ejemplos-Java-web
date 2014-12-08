
package maristas.dao;

import java.sql.*;
import java.util.ArrayList;
import maristas.beans.PlanOperativoBean;
import maristas.conexion.conecctionBDMysql;

public class PlanOperativoDAO {
    
    ArrayList<PlanOperativoBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<PlanOperativoBean> getPlanO(){
       lista = new ArrayList<PlanOperativoBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, nombre,"
                    + " descripcion, id_plan_estrategico,"
                    + " id_encargado, id_unidad_org"
                    + " from PlanOperativo");

            rs=pt.executeQuery();


            while(rs.next()){
                PlanOperativoBean objPlanOp=new PlanOperativoBean();

                objPlanOp.setId(rs.getInt(1));
                objPlanOp.setNombre(rs.getString(2));
                objPlanOp.setDescripcion(rs.getString(3));
                objPlanOp.setId_plan_estrategico(rs.getInt(4));
                objPlanOp.setId_encargado(rs.getInt(5));
                objPlanOp.setId_unidad_organica(rs.getInt(6));

                lista.add(objPlanOp);                            
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
   
   public int InsertarPlanOp(PlanOperativoBean objPlanOp) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into planoperativo(nombre, id_unidad_org) values(?,?)");
            pt.setString(1, objPlanOp.getNombre());        
            pt.setInt(2, objPlanOp.getId_unidad_organica());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
            return estado;
        } catch(Exception e){  
            return estado;
        }
        
    }
   
   public int ActualizarPlanOperativo(PlanOperativoBean objPlanOp) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();     
            pt=cnn.prepareStatement("update planoperativo set "
                    + " nombre = ?,"
                    + " id_unidad_org = ?,"
                    + " where id = ?");
            pt.setString(1, objPlanOp.getNombre());
            pt.setInt(2, objPlanOp.getId_unidad_organica());
            
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
            return estado;
        } catch(Exception e){
            return estado;
        }
    }

    public int EliminarPlanOperativo(int id) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();    
            pt=cnn.prepareStatement("delete from planoperativo where id=?");
            pt.setInt(1,id);
            estado = pt.executeUpdate();
            pt.close();
            return estado;
        } catch(Exception e){
            return estado;
        }
        
    }
}
