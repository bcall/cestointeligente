<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Cestos Inteligentes - Login</title>
<c:set var="sectionLabel" value="Iniciar Sesión" scope="session" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet"
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
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand"><i class="fa fa-recycle"></i> Cestos Inteligentes - ${sectionLabel }</a>
	</div>
</nav>
	<div class="container">
		<div class="col-lg-4" style="margin: auto; float: none;">
			<div class="panel panel-default out-shadow ">
				<div class="panel-body">

					<form role="form" action="<c:url value='j_spring_security_check'/>"
						method="post">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
						<div class="form-group">
							<label>Usuario:</label> <input id="j_username" name="j_username"
								class="form-control" placeholder="Ingrese su usuario...">
						</div>
						<div class="form-group">
							<label>Contraseña:</label> <input id="j_password"
								name="j_password" type="password" class="form-control"
								placeholder="Ingrese su contraseña...">
						</div>
						<div style="text-align: center;margin-top: 15px;">
						<button type="submit" class="btn btn-primary">Ingresar »</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>