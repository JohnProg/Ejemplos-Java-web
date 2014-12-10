<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Objetivo</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/main.css">
</head>
<body>
	<div class="container">
		
		<br>
		<header>
			<a href="list.html" class="pull-right btn btn-info btn-lg">Regresar</a>
			<br>
			<br>
			<h1>Crear Objetivo:</h1>
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
			<form class="col-sm-12" method="post" action="<%=request.getContextPath()%>/ObjetivoServlet">
                            <input type="hidden" name="option" value="1" />
                            <input type="hidden" name="id_linea" value="<%=request.getAttribute("id_linea") %>"> 
                            <fieldset class="form-group">
					<div class="row">
						<div class="col-sm-2">
							<label class="label-control" >Nombre: </label>
						</div>
						<div class="col-sm-4">
                                                    <input type="text" class="form-control" autofocus="true" id="txtName" placeholder=" Ingresa el nombre">
						</div>			
					</div>
					<div class="row">
						<div class="col-sm-2">
							<label class="label-control" >Descripción: </label>
						</div>
						<div class="col-sm-4">
                                                    <textarea class="form-control" id="txtDescription" col="3" placeholder="Ingresa la descripcion"></textarea>
						</div>			
					</div>
					<br>
					<div class="row">
                                                <div class="col-sm-offset-2 col-sm-2">
							<input type="submit" value="Crear" id="btnAdd" class="btn btn-block btn-lg btn-success">
						</div>
						<div class="col-sm-2">
							<a href="<%=request.getContextPath()%>/ObjetivoServlet?option=1&id_linea=<%=request.getAttribute("id_linea") %>" class="btn btn-block btn-lg btn-danger">Cancelar</a>
						</div>
					</div>
				</fieldset>
			</form>
		</section>
	</div>
	<script type="text/javascript" src="../../../static/js/goal.js"></script>
</body>
</html>