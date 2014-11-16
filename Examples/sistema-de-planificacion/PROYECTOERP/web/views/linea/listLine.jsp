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
                        <a href="#" class="pull-right btn btn-info btn-lg">Regresar</a>
                        <br>
                        <br>
                        <h1>Plan 1 >> L�neas <a href="create.html" class="pull-right btn btn-primary btn-lg">+ Crear</a></h1>
                        <hr>
                </header>		
                <br>
                <section class="row">
                            <form class="col-sm-12">
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
                                                                    <th>Descripci�n</th>
                                                                    <th>Opciones</th>
                                                            </tr>
                                                    </thead>
                                                    <tbody></tbody>
                                            </table>
                                    </fieldset>
                            </form>
                </section>
            </div>
    </body>
</html>