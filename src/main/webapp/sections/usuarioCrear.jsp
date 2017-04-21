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
<title>Establecimientos</title>
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
    <style type="text/css">
       .error {color: #f00;}
    </style>
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
						<h3 style="margin: 0; text-align: center;">Nuevo Usuario</h3>
					</div>
					<div class="panel-body">

						<form id="formulario" action="crearusuario" method="post" >
							<label style="margin-right: 27px;">Nombre:</label><input type="text" name="nombre" class="required" style="margin-right: 5px;"> <br />
							<label style="margin-right: 25px;">Apellido:</label><input type="text" name="apellido" class="required" style="margin-right: 5px;" > <br />
							<label style="margin-right: 23px;">Tel&eacute;fono:</label><input type="text" name="telefono" class="required number" style="margin-right: 5px;"> <br />
							<label style="margin-right: 14px;">Password:</label><input type="password" name="password" class="required" style="margin-right: 5px;"> <br />
							<label style="margin-right: 43px;"> Email:</label><input type="text" name="email" class="required email" style="margin-right: 5px;"> <br />
						    <br><br>
							<p>
								<a class="btn btn-primary" href="../sections/usuario">Volver</a>
						    	<input type="submit" value="Guardar" class="btn btn-primary">
							</p>
						</form>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
		</section>
	</div>

	<div id="overlay"
		style="position: absolute; width: 100%; height: 100%; display: none; top: 0;"></div>
	<!-- /.container -->
	<!--  script src="../js/jquery.js"></script-->
	<script src="../js/jquery-1.8.3.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.dataTables.js"></script>
	<script src="../js/dataTables.bootstrap.js"></script>
	<!-- 	<script src="../js/btp.dataTable.js"></script> -->
	<script src="../js/scripts.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.js"></script>
    <script type="text/javascript">
	    function validarFormulario(){
	    	jQuery.validator.messages.required = 'Este campo es obligatorio.';
	    	jQuery.validator.messages.number = 'Este campo debe ser num&eacute;rico.';
	    	jQuery.validator.messages.email = 'Por favor, ingrese una direcci&oacute;n de email v&aacute;lida.';
	    	$("#formulario").validate();
	    }
	    $(document).ready(function(){
	       validarFormulario();
	    });
 </script>

</body>
</html>