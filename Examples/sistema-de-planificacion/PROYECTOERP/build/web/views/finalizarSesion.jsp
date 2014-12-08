<%@page  session="true"%>
<%-- 
    Document   : finalizarSesion
    Created on : Dec 3, 2014, 8:47:56 AM
    Author     : johnmachahuay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(session.getAttribute("SESSION") == null ) {
                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>
