
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
    
    public ArrayList<PlanOperativoBean> get_queryset(){
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
                PlanOperativoBean objPlan=new PlanOperativoBean();

                objPlan.setId(rs.getInt(2));
                objPlan.setNombre(rs.getString(3));
                objPlan.setDescripcion(rs.getString(4));
                objPlan.setId_plan_estrategico(rs.getInt(5));
                objPlan.setId_encargado(rs.getInt(6));
                objPlan.setId_unidad_organica(rs.getInt(7));

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
    
    public JSONArray get_Planoperativo() throws SQLException{
        //Se obtiene el resultado de la consulta
        lista = new ArrayList<PlanOperativoBean>();
        lista = get_queryset();

        JSONArray json_list = new JSONArray();
        
        JSONObject json_obj=new JSONObject();
        
        for(PlanOperativoBean obj:lista) {
            Map mapa=new LinkedHashMap();
            mapa.put("id",obj.getId());
            mapa.put("nombre",obj.getNombre());
            mapa.put("descripcion",obj.getDescripcion());
            mapa.put("id_plan_estrategico",obj.getId_plan_estrategico());
            mapa.put("id_encargado",obj.getId_encargado());
            mapa.put("id_unidad_org",obj.getId_unidad_organica());
            ;
            
            json_list.add(mapa);
        }
         System.out.print(json_list);
        
        return json_list;
    }
}
