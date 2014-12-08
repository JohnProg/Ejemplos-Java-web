<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="container">
                <br>
                <header>
                    <a href="<%=request.getContextPath()%>/PlanPresupuestalServlet?accion=1" class="pull-right btn btn-info btn-lg">Regresar</a>
                        <br>
                        <br>
                        <h1>Crear Plan Presupuestal</h1>
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
                            <input type="hidden" name="accion" value="1">    
                                <fieldset class="form-group">
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Nombre: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                            <input type="text" name="nombre" class="form-control" autofocus="true" id="txtName" placeholder=" Ingresa el nombre">
                                                    </div>			
                                            </div>									
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Fecha de inicio: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="date" name="fec_inicio"class="form-control" id="txtVigency" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Fecha de término: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="date" name="fecha_final"class="form-control" id="txtFinish" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Monto: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="text" name="monto"class="form-control" id="txtYearStart" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            
                                            <br>
                                            
                                            <div class="row">
                                                    <div class="col-sm-offset-2 col-sm-2">
                                                            <input type="submit" value="Crear" id="btnAdd" class="btn btn-block btn-lg btn-success">
                                                    </div>
                                                    <div class="col-sm-2">
                                                            <a href="<%=request.getContextPath()%>/PlanPresupuestalServlet" class="btn btn-block btn-lg btn-danger">Cancelar</a>
                                                    </div>
                                            </div>
                                    </fieldset>
                            </form>
                    </section>
            </div>
    </body>
</html>