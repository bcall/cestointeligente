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
<title>Punto Verde</title>
<c:set var="sectionLabel" value="Punto Verde" scope="session" />
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
		<section style="height: 70vh;">
			<div class="col-lg-12">
				<div class="panel panel-default out-shadow"
					style="margin-bottom: 7px; height: 760px;">
					<div class="panel-heading"></div>
					<div class="panel-body">
						<h4 style="text-align: center; margin-top: 0;">Punto Verde</h4>
						<div class="table-responsive" style="width: 100%; float: left;">
							<table class="table" style="font-size: 10pt;">
								<tr>
									<td class="bold">ID:</td>
									<td><input type="text" readonly="readonly"
										name="${isla.id}" /></td>
								</tr>

								<tr>
									<td class="bold">Ubicacion:</td>
									<td><select name=posicion>
											<c:forEach items="${posicion}" var="ubicacion">
												<option value="${ubicacion.ID}">${ubicacion.POSICION}</option>
											</c:forEach>
									</select></td>
								</tr>

							</table>
						</div>

					</div>
					<!-- /.panel-body -->
				</div>
			</div>
		</section>
	</div>
</body>
</html>