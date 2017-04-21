<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Cestos Inteligentes - Inicio</title>
<c:set var="sectionLabel" value="Inicio" scope="session" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
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
.form-control1 {
 
    width: 40%;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}

</style>
</head>
<body>
	<!-- Navigation -->
	<c:import url="includes/nav" />
	<!-- Page Content -->
	<section id="p-section" style="height: 500px;">
		<div class="container" style="padding-left: 0; padding-right: 0;">
				<div class="col-md-3">
					<div class="sh panel panel-default out-shadow"
						style="height: 830px;">
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12 col-md-12">
									<div class="panel panel-primary" style="margin-bottom: 0;">
										<div class="panel-heading">
											<div class="row">
												<div class="col-xs-3">
													<i class="fa fa-trophy fa-3x"></i>
												</div>
												<div class="col-xs-9 text-right">
													<div class="huge">1</div>
												</div>
											</div>
										</div>
										<a
											href="${pageContext.request.contextPath}/sections/concurso">
											<div class="panel-footer">
												<span class="pull-left">Concursos</span> <span
													class="pull-right"><i
													class="fa fa-trophy"></i></span>
												<div class="clearfix"></div>
											</div>
										</a>
									</div>
								</div>
							</div>
							<br>
									<div class="row">
								<div class="col-lg-12 col-md-12">
									<div class="panel panel-green" style="margin-bottom: 0;">
										<div class="panel-heading">
											<div class="row">
												<div class="col-xs-3">
													<i class="fa fa-bars fa-3x"></i>
												</div>
												<div class="col-xs-9 text-right">
													<div class="huge">1</div>
												</div>
											</div>
										</div>
										<a
											href="${pageContext.request.contextPath}/sections/proyecto?id=100">
											<div class="panel-footer">
												<span class="pull-left">Puntos Verdes</span> <span
													class="pull-right"><i
													class="fa fa-bars "></i></span>
												<div class="clearfix"></div>
											</div>
										</a>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
							<div class="col-lg-12 col-md-12">
									<div class="panel panel-red" style="margin-bottom: 0;">
										<div class="panel-heading">
										    <div class="row">
												<div class="col-xs-3">
													<i class="fa fa-arrow-circle-down fa-3x"></i>
												</div>
												<div class="col-xs-9 text-right">
													<div class="huge">${countCestosNotAlive}</div>
												</div>
											</div>
										</div>
										<a
											href="${pageContext.request.contextPath}/sections/cestosnovivos">
											<div class="panel-footer">
												<span class="pull-left">Cestos No Vivos</span> <span
													class="pull-right"><i
													class="fa fa-arrow-circle-right"></i></span>
												<div class="clearfix"></div>
											</div>
										</a>										
									</div>
								</div>
							</div>
						</div>
					</div>
               </div>
				<div class="col-md-9">
					<div class="sh panel panel-default out-shadow"
						style="height: 830px;">
						<div class="panel-body">
							<div class="row">
                             <div >
							<select name="establecimiento" id="establecimiento" class="form-control1">
										<option value="-1">--Seleccione una opción--</option>
										<c:forEach items="${establecimientos}" var="establecimiento">
											<option value="<c:out value="${establecimiento.ID}" />"><c:out
													value="${establecimiento.NAME}" /></option>
										</c:forEach>
									</select>
								
									<select name="proyecto" id="proyecto" disabled="disabled" class="form-control1">
										<option value="-1">--Seleccione una opción--</option>
									</select>
									</div>
							      <div>
									<select name="isla" id="isla" disabled="disabled" class="form-control1">
										<option value="-1">--Seleccione una opción--</option>
									</select>
							
<!-- 									<select name="corriente_residuo" id="corriente_residuo" -->
<!-- 										disabled="disabled" class="form-control" style="width: 50%;"> -->
<!-- 										<option value="-1">--Seleccione una opción--</option> -->
<!-- 									</select> -->
									
									<select name="tipo_residuo" id="tipo_residuo" disabled="disabled" class="form-control1">
										<option value="-1">--Seleccione una opción--</option>
									</select>
									<button id="btnSubmit" class="btn btn-primary">Buscar</button>
								</div>
								
							</div>
							<!-- row -->
							<div class="row" style="text-align:center;">
						    
								<table align="center">
									<tr>
										<h4>Actividad Diaria</h4>
									<tr>
										<canvas id="myChartDiario" width="500" height="200"></canvas>
									</tr>
									
									<tr> </tr>
								</table>
								
								<table align="center">
									<tr>
										<h4>Acumulado</h4>
									<tr>
										<canvas id="myChartAcumulado" width="500" height="200"></canvas>
									</tr>
									<tr>
										<ul class="legend">
											<li><span style="background-color: #ebcb8b"></span>Rec</li>
											<li><span style="background-color: #a3be8c"></span>No Rec</li>
										</ul>
									</tr>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
				</div>
			</div>

		<!-- /.container -->
	</section>
	<div id="overlay"
		style="position: absolute; width: 100%; height: 100%; display: none; top: 0;"></div>
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/Chart.min.js" type="text/javascript"></script>
	<script src="js/scripts.js" type="text/javascript"></script>
	<script src="js/hotkeys.js" type="text/javascript"></script>
	<script src="js/please.js" type="text/javascript"></script>
	<script src="js/sections/index.js" type="text/javascript"></script>
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript">
	jQuery(document).ready(function() { 
    var contexPath = "<%=request.getContextPath()%>";

							$('#establecimiento')
									.change(
											function(e) {

												if (jQuery(this).val() != "-1") {
													$('#proyecto')
															.find('option')
															.remove()
															.end()
															.append(
																	'<option value="-1">--Seleccione una opción--</option>');

													e.preventDefault();
													var val = $(this).val();
													jQuery("#proyecto")
															.removeAttr(
																	"disabled");
													//$('#othstate').val('').hide(); 
													$
															.ajax({
																type : "GET",
																url : contexPath
																		+ '/reporte/proyecto',
																dataType : 'json',
																data : {
																	establecimiento_id : val
																},
																success : function(
																		data) {
																	showProyectos(data.proyectos);
																},
																error : function(
																		e) {
																	console
																			.error(e);
																}
															});
												} else {
													resetOptions('#proyecto');
													resetOptions('#isla');
													resetOptions('#corriente_residuo');
													resetOptions('#tipo_residuo');
												}
											});

							function showProyectos(data) {

								for (var i = 0, len = data.length; i < len; ++i) {
									var msajax = data[i];
									$('#proyecto').append(
											"<option value=\"" +msajax.id + "\">"
													+ msajax.identifier
													+ "</option>");
								}
							}
						//Islas
								$('#proyecto')
									.change(
											function(e) {

												if (jQuery(this).val() != "-1") {
													$('#isla')
															.find('option')
															.remove()
															.end()
															.append(
																	'<option value="-1">--Seleccione una opción--</option>');

													e.preventDefault();
													var val = $(this).val();
													jQuery("#isla")
															.removeAttr(
																	"disabled");
													//$('#othstate').val('').hide(); 
													$
															.ajax({
																type : "GET",
																url : contexPath
																		+ '/reporte/isla',
																dataType : 'json',
																data : {
																	proyecto_id : val
																},
																success : function(
																		data) {
																	showIslas(data.islas);
																},
																error : function(
																		e) {
																	console
																			.error(e);
																}
															});
												} else {
													resetOptions('#isla');
													resetOptions('#corriente_residuo');
													resetOptions('#tipo_residuo');
												}
											});

							function showIslas(data) {

								for (var i = 0, len = data.length; i < len; ++i) {
									var msajax = data[i];
									$('#isla').append( "<option value=\"" +msajax.id + "\">" + msajax.identifier + "</option>");
								}
							}
							//Corriente Residuo
							
							$('#isla')
							.change(
									function(e) {

										if (jQuery(this).val() != "-1") {
											$('#tipo_residuo')
													.find('option')
													.remove()
													.end()
													.append(
															'<option value="-1">--Seleccione una opción--</option>');

											e.preventDefault();
											var val = $(this).val();
											jQuery("#tipo_residuo")
													.removeAttr(
															"disabled");
											//$('#othstate').val('').hide(); 
											$
													.ajax({
														type : "GET",
														url : contexPath
																+ '/reporte/tipo_residuo',
														dataType : 'json',
														data : {
															isla_id : val
														},
														success : function(
																data) {
															showTipoResiduo(data.tipo_residuos);
														},
														error : function(
																e) {
															console
																	.error(e);
														}
													});
										} else {
											resetOptions('#corriente_residuo');
											resetOptions('#tipo_residuo');
										}
									});

					function showCorrienteResiduo(data) {

						for (var i = 0, len = data.length; i < len; ++i) {
							var msajax = data[i];
							$('#corriente_residuo').append(
									"<option value=\"" +msajax.id + "\">"
											+ msajax.name
											+ "</option>");
						}
					}
								
					//tipo residuo
					$('#corriente_residuo')
						.change(
								function(e) {

									if (jQuery(this).val() != "-1") {
										$('#tipo_residuo')
												.find('option')
												.remove()
												.end()
												.append(
														'<option value="-1">--Seleccione una opción--</option>');

										e.preventDefault();
										var val = $(this).val();
										var islaID = $('#isla').val();
										jQuery("#tipo_residuo")
												.removeAttr(
														"disabled");
										//$('#othstate').val('').hide(); 
										$
												.ajax({
													type : "GET",
													url : contexPath
															+ '/reporte/tipo_residuo',
													dataType : 'json',
													data : {
														corriente_residuo : val,
														isla_id : islaID
													},
													success : function(
															data) {
														showTipoResiduo(data.tipo_residuos);
													},
													error : function(
															e) {
														console
																.error(e);
													}
												});
									} else {
								            resetOptions('#tipo_residuo');
									}
								});

				function showTipoResiduo(data) {

					for (var i = 0, len = data.length; i < len; ++i) {
						var msajax = data[i];
						$('#tipo_residuo').append( "<option value=\"" +msajax.id + "\">" + msajax.name + "</option>");
					}
				}
							
						});
   
    
    $(document).ready(function() {
    	
        $("#btnSubmit").click(function(){
        	  var islaID = $('#isla').val();
        	  var establecimientoID = $('#establecimiento').val();
        	  var proyectoID = $('#proyecto').val();
        	  var corrienteID = $('#corriente_residuo').val();
        	  var tipoResiduoID = $('#tipo_residuo').val();
        	   
        	$.ajax({
    			type : "GET",
    			url :     '../cestointeligente/services/indexGraph',
    			dataType : 'json',
    			data : {
    				establecimiento_id : establecimientoID,
    				corriente_residuo_id: corrienteID ,
    				tipo_residuo_id: tipoResiduoID ,
    				isla_id:islaID,
    				proyecto_id: proyectoID 
    			},
    			success : function(
    					data) {
    				if (data.length > 0 && data[1].length > 0) {
    				    graphDiaria(data);
    				    graphAumulado(data);
    				} else {
    					alert("No hay datos");
    					//$("#myChartDiario").remove();
    					//$("#myChartAcumulado").remove();
    				}
    			},
    			error : function(
    					e) {
    				console
    						.error(e);
    			}
        	});
        });
    		});
	
		$(function() {
			listaEst = [];
			listaInfo = [];
			markers = [];
			$('.list-group-item').each(function() {
				var id = $(this).attr('id');
				var data = $('#' + id + '_hidden').val().split('@');
				listaEst.push({
					"name" : $(this).text(),
					"dir" : data[3],
					"lat" : parseFloat(data[0]),
					"lng" : parseFloat(data[1]),
					"eId" : data[2],
					"cComp" : data[4]
				});
			});

		});

		function resetOptions(id) {
		
								$(id).attr(
												   "disabled",
												   "disabled");
								$(id)
											  .find('option')
											  .remove()
											  .end()
											  .append(
													'<option value="-1">--Seleccione una opción--</option>');
								}
												   
	</script>
</body>
</html>