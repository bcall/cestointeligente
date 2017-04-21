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
						<h3 style="margin: 0; text-align: center;">Editar Usuario</h3>
					</div>
					<div class="panel-body">

						<form action="modificarusuario" method="post" >
							Nombre:&nbsp;&nbsp; <input type="text" name="nombre" value="${usuario.nombre}"> <br />
							Apellido:&nbsp;&nbsp; <input type="text" name="apellido" value="${usuario.apellido}"> <br />
							Telefono:&nbsp; <input type="text" name="telefono" value="${usuario.telefono}"> <br />
							Password:<input type="password" name="password"> <br />
							<input type=hidden name="id" value="${usuario.id}">
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
	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.dataTables.js"></script>
	<script src="../js/dataTables.bootstrap.js"></script>
	<!-- 	<script src="../js/btp.dataTable.js"></script> -->
	<script src="../js/scripts.js"></script>
	
</body>
</html>