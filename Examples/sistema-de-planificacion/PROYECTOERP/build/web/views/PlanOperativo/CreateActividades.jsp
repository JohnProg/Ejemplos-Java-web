<%-- 
    Document   : CrearActividades
    Created on : 12/11/2014, 08:01:06 PM
    Author     : Autonoma
--%>

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
            <button class="btn btn-lg btn-danger"> Salir </button>
            <br>
            <section class="row col-sm-12 col-sm-offset-0">
                <h2 style="text-align:center;"> Plan Operativo</h2>
                <hr>
                <div class="col-sm-4 col-sm-offset-1" id="plan-operativo">
                    <br>
                    <form role="form" name="form" method="post" id="miFormulario" >
                        <div class="form-group" style="width: 300px;">
                            <label for="nombre">Nombre :</label>
                            <input id="nombre" type="text" name="nombre" class="form-control" placeholder="Nombre"  required=""/>                  
                        </div>

                        <div class="form-group">
                            <label for="mensaje">Descripcion :</label>
                            <textarea id="mensaje" name="mensaje" class="form-control" placeholder="Descripcion" required=""></textarea>
                        </div>
                        
                        <button class="btn btn-lg btn-info" id="btnCrear"> Crear Plan Operativo </button>
                    </form>
                </div>

                <div class="col-sm-4 col-sm-offset-1" id="plan-operativo">
                    <br>
                    <form role="form" name="form" method="post" id="miFormulario" >
                        <div class="form-group">
                            <label> Plan : </label>
                            <select class="form-control"  name="cboplan" required="">
                                <option value="" selected> ---- Escoga un Plan ---- </option>
                                <option> Plan operativo 1</option>
                                <option> Plab operativo 2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label> Linea : </label>
                            <select class="form-control" name="cbolinea" required="">
                                <option value="" selected> ---- Escoga una Linea ---- </option>
                                <option> Linea 1</option>
                                <option> Linea 2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label> Objetivos: </label>
                            <select class="form-control" name="cboob" required="">
                                <option value="" selected> ---- Escoga un Objetivo ---- </option>
                                <option> Objetivo 1</option>
                                <option> Objetivo 2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label> Sub-Objetivos : </label>
                            <select class="form-control" name="cbosub" required="">
                                <option value="" selected> ---- Escoga un Sub-objetivo ---- </option>
                                <option> Sub-Objetivo 1</option>
                                <option> Sub-Objetivo 2</option>
                            </select>
                        </div>

                    </form>
                </div>
            </section>
         </div>
            <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/js/ValidacionAldo.js"></script> 
    </body>
</html>