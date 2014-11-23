
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
import maristas.conexion.conecctionBDMysql;


public class UnidadOrganicaDAO {
    
    ArrayList<UnidadOrganicaBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<UnidadOrganicaBean> lista(){
       lista = new ArrayList<UnidadOrganicaBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id,"
                    + " nombre"
                    + " from UnidadOrganizativa");

            rs=pt.executeQuery();


            while(rs.next()){
                UnidadOrganicaBean objPlan=new UnidadOrganicaBean();

                objPlan.setId(rs.getInt(1));
                objPlan.setNombre(rs.getString(2));

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
