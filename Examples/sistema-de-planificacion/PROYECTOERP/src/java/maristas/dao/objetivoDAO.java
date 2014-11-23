

package maristas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import maristas.beans.ObjetivoBean;
import maristas.conexion.connectionBD;


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
