<%@page import="maristas.beans.PresupuestoBean"%>
<%@page import="maristas.beans.UsuarioBean"%>
<%@page import="maristas.dao.planDAO"%>
<%@page import="java.util.ArrayList"%>
<%
    PresupuestoBean  objEmpleBean = null;
    UsuarioBean  userBean = null;
    ArrayList<PresupuestoBean> plans=null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan Presupuestal</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/main.css">
    </head>
    <body>
        <script>
            function irVistaActualizar(plan_id) {
                document.form.action = "<%=request.getContextPath()%>/PlanPresupuestalServlet";
                document.form.method = "GET";
                document.form.accion.value=3;
                document.form.plan_id.value= plan_id;
                document.form.submit();
            }
            function eliminar(plan_id) {
                var resp = confirm("EStas seguro que deseas eliminar?");
                if(resp) {
                    document.form.action = "<%=request.getContextPath()%>/PlanPresupuestalServlet";
                    document.form.method = "GET";
                    document.form.accion.value=2;
                    document.form.plan_id.value=plan_id;
                    document.form.submit();
                }                
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
                    <h1>Planes presupuestal <a href="<%=request.getContextPath()%>/views/PlanPresupuestal/createPlan.jsp" class="pull-right btn btn-primary btn-lg">+ Crear</a></h1>
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
                        <input  type="hidden"  name="plan_id">
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
                                                                <th>Código</th>
                                                                <th>Nombre</th>
                                                                <th>Monto</th>
                                                                <th>Fecha de inicio</th>
                                                                <th>Fecha de termino</th>
                                                                <th>Opciones</th>
                                                        </tr>
                                                </thead>
                                                <tbody id="table">
                                                     <%  
                                                        plans = (ArrayList<PresupuestoBean>)request.getAttribute("plans");  
                                                        if(plans != null) {
                                                            for(PresupuestoBean   obj:plans) {   %>
                                                            <tr>
                                                                <td><%=obj.getId()%></td>
                                                               <td><%=obj.getNombre()%></td>
                                                               <td><%=obj.getMonto()%></td>
                                                               <td><%=obj.getFecha_inicio()%></td>
                                                               <td><%=obj.getFecha_final()%></td>
                                                               <td><a href="#" onclick="irVistaActualizar(<%=obj.getId()%>)"><span class="label label-primary">Actualizar</span></a> | 
                                                                   <a href="#" onclick="eliminar(<%=obj.getId()%>)"><span class="label label-danger">Eliminar</span></a></td>
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
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/bootstrap.min.js"></script> 
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/app.js"></script>
    </body>
</html>