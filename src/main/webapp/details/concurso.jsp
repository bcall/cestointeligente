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
<title>Cestos inteligentes - Detalle de Concursos</title>
<c:set var="sectionLabel" value="Detalle de Concursos" scope="session" />
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
					style="margin-bottom: 7px; height: 22vh;">
					
					
					<div class="panel-body">
					    <div class="panel-heading"><h3 style="margin:0;text-align:center;">${concurso.descripcion} </h3></div>
						<div class="bold" style="text-align: center;">Fecha de Vigencia: 01/03/2017 al 31/03/2017</div>
					
							
								<div id="map-canvas"></div>
						<div class="panel-heading"></div>
						
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
			
			<div class="col-lg-6">
				<div class="panel panel-default out-shadow" style="margin-bottom: 7px;">
				<div class="panel-heading"><h3 style="margin:0;text-align:center;">Usuarios</h3></div>
					<div class="panel-body">
                                <table class="table table-striped table-bordered table-hover" id="topTable">
									<thead>
								<tr>
									<th>Id</th>
									<th>Nombre</th>
									<th>Apellido</th>
									<th>Telefono</th>
									<th></th>
								</tr>
							</thead>
							</table>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
			<div class="col-lg-6">
				<div class="panel panel-default out-shadow" style="margin-bottom: 7px;">
					<div class="panel-heading">
						<h3 style="margin: 0; text-align: center;">Puntos Verdes</h3>
					</div>
					<div class="panel-body">
						<div id="topTable_wrapper" class="dataTables_wrapper form-inline" role="grid"><div class="row"><div class="col-sm-6"><div class="dataTables_length" id="topTable_length"><label>Mostrar <select name="topTable_length" aria-controls="topTable" class="form-control input-sm"><option value="10">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select></label></div></div><div class="col-sm-6"><div id="topTable_filter" class="dataTables_filter"><div class="form-group input-group" style="float: right; margin-bottom: 10px;"><input type="search" class="form-control" placeholder="Buscar..." aria-controls="topTable"> <span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i></button></span></div></div></div></div><table class="table table-striped table-bordered table-hover dataTable no-footer" id="topTable" aria-describedby="topTable_info">
							<thead>
								<tr role="row"><th class="sorting_asc" tabindex="0" aria-controls="topTable" rowspan="1" colspan="1" aria-label="Ubicacion: Activar para ordenar la columna de manera ascendente" aria-sort="ascending" style="width: 223px;">Ubicacion</th><th class="sorting" tabindex="0" aria-controls="topTable" rowspan="1" colspan="1" aria-label="Acumulado: Activar para ordenar la columna de manera ascendente" style="width: 246px;">Acumulado</th><th class="sorting" tabindex="0" aria-controls="topTable" rowspan="1" colspan="1" aria-label="Recogido: Activar para ordenar la columna de manera ascendente" style="width: 215px;">Recogido</th><th class="sorting" tabindex="0" aria-controls="topTable" rowspan="1" colspan="1" aria-label="Peso Actual: Activar para ordenar la columna de manera ascendente" style="width: 256px;">Peso Actual</th><th class="sorting" tabindex="0" aria-controls="topTable" rowspan="1" colspan="1" aria-label=": Activar para ordenar la columna de manera ascendente" style="width: 47px;"></th></tr>
							</thead>
						<tbody><tr class="odd">
								<td class="sorting_1">Punto verde 1</td>
								<td class=" ">24.216</td>
								<td class=" ">0</td><td class=" ">24.216</td>
								<td class=" "><a href="../sections/isladetails?projectId=200&amp;locationId=2" class="fa fa-eraser"></a></td>
								</tr>
								<tr class="odd">
								<td class="sorting_1">Punto verde 2</td>
								<td class=" ">24.216</td>
								<td class=" ">0</td><td class=" ">24.216</td>
								<td class=" "><a href="../sections/isladetails?projectId=200&amp;locationId=2" class="fa fa-eraser"></a></td>
								</tr>
								<tr class="odd">
								<td class="sorting_1">Punto verde 3</td>
								<td class=" ">24.216</td>
								<td class=" ">0</td><td class=" ">24.216</td>
								<td class=" "><a href="../sections/isladetails?projectId=200&amp;locationId=2" class="fa fa-eraser"></a></td>
								</tr>
								</tbody></table><div class="row"><div class="col-sm-6"><div class="dataTables_info" id="topTable_info" role="alert" aria-live="polite" aria-relevant="all"></div></div><div class="col-sm-6"><div class="dataTables_info" id="orderedBy" role="alert" aria-live="polite" aria-relevant="all"></div></div><div class="col-sm-6"><div class="dataTables_paginate paging_simple_numbers" id="topTable_paginate"><ul class="pagination"><li class="paginate_button previous disabled" aria-controls="topTable" tabindex="0" id="topTable_previous"><a href="#">Anterior</a></li><li class="paginate_button active" aria-controls="topTable" tabindex="0"><a href="#">1</a></li><li class="paginate_button next disabled" aria-controls="topTable" tabindex="0" id="topTable_next"><a href="#">Siguiente</a></li></ul></div><a class="btn btn-primary" href="../sections/nuevoconcurso">Agregar Puntos Verdes</a></div></div></div>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
	 </section>
	</div>
	
