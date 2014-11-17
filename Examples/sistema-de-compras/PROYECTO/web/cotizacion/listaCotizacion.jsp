

<%@page import="compraProveedores.beans.cotizacionBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<cotizacionBean> cotizaciones = (ArrayList<cotizacionBean>)request.getAttribute("cotizaciones"); %>
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
        <h2>LISTA DE COTIZACIONES </h2>
        <table border="1px">
            <tbody>
                <tr>
                    <th colspan="6">	
                        <strong>cotizaciones pendientes</strong>
                    </th>  
                </tr>
            
            </tbody>
            <tbody>
                 <tr>
                    <td>id pedido</td>
                    <td>id proveedor</td>
                    <td>forma de pago</td>
                    <td>descripcion</td>
                    <td>costo</td>
                </tr>
                
                
                <%  for(cotizacionBean   obj:cotizaciones){   %>
                <tr>
                   <td ><%=obj.getId_fk_pedido()%></td>
                   <td ><%=obj.getId_fk_usuario()%></td>
                   <td ><%=obj.getForma_pago()%></td>
                   <td ><%=obj.getDescripcion()%></td>
                   <td ><%=obj.getCosto()%></td>
               </tr>
                <%   }%>
            </tbody>
       </table>
       <br><br>
    
</body>
</html>
