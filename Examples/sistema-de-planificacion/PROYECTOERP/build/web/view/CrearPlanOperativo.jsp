<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
        <title> Plan Operativo </title>
    </head>
    <body>
        <div class="container">
            <br>
            <button class="btn btn-lg btn-danger"> Salir </button>
            <br><br><br>
            <section class="row col-sm-4 col-sm-offset-4" style="">
                <div class="col-sm-4 col-sm-offset-1" id="plan-operativo">
                    <h2 style="width:200px; text-align:center;">Plan Operativo</h2>
                    <br><br>

                    <form role="form" name="form" method="post" id="miFormulario" >
                        <div style="width: 300px;" class="form-group">
                            <label> Nombre: </label>
                            <input type="text" autofocus="true" class="form-control" name="nombre" id="TxtNombre"/>
                            <label class="error" form="nombre" generated="true"></label>                       
                        
                        <div class="form-group">
                            <br>
                            <label> Area : </label>
                            <br>
                            <select class="form-control">
                                <option value="default"> ---- Escoga una area ---- </option>
                                <option value="1"> area 1</option>
                                <option value="2"> area 2</option>
                            </select>
                        </div>
                        <br>
                        <button class="btn btn-lg btn-info" id="btnCrear"> Crear Plan Operativo </button>

                    </form>
                </div>
            </section>   

            <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
            <script src="../dist/jquery.validate.js"></script>
            <script type="text/javascript">

                $(function(){
                    $("#btnCrear").on("click", function(){
                            $("#miFormulario").validate(
                            {
                                rules:
                                {
                                    nombre:{required:true, minlength:8, maxlength:10}
                                },

                                messages:
                                {
                                    nombre:{required:'El campos es obligatorio'}
                                }
                            });
                    });

                });

            </script> 

    </body>
</html>