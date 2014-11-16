<html>
    <head>
        <title>Rest Plan</title>
    </head>
    
    <button id="getPlan">Ver planes</button>
    
    <body>
        <script type="text/javascript" src="../../static/js/jquery.min.js"></script>
        <script>
            $(document).on("ready", function(){
               $("#getPlan").on("click", function(){
                      $.ajax({
                        url:"http://localhost:8084/PROYECTOERP/views/rest/plan/list.jsp",
                        type:"GET",
                        data:{},
                        contentType:"application/json; charset=utf-8",
                        dataType:"json",
                        success: function(res){
                            debugger
                        }
                      })
               }) 
            });

        </script>
    </body>

</html>