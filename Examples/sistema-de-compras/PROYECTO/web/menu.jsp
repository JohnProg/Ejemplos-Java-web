
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<%=request.getContextPath()%>/css/master.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
            function irVistaListadoPedido() {
                document.form.action = "<%=request.getContextPath()%>/SrvPedido";
                document.form.method = 'GET';
                document.form.submit();
            }
            function irVistaGenerarOrdenDeCompra() {
                document.form.action = "<%=request.getContextPath()%>/";
                document.form.method = 'GET';
                document.form.submit();
            }
            function irVistaListadoCotizacion() {
                document.form.action = "<%=request.getContextPath()%>/SrvCotizacion";
                document.form.method = 'GET';
                document.form.submit();
            }
        </script>
        <h1>Bienvenidos al sistema de compras!</h1>
        <form name='form'>
            <ul>
                <li>
                    <a href='#' onclick="irVistaListadoPedido()">Ver listado de pedidos</a>
                </li>
                <li>
                    <a href='#' onclick="irVistaGenerarOrdenDeCompra()">Realizar Orden de compra</a>
                </li>
                <li>
                    <a href='#' onclick="irVistaListadoCotizacion()">Ver listado de cotizaciones</a>
                </li>
            </ul>
        </form>
    </body>
</html>
