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
    <body id="login">
        <div class="container">
            <div class="jumbotron">
                <header>
                        <h1 class="text-center">Iniciar sesión</h1>
                </header>
                <br>
                <section class="row col-sm-offset-0">
                    <% if(request.getAttribute("mensaje") != null) { %>
                        <div class="alert alert-danger">
                            ${mensaje}<a href="#" aria-hidden="true" class="close"><i class="fa fa-remove">×</i></a>
                        </div>
                    <% }%>
                        <form class="col-sm-12" action="UsuarioServlet" method="post">
                                <fieldset class="form-group">
                                        <div class="row">
                                                <div class="col-sm-2">
                                                        <label class="label-control" >Usuario: </label>
                                                </div>
                                                <div class="col-sm-10 col-sm-offset-0">
                                                        <input type="text" class="form-control" name="username" id="txtUsername" autofocus placeholder=" Ingresa tu usuario">
                                                </div>			
                                        </div>
                                        <br>
                                        <div class="row">
                                                <div class="col-sm-2">
                                                        <label class="label-control">Password: </label>
                                                </div>
                                                <div class="col-sm-10">
                                                        <input type="password" class="form-control" name="contra" id="txtPassword" placeholder=" Ingresa tu password">
                                                </div>			
                                        </div>	
                                        <br>
                                        <div class="row text-center">
                                                <div class="col-sm-12">
                                                        <input type="submit" class="btn btn-hot text-uppercase btn-lg" id="btnEnter" value="Iniciar Sesión">
                                                </div>
                                        </div>	
                                </fieldset>
                        </form>
                </section>
            </div>	
	</div>
    </body>
</html>
