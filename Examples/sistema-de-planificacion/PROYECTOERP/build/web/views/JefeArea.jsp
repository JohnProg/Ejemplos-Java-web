<%-- 
    Document   : JefeArea
    Created on : 16-nov-2014, 12:25:11
    Author     : Aldair
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <title> Plan Operativo </title>
        <script>
            
            function EnterCreate(){
                
                
            }
            
        </script>
    </head>
    <body>
        <div class="container">
            <br>
            <header>
                <h1> Plan Operativo <a href="<%=request.getContextPath()%>/views/PlanOperativo/CrearPlanOperativo.jsp" class="pull-right btn btn-lg btn-info" id="btnCrear"> Crear </a></h1>
                <hr>
            </header>

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
                        <tbody></tbody>
                    </table>
                </fieldset>
            </div>

        </div>
    </body>
</html>