<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.dataTables.js"></script>
	<script src="../js/dataTables.bootstrap.js"></script>
	<script src="../js/Chart.min.js" type="text/javascript"></script>
	<!-- 	<script src="../js/btp.dataTable.js"></script> -->
	<script src="../js/scripts.js"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript">
		var date = new Date();
		lang = {
			"sProcessing" : "Procesando...",
			"sLengthMenu" : "Mostrar _MENU_ registros",
			"sZeroRecords" : "No se encontraron resultados",
			"sEmptyTable" : "Ningún dato disponible en esta tabla",
			"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix" : "",
			"sUrl" : "",
			"sInfoThousands" : ",",
			"sLoadingRecords" : "Cargando...",
			"oPaginate" : {
				"sFirst" : "Primero",
				"sLast" : "Último",
				"sNext" : "Siguiente",
				"sPrevious" : "Anterior"
			},
			"oAria" : {
				"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",
				"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
			}
		};
		function loadData(val) {
			var range = new Date(date.getFullYear(), date.getMonth(), date
					.getDate()
					- parseInt(val)).toLocaleDateString();
			if (val == 0) {
				$('.dateRange').text(date.toLocaleDateString());
			} else {
				$('.dateRange').text(date.toLocaleDateString() + ' - ' + range);
			}
			$.get("../services/usuarioTableData", function(data) {
				dataTable.fnClearTable();
				dataTable.fnAddData(data);
			});
		}
		$(function() {
			dataTable = $('#topTable')
					.dataTable(
							{
								"columnDefs" : [ {
									"targets" : 4,
									"data" : "id",
									"render" : function(data, type, full, meta) {
										return '<a href="../sections/borrarusuario?id='
												+ data
												+ '"class="fa fa-eraser"></a>';
									}
								} ],

								"language" : lang,
								"columns" : [ {
									"data" : "id"
								}, {
									"data" : "nombre"
								}, {
									"data" : "apellido"
								}, {
									"data" : "telefono"
								} ]

							});
			$('.row:eq(1) .col-sm-6:eq(0)')
					.after(
							'<div class="col-sm-6"><div class="dataTables_info" id="orderedBy" role="alert" aria-live="polite" aria-relevant="all"></div></div>&nbsp;&nbsp;&nbsp;<a class="btn btn-primary" href="../sections/nuevoconcurso">Agregar usuario</a>');
			$('.input-sm').after('<label class="dateRange"></label>');
			loadData(0);
			$("select[name='topTable_length']").change(function() {
				loadData(values[this.selectedIndex]);
			});

			dataTable.on('order.dt',
					function(e, settings, sorting, columns) {
						sort = (sorting[0].dir == 'asc') ? 'ascendente'
								: 'descendente';
						text = 'Ordenando por: '
								+ $('th:eq(' + sorting[0].col + ')').text()
								+ ' - ' + sort;
						$('#orderedBy').text(text);
					});

		});
	</script>
</body>
</html>