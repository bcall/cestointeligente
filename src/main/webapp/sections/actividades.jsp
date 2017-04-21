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
<title>Proyecto - Actividades</title>
<c:set var="sectionLabel" value="Actividades" scope="session" />
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
.c0, .c1, .c2 {
	vertical-align: middle !important;
}

.c0, .c1 {
	border-right: 1px solid #ddd;
}

#dataTable {
	text-align: center;
}
</style>
</head>
<body>
	<!-- Navigation -->
	<c:import url="../includes/nav" />
	<!-- Page Content -->
	<div class="container">
		<section style="height: 85vh;">
			<div class="col-lg-12">
				<div class="panel panel-default out-shadow" style="height:85vh">
					<div class="panel-heading">
					<h3 style="margin:0;text-align:center;">Actividades</h3>
					</div>
					<div class="row" style="margin: 15px auto 0 0;">
					<div class="col-lg-12">
					<div class="table-responsive col-lg-8" >
							<table class="table tableMed">
								<tr>
								<td class="bold" style="padding-top:18px;">Actividad:</td>
								<td style="padding-top:18px;">${activity.IDENTIFIER}</td>
									<td colspan="2">
										<div class="form-group input-group" style="margin: auto;">
											<input id="actSearch" type="text" class="form-control"
												placeholder="Buscar..."> <span
												class="input-group-btn"><button
													class="btn btn-default" type="button">
													<i class="fa fa-search"></i>
												</button></span>
										</div>
									</td>
								</tr>
								<tr>
								
								<td class="bold">Tipo:</td>
								<td>${activity.TYPE}</td>
								<td class="bold">Motivo:</td>
								<td>${activity.MOTIVE}</td>
								</tr>
								<tr>
									<td class="bold">Fecha Desde:</td>
									<td>${activity.DATE_FROM}</td>
									<td class="bold">Fecha Hasta:</td>
									<td >${activity.DATE_TO}</td>
								</tr>
								<tr>
									<td class="bold">Destinatarios:</td>
									<td>${activity.USERS}</td>
									<td class="bold">Asistentes:</td>
									<td>${activity.ASIST}</td>
								</tr>
								<tr>
									<td class="bold">Responsable:</td>
									<td>${activity.RESP}</td>
									<td class="bold">Resultado:</td>
									<td>${activity.RES}</td>
								</tr>
								<tr>
									<td class="bold">Observaciones:</td>
									<td colspan="3">${activity.OBS}</td>
								</tr>
								</tbody>
							</table>
						</div>
						<div class="col-lg-4">
							<div class="mapa"
								style="height: 200px; width: 200px; margin:auto;">
								<div id="map-canvas"></div>
							</div>
						</div>
					</div>
					</div>
					<div class="row" style="margin:0;!important">
					<div class="panel-body" style="padding: 0 15px 10px;">
						<div class="table-responsive" style="height: 40vh; overflow:auto;">
							<table
								class="table table-striped table-bordered dataTable no-footer tableThin"
								id="dataTable">
								<thead >
								<tr>
									<td class="bold">Establecimiento</td>
									<td class="bold">Proyecto</td>
									<td></td>
									<td class="bold">Planificado</td>
									<td class="bold">Alcanzado</td>
									<td class="bold">Estado</td>
								</tr>
								</thead>
								<tbody id="tBody" style="display: none;">
									<c:forEach items="${tableData }" var="item">
										<tr>
											<td rowspan="2" class="c1">${item["NAME"]}</td>
											<td rowspan="2" class="c2">${item["CURSO_DIVISION"]}</td>
											<td rowspan="1">Peso Input</td>
											<td rowspan="1"><fmt:formatNumber maxFractionDigits="2" value='${not empty item["OBJ_INPUT"]?item["OBJ_INPUT"]:0}'/> kg</td>
											<td rowspan="1"><fmt:formatNumber maxFractionDigits="2" value='${not empty item["F_IN"]?item["F_IN"]:0}'/> kg</td>
											<td rowspan="1"></td>
										</tr>
										<tr>
											<td rowspan="1">Aperturas Arriba</td>
											<td rowspan="1">${item["OBJ_C_IN"]}</td>
											<td rowspan="1">${item["F_C_IN"]}</td>
											<td rowspan="1"></td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
					<!-- /.panel-body -->
				</div>
				</div>
			</div>
		</section>
		${estItems}
	</div>
	<div id="overlay"
		style="position: absolute; width: 100%; height: 100%; display: none; top: 0;"></div>
	<!-- /.container -->
	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/scripts.js"></script>
	<script src="../js/sections/activity.js"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script>
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
				$('.est').each(function() {
					var data = $(this).val().split('@');
					listaEst.push({
						"name" : $(this).text(),
						"dir" : data[3],
						"lat" : parseFloat(data[0]),
						"lng" : parseFloat(data[1]),
						"eId" : data[2]
					});
				});
		});
		function createLocalsMarkers(map, listaEst) {
			var marker;
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
		function openInfo(mark) {
			for (var i = 0; i < listaInfo.length; i++) {
				listaInfo[i].close();
			}
			listaInfo[mark.pos].open(map, mark);
		}
		var defaultLatLng = new google.maps.LatLng(-34.6158533, -58.4332985);
		var map;

		function initialize() {
			var mapOptions = {
				center : defaultLatLng,
				zoom : 10,
				draggable : true,
                disableDefaultUI: true
			};
			map = new google.maps.Map(document.getElementById("map-canvas"),
					mapOptions);
			createLocalsMarkers(map, listaEst);

		}
		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
</body>
</html>