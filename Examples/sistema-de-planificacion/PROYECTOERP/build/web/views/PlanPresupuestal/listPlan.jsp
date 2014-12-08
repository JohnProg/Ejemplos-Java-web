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
            function crear() {
                document.form.action = "<%=request.getContextPath()%>/PlanPresupuestalServlet";
                document.form.method = "GET";
                document.form.accion.value="CREATE";
                document.form.submit();
            }
            function actualizar(plan_id) {
                document.form.action = "<%=request.getContextPath()%>/PlanPresupuestalServlet";
                document.form.method = "GET";
                document.form.accion.value="UPDATE";
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
        <div class="container">
            <br>
            <header>
                <a href="#" onclick="cerrarSesion()" class="pull-right btn btn-danger btn-lg" id="btnSalir">Salir</a>
                    <br>
                    <br>
                    <h1>Planes presupuestal: <a href="<%=request.getContextPath()%>/views/PlanPresupuestal/createPlan.jsp" class="pull-right btn btn-primary btn-lg">+ Crear</a></h1>
                    <hr>
            </header>	
            <%  userBean = (UsuarioBean)session.getAttribute("SESSION"); 
                if(userBean != null) {
                    out.println("Usuario: " + userBean.getUsername());
                }
            %>
            <br>
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
                                                                <th>#</th>
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
                                                                <td>1</td>
                                                                <td><%=obj.getId()%></td>
                                                               <td><%=obj.getNombre()%></td>
                                                               <td><%=obj.getMonto()%></td>
                                                               <td><%=obj.getFecha_inicio()%></td>
                                                               <td><%=obj.getFecha_final()%></td>
                                                               <td><a href="#" onclick="actualizar(<%=obj.getId()%>)">Actualizar</a>
                                                                   <a href="#" onclick="eliminar(<%=obj.getId()%>)">Eliminar</a></td>
                                                           </tr>
                                                          <%   }
                                                          }%>
                                                </tbody>
                                        </table>
                                </fieldset>
                        </form>
                </section>
        </div>
    </body>
</html>