<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bienvenido</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/main.css">
</head>
<body>
	<div class="container">
		<br>
		<header>
                    <a href="index.html" class="pull-right btn btn-danger btn-lg" id="btnSalir">Salir</a>
		<br>
			<br>
			<h1>Crear Línea:</h1>
			<hr>
		</header>		
		<br>
		<section class="row">
                        <% if(request.getAttribute("status") == "ok"){ %>
                            <div class="alert alert-success">
                                <%=request.getAttribute("mensaje") %>
                            </div>
                        <%}%>
                        <% if(request.getAttribute("status") == "fail"){ %>
                            <div class="alert alert-danger">
                                <%=request.getAttribute("mensaje") %>
                            </div>
                        <%}%>
			<form class="col-sm-12" method="post" action="<%=request.getContextPath()%>/LineaServlet">
                                <input type="hidden" name="option" value="1">
                                <input type="hidden" name="id_plan" value="<%=request.getAttribute("id_plan") %>"> 
				<fieldset class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label class="label-control" >Nombre: </label>
						</div>
						<div class="col-sm-4">
                                                    <input type="text" class="form-control" autofocus="true" name="nombre" id="nombre" placeholder=" Ingresa el nombre">
						</div>			
					</div>									
					<br>
					<div class="row">
						<div class="col-sm-2">
							<label class="label-control" >Descripción: </label>
						</div>
						<div class="col-sm-4">
                                                    <textarea class="form-control" id="descripcion" name="descripcion" col="3" placeholder="Ingresa la descripcion"></textarea>
						</div>			
					</div>
					<br>
					<div class="row">
						<div class="col-sm-offset-2 col-sm-2">
							<input type="submit" value="Crear" id="btnAdd" class="btn btn-block btn-lg btn-success">
						</div>
						<div class="col-sm-2">
							<a href="<%=request.getContextPath()%>/LineaServlet?option=1&id_plan=<%=request.getAttribute("id_plan") %>" class="btn btn-block btn-lg btn-danger">Cancelar</a>
						</div>
					</div>
				</fieldset>				
			</form>
		</section>
	</div>
	<script type="text/javascript" src="../../../static/js/line.js"></script>
</body>
</html>