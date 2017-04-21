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

