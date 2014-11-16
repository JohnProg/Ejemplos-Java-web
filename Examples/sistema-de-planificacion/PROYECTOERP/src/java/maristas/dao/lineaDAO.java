
package maristas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import maristas.beans.LineaBean;
import maristas.conexion.connectionBD;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class lineaDAO {
    ArrayList<LineaBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
   
   public ArrayList<LineaBean> get_queryset(){
       lista = new ArrayList<LineaBean>();
       
       try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select l.id,"
                    + " l.id_plan_estrategico,"
                    + " p.nombre as nombre_plan,"
                    + " l.nombre as nombre_linea,"
                    + " l.descripcion"
                    + " from Linea l"
                    + " inner join PlanEstrategico"
                    + " p on p.id = l.id_plan_estrategico");

            rs=pt.executeQuery();

            while(rs.next()){
                LineaBean objLinea=new LineaBean();
                objLinea.setId(rs.getInt(1));
                objLinea.setNombre(rs.getString(3));
                objLinea.setDescripcion(rs.getString(4));
                lista.add(objLinea);                            
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
    
   public JSONArray get_lineas() throws SQLException{
        //Se obtiene el resultado de la consulta
        lista = new ArrayList<LineaBean>();
        lista = get_queryset();

        JSONArray json_list = new JSONArray();
        
        JSONObject json_obj=new JSONObject();
        
        for(LineaBean obj:lista) {
            Map mapa=new LinkedHashMap();
            mapa.put("id",obj.getId());
            mapa.put("name",obj.getNombre());
            mapa.put("plan_estrategico",obj.getId_plan());
            mapa.put("descripcion",obj.getDescripcion());
            json_list.add(mapa);
        }
         System.out.print(json_list);
        
        return json_list;
    }
    
    public int InsertarPlan(LineaBean objLinea) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into Linea(id_plan_estrategico, nombre, descripcion) values(?, ?, ?)");
            pt.setInt(1, objLinea.getId_plan());
            pt.setString(2, objLinea.getNombre());
            pt.setString(3, objLinea.getDescripcion());
    
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    public int ActualizarPlan(LineaBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("update Linea set "
                    + " nombre = ?,"
                    + " id_plan_estrategico=?,"
                    + " descripcion=?,"
                    + " where id = ?");
            pt.setInt(1, objPlan.getId_plan());
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
    public int EliminarLinea(LineaBean objLinea) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("delete Linea where id=?");
            pt.setInt(1, objLinea.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
}