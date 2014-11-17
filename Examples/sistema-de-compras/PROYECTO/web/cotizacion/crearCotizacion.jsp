

<%@page import="java.util.ArrayList"%>
<%@page import="compraProveedores.beans.usuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<usuarioBean> proveedores = (ArrayList<usuarioBean>)request.getAttribute("proveedores");
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<%=request.getContextPath()%>/css/master.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <a href="<%=request.getContextPath()%>/SrvPedido">Regresar</a>
        <form name="form" action="SrvCotizacion" method="post">
            <input type="hidden" value="1" name="option">
            <input type="hidden" value="<%= session.getAttribute("pedido_id") %>" name="pedido_id">
            <span class="error">${mensaje}</span>
            <center>Proveedor 
                <label>
                    <select name="proveedor" class="input_text_combo" id="select">
                        <option selected="">---Seleccione---</option>
                        <%
                            if(proveedores != null) {
                                for(usuarioBean   obj:proveedores){
                        %>
                        <option value="<%= obj.getId_usuario() %>">
                            <%= obj.getNombre() %>
                        </option>
                        <%      }
                            }
                        %>
                    </select>
                </label>
                <br>
                <br>
                Forma de pago<label>
                    <select name="forma_pago" class="input_text_combo" id="select">
                        <option selected="">---Seleccione---</option>
                        <option value="Al contado">al contado </option>
                        <option value="Al crédito">al credito</option>
                    </select>
                </label>
            </center>
                    <br>
            <center>
                <textarea name="descripcion" rows="10" cols="40" placeholder="Escribe aquí tus comentarios"></textarea>
            </center>
           <center> 
               <input type="submit" name="generar_resultado" value="Aceptar"> 
               <a href="<%=request.getContextPath()%>/SrvPedido">Cancelar</a>
           </center>
        </form>
       <br>
       <br>
    </body>
</html>
