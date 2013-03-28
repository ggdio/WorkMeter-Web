<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/hora/" var="pathGerenciadorHora"/>

<br/>
<br/>
<div class="container-fluid">
	
	<div class="row-fluid">
		<div class="span3 pull-left"></div>
		<div class="span6">
			<sc:label texto="Painel Geral" tipo="label-success" align="center" fontSize="x-large"/>
		</div>
		<div class="span3 pull-right"></div>
	</div>
	<br/>
	<br/>
	
	<div class="row-fluid">
		<div class="well">
			<div class="span4 pull-right" align="center"><a href="#" class="btn btn-large btn-primary">Relatórios</a></div>
			<div class="span4" align="center"><a href="${pathGerenciadorHora}" class="btn btn-large btn-primary">Gerenciador de Horas</a></div>
			<div class="span4 pull-left" align="center"><a href="#" class="btn btn-large btn-primary">Calculos</a></div>
			<br/>
		</div>
	</div>

</div>

