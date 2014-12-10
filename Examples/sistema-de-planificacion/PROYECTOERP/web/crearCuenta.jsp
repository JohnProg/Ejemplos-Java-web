<%-- 
    Document   : iniciarSesion
    Created on : Nov 15, 2014, 10:36:06 PM
    Author     : johnmachahuay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/main.css">
        <title>Iniciar Sesión</title>
    </head>
    <body id="login" class="registro">
        <div class="container">
            <div class="jumbotron">
                <header>
                        <h1 class="text-center">Crear Cuenta</h1>
                </header>
                <br>
                <section class="row col-sm-offset-0">
                    <% if(request.getAttribute("mensaje") != null) { %>
                        <div class="alert alert-danger alert-dismissible fade in" role="alert">
                            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                            ${mensaje}
                        </div>
                    <% }%>
                        <form class="col-sm-12" action="UsuarioServlet" method="post" name="form">
                                <fieldset class="form-group">
                                        <div class="row">
                                                <div class="col-sm-2">
                                                        <label class="label-control" >Usuario: </label>
                                                </div>
                                                <div class="col-sm-10 col-sm-offset-0">
                                                        <input type="text" required="" class="form-control" name="username" id="txtUsername" autofocus placeholder=" Ingresa tu usuario">
                                                </div>			
                                        </div>
                                        <br>
                                        <div class="row">
                                                <div class="col-sm-2">
                                                        <label class="label-control" >Rol: </label>
                                                </div>
                                                <div class="col-sm-10 col-sm-offset-0">
                                                    <select name="id_rol" class="form-control">
                                                        <option value="1">Director</option>
                                                        <option value="1">Jefe de Área</option>
                                                        <option value="1">Presupuesto</option>
                                                    </select>
                                                </div>			
                                        </div>
                                        <br>
                                        <div class="row">
                                                <div class="col-sm-2">
                                                        <label class="label-control">Password: </label>
                                                </div>
                                                <div class="col-sm-10">
                                                        <input type="password" required="" class="form-control" name="contra" id="txtPassword" placeholder=" Ingresa tu password">
                                                </div>			
                                        </div>	
                                        <br>
                                        <div class="row text-center">
                                                <div class="col-sm-12">
                                                        <input type="submit" class="btn btn-hot text-uppercase btn-lg" id="btnEnter" value="Crear Cuenta">
                                                </div>
                                        </div>	
                                </fieldset>
                        </form>
                </section>
            </div>	
	</div>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-1.11.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-migrate-1.2.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/bootstrap.min.js"></script> 
            <script src="<%=request.getContextPath()%>/static/js/ValidacionAldo.js"></script> 
    </body>
</html>
