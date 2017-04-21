<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored="false" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<link href="../css/jquery-ui.min.css" rel="stylesheet">
<link href="../css/jquery-ui.theme.css" rel="stylesheet">
<link href="../fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reporte</title>
</head>
<body>
ssssssssssssssssssss
	<div id="container">

		<div id="establecimientoCombo">
			<select name="establecimiento" id="establecimiento">
				<option value="-1">--Seleccione una opción--</option>
				<c:forEach items="${establecimientos}" var="establecimiento">
					<option value="<c:out value="${establecimiento.ID}" />"><c:out
							value="${establecimiento.NAME}" /></option>
				</c:forEach>
			</select>
		</div>

		<div id="proyectoCombo">
			<select name="proyecto" id="proyecto" disabled="disabled">
				<option value="-1">--Seleccione una opción--</option>
			</select>
		</div>
		
		<div id="islaCombo">
			<select name="isla" id="isla" disabled="disabled">
				<option value="-1">--Seleccione una opción--</option>
			</select>
		</div>
		
		<div id="corrienteResiduoCombo">
			<select name="corriente_residuo" id="corriente_residuo" disabled="disabled">
				<option value="-1">--Seleccione una opción--</option>
			</select>
		</div>
		
		<div id="tipoResiduoCombo">
			<select name="tipo_residuo" id="tipo_residuo" disabled="disabled">
				<option value="-1">--Seleccione una opción--</option>
			</select>
		</div>
		
		<div>
		 <button id="btnSubmit">Buscar</button>
		</div>
		
	</div> 
	
	
	
	
	<div class="row" style="text-align:center;">
						    
								<table align="center">
									<tr>
										<h4>Actividad Diaria</h4>
									<tr>
										<canvas id="myChartDiario" width="400" height="200"></canvas>
									</tr>
									<tr>
										<ul class="legend">
											<li><span style="background-color: #ebcb8b"></span>Rec</li>
											<li><span style="background-color: #a3be8c"></span>No Rec</li>
										</ul>
									</tr>
									<tr> </tr>
								</table>
								
								<table align="center">
									<tr>
										<h4>Acumulado</h4>
									<tr>
										<canvas id="myChartAcumulado" width="400" height="200"></canvas>
									</tr>
									<tr>
										<ul class="legend">
											<li><span style="background-color: #ebcb8b"></span>Rec</li>
											<li><span style="background-color: #a3be8c"></span>No Rec</li>
										</ul>
									</tr>
								</table>
							</div>
						
         
    <!--! end of #container --> 

<script src="../js/jquery.js"></script>
<script src="../js/jquery-ui.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/scripts.js"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../js/Chart.min.js" type="text/javascript"></script>
	<script src="../js/scripts.js" type="text/javascript"></script>
	<script src="../js/hotkeys.js" type="text/javascript"></script>
	<script src="../js/please.js" type="text/javascript"></script>
	<script src="../js/sections/index.js" type="text/javascript"></script>
	<script src="../js/sections/index.js" type="text/javascript"></script>



	<script type="text/javascript" language="javascript"> 


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
													$("#proyecto").attr(
															"disabled",
															"disabled");
													$('#proyecto')
															.find('option')
															.remove()
															.end()
															.append(
																	'<option value="-1">--Seleccione una opción--</option>');
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
													$("#isla").attr(
															"disabled",
															"disabled");
													$('#isla')
															.find('option')
															.remove()
															.end()
															.append(
																	'<option value="-1">--Seleccione una opción--</option>');
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
											$('#corriente_residuo')
													.find('option')
													.remove()
													.end()
													.append(
															'<option value="-1">--Seleccione una opción--</option>');

											e.preventDefault();
											var val = $(this).val();
											jQuery("#corriente_residuo")
													.removeAttr(
															"disabled");
											//$('#othstate').val('').hide(); 
											$
													.ajax({
														type : "GET",
														url : contexPath
																+ '/reporte/corriente_residuo',
														dataType : 'json',
														data : {
															isla_id : val
														},
														success : function(
																data) {
															showCorrienteResiduo(data.tipo_corrientes);
														},
														error : function(
																e) {
															console
																	.error(e);
														}
													});
										} else {
											$("#corriente_residuo").attr(
													"disabled",
													"disabled");
											$('#corriente_residuo')
													.find('option')
													.remove()
													.end()
													.append(
															'<option value="-1">--Seleccione una opción-</option>');
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
										$("#tipo_residuo").attr(
												"disabled",
												"disabled");
										$('#tipo_residuo')
												.find('option')
												.remove()
												.end()
												.append(
														'<option value="-1">--Seleccione una opción--</option>');
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
    			url :     '../services/indexGraph',
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
        
    
    
    
  

	</script>

</body>
</html>