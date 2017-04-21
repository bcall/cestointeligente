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
<c:set var="sectionLabel" value="Mensajes" scope="session" />
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

<style>
.form-control1 {
    
    width: 20%; 
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
	<c:import url="../includes/nav" />
	<!-- Page Content -->
	<div class="container">

		<section> 
		<div class="col-lg-12">
			<div class="panel panel-default out-shadow"
				style="margin-bottom: 7px;">
				<div class="panel-heading">
					<h3 style="margin: 0; text-align: center;">Mensajes</h3>
				    <br>
					<div class='picker'>
						<label for="fromperiod">Desde:</label> <input type="text"
							id="fromperiod" name="from" class="form-control1"> <label for="toperiod">Hasta:</label>
						<input type="text" id="toperiod" name="to" class="form-control1">
					
					<label for="cesto">  Cesto:</label> <select name="cesto" id="cesto" class="form-control1"
						style="width: 10%;">
						<option value="-1">--Todos--</option>
						<c:forEach items="${cestos}" var="cesto">
							<option value="<c:out value="${cesto.ID}" />"><c:out
									value="cesto ${cesto.ID}" /></option>
						</c:forEach>
					</select>
					<button id="btnSubmit" image="">Buscar</button>
					</div>
                  </div>
					<div class="panel-body">
						<table class="table table-striped table-bordered table-hover"
							id="topTable">
							<thead>
								<tr>

									<th>Id</th>
									<th>Fecha</th>
									<th>Cesto</th>
									<th>Evento</th>
									<th>peso</th>
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
			"sProcessing" : "Procesando...",
			"sZeroRecords" : "No se encontraron resultados",
			"sEmptyTable" : "Ningún dato disponible en esta tabla",
			"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
			"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
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

			$.get("../services/messages", function(data) {

				dataTable.fnClearTable();
				dataTable.fnAddData(data);
			});
		}
		$(function() {
			values = [ 0, 1, 7, 30, 60, 365 ];
			dataTable = $('#topTable').dataTable({
				"columnDefs" : [ {
					"targets" : 2,
					"data" : "name",
					"render" : function(data, type, full, meta) {
						return 'Cesto' + data;
					}
				} ],
				"order" : [ [ 1, "desc" ] ],
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
				} ]

			});
			$('.row:eq(1) .col-sm-6:eq(0)')
					.after(
							'<div class="col-sm-6"><div class="dataTables_info" id="orderedBy" role="alert" aria-live="polite" aria-relevant="all">Ordenando por: Mensajes - ascendente</div></div>');
			$('.input-sm').after('<label class="dateRange"></label>');
			loadData(0);
		
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

		$(function() {
			$("#fromperiod").datepicker(
					{
						defaultDate : "+1w",
						changeMonth : true,
						numberOfMonths : 1,
						onClose : function(selectedDate) {
							$("#toperiod").datepicker("option", "minDate",
									selectedDate);
						}
					});
			$("#toperiod").datepicker(
					{
						defaultDate : "+1w",
						changeMonth : true,
						numberOfMonths : 1,
						onClose : function(selectedDate) {
							$("#fromperiod").datepicker("option", "maxDate",
									selectedDate);
						}
					});
		});
		
		 $(document).ready(function() {
    	
        $("#btnSubmit").click(function(){
        	  var cestoId = $('#cesto').val();
        	  var fromperiod = $('#fromperiod').val();
        	  var toperiod = $('#toperiod').val();
        	  
        	  if (fromperiod=="" || toperiod=="")
        	     {
        	      alert("Por favor ingresar las fechas");
        	      return;
        	     }
              $.get("../services/messagesfilter?cestoId="+cestoId+"&fromperiod="+fromperiod+"&toperiod="+toperiod, function(data) {

				dataTable.fnClearTable()
				dataTable.fnAddData(data);
			});
        	
    		});
    		});
    		
    		 $("#fromperiod").datepicker({ dateFormat: "dd/mm/yy" }).val()
               $("#toperiod").datepicker({ dateFormat: "dd/mm/yy" }).val()
	</script>
</body>
</html>