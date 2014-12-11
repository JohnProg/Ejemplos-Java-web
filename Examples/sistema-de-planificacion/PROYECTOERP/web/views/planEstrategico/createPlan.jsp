<%@page import="maristas.beans.UsuarioBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
ArrayList<UsuarioBean> usuarios= (ArrayList<UsuarioBean>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
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
                    <a href="<%=request.getContextPath()%>/PlanEstrategicoServlet" class="pull-right btn btn-info btn-lg">Regresar</a>
                        <br>
                        <br>
                        <h1>Crear plan estratégico</h1>
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
                        <form class="col-sm-12" method="post" action="<%=request.getContextPath()%>/PlanEstrategicoServlet">
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
                                                            <label class="label-control" >Fecha de vigencia: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="date" required name="fec_inicio"class="form-control" id="txtVigency" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Fecha de término: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="date" required name="fec_termino"class="form-control" id="txtFinish" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Año de inicio: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="number" required name="anio_inicio"class="form-control" id="txtYearStart" placeholder=" ">
                                                    </div>			
                                            </div>	
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Año de término: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <input type="number" required name="anio_termino"class="form-control" id="txtYearFinish" placeholder=" ">
                                                    </div>			
                                            </div>
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Aprobado por: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <select name="aprobado_por" required class="form-control" id="txtApprovedBy">
                                                            <%
                                                                for(UsuarioBean obj:usuarios){
                                                                    out.print("<option value="+ obj.getId() +">"+ obj.getUsername() +"</option>");
                                                                }
                                                            %>
                                                        </select>
                                                    </div>			
                                            </div>
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-2">
                                                            <label class="label-control" >Descripción: </label>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <textarea class="form-control" required name="descripcion"id="txtDescription" col="3" placeholder="Ingresa la descripcion"></textarea>
                                                    </div>			
                                            </div>
                                            <br>
                                            <div class="row">
                                                    <div class="col-sm-offset-2 col-sm-2">
                                                            <input type="submit" value="Crear" id="btnAdd" class="btn btn-block btn-lg btn-success">
                                                    </div>
                                                    <div class="col-sm-2">
                                                            <a href="<%=request.getContextPath()%>/PlanEstrategicoServlet" class="btn btn-block btn-lg btn-danger">Cancelar</a>
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