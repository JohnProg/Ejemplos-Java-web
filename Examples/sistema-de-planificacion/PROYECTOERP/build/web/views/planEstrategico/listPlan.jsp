<%@page import="maristas.dao.planDAO"%>
<%@page import="maristas.beans.PlanEstrategicoBean"%>
<%@page import="java.util.ArrayList"%>
<%
PlanEstrategicoBean  objEmpleBean=null;
ArrayList<PlanEstrategicoBean>          plans=null;
%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Bienvenido</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
                <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
</head>
<body>
    <script>
        function crear() {
            document.form.action = "<%=request.getContextPath()%>/createPlanServlet";
            document.form.method = "GET";
            document.form.accion.value="CREATE";
            document.form.submit();
        }
        function actualizar() {
            document.form.action = "<%=request.getContextPath()%>/updatePlanServlet";
            document.form.method = "GET";
            document.form.accion.value="UPDATE";
            document.form.submit();
        }
        function eliminar() {
            document.form.action = "<%=request.getContextPath()%>/deletePlanServlet";
            document.form.method = "GET";
            document.form.accion.value="DELETE";
            document.form.submit();
        }
    </script>
	<div class="container">
		<br>
		<header>
			<a href="../../index.html" class="pull-right btn btn-danger btn-lg" id="btnSalir">Salir</a>
			<br>
			<br>
                        <h1>Planes estratégicos: <a href="#" onclick='javascript:crear()'class="pull-right btn btn-primary btn-lg">+ Crear</a></h1>
			<hr>
		</header>		
		<br>
		<section class="row">            
                    <form class="col-sm-12" name="form">
                        <input  type="hidden"  name="accion">
				<fieldset class="form-group">
					<div class="row">
						<div class="col-sm-1">
							<label class="label-control" >Buscar: </label>
						</div>
						<div class="col-sm-4">
							<input type="text" class="form-control" autofocus="true" id="txtSearch" placeholder="Buscando...">
						</div>			
					</div>					
					<br>
				</fieldset>
				<br>
				<fieldset>
					<table class="table table-stripped table-responsive">
						<thead>
							<tr>
								<th>#</th>
								<th>Nombre</th>
								<th>Fecha de Vigencia</th>
								<th>Fecha de Término</th>
								<th>Año de inicio</th>
								<th>Año de término</th>
								<th>Aprobado por</th>
								<th>Descripción</th>
								<th>Opciones</th>
							</tr>
						</thead>
						<tbody id="table">
                                                     <%  
                                                        plans = (ArrayList<PlanEstrategicoBean>)request.getAttribute("plans");  
                                                        if(plans != null) {
                                                            for(PlanEstrategicoBean   obj:plans) {   %>
                                                            <tr>
                                                                <td>1</td>
                                                               <td><%=obj.getNombre()%></td>
                                                               <td><%=obj.getFec_vigencia()%></td>
                                                               <td><%=obj.getFec_termino()%></td>
                                                               <td><%=obj.getAnio_inicio()%></td>
                                                               <td><%=obj.getAnio_termino()%></td>
                                                               <td><%=obj.getAprobado_por()%></td>
                                                               <td><%=obj.getDescripcion()%></td>
                                                               <td><a onclick="actualizar()">Actualizar</a>
                                                                   <a onclick="eliminar()">Eliminar</a>
                                                                   <a href="/lineas/">Lineas</a></td>
                                                           </tr>
                                                          <%   }
                                                          }%>
						</tbody>
					</table>
				</fieldset>
			</form>
		</section>
	</div>
                                                
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
	<script type="text/javascript" src="../../static/js/strategy.js"></script>
</body>
</html>