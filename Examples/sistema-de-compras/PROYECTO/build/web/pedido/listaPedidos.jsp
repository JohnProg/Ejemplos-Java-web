
<%@page import="compraProveedores.dao.pedidoDAO"%>
<%@page import="compraProveedores.beans.pedidoBean"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<pedidoBean> pedidos = (ArrayList<pedidoBean>)request.getAttribute("pedidos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<%=request.getContextPath()%>/css/master.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
            function irVistaMenu() {
                document.form.action = "<%=request.getContextPath()%>/SrvUsario";
                document.form.method = 'GET';
                document.form.submit();
            }
        </script>
        <form name='form'>
            <a href='#' onclick='irVistaMenu()'>Regresar</a>
        </form>
        <br>
        <h2>LISTA DE PEDIDOS </h2>
        <table border="2px">
            <thead>
                <tr>
                    <th colspan="6">	
                        <strong>PEDIDOS SOLICITADOS</strong>
                    </th> 
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>codigo</td>
                    <td>estado</td>
                    <td>area</td>
                    <td>descripcion</td>
                    <td>Accion</td>
                </tr>
                <%  
                    for(pedidoBean   obj:pedidos){
                %>
                <tr>
                   <td><%=obj.getId_pedido()%></td>
                   <td><%=obj.getEstado()%></td>
                   <td><%=obj.getArea()%></td>
                   <td><%=obj.getDescripcion()%></td>
                   <td>
                       <input type="button" value="Cotizar">
                   </td>
               </tr>
                <%   }%>
            </tbody>
       </table>
</body>
</html>
