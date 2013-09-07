<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/hora/" var="pathGerenciadorHora"/>

<div class="container-fluid">
	
	<div class="row-fluid vertical-aligned">
		<div class="well">
			<div class="titulo-secao" align="center">Painel Geral</div>
			<br/>
			<div class="span12">
				<div class="span4" align="center"><a href="#" class="btn btn-medium btn-primary">Relatórios</a></div>
				<div class="span4" align="center"><a href="${pathGerenciadorHora}" class="btn btn-medium btn-primary">Gerenciador de Horas</a></div>
				<div class="span4" align="center"><a href="#" class="btn btn-medium btn-primary">Calculos</a></div>
			</div>
			<br/>
		</div>
	</div>

</div>

