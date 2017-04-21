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
<title>Cestos Ineligentes - Puntos Verdes</title>
<c:set var="sectionLabel" value="Puntos Verdes" scope="session" />
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
		<div class="sh mapa round out-shadow"
						style="float: left; height: 270px; width: 420px;">
						<div class="round" id="map-canvas"></div>
					</div>
			<div class="col-lg-7">
				<div class="panel panel-default out-shadow"
					style="margin-bottom: 7px; height: 40vh;">
					
					
					<div class="panel-body">
					    <div class="panel-heading"><h3 style="margin:0;text-align:center;">Establecimiento</h3></div>
						<div class="bold" style="text-align: center;">${est.NAME}</div>
					
							
								<div id="map-canvas"></div>
						
				
						<div class="table-responsive tableMed">
							<table class="table">
								<tr>
									<td class="bold">Dirección:</td>
									<td>${est.CALLE}${est.NUM}</td>
								</tr>
								<tr>
									<td class="bold">CGP:</td>
									<td>${est.NAME}</td>
								</tr>
								<tr>
									<td class="bold">D. E.:</td>
									<td>-</td>
								</tr>
								<tr>
									<td class="bold">Contacto:</td>
									<td>-</td>
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
				<div class="panel-heading"><h3 style="margin:0;text-align:center;">Proyectos</h3></div>
					<div class="panel-body">
                                <table class="table table-striped table-bordered table-hover" id="topTable">
								<thead>
									<tr>
									    
										<th>Proyecto</th>
										<th>Stado</th>
										<th>Fecha inicio</th>
										<th>Fecha fin</th>
										<th>Responsable</th>
										<th>Telefono</th>
										<th></th>
									</tr>
								</thead>
							</table>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
		<div class="col-lg-12">
				<div class="panel panel-default out-shadow"
					style="margin-bottom: 7px;">
					<div class="panel-heading">
						<h3 style="margin: 0; text-align: center;">Proyección</h3>
					</div>
					<div class="panel-body">
				<table class="table table-striped table-bordered table-hover"
							id="topTable">
			        <tr>
                    	<canvas id="myChart" width="500" height="200"></canvas>
						<canvas id="myChart1" width="500" height="200"></canvas>
                     </tr>
     				<tr>
						<ul class="legend">
						<li><span style="background-color: #8beb9b"></span>Rec</li>
						<li><span style="background-color: #a3be8c"></span>No Rec</li>
						</ul>
					</tr>
				</table>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
			
				</section>
	</div>
			
	<div id="overlay"
		style="position: absolute; width: 100%; height: 100%; display: none; top: 0;"></div>
		<script>
	var estLat = ${est.LAT};
	var estLong = ${est.LONG};
