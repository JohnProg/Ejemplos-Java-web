<%-- 
    Document   : JefeArea
    Created on : 16-nov-2014, 12:25:11
    Author     : Aldair
--%>

<%@page import="maristas.beans.PlanEstrategicoBean"%>
<%@page import="maristas.beans.UnidadOrganicaBean"%>
<%@page import="maristas.beans.UsuarioBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="maristas.beans.PlanOperativoBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<PlanOperativoBean> plansO = (ArrayList<PlanOperativoBean>)request.getAttribute("plansO");
    ArrayList<UnidadOrganicaBean> areas = (ArrayList<UnidadOrganicaBean>)request.getAttribute("areas");
    ArrayList<UsuarioBean> usuarios = (ArrayList<UsuarioBean>)request.getAttribute("usuarios");
    ArrayList<PlanEstrategicoBean> plansE = (ArrayList<PlanEstrategicoBean>)request.getAttribute("plansE");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/main.css">
        <title> Plan Operativo </title>
        <script>
            
             function irActividades(id){
                 document.form.action = "<%=request.getContextPath()%>/PlanOperativoServlet";
                 document.form.method = "GET";
                 document.form.option.value = "2";
                 document.form.id_plan_operativo.value = id;
                 document.form.submit();
             }
            
             function crear() {
                document.form.action = "<%=request.getContextPath()%>/PlanOperativoServlet";
                document.form.method = "GET";
                document.form.option.value= "1";
                document.form.submit();
            }
            
            function eliminar(id) {
                document.form.action = "<%=request.getContextPath()%>/PlanOperativoServlet";
                document.form.method = "get";
                document.form.option.value=4;
                document.form.id_plan_operativo.value=id;
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
                        <img class="user-image" src="<%=request.getContextPath()%>/static/img/user.jpg">
                    <%  UsuarioBean userBean = (UsuarioBean)session.getAttribute("SESSION"); 
                        if(userBean != null) {
                            out.println(userBean.getUsername());
                        }
                    %>
                    </a>
                </li>
               <li class="dropdown"><a href="<%=request.getContextPath()%>/cerrarSesion">Salir</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            <header>
                    <h1> Plan Operativo <a href="#" class="pull-right btn btn-lg btn-primary" onclick="crear()" id="btnCrear"> Crear </a></h1>
                <hr>
            </header>
            <br>
            <% if(request.getAttribute("status") == "ok"){ %>
                            <div class="alert alert-success alert-dismissible fade in" role="alert">
                                <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                <%=request.getAttribute("mensaje") %>
                            </div>
                        <%}%>
                        <% if(request.getAttribute("status") == "fail"){ %>
                            <div class="alert alert-danger alert-dismissible fade in" role="alert">
                                <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                <%=request.getAttribute("mensaje") %>
                            </div>
                        <%}%>
            <section class="row"> 
                <form class="col-sm-12" name="form">
                    <input  type="hidden"  name="accion">
                    <input  type="hidden"  name="id_plan_operativo">
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
                                        <th>Encargado</th>
                                        <th>Area Organizativa</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                     <%   
                                        if(plansO != null) {
                                            for(PlanOperativoBean   obj:plansO) {   %>
                                            <tr>
                                               <td><%=obj.getId()%></td>
                                               <td><%=obj.getNombre()%></td>
                                               <td><%=obj.getDescripcion()%></td>                                           
                                               <td>
                                                   <% for(PlanEstrategicoBean obj1:plansE) {
                                                       if(obj.getId_plan_estrategico()== obj1.getId()) {
                                                           out.print(obj1.getNombre());
                                                       }
                                                   }%>
                                               </td>
                                               <td>
                                                   <% for(UsuarioBean obj2:usuarios) {
                                                       if(obj.getId_encargado()== obj2.getId()) {
                                                           out.print(obj2.getUsername());
                                                       }
                                                   }%>
                                               </td>
                                               <td>
                                                   <% for(UnidadOrganicaBean obj3:areas) {
                                                       if(obj.getId_unidad_organica() == obj3.getId()) {
                                                           out.print(obj3.getNombre());
                                                       }
                                                   }%>
                                               </td>
                                               <td>
                                                   <a href="#" onclick="irActividades(<%=obj.getId()%>)"><span class="label label-success">Actividades</span></a> | 
                                                   <a href="<%=request.getContextPath()%>/PlanOperativoServlet?option=3&id=<%= obj.getId() %>"><span class="label label-primary">Actualizar</span></a> 
                                                   <!--<a href="#" onclick="eliminar(<%=obj.getId()%>)"><span class="label label-danger">Eliminar</span></a>-->
                                                </td>
                                           </tr>
                                          <%   }
                                          }%>
                                </tbody>
                            </table>
                        </fieldset>
                    </div>
                </form>
            </section>  
            <br>
            <br>
        </div>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-1.11.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-migrate-1.2.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/app.js"></script>
    </body>
</html>
