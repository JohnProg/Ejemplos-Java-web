<%-- 
    Document   : EscogerActividades
    Created on : 12/11/2014, 07:59:24 PM
    Author     : Autonoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="./static/css/bootstrap.min.css">-->
        <!--<link rel="stylesheet" href="./static/css/font-awesome.min.css">-->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <title> Actividades </title>
    </head>
    <body>
        <div class="container">
            <br>
            <header>
                <h1> Actividades <a href="index.html" class="pull-right btn btn-lg btn-success" id="btnCrear"> Crear </a></h1>
                <hr>
            </header>

            <div class="row col-sm-12 col-sm-offset-0" id="TableExecute">
                <fieldset>
                    <textarea style="width:100%; height:300px;"></textarea>
                </fieldset>
            </div>

        </div>
    </body>
</html>