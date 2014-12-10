<%@page import="maristas.beans.UsuarioBean"%>
<%@page import="maristas.dao.planDAO"%>
<%@page import="maristas.beans.PlanEstrategicoBean"%>
<%@page import="java.util.ArrayList"%>
<%
    PlanEstrategicoBean  objEmpleBean = null;
    UsuarioBean  userBean = null;
    ArrayList<PlanEstrategicoBean> plans=null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/main.css">
    </head>
    <body>
        <script>
            function lineas(plan_id){
                document.form.action = "<%=request.getContextPath()%>/LineaServlet";
                document.form.method = "GET";
                document.form.option.value="1";
                document.form.id_plan.value=plan_id;
                document.form.submit();
            }
            function crear(plan_id) {
                document.form.action = "<%=request.getContextPath()%>/PlanEstrategicoServlet";
                document.form.method = "GET";
                document.form.option.value="1";
                document.form.id_plan.value=plan_id;
                document.form.submit();
            }
            function actualizar() {
                document.form.action = "<%=request.getContextPath()%>/PlanEstrategicoServlet";
                document.form.method = "GET";
                document.form.accion.value="2";
                document.form.submit();
            }
            function eliminar() {
                debugger
                document.form.action = "<%=request.getContextPath()%>/PlanEstrategicoServlet";
                document.form.method = "POST";
                document.form.option.value="3";
                debugger
                document.form.submit();
            }
            function cerrarSesion() {
                document.form.action = "<%=request.getContextPath()%>/cerrarSesion";
                document.form.method = "GET";
                document.form.accion.value="SALIR";
                document.form.submit();
            }
            
        </script>
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
                    <%  userBean = (UsuarioBean)session.getAttribute("SESSION"); 
                        if(userBean != null) {
                            out.println(userBean.getUsername());
                        }
                    %>
                    </a>
                </li>
               <li class="dropdown"><a onclick="cerrarSesion()"  href="#">Salir</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            <header>
                <a onclick="crear()" class="pull-right btn btn-primary btn-lg">+ Crear</a>
                    <h1>Planes estratégicos: </h1>
                    <hr>
            </header>	
            <br>
            <section class="row">            
                    <form class="col-sm-12" name="form">
                        <input  type="hidden"  name="option">
                        <input  type="hidden"  name="id_plan">
                                <fieldset class="form-group">
                                        <div class="row">
                                                <div class="col-sm-1">
                                                        <label class="label-control" >Buscar: </label>
                                                </div>
                                                <div class="col-sm-4">
                                                        <input type="text" class="form-control" autofocus="true" id="txtSearch" placeholder="Buscando...">
                                                </div>			
                                        </div>					
                                        <br>
                                </fieldset>
                                <br>
                                <fieldset>
                                        <table class="table table-stripped table-responsive">
                                                <thead>
                                                        <tr>
                                                                <th>#</th>
                                                                <th>Nombre</th>
                                                                <th>Fecha de Vigencia</th>
                                                                <th>Fecha de Término</th>
                                                                <th>Año de inicio</th>
                                                                <th>Año de término</th>
                                                                <th>Aprobado por</th>
                                                                <th>Descripción</th>
                                                                <th>Opciones</th>
                                                        </tr>
                                                </thead>
                                                <tbody id="table">
                                                     <%  
                                                        plans = (ArrayList<PlanEstrategicoBean>)request.getAttribute("plans");  
                                                        if(plans != null) {
                                                            for(PlanEstrategicoBean   obj:plans) {   %>
                                                            <tr>
                                                               <td><%=obj.getId()%></td>
                                                               <td><%=obj.getNombre()%></td>
                                                               <td><%=obj.getFec_vigencia()%></td>
                                                               <td><%=obj.getFec_termino()%></td>
                                                               <td><%=obj.getAnio_inicio()%></td>
                                                               <td><%=obj.getAnio_termino()%></td>
                                                               <td><%=obj.getAprobado_por()%></td>
                                                               <td><%=obj.getDescripcion()%></td>
                                                               <td>
                                                                   <a href="#" onclick="lineas(<%=obj.getId()%>)"><span class="label label-success">Lineas</span></a> |
                                                                   <a href="#" onclick="actualizar()"><span class="label label-primary">Actualizar</span></a> |
                                                                   <a href="#" onclick="eliminar()"><span class="label label-danger">Eliminar</span></a>
                                                           </tr>
                                                          <%   }
                                                          }%>
                                                </tbody>
                                        </table>
                                </fieldset>
                        </form>
                </section>
        </div>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-1.11.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-migrate-1.2.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/app.js"></script>
    </body>
</html>