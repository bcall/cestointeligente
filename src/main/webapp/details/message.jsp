<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Proyecto - Detalle Establecimiento</title>
<c:set var="sectionLabel" value="Detalle Establecimiento" scope="session" />
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<link href="../css/jquery-ui.min.css" rel="stylesheet">
<link href="../css/jquery-ui.theme.css" rel="stylesheet">
<link href="../fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>
<body>
	<!-- Navigation -->
	<c:import url="../includes/nav" />
	<!-- Page Content -->
	<div class="container">
		<section>
			<div class="col-lg-12">
				<div class="panel panel-default out-shadow"
					style="margin-bottom: 7px; height: 40vh;">
					
					<div class="panel-body">
					    <div class="panel-heading"><h3 style="margin:0;text-align:center;">Isla</h3></div>
						<div class="bold" style="text-align: center;"></div>
						<div style="width: 220px; margin: auto;">
											
						</div>
						<div class="table-responsive tableMed">
							<table class="table">
								<tr>
									<td class="bold">Ubicación:</td>
									<td>${isla.ISLAPOSICION}</td>
								</tr>
								<tr>
									<td class="bold">Peso Actual:</td>
									<td>${isla.LASTW}</td>
								</tr>
								<tr>
									<td class="bold">Acumulado:</td>
									<td>${isla.HINPUT}</td>
								</tr>
								<tr>
									<td class="bold">Recogido:</td>
									<td>${isla.HOUTPUT}</td>
								</tr>
								</tbody>
							</table>
						</div>
						<div class="panel-heading"></div>
						
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
			
			<div class="col-lg-12">
				<div class="panel panel-default out-shadow" style="margin-bottom: 7px;">
				<div class="panel-heading"><h3 style="margin:0;text-align:center;">Cestos</h3></div>
					<div class="panel-body">
                                <table class="table table-striped table-bordered table-hover" id="topTable">
								<thead>
									<tr>
									    
										<th>Proyecto</th>
										<th>Estado</th>
										<th>Tipo de Residuo</th>
										<th>Corriente de Residuo</th>
										<th></th>
									</tr>
								</thead>
							</table>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
		</section>
	</div>
			
	<div id="overlay"
		style="position: absolute; width: 100%; height: 100%; display: none; top: 0;"></div>
<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.dataTables.js"></script>
	<script src="../js/dataTables.bootstrap.js"></script>
	<!-- 	<script src="../js/btp.dataTable.js"></script> -->
	<script src="../js/scripts.js"></script>
	<script type="text/javascript">
	var date = new Date();
	lang = {
		    "sProcessing":     "Procesando...",
		    "sLengthMenu":     "Mostrar _MENU_ registros",
		    "sZeroRecords":    "No se encontraron resultados",
		    "sEmptyTable":     "Ningún dato disponible en esta tabla",
		    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
		    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
		    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
		    "sInfoPostFix":    "",
		    "sSearch":         "Buscar:",
		    "sUrl":            "",
		    "sInfoThousands":  ",",
		    "sLoadingRecords": "Cargando...",
		    "oPaginate": {
		        "sFirst":    "Primero",
		        "sLast":     "Último",
		        "sNext":     "Siguiente",
		        "sPrevious": "Anterior"
		    },
		    "oAria": {
		        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
		        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
		    }
		};
	function loadData(val){
		var range = new Date(date.getFullYear(),date.getMonth(),date.getDate()-parseInt(val)).toLocaleDateString();
		if(val == 0){
			$('.dateRange').text(date.toLocaleDateString());
		}else{
			$('.dateRange').text(date.toLocaleDateString()+' - '+ range);
		}
		$.get("../services/messages", function(data) {
		
			dataTable.fnClearTable();
			dataTable.fnAddData(data);
		});
	}
		$(function() {
			values = [0,1,7,30,60,365];
			dataTable = $('#topTable').dataTable({
			 "columnDefs": [ {
                "targets": 4,
                "data": "name",
                "render": function ( data, type, full, meta ) {
                          return '<a href="'+data+'"class="fa fa-arrow-circle-right"></a>';
                                  }
                } ],

            	"language" : lang,
				"columns" : [ {
					"data" : "mensajeId"
				}, {
					"data" : "composteraId"
				}, {
					"data" : "evento"
				}, {
					"data" : "fecha"
				}, {
					"data" : "peso"
				}]
				
			});
			$('.row:eq(1) .col-sm-6:eq(0)').after('<div class="col-sm-6"><div class="dataTables_info" id="orderedBy" role="alert" aria-live="polite" aria-relevant="all">Ordenando por: Establecimiento - ascendente</div></div>');
			$('.input-sm').after('<label class="dateRange"></label>');
			loadData(0);
			$("select[name='topTable_length']").change(function(){
				loadData(values[this.selectedIndex]);
			});
			
			dataTable.on( 'order.dt', function (e, settings, sorting, columns) {
				sort = (sorting[0].dir=='asc')?'ascendente':'descendente';
				text = 'Ordenando por: '+$('th:eq('+sorting[0].col+')').text() + ' - ' + sort ;
				$('#orderedBy').text(text);
			});
			
		});
		
	</script>
</body>
</html>