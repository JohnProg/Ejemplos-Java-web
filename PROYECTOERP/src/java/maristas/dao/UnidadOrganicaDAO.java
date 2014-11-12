
package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.UnidadOrganicaBean;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;


public class UnidadOrganicaDAO {
    
    ArrayList<UnidadOrganicaBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<UnidadOrganicaBean> get_queryset(){
       lista = new ArrayList<UnidadOrganicaBean>();
       
       try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id,"
                    + " nombre"
                    + " from UnidadOrganizativa");

            rs=pt.executeQuery();


            while(rs.next()){
                UnidadOrganicaBean objPlan=new UnidadOrganicaBean();

                objPlan.setId(rs.getInt(2));
                objPlan.setNombre(rs.getString(3));

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
    
    public JSONArray get_UnidadOrganica() throws SQLException{
        //Se obtiene el resultado de la consulta
        lista = new ArrayList<UnidadOrganicaBean>();
        lista = get_queryset();

        JSONArray json_list = new JSONArray();
        
        JSONObject json_obj=new JSONObject();
        
        for(UnidadOrganicaBean obj:lista) {
            Map mapa=new LinkedHashMap();
            mapa.put("id",obj.getId());
            mapa.put("nombre",obj.getNombre());
            ;
            
            json_list.add(mapa);
        }
         System.out.print(json_list);
        
        return json_list;
    }
}
