<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/index"><i class="fa fa-recycle"></i> Cestos Inteligentes - ${sectionLabel }</a>
	</div>
	<ul class="nav navbar-top-links navbar-right top-nav">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" rel="tooltip"data-placement="bottom"  data-original-title="Estado de Proyectos"> <i class="fa fa-tasks fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-tasks" style="max-height:300px;overflow:auto;">
			<li><a class="text-center"><strong>Estado de Proyectos</strong></a></li>
			<li class="divider"></li>
			<c:forEach var="item" items="${proyects}" varStatus="i">
				<li><a href="${pageContext.request.contextPath}/sections/proyecto?id=${item.ID}">
						<div>
							<p>
								<strong>${item["NAME"]}</strong> 
							</p>
							
							<span class="text-muted" style="color:black !important;">
									</span>
							<div class="progress progress-striped active" style="margin-bottom:0;position:relative;">
								<span class="pull-right text-muted legendText" style="margin-left: 10px;">
							<fmt:formatNumber pattern="##.##" value='${item["INPUT"]}' /> /
									<fmt:formatNumber pattern="##.##" value='${item["TOTAL"]}' /> kg - 
									<fmt:formatNumber pattern="##.##" value='${item["PERC"]}' /> % Completado
									</span>
								<div class="progress-bar progress-bar-<c:choose><c:when test='${item["PERC"] < 50}'>warning</c:when><c:otherwise>success</c:otherwise></c:choose>"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style='width: ${item["PERC"]}%'>
									<span class="sr-only">
									<fmt:formatNumber pattern="##.##" value='${item["PERC"]}' /> % Completado
									</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
			</c:forEach>
			</ul> <!-- /.dropdown-tasks --></li>
		<!-- /.dropdown -->
		<li id="dropMes" class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" rel="tooltip"data-placement="bottom"  data-original-title="Últimos Mensajes"> <i class="fa fa-envelope fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
		<span id="notMes" class="notification" style="display:none;">!</span>
			<ul id="messages" class="dropdown-menu dropdown-alerts">
			<li><a class="text-center"><strong>Últimos Mensajes</strong></a></li>
			<li class="divider"></li>
			${messages}</ul> 
			<!-- /.dropdown-alerts -->
			</li>
		<!-- /.dropdown -->
		<li id="dropAle"  class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#" rel="tooltip"data-placement="bottom"  data-original-title="Alarmas de peso"> <i class="fa fa-bell fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
		<span id="notAle" class="notification" style="display:none;">!</span>
			<ul id="alerts" class="dropdown-menu dropdown-alerts">
			<li><a class="text-center"><strong>Alarmas de peso</strong></a></li>
			<li class="divider"></li>
			${alerts}
			</ul> 
			<!-- /.dropdown-alerts -->
			</li>
		<!-- /.dropdown -->
		<li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" rel="tooltip"data-placement="bottom"  data-original-title="Usuario"><i class="fa fa-user"></i><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-fw fa-power-off"></i> Salir</a>
                        </li>
                    </ul>
                </li>
		<li><a id="menu-toggle" href="#"
			class="btn btn-dark btn-lg toggle" rel="tooltip"data-placement="bottom"  data-original-title="Menu"><i class="fa fa-bars"></i></a></li>
	</ul>
</nav>
<nav id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<li><a href="${pageContext.request.contextPath}/index">Inicio</a></li>
		<li><a href="${pageContext.request.contextPath}/sections/establecimiento">Establecimientos</a></li>
		<li><a href="${pageContext.request.contextPath}/sections/message">Mensajes</a></li>
		<li><a href="${pageContext.request.contextPath}/sections/usuario">Usuarios</a></li>
	    <li><a href="${pageContext.request.contextPath}/sections/concurso">Concursos</a></li>
	
	</ul>
</nav>