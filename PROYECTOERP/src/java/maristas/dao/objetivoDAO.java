

package maristas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import maristas.beans.ObjetivoBean;
import maristas.conexion.connectionBD;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class objetivoDAO {
    ArrayList<ObjetivoBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
   
   public ArrayList<ObjetivoBean> get_queryset(){
       lista = new ArrayList<ObjetivoBean>();
       
       try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, linea, nombre, descripcion from Objetivo");

            rs=pt.executeQuery();


            while(rs.next()){
                ObjetivoBean objObjetivo=new ObjetivoBean();

                objObjetivo.setNombre(rs.getString(2));
                objObjetivo.setId_linea(rs.getInt(3));
                objObjetivo.setDescripcion(rs.getString(4));

                lista.add(objObjetivo);                            
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
    
   public JSONArray get_objetivos() throws SQLException{
        //Se obtiene el resultado de la consulta
        lista = new ArrayList<ObjetivoBean>();
        lista = get_queryset();

        JSONArray json_list = new JSONArray();
        
        JSONObject json_obj=new JSONObject();
        
        for(ObjetivoBean obj:lista) {
            Map mapa=new LinkedHashMap();
            mapa.put("id",obj.getId());
            mapa.put("nombre",obj.getNombre());
            mapa.put("linea",obj.getId_linea());
            mapa.put("descripcion",obj.getDescripcion());
            json_list.add(mapa);
        }
         System.out.print(json_list);
        
        return json_list;
    }
    
    public int InsertarObjetivo(ObjetivoBean objObjetivo) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into Objetivo(id_linea, nombre, descripcion) values(?,?,?)");
            pt.setInt(1, objObjetivo.getId_linea());
            pt.setString(2, objObjetivo.getNombre());
            pt.setString(3, objObjetivo.getDescripcion());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    public int ActualizarObjetivo(ObjetivoBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("update Objetivo set "
                    + " id_linea = ?,"
                    + " nombre=?,"
                    + " descripcion=?,"
                    + " where id = ?");
            pt.setInt(1, objPlan.getId_linea());
            pt.setString(2, objPlan.getNombre());
            pt.setString(3, objPlan.getDescripcion());
            pt.setInt(4, objPlan.getId());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    public int EliminarObjetivo(ObjetivoBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("delete Objetivo where id=?");
            pt.setInt(1, objPlan.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
    
}
