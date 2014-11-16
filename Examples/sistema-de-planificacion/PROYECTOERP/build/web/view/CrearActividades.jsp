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
            <br>
            <section class="row col-sm-12 col-sm-offset-0">
                <h2 style="text-align:center;"> Plan Operativo</h2>
                <hr>
                <div class="col-sm-4 col-sm-offset-1" id="plan-operativo">
                    <form role="form" name="form">
                        <div class="form-group">
                            <label> Plan : </label>
                            <select class="form-control" id="cboPlanop">
                                <option> ---- Escoga un Plan ---- </option>
                                <option> Plan operativo 1</option>
                                <option> Plab operativo 2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label> Linea : </label>
                            <select class="form-control">
                                <option> ---- Escoga una Linea ---- </option>
                                <option> Linea 1</option>
                                <option> Linea 2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label> Objetivos: </label>
                            <select class="form-control">
                                <option> ---- Escoga un Objetivo ---- </option>
                                <option> Objetivo 1</option>
                                <option> Objetivo 2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label> Sub-Objetivos : </label>
                            <select class="form-control">
                                <option> ---- Escoga un Sub-objetivo ---- </option>
                                <option> Sub-Objetivo 1</option>
                                <option> Sub-Objetivo 2</option>
                            </select>
                        </div>

                    </form>
                </div>

                <div class="col-sm-4 col-sm-offset-1" id="plan-operativo">
                    <br>
                    <form role="form" name="form">
                        <div class="form-group">
                            <label> Titulo:</label>
                            <input type="text" autofocus="true" class="form-control" id="TxtTitulo" placeholder=" Agrega un titulo "> 
                        </div>
                        <div class="form-group">
                            <label> Descripción: </label>
                            <input type="text" autofocus="true" class="form-control" id="TxtDesc" placeholder=" ----- ">
                        </div>
                        
                        <button id="Agregar" type="button" class="btn btn-sky text-uppercase btn-lg col-sm-offset-4"> Crear </button>
                    </form>
                </div>
            </section>

                    </form>
                </div>
            </section>   
    </body>
</html>