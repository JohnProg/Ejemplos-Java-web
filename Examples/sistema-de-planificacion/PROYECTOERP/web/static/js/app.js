$(document).on('ready', initApp);

function initApp () {
    $("#cboplanope").on("change", cargarLineas);
    $("#cbolinea").on("change", cargarObjetivos);
    $("#cboob").on("change", cargarSubObjetivos);

    function cargarLineas() {
        var planId = $(this).val(),
            ruta = $(this).data("ruta");
        var  pag = ruta+"?accion=2&planE_id=" + planId;
         $.get(pag, function(data) {
            var html = "<option  value=0> ---- Escoga una Linea ---- </option> ";
            for(var i in data){
                var item = data[i];
                html += "<option value="+item.id+">"+ item.nombre + "</option>"; 
            }
            $("#cbolinea").html(html);    
        });
    }
    function cargarObjetivos() {
        var lineaId = $(this).val(),
            ruta = $(this).data("ruta");
        var  pag = ruta+"?accion=3&linea_id=" + lineaId;
         $.get(pag, function(data) {
            var html = "<option  value=0> ---- Escoga un Objetivo ---- </option> ";
            for(var i in data){
                var item = data[i];
                html += "<option value="+item.id+">"+ item.nombre + "</option>"; 
            }
            $("#cboob").html(html);    
        });
    }
    function cargarSubObjetivos() {
        var objetivoId = $(this).val(),
            ruta = $(this).data("ruta");
        var  pag = ruta+"?accion=4&obj_id=" + objetivoId;
         $.get(pag, function(data) {
            var html = "<option  value=0> ---- Escoga un Sub-objetivo ---- </option> ";
            for(var i in data){
                var item = data[i];
                html += "<option name=id_sub_objetivo value="+item.id+">"+ item.nombre + "</option>"; 
            }
            $("#cbosub").html(html);    
        });
    }
    var txtSearch = document.getElementById("txtSearch");
    txtSearch.addEventListener('keyup', searchByText);
    function searchByText () {
        var $rows = $('#table tr');
        var val = txtSearch.value.trim().toLowerCase();

        $rows.show().filter(function() {
            var text = $(this).text().toLowerCase();
            return !~text.indexOf(val);
        }).hide();
    }
}