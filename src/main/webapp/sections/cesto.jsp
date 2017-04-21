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
<title>Proyecto - Detalle Cesto</title>
<c:set var="sectionLabel" value="Detalle Cesto" scope="session" />
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
        <style>
        .noBorder>td{
        border-top:none !important;
        }
        .nAlive{
        text-align:center;
        color:red;
        }
        </style>
</head>
<body>
	<!-- Navigation -->
	<c:import url="../includes/nav" />
	<!-- Page Content -->
	<div class="container">
		<section style="height: 80vh;">
			<div class="col-lg-3">
				<div class="panel panel-default out-shadow" style="height: 900px;">
					<div class="panel-heading">
						<div class="form-group input-group" style="margin-bottom: 0;">
							<input id="compSearch" type="text" class="form-control"
								placeholder="Buscar..."> <span class="input-group-btn"><button
									class="btn btn-default" type="button">
									<i class="fa fa-search"></i>
								</button></span>
						</div>
					</div>
					<div class="panel-body">
					<h4 style="text-align:center;margin-top:0;">Cesto</h4>
							<div style="width:150px;margin:auto;margin-bottom: 20px;">
						<img class="img-thumbnail" src="../images/comp/${comp.IMAGE}" width="150px"height="150px" style="max-height: 150px;">
						</div>
						<div class="alert alert-fail"
							style="margin: 0 0 10px; padding: 5px; text-align: center;">${comp.STATUS}</div>
						<div class="table-responsive tableMed">
							<table class="table">
								<tbody>
									<tr>
										<td class="bold">ID</td>
										<td>${comp.ID}</td>
									</tr>
									<tr>
										<td class="bold">Modelo</td>
										<td>${comp.MODEL_NAME}</td>
									</tr>
									<tr>
										<td class="bold">Volúmen</td>
										<td>${comp.VOLUME}</td>
									</tr>
									<tr>
										<td class="bold">Peso Alarma</td>
										<td>${comp.ALARM_W}</td>
									</tr>
									<tr>
										<td class="bold">Hardware</td>
										<td>${comp.HARD_D}</td>
									</tr>
									<tr>
										<td class="bold">Firmware</td>
										<td>${comp.FIRMWARE}</td>
									</tr>
									<tr>
										<td class="bold">Fecha Fabricación</td>
										<td>${comp.FAB_DATE}</td>
									</tr>
									<tr>
										<td class="bold">Tipo de Residuo</td>
										<td>${comp.TIPO_RESIDUO}</td>
									</tr>
									<tr>
										<td class="bold">Corriente Residuo</td>
										<td>${comp.CORRIENTE_RESIDUO}</td>
									</tr>
								</tbody>
							</table>
						</div>
						
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
			<div class="col-lg-9" style="padding:0;">
				<div class="panel panel-default out-shadow" style="margin-bottom: 7px;height: 250px;">
				<div class="panel-body" style="padding:0;margin:0;"> </div>
			</div>
			</div>		
			<div class="col-lg-8" style="padding:0;">
				<div class="panel panel-default">
					<div class="panel-body" style="height: 240px;">
						<div class="table-responsive">
							<table
								class="table table-bordered table-hover table-striped tableRed">
								<thead>
									<tr>
										<td rowspan=2></td>
										<td rowspan=2 class="tableHeader" >HOY</td>
										<td rowspan=2 class="tableHeader" >AYER</td>
										<td colspan=4 class="tableHeader" >Últimos</td>
									</tr>
									<tr>
										<td class="tableHeader" >7 Días</td>
										<td class="tableHeader" >30 Días</td>
										<td class="tableHeader" >60 Días</td>
										<td class="tableHeader" >365 Días</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="bold">No Viva</td>
										<td class="nAlive">${nAlive[0]["TD"]}</td>
										<td class="nAlive">${nAlive[0]["YST"]}</td>
										<td class="nAlive">${nAlive[0]["WK"]}</td>
										<td class="nAlive">${nAlive[0]["MTH"]}</td>
										<td class="nAlive">${nAlive[0]["MTH2"]}</td>
										<td class="nAlive">${nAlive[0]["YR"]}</td>
									</tr>
									<tr>
										<td class="bold">Peso Input</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["TD_DAY_IN"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["YST_DAY_IN"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["WK_DAY_IN"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["MTH_DAY_IN"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["MTH2_DAY_IN"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["YR_DAY_IN"]}' /> grs</td>
									</tr>
									<tr>
										<td class="bold">Aperturas Arriba</td>
										<td style="text-align: center;">${stats[0]["TD_C_IN"]}</td>
										<td style="text-align: center;">${stats[0]["YST_C_IN"]}</td>
										<td style="text-align: center;">${stats[0]["WK_C_IN"]}</td>
										<td style="text-align: center;">${stats[0]["MTH_C_IN"]}</td>
										<td style="text-align: center;">${stats[0]["MTH2_C_IN"]}</td>
										<td style="text-align: center;">${stats[0]["YR_C_IN"]}</td>
									</tr>
									<tr>
										<td class="bold">Peso Output</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["TD_DAY_OUT"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["YST_DAY_OUT"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["WK_DAY_OUT"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["MTH_DAY_OUT"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["MTH2_DAY_OUT"]}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##" value='${stats[0]["YR_DAY_OUT"]}' /> grs</td>
									</tr>
									<tr>
										<td class="bold">Aperturas Abajo</td>
										<td style="text-align: center;">${stats[0]["TD_C_OUT"]}</td>
										<td style="text-align: center;">${stats[0]["YST_C_OUT"]}</td>
										<td style="text-align: center;">${stats[0]["WK_C_OUT"]}</td>
										<td style="text-align: center;">${stats[0]["MTH_C_OUT"]}</td>
										<td style="text-align: center;">${stats[0]["MTH2_C_OUT"]}</td>
										<td style="text-align: center;">${stats[0]["YR_C_OUT"]}</td>
									</tr>
									<tr>
										<td class="bold">Peso Input por Usuario</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##"
												value='${stats2[0]["TD_DAY_IN"] / proyect.USERS}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##"
												value='${stats2[0]["YST_DAY_IN"] / proyect.USERS }' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##"
												value='${stats2[0]["WK_DAY_IN"] / proyect.USERS}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##"
												value='${stats2[0]["MTH_DAY_IN"] / proyect.USERS}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##"
												value='${stats2[0]["MTH2_DAY_IN"] / proyect.USERS}' /> grs</td>
										<td style="text-align: center;"><fmt:formatNumber
												pattern="##.##"
												value='${stats2[0]["YR_DAY_IN"] / proyect.USERS}' /> grs</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
			<div class="col-lg-4" style="padding:0;">
				<div class="panel panel-default">
				<div class="panel-heading" style="text-align:center;font-weight: bold;">Mensajes del día</div>
					<div class="panel-body" style="height: 199px; overflow: auto;">
						<ul class="chat">${compAlert}</ul>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
			<!-- /.panel-body -->
				</div>
			</div>

			<div class="col-lg-12">
				<div class="panel panel-default out-shadow" style="margin-bottom: 7px;">
				<div class="panel-heading"><h3 style="margin:0;text-align:center;">Mensajes</h3></div>
					<div class="panel-body">
                                <table class="table table-striped table-bordered table-hover" id="topTable">
								<thead>
									<tr>
									    
										<th>Id</th>
										<th>Fecha</th>
										<th>Cesto</th>
										<th>Evento</th>
										<th>peso (grs.)</th>
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

	<div id="overlay"
		style="position: absolute; width: 100%; height: 100%; display: none; top: 0;"></div>
	<!-- /.container -->
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/scripts.js"></script>
	<script src="../js/sections/comp-details.js"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript">

	function centerOnMap(lat, lng) {
        var pos = new google.maps.LatLng(lat, lng);
        map.setCenter(pos);
        map.setZoom(15);
    }
        var defaultLatLng = new google.maps.LatLng(${estab.LAT}, ${estab.LONG});
        var map;
		var marker;
		var mapOptions = {
                center: defaultLatLng,
                zoom: 15,
                draggable: false,
                disableDefaultUI: true
            };
        function initialize() {
            
            map = new google.maps.Map(document.getElementById("map-canvas"),
                mapOptions);
            marker = new google.maps.Marker({
                position: defaultLatLng,
                map: map,
                title: "Establecimiento"
            });
        }
        $(function(){
        	initialize();
        google.maps.event.addListener(map, 'center_changed', function() {
        	map.panTo(defaultLatLng)
        	});
        });
</script>
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
		$.get("../services/messagesbycesto?cestoId="+${comp.ID}, function(data) {
		
			dataTable.fnClearTable();
			dataTable.fnAddData(data);
		});
	}
		$(function() {
			values = [0,1,7,30,60,365];
			dataTable = $('#topTable').dataTable({
				"columnDefs": [ {
                "targets": 2,
                "data": "name",
                "render": function ( data, type, full, meta ) {
                          return 'Cesto'+data;
                                  }
                } ],
                "order" : [[ 1, "desc" ]],
			   	"language" : lang,
				"columns" : [ {
					"data" : "mensajeId"
				}, {
					"data" : "fecha"
				}, {
					"data" : "composteraId"
				}, {
					"data" : "evento"
				}, {
					"data" : "peso"
				}]
				
			});
			$('.row:eq(1) .col-sm-6:eq(0)').after('<div class="col-sm-6"><div class="dataTables_info" id="orderedBy" role="alert" aria-live="polite" aria-relevant="all">Ordenando por: Establecimiento - ascendente</div></div><a class="btn btn-primary" href="../sections/proyecto?id=100">Volver</a>');
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