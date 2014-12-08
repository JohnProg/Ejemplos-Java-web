<%-- 
    Document   : JefeArea
    Created on : 16-nov-2014, 12:25:11
    Author     : Aldair
--%>

<%@page import="maristas.beans.UsuarioBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="maristas.beans.PlanOperativoBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<PlanOperativoBean> plans = (ArrayList<PlanOperativoBean>)request.getAttribute("plans");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <title> Plan Operativo </title>
        <script>
            
             function irActividades(){
                 document.form.action = "<%=request.getContextPath()%>/PlanOperativoServlet";
                 document.form.method = "GET";
                 document.form.option.value = "2";
                 document.form.submit();
             }
            
             function crear() {
                document.form.action = "<%=request.getContextPath()%>/PlanOperativoServlet";
                document.form.method = "GET";
                document.form.option.value= "1";
                document.form.submit();
            }
            
            function cerrarSesion() {
                document.form.action = "<%=request.getContextPath()%>/cerrarSesion";
                document.form.method = "GET";
                document.form.accion.value="SALIR";
                document.form.submit();
            }
            
            function eliminar(id) {
                document.form.action = "<%=request.getContextPath()%>/PlanOperativoServlet";
                document.form.method = "post";
                document.form.accion.value=4;
                document.form.id.value=id;
                document.form.submit();
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-default" role="navigation">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <a class="navbar-brand" href="#">Maristas</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

              <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                    <%  UsuarioBean userBean = (UsuarioBean)session.getAttribute("SESSION"); 
                        if(userBean != null) {
                            out.println(userBean.getUsername());
                        }
                    %>
                    </a>
                </li>
               <li class="dropdown"><a href="#" onclick="cerrarSesion()">Salir</a></li>
              </li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            <br>
            <header>
                <br>
                    <br>
                    <h1> Plan Operativo <a href="#" class="pull-right btn btn-lg btn-info" onclick="crear()" id="btnCrear"> Crear </a></h1>
                <hr>
            </header>
            <form class="col-sm-12" name="form">
                <input  type="hidden"  name="accion">
                <input  type="hidden"  name="option">
                <fieldset class="form-group">
                        <div class="row">
                                <div class="col-sm-1">
                                        <label class="label-control" >Buscar: </label>
                                </div>
                                <div class="col-sm-4">
                                        <input type="text" class="form-control" autofocus="" id="txtSearch" placeholder="Buscando...">
                                </div>			
                        </div>					
                        <br>
                </fieldset>
                    <div class="row col-sm-12 col-sm-offset-0" id="TableExecute">
                    <fieldset>
                        <table class="table table-stripped table-responsive">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Nombre</th>
                                    <th>Descripcion</th>
                                    <th>Plan Estrategico</th>
                                    <th>Area Organizativa</th>
                                    <th>Encargado</th>
                                    <th>Crear Actividades</th>
                                </tr>
                            </thead>
                            <tbody>
                                 <%  
                                    plans = (ArrayList<PlanOperativoBean>)request.getAttribute("plans");  
                                    if(plans != null) {
                                        for(PlanOperativoBean   obj:plans) {   %>
                                        <tr>
                                           <td><%=obj.getId()%></td>
                                           <td><%=obj.getNombre()%></td>
                                           <td><%=obj.getDescripcion()%></td>                                           
                                           <td><%=obj.getId_plan_estrategico()%></td>
                                           <td><%=obj.getId_encargado()%></td>
                                           <td><%=obj.getId_unidad_organica()%></td>
                                           <td><a href="#" onclick="actualizar()">Actualizar</a>
                                               <a href="#" onclick="eliminar(<%=obj.getId()%>)">Eliminar</a>
                                               <a href="#" onclick="irActividades()">Crear</a></td>
                                       </tr>
                                      <%   }
                                      }%>
                            </tbody>
                        </table>
                    </fieldset>
                </div>
            </form>
        </div>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-1.11.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-migrate-1.2.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/app.js"></script>
    </body>
</html>
