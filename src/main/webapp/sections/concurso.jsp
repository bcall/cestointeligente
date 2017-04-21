<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Concursos</title>
<c:set var="sectionLabel" value="Rankings" scope="session" />
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<link href="../css/jquery-ui.min.css" rel="stylesheet">
<link href="../css/jquery-ui.theme.css" rel="stylesheet">
<link href="../fonts/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
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
		<section style="height: 90vh;">
			<div class="col-lg-12">
				<div class="panel panel-default out-shadow"
					style="margin-bottom: 7px;">
					<div class="panel-heading">
						<h3 style="margin: 0; text-align: center;">Concursos</h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-bordered table-hover"
							id="topTable">
							<thead>
								<tr>
									<th>Id</th>
									<th>Nombre</th>
									<th>Fecha Inicio</th>
									<th>Fecha Fin</th>
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
	<!-- /.container -->
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
			"sProcessing" : "Procesando...",
			"sLengthMenu" : "Mostrar _MENU_ registros",
			"sZeroRecords" : "No se encontraron resultados",
			"sEmptyTable" : "Ningún dato disponible en esta tabla",
			"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
			"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix" : "",
			"sSearch" : "Buscar:",
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
			$.get("../services/concursoTableData", function(data) {
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
									"data" : "codigo",
									"render" : function(data, type, full, meta) {
										return '<a'
												+ data
												+ '"class="fa fa-pencil-square"></a>&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="../sections/obtenerconcurso?codigo='
												+ data
												+ '"class="fa fa-arrow-right"></a>';
									}
								} ],

								"language" : lang,
								"columns" : [ {
									"data" : "id"
								}, {
									"data" : "descripcion"
								}, {
									"data" : "fechaInicio"
								}, {
									"data" : "fechaFin"
								} ]

							});
			$('.row:eq(1) .col-sm-6:eq(0)')
					.after(
							'<div class="col-sm-6"><div class="dataTables_info" id="orderedBy" role="alert" aria-live="polite" aria-relevant="all">Ordenando por: Establecimiento - ascendente</div></div><a class="btn btn-primary" href="../index">Volver</a>&nbsp;&nbsp;&nbsp;<a class="btn btn-primary" href="../sections/nuevoconcurso">Nuevo Concurso</a>');
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