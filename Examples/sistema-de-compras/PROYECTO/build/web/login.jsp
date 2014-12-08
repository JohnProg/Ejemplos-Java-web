
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<%=request.getContextPath()%>/css/master.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.jsp">Inicio</a>
        <h1>Iniciar Sesion</h1>
        <form action="SrvUsario" method="post">
            <div>
                <label>Usuario</label>
                <input type="text" name='usuario' required>
            </div>
            <br>
            <div>
                <label>Contraseña</label>
                <input type="password" name='contrasena' required>
            </div>
            <br>
            <input type="submit" value="Iniciar sesión">
            <br>
            <span class="error">${mensaje}</span>
        </form>
    </body>
</html>
