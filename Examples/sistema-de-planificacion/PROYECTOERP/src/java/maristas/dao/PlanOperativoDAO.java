
package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.PlanOperativoBean;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanOperativoDAO {
    
    ArrayList<PlanOperativoBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<PlanOperativoBean> getPlanO(){
       lista = new ArrayList<PlanOperativoBean>();
       
       try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, nombre,"
                    + " descripcion, id_plan_estrategico,"
                    + " id_encargado, id_unidad_org"
                    + " from PlanOperativo");

            rs=pt.executeQuery();


            while(rs.next()){
                PlanOperativoBean objPlanOp=new PlanOperativoBean();

                objPlanOp.setId(rs.getInt(2));
                objPlanOp.setNombre(rs.getString(3));
                objPlanOp.setDescripcion(rs.getString(4));
                objPlanOp.setId_plan_estrategico(rs.getInt(5));
                objPlanOp.setId_encargado(rs.getInt(6));
                objPlanOp.setId_unidad_organica(rs.getInt(7));

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
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into PlanOperativo(id,nombre,descripcion,id_plan_estrategico,id_encargado,id_unidad_org)" +
                    "values('?,?,?,?,?,?,?)");
            pt.setInt(2, objPlanOp.getId());
            pt.setString(3, objPlanOp.getNombre());
            pt.setString(4, objPlanOp.getDescripcion());
            pt.setInt(5, objPlanOp.getId_plan_estrategico());
            pt.setInt(6, objPlanOp.getId_encargado());
            pt.setInt(7, objPlanOp.getId_unidad_organica());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){           
        }
        return estado;
    }
}
