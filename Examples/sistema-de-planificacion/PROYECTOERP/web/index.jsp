<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión</title>
        <!-- Meta -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">    
        <link rel="shortcut icon" href="favicon.ico">  
        <link href="http://fonts.googleapis.com/css?family=Roboto:400,400italic,500,500italic,700,700italic,900,900italic,300italic,300" rel="stylesheet" type="text/css"> 
        <link href="http://fonts.googleapis.com/css?family=Roboto+Slab:400,700,300,100" rel="stylesheet" type="text/css">
        <!-- Global CSS -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">   
        <!-- Plugins CSS -->    
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/flexslider.css">
        <!-- Theme CSS -->
        <link id="theme-style" rel="stylesheet" href="<%=request.getContextPath()%>/static/css/styles-9.css">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
       
    </head>
    <body class="home-page" data-twttr-rendered="true">  
        <script>
            var URLS = {
                listPlan: "<%=request.getContextPath()%>/UsuarioServlet"
            };

            function goToLoginView() {
                document.form.action = URLS.listPlan;
                document.form.method = 'GET';
                document.form.submit();
            }
            function goToCreateAccountView () {
                document.form.action = URLS.listPlan;
                document.form.method = 'GET';
                document.form.submit();
            }
        </script>
    <!-- ******HEADER****** --> 
    <header id="header" class="header">  
        <div class="container">       
            <h1 class="logo">
                <a href=""><span class="text"> PLANNING</span></a>
            </h1><!--//logo-->
            <nav class="main-nav navbar-right" role="navigation">
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button><!--//nav-toggle-->
                </div><!--//navbar-header-->
                <form name='form' id="navbar-collapse" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active nav-item"><a href="#">Inicio</a></li>                      
                        <li class="nav-item">
                            <a href="<%=request.getContextPath()%>/iniciarSesion.jsp">Iniciar Sesión</a>
                        </li>
                        <li class="nav-item nav-item-cta last">
                            <a class="btn btn-cta btn-cta-secondary" 
                               href="<%=request.getContextPath()%>/crearCuenta.jsp">Crear Cuenta</a>
                        </li>
                    </ul><!--//nav-->
                </form><!--//navabr-collapse-->
            </nav><!--//main-nav-->                     
        </div><!--//container-->
    </header><!--//header-->
    
    <div class="bg-slider-wrapper">
        <div class="flexslider bg-slider">
            <ul class="slides">
                <li class="slide slide-1"></li>
                <li class="slide slide-2"></li>
                <li class="slide slide-3 flex-active-slide"></li>
            </ul>
        </div>
    </div><!--//bg-slider-wrapper-->        
    
    <section class="promo section section-on-bg">
        <div class="container text-center">                
            <h2 class="title">Sistema de Planificacion Estrategica</h2>
            <hr style="width: 300px;">
            <h2> ERP </h2>
            <p class="intro">La Planificación estratégica es un proceso sistematico de desarrollo e implementación de planes para alcanzar propósitos u objetivos. La planificación estratégica se aplica sobre todo en los asuntos militares y en actividades de negocios.</p>
            <p><a class="btn btn-cta btn-cta-primary" href="#">Obten el ERP</a></p>   
            <button type="button" class="play-trigger btn-link " data-toggle="modal" data-target="#modal-video" data-backdrop="static" data-keyboard="false"><i class="fa fa-youtube-play"></i> Mira nuestro video</button>
        </div><!--//container-->
    </section><!--//promo-->
    
<!--    <div class="sections-wrapper">   
             
        
        
         ******CTA Section****** 
        <section class="section cta-section text-center home-cta-section">
            <div class="container">
               <h2 class="title">Ready to get our product?</h2>
               <p class="intro">Stay up to date with the latest news and offers from Planning</p>
                <form class="signup-form navbar-form">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Enter your email address">
                    </div>   
                    <button type="submit" class="btn btn-cta btn-cta-primary">Subscribe Now</button>                                 
                </form>   
            </div>//container
        </section>//cta-section
        
    </div>//section-wrapper-->
<!--    
     ******FOOTER******  
    <footer class="footer">
        <div class="bottom-bar">
            <div class="container">
                <small class="copyright">Copyright @ 2014 <a href="/" target="_blank"></a></small>                
            </div>//container
        </div>//bottom-bar
    </footer>//footer
    -->
    <!-- Video Modal -->
    <div class="modal modal-video" id="modal-video" tabindex="-1" role="dialog" aria-labelledby="videoModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 id="videoModalLabel" class="modal-title sr-only">Video Tour</h4>
                </div>
                <div class="modal-body">
                    <div class="video-container">
                        <div class="fluid-width-video-wrapper" style="padding-top: 56.25%;"><iframe src="//player.vimeo.com/video/28872840?color=ffffff&amp;wmode=transparent" frameborder="0" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen="" id="fitvid5319"></iframe></div>
                    </div><!--//video-container-->
                </div><!--//modal-body-->
            </div><!--//modal-content-->
        </div><!--//modal-dialog-->
    </div><!--//modal-->
    
 
    <!-- Javascript -->          
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/bootstrap.min.js"></script> 
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/bootstrap-hover-dropdown.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/back-to-top.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery.placeholder.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery.fitvids.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/plugins/jquery.flexslider-min.js"></script>     
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/main.js"></script>
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/app.js"></script>
    
            

 

</html>