<%@page import="maristas.beans.PresupuestoBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PresupuestoBean objPre = (PresupuestoBean)request.getAttribute("plan");
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
            function listar() {
                document.form.action = "<%=request.getContextPath()%>/listPlanServlet";
                document.form.method = "GET";
                document.form.accion.value="LIST";
                document.form.submit();
            }
        </script>
        <div class="container">
            <br>
            <header>
                <a href="<%=request.getContextPath()%>/PlanPresupuestalServlet?accion=1" class="pull-right btn btn-info btn-lg">Regresar</a>
                    <br>
                    <br>
                    <h1>Actualizar plan estratégico:</h1>
                    <hr>
            </header>		
            <br>
            <section class="row">
                <% if(request.getAttribute("status") == "ok"){ %>
                    <div class="alert alert-success">
                        <%=request.getAttribute("mensaje") %>
                    </div>
                <%}%>
                <% if(request.getAttribute("status") == "fail"){ %>
                    <div class="alert alert-danger">
                        <%=request.getAttribute("mensaje") %>
                    </div>
                <%}%>
                <form class="col-sm-12" method="post" action="<%=request.getContextPath()%>/PlanPresupuestalServlet">
                            <input type="hidden" name="accion" value="2">
                            <input type="hidden" name="id" value="<%= objPre.getId()%>">
                                <fieldset class="form-group">
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Nombre: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="text" name="nombre" class="form-control" value="<%= objPre.getNombre() %>" autofocus="true" id="txtName" placeholder=" Ingresa el nombre">
                                                    </div>			
                                            </div>									
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Fecha de inicio: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="date" value="<%= objPre.getFecha_inicio() %>" name="fec_inicio" class="form-control" id="txtVigency" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Fecha de término: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="date" name="fecha_final" value="<%= objPre.getFecha_final() %>" class="form-control" id="txtFinish" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Monto: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="text" name="monto" value="<%= objPre.getMonto()%>" class="form-control" id="txtYearStart" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            
                                            <br>
                                            
                                            <div class="row">
                                                    <div class="col-sm-offset-2 col-sm-2">
                                                            <input type="submit" value="Actualizar" id="btnAdd" class="btn btn-block btn-lg btn-success">
                                                    </div>
                                                    <div class="col-sm-2">
                                                            <a href="<%=request.getContextPath()%>/PlanPresupuestalServlet?accion=1" class="btn btn-block btn-lg btn-danger">Cancelar</a>
                                                    </div>
                                            </div>
                                    </fieldset>
                            </form>
            </section>
        </div>
    </body>
</html>