<%-- 
    Document   : CreatePlanOperativo
    Created on : 12/11/2014, 07:57:00 PM
    Author     : Autonoma
--%>

<%@page import="maristas.beans.PlanOperativoBean"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<PlanOperativoBean> PlanOperativo = (ArrayList<PlanOperativoBean>)request.getAttribute("PlanOperativo");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <title> Plan Operativo </title>
    </head>
    <body>
        <div class="container">
            <br>
            <a class="btn btn-lg btn-danger" href="<%=request.getContextPath()%>/views/JefeArea.jsp"> Salir </a>
            <br><br><br>
            <section class="row col-sm-4 col-sm-offset-4" style="">
                <div class="col-sm-4 col-sm-offset-1" id="plan-operativo">
                    <h2 style="width:200px; text-align:center;">Plan Operativo</h2>
                    <br><br>

                    <form role="form" name="form" method="post" id="miFormulario" action="<%=request.getContextPath()%>/CreatePlanOperativoServlet">
                        <div class="form-group" style="width: 300px;">
                            <label for="nombre">Nombre :</label>
                            <input id="nombre" type="text" name="nombre" class="form-control" placeholder="Nombre y Apellido"  required=""/>                  
                        </div>

                        <div class="form-group" style="width: 300px;">
                            <label for="cboarea">Email :</label>
                            <select class="form-control" required="true" name="cboarea">
                                <option value="" selected> --- Escoge un area ---</option>
                                <option> Area 1 </option>
                                <option> Area 2 </option>
                            </select>
                        </div>
                        
                        <br>
                        <button class="btn btn-lg btn-info" id="btnCrear"> Crear Plan Operativo </button>

                    </form>
                </div>
            </section>   
        </div>
            <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/js/ValidacionAldo.js"></script> 

    </body>
</html>


