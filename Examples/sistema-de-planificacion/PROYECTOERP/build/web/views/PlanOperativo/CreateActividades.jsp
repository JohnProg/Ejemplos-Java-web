<%-- 
    Document   : CrearActividades
    Created on : 12/11/2014, 08:01:06 PM
    Author     : Autonoma
--%>

<%@page import="maristas.beans.ActividadBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="maristas.beans.UsuarioBean"%>
<% ArrayList<ActividadBean> Actividad = (ArrayList<ActividadBean>)request.getAttribute("Actividades");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UsuarioBean  userBean = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <title> Plan Operativo </title>
    </head>
     <script>
            function cargarPlanes(ruta) {
                
                var  pag = ruta+"?accion=1";
                 $.get(pag, function(data) {
                    var html = "<option  value=0>---------</option> ";
                    for(var i in data){
                        var item = data[i];
                        html += "<option value="+item.id+">"+ item.nombre + "</option>"; 
                    }
                    $("#cboplanope").html(html);    
                });
            }
        </script>
    <body onload="cargarPlanes('<%=request.getContextPath()%>/PlanOperativoServletAjax');">
        
        <div class="container">
            <br>
            <a href="<%=request.getContextPath()%>/PlanOperativoServlet?accion=&option=2" class="pull-right btn btn-info btn-lg">Regresar</a>
            <br>
            <%  userBean = (UsuarioBean)session.getAttribute("DatosUsuario"); 
                if(userBean != null) {
                    out.println(userBean.getUsername());
                }
            %>
            <section class="row col-sm-12 col-sm-offset-0">
                <h2 style="text-align:center;"> Actividades</h2>
                <hr>
                <div class="col-sm-12 col-sm-offset-0">
                    <br>
                        <form role="form" name="form" method="post" id="miFormulario" action="<%=request.getContextPath()%>/ActividadesServlet?option=1" >
                            <input  type="hidden"  name="accion">
                            
                            <div class="col-sm-4 col-sm-offset-2" id="plan-operativo">
                                <div class="form-group" >
                                    <label for="nombre">Nombre :</label>
                                    <input id="nombre" type="text" name="nombre" class="form-control" placeholder="Nombre"  required=""/>                  
                                </div>

                                <div class="form-group">
                                    <label for="mensaje">Costos :</label>
                                    <input id="nombre" type="number" name="costo" class="form-control" placeholder="Costos"  required=""/>                  
                                </div>
                                
                                <div class="form-group">
                                    <label for="mensaje">Ingresos :</label>
                                    <input id="nombre" type="number" name="ingreso" class="form-control" placeholder="Ingresos"  required=""/>                  
                                </div>

                                <button class="btn btn-lg btn-info" id="btnCrear"> Crear Plan Operativo </button>
                            </div> 
                            
                            <div class="col-sm-4 col-sm-offset-1" id="plan-operativo">
                                <div class="form-group">
                                <label> Plan : </label>
                                <select class="form-control"  id="cboplanope" name="cboplanope" required="" data-ruta="<%=request.getContextPath()%>/PlanOperativoServletAjax">
                                                        
                                   <option  value="0" selected>---------</option>                            
                                
                                 
                           <option  value="" selected>
                               
                           </option>               
                        
                                </select>
                            </div>
                            <div class="form-group">
                                <label> Linea : </label>
                                <select class="form-control" id="cbolinea" name="cbolinea" required="" data-ruta="<%=request.getContextPath()%>/PlanOperativoServletAjax">
                                    <option value="" selected> ---- Escoga una Linea ---- </option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label> Objetivos: </label>
                                <select class="form-control" id="cboob" name="cboob" required="" data-ruta="<%=request.getContextPath()%>/PlanOperativoServletAjax">
                                    <option value="" selected> ---- Escoga un Objetivo ---- </option>
                                    
                                </select>
                            </div>
                            <div class="form-group">
                                <label> Sub-Objetivos : </label>
                                <select class="form-control" name="id_sub_objetivo" id="cbosub" required="">
                                    <option value="" selected> ---- Escoga un Sub-objetivo ---- </option>
                                    
                                </select>
                            </div>
                            </div>
                        </form>
                    </div>
                </section>
                </div>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-1.11.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-migrate-1.2.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/bootstrap.min.js"></script> 
            <script src="<%=request.getContextPath()%>/static/js/ValidacionAldo.js"></script> 
            <script src="<%=request.getContextPath()%>/static/js/app.js"></script> 
    </body>
</html>