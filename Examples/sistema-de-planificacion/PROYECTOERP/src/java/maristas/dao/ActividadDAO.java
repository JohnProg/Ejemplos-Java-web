
package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.ActividadBean;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;


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
    
    public JSONArray get_Actividad() throws SQLException{
        //Se obtiene el resultado de la consulta
        lista = new ArrayList<ActividadBean>();
        lista = get_queryset();

        JSONArray json_list = new JSONArray();
        
        JSONObject json_obj=new JSONObject();
        
        for(ActividadBean obj:lista) {
            Map mapa=new LinkedHashMap();
            mapa.put("id",obj.getId());
            mapa.put("id_plan_operativo",obj.getId_plan_operativo());
            mapa.put("nombre",obj.getNombre());
            mapa.put("gastos",obj.getGastos());
            mapa.put("ingresos",obj.getIngresos());
            mapa.put("id_sub_objetivo",obj.getId_sub_objetivo());
            mapa.put("id_presupuesto",obj.getId_presupuesto());
            
            ;
            
            json_list.add(mapa);
        }
         System.out.print(json_list);
        
        return json_list;
    }
    
}
