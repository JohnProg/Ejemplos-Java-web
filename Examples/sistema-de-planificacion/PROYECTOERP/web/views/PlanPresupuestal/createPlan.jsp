<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan Presupuestal</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/main.css">
        <script>
           function init() {
                var date = new Date();
            var day = date.getDate();
            var month = date.getMonth() + 1;
            var year = date.getFullYear();

            if (month < 10) month = "0" + month;
            if (day < 10) day = "0" + day;

            var today = year + "-" + month + "-" + day;

            document.getElementById('txtVigency').value = today;
            document.getElementById('txtFinish').value = today;
           }
        </script>
    </head>
    <body onload="init()">
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
                        <form class="col-sm-12" method="post" action="<%=request.getContextPath()%>/PlanPresupuestalServlet">
                            <input type="hidden" name="accion" value="1">    
                                <fieldset class="form-group">
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Nombre: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                            <input type="text" name="nombre" required class="form-control" autofocus="true" id="txtName" placeholder=" Ingresa el nombre">
                                                    </div>			
                                            </div>									
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Fecha de inicio: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="date" name="fec_inicio" required class="form-control" id="txtVigency" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Fecha de término: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="date" name="fecha_final" required class="form-control" id="txtFinish" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Monto: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="number" name="monto" required class="form-control" id="txtYearStart" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            
                                            <br>
                                            
                                            <div class="row">
                                                    <div class="col-sm-offset-2 col-sm-2">
                                                            <input type="submit" value="Crear" id="btnAdd" class="btn btn-block btn-lg btn-success">
                                                    </div>
                                                    <div class="col-sm-2">
                                                            <a href="<%=request.getContextPath()%>/PlanPresupuestalServlet?accion=1" class="btn btn-block btn-lg btn-danger">Cancelar</a>
                                                    </div>
                                            </div>
                                    </fieldset>
                            </form>
                    </section>
            </div>
                                                    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-1.11.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-migrate-1.2.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/bootstrap.min.js"></script> 
    </body>
</html>