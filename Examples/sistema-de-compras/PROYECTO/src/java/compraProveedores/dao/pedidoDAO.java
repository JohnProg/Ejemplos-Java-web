/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraProveedores.dao;

import compraProveedores.beans.pedidoBean;
import compraProveedores.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class pedidoDAO {
    ArrayList<pedidoBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<pedidoBean> listado(){
       lista = new ArrayList<pedidoBean>();
       
       try{
            Conexion cn = new Conexion();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id_pedido, estado,"
                    + " descripcion, area, fecha_titulo"
                    + " from pedido");

            rs=pt.executeQuery();


            while(rs.next()){
                pedidoBean objPedido = new pedidoBean();

                objPedido.setId_pedido(rs.getInt(1));
                objPedido.setEstado(rs.getBoolean(2));
                objPedido.setDescripcion(rs.getString(3));
                objPedido.setArea(rs.getString(4));
                objPedido.setFecha_titulo(rs.getString(5));
                
                lista.add(objPedido);                            
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
