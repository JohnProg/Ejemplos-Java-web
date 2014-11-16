
package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.IndicadoresBean;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

public class indicadorDAO {
    
    ArrayList<IndicadoresBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<IndicadoresBean> get_queryset(){
       lista = new ArrayList<IndicadoresBean>();
       
       try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, id_actividad,"
                    + " nombre,"
                    + " tipo_logo, logro");

            rs=pt.executeQuery();


            while(rs.next()){
                IndicadoresBean objPlan=new IndicadoresBean();

                objPlan.setId(rs.getInt(2));
                objPlan.setId_actividad(rs.getInt(3));
                objPlan.setNombre(rs.getString(4));
                objPlan.setTipo_logo(rs.getString(5));
                objPlan.setLogo(rs.getString(6));

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
    
    public JSONArray get_Indicadores() throws SQLException{
        //Se obtiene el resultado de la consulta
        lista = new ArrayList<IndicadoresBean>();
        lista = get_queryset();

        JSONArray json_list = new JSONArray();
        
        JSONObject json_obj=new JSONObject();
        
        for(IndicadoresBean obj:lista) {
            Map mapa=new LinkedHashMap();
            mapa.put("id",obj.getId());
            mapa.put("id_actividad",obj.getId_actividad());
            mapa.put("nombre",obj.getNombre());
            mapa.put("tipo_logo",obj.getTipo_logo());
            mapa.put("logro",obj.getLogo());
            ;
            
            json_list.add(mapa);
        }
         System.out.print(json_list);
        
        return json_list;
    }
    
}
