<%-- 
    Document   : EscogerActividades
    Created on : 12/11/2014, 07:59:24 PM
    Author     : Autonoma
--%>

<%@page import="maristas.beans.ActividadBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<ActividadBean> actividad = (ArrayList<ActividadBean>)request.getAttribute("actividad");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="./static/css/bootstrap.min.css">-->
        <!--<link rel="stylesheet" href="./static/css/font-awesome.min.css">-->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <title> Actividades </title>      
    </head>
    <body>
        <script>
             function cerrarSesion() {
                document.form.action = "<%=request.getContextPath()%>/UsuarioServlet";
                document.form.method = "GET";
                document.form.accion.value="SALIR";
                document.form.submit();
            }
            
            function crearActi() {
                document.form.action = "<%=request.getContextPath()%>/ActividadesServlet";
                document.form.method = "GET";
                document.form.option.value = "1";
                document.form.submit();
            }
        </script>
        
        <div class="container">
            <br>
             <header>
                <a href="<%=request.getContextPath()%>/PlanOperativoServlet" class="pull-right btn btn-info btn-lg">Regresar</a>
                <br>
                    <br>
                    <h1> Actividades <a onclick="crearActi()" class="pull-right btn btn-lg btn-info"  id="btnCrear"> Crear </a></h1>
                <hr>
            </header>
            <form role="form" name="form" method="post" action="">
                <input  type="hidden"  name="accion">
                <input  type="hidden"  name="option">
                <div class="row col-sm-12 col-sm-offset-0" id="TableExecute">
                    <fieldset>
                        <table class="table table-stripped table-responsive">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Nombre</th>
                                    <th>Descripcion</th>
                                    <th>Plan Estrategico</th>
                                    <th>Linea</th>
                                    <th>Objetivo</th>
                                    <th>Sub-objetivo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%  
                                    actividad = (ArrayList<ActividadBean>)request.getAttribute("actividad");  
                                    if(actividad != null) {
                                        for(ActividadBean   obj:actividad) {   %>
                                        <tr>
                                           <td><%=obj.getId()%></td>
                                           <td><%=obj.getNombre()%></td>
                                           <td><%=obj.getDescripcion()%></td>                                           
                                           <td><%=obj.getId_plan_operativo()%></td>
                                           <td><%=obj.getGastos()%></td>
                                           <td><%=obj.getIngresos()%></td>
                                           <td><%=obj.getId_sub_objetivo()%></td>
                                           <td><%=obj.getId_presupuesto()%></td>
                                           <td><a onclick="actualizar()">Actualizar</a>
                                               <a onclick="eliminar()">Eliminar</a>
                                               <a onclick="irActividades()">Crear</a></td>
                                       </tr>
                                      <%   }
                                      }%>
                            </tbody>
                        </table>
                    </fieldset>
                </div>
            </form>    
        </div>
    </body>
</html>