<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/hora/" var="pathInicioHora"/>

<br/>
<br/>
<div class="container-fluid">
	
	<div class="row-fluid">
		<div class="span3 pull-left"></div>
		<div class="span6">
			<sc:label texto="{Work}Meter" tipo="label-success" align="center" fontSize="x-large"/>
		</div>
		<div class="span3 pull-right"></div>
	</div>
	<br/>
	<br/>
	
	<!-- FORMULARIO DE LOGIN -->
	<div class="row-fluid">
		<div class="span4 pull-right" align="center">Minhas Horas</div>
		<div class="span4" align="center"><a href="${pathInicioHora}" class="btn btn-large btn-primary">Dia de Trabalho</a></div>
		<div class="span4 pull-left" align="center">Descrições</div>
	</div>

</div>