</script>
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
		$.get("../services/projectTableData?idest="+${est.ID}, function(data) {
		
			dataTable.fnClearTable();
			dataTable.fnAddData(data);
		});
	}
		$(function() {
			values = [0,1,7,30,60,365];
			dataTable = $('#topTable').dataTable({
			 "columnDefs": [ {
                "targets": 6,
                "data": "name",
                "render": function ( data, type, full, meta ) {
                          return '<a href="../sections/proyecto?id='+data+'"class="fa fa-arrow-circle-right"></a>';
                                  }
                } ],

            	"language" : lang,
				"columns" : [ {
					"data" : "identifier"
				}, {
					"data" : "status"
				}, {
					"data" : "dateto"
				}, {
					"data" : "datefrom"
				}, {
					"data" : "respname"
				}, {
					"data" : "respphone"
				},{
					"data" : "id"
				}]
				
			});
			$('.row:eq(1) .col-sm-6:eq(0)').after('<div class="col-sm-6"><div class="dataTables_info" id="orderedBy" role="alert" aria-live="polite" aria-relevant="all">Ordenando por: Establecimiento - ascendente</div></div><a class="btn btn-primary" href="../index">Volver</a>');
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
		
		$(function() {

			for (i = 0; i < 2; i++) {
				var first_instance = null;
				var count = 1;
				$('#dataTable .c' + i).each(function() {
					var dimension_td = $(this);

					if (first_instance == null) {
						first_instance = dimension_td;
					} else if (dimension_td.text() == first_instance.text()) {
						dimension_td.remove();
						count++;
						first_instance.attr('rowspan', count * 2);
					} else {
						count = 1;
						first_instance = dimension_td;
					}
				});
			}
			$('#tBody').show();
				listaEst = [];
				listaInfo = [];
				markers = [];
				
				var estLat = ${est.LAT};
				var estLong = ${est.LONG};
				var estName = '${est.NAME}';
				var estCalle = '${est.CALLE}' + '${est.NUM}';
				var estId = ${est.ID};
				var data = $(this).val().split('@');
				listaEst.push({
						"name" : estName,
						"dir" : estCalle,
						"lat" : parseFloat(estLat),
						"lng" : parseFloat(estLong),
						"eId" : estId
					
				});
		});
		
		function openInfo(mark) {
			for (var i = 0; i < listaInfo.length; i++) {
				listaInfo[i].close();
			}
			listaInfo[mark.pos].open(map, mark);
		}
		
		
		var defaultLatLng = new google.maps.LatLng(-34.6037687,-58.3814311,17);
		var map;
		function initialize() {
			var mapOptions = {
				center : defaultLatLng,
				zoom : 11,
				draggable : true
			};
			map = new google.maps.Map(document.getElementById("map-canvas"),
					mapOptions);
			createLocalsMarkers(map, listaEst);

		}
		google.maps.event.addDomListener(window, 'load', initialize);
		
		$(function() {

	$.get("../services/indexGraph?establecimiento_id=${est.ID}", function(data) {
		graphNotReci(data);
		graphReci(data);
	});
});
$(".list-group-item").click(function(e) {
	e.preventDefault();
	listActive = $(this).attr('id').split('_')[2];
	$(".list-group-item.active").toggleClass("active");
	$("#est_item_" + listActive).toggleClass("active");
	centerOnMap(markers[listActive]);
});

function createLocalsMarkers(map, listaEst) {
	for (i = 0; i < listaEst.length; i++) {
		marker = new google.maps.Marker({
			position : new google.maps.LatLng(listaEst[i].lat,
					listaEst[i].lng),
			map : map,
			title : listaEst[i].name,
			estId : listaEst[i].eId,
			pos : i,
			dir : listaEst[i].dir
		});
		markers[i] = marker;
		var contentString = '<div id="content">'
				+ '<div id="siteNotice">' + '</div>'
				+ '<div id="bodyContent">' + '<p>' + marker.title
				+ '</p>' + '<p>' + marker.dir + '</p>'
				+ '<p><a href="./establecimiento?id='
				+ marker.estId + '">Ver establecimiento</a></p>'
				+ '</div>' + '</div>';

		var infowindow = new google.maps.InfoWindow({
			content : contentString
		});

		listaInfo[i] = infowindow;
		google.maps.event.addListener(marker, "click", function() {
			openInfo(this);
		});

	}

}

function graphReci(wsData) {
	var total = wsData[0][0].proy_total;
	var days = wsData[1];
	var totalDays = [];
	var labels = [];
	var dataDays = [];
	var daysInMont = new Date(days[0].DATE.split('-')[0], days[0].DATE
			.split('-')[1], 0).getDate();
	var totalBday = total / daysInMont;
	for (var i = 0; i < daysInMont; i++) {
		labels[i] = i+1;
		totalDays[i] = (totalBday * (i+1)).toFixed(2);
		
		dataDays[i] = 0;
	}
	var totalW = 0;

	for ( var i in days) {
	
		dataDays[i] = totalW = (parseInt(totalW) + parseInt(days[i].INPUT)).toFixed(2);
		
	}
	
	var data = {
		labels : labels,
		datasets : [ {
			label : "Peso Proyectado",
			fillColor : "rgba(235, 203, 139,0.2)",
			strokeColor : "#9b8beb",
			pointColor : "#9b8beb",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(235, 203, 139,1)",
			data : totalDays
		}, {
			label : "Peso Alcanzado",
			fillColor : "rgba(163, 190, 140,0.2)",
			strokeColor : "#8beb9b",
			pointColor : "#8beb9b",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(163, 190, 140,1)",
			data : dataDays
		} ]
	};
	var ctx = $("#myChart").get(0).getContext("2d");
	var myLineChart = new Chart(ctx).Line(data);
}

function graphNotReci(wsData) {
	var total = wsData[2][0].proy_total;
	var days = wsData[3];
	var totalDays = [];
	var labels = [];
	var dataDays = [];
	var daysInMont = new Date(days[0].DATE.split('-')[0], days[0].DATE
			.split('-')[1], 0).getDate();
	var totalBday = total / daysInMont;
	for (var i = 0; i < daysInMont; i++) {
		labels[i] = i+1;
		totalDays[i] = (totalBday * (i+1)).toFixed(2);
		dataDays[i] = 0;
	}
	var totalW = 0;

	for ( var i in days) {
		dataDays[i] = totalW = (parseInt(totalW) + parseInt(days[i].INPUT)).toFixed(2);
	}
	
	var data = {
		labels : labels,
		datasets : [ {
			label : "Peso Proyectado",
			fillColor : "rgba(235, 203, 139,0.2)",
			strokeColor : "#9b8beb",
			pointColor : "#9b8beb",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(235, 203, 139,1)",
			data : totalDays
		}, {
			label : "Peso Alcanzado",
			fillColor : "rgba(163, 190, 140,0.2)",
			strokeColor : "#a3be8c",
			pointColor : "#a3be8c",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(163, 190, 140,1)",
			data : dataDays
		} ]
	};
	var ctx = $("#myChart1").get(0).getContext("2d");
	var myLineChart = new Chart(ctx).Line(data);
}
		
	</script>
</body>
</html>