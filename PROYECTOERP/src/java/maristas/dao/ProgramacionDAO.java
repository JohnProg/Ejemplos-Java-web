
package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.ProgramacionBean;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProgramacionDAO {
    
    ArrayList<ProgramacionBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<ProgramacionBean> get_queryset(){
       lista = new ArrayList<ProgramacionBean>();
       
       try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, id_actividad,"
                    + " fecha_inicio, fecha_final"
                    + " from programacion");

            rs=pt.executeQuery();


            while(rs.next()){
                ProgramacionBean objPlan=new ProgramacionBean();

                objPlan.setId(rs.getInt(2));
                objPlan.setId_actividad(rs.getInt(3));
                objPlan.setFecha_inicio(rs.getString(4));
                objPlan.setFecha_final(rs.getString(5));

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
    
    public JSONArray get_programacion() throws SQLException{
        //Se obtiene el resultado de la consulta
        lista = new ArrayList<ProgramacionBean>();
        lista = get_queryset();

        JSONArray json_list = new JSONArray();
        
        JSONObject json_obj=new JSONObject();
        
        for(ProgramacionBean obj:lista) {
            Map mapa=new LinkedHashMap();
            mapa.put("id",obj.getId());
            mapa.put("id_actividad",obj.getId_actividad());
            mapa.put("fecha_inicio",obj.getFecha_inicio());
            mapa.put("fecha_final",obj.getFecha_final());
            ;
            
            json_list.add(mapa);
        }
         System.out.print(json_list);
        
        return json_list;
    }
    
    public int InsertarProgramacion(ProgramacionBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into programacion(id,id_actividad,fecha_inicio,fecha_final)" +
                    "values(?, ?, ?, ?, ?, ?, ?)");
            pt.setInt(1, objPlan.getId());
            pt.setInt(2, objPlan.getId_actividad());
            pt.setString(3, objPlan.getFecha_inicio());
            pt.setString(4, objPlan.getFecha_final());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    public int ActualizarProgramacion(ProgramacionBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("update Planes set "
                    + " id = ?,"
                    + " id_actividad=?,"
                    + " fecha_inicio=?,"
                    + " fecha_termino=?,"
                    + " where id = ?");
            pt.setInt(1, objPlan.getId());
            pt.setInt(2, objPlan.getId_actividad());
            pt.setString(3, objPlan.getFecha_inicio());
            pt.setString(4, objPlan.getFecha_final());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    public int EliminarProgramacion(ProgramacionBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("delete Programacion where id=?");
            pt.setInt(1, objPlan.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
    
}
