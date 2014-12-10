<%@page import="maristas.beans.UsuarioBean"%>
<%@page import="maristas.dao.objetivoDAO"%>
<%@page import="maristas.beans.ObjetivoBean"%>
<%@page import="java.util.ArrayList"%>
<%
    ObjetivoBean  objetivoBean = null;
    UsuarioBean  userBean = null;
    ArrayList<ObjetivoBean> objetivos=null;
%>
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
        <script>
            function regresar(){
                document.form.action = "<%=request.getContextPath()%>/LineaServlet";
                document.form.method = "GET";
                document.form.option.value="2";
                document.form.submit();
            }
            function sub_objetivos(objetivo_id){
                document.form.action = "<%=request.getContextPath()%>/SubObjetivoServlet";
                document.form.method = "GET";
                document.form.option.value="1";
                document.form.id_objetivo.value=objetivo_id;
                document.form.submit();
            }
            function crear(objetivo_id) {
                document.form.action = "<%=request.getContextPath()%>/ObjetivoServlet";
                document.form.method = "GET";
                document.form.option.value="2";
                document.form.id_objetivo.value=objetivo_id;
                document.form.submit();
            }
            function actualizar() {
                document.form.action = "<%=request.getContextPath()%>/ObjetivoServlet";
                document.form.method = "GET";
                document.form.option.value="3";
                document.form.submit();
            }
            function eliminar() {
                document.form.action = "<%=request.getContextPath()%>/ObjetivoServlet";
                document.form.method = "POST";
                document.form.option.value="3";
                document.form.submit();
            }
            function cerrarSesion() {
                document.form.action = "<%=request.getContextPath()%>/UsuarioServlet";
                document.form.method = "GET";
                document.form.option.value="SALIR";
                document.form.submit();
            }
        </script>
        <nav class="navbar navbar-default" role="navigation">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <a class="navbar-brand" href="#">Maristas</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

              <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                    <%  userBean = (UsuarioBean)session.getAttribute("DatosUsuario"); 
                        if(userBean != null) {
                            out.println(userBean.getUsername());
                        }
                    %>
                    </a>
                </li>
               <li class="dropdown"><a href="#">Salir</a></li>
              </li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
	<div class="container">
		<br>
		<header>
                <a onclick="crear()" class="pull-right btn btn-primary btn-lg">+ Crear</a>
                <a href="#" onclick="regresar()" class="pull-right btn btn-danger btn-lg" id="btnSalir">Regresar</a>
		<hr>
		<h1>Plan 1 >> Línea 1 >> Objetivos </h1>
		</header>		
		<br>
		<section class="row">
                    
			<form class="col-sm-12">
                            <input  type="hidden"  name="option">
                            <input type="hidden" name="id_linea" value="<%=request.getAttribute("id_linea") %>">
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
								<th>Descripción</th>
								<th>Opciones</th>
							</tr>
						</thead>
                                                <tbody>
                                                    <%  
                                                        objetivos = (ArrayList<ObjetivoBean>)request.getAttribute("objetivos");  
                                                        if(objetivos != null) {
                                                            for(ObjetivoBean   obj:objetivos) {   %>
                                                            <tr>
                                                               <td><%=obj.getId()%></td>
                                                               <td><%=obj.getNombre()%></td>
                                                               <td><%=obj.getDescripcion()%></td>
                                                               <td>
                                                                   <a onclick="lineas(<%=obj.getId()%>)"><span class="label label-success">Lineas</span></a> |
                                                                   <a onclick="actualizar()"><span class="label label-primary">Actualizar</span></a> |
                                                                   <a onclick="eliminar()"><span class="label label-warning">Eliminar</span></a>
                                                           </tr>
                                                          <%   }
                                                          }%>
                                                    
                                                </tbody>
					</table>
				</fieldset>
			</form>
		</section>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-1.11.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-migrate-1.2.1.min.js"></script>
            <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/app.js"></script>
</body>
</html>