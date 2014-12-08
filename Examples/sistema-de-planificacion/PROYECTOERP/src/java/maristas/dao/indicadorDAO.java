
package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.IndicadoresBean;
import java.sql.*;
import java.util.ArrayList;

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
    
}
