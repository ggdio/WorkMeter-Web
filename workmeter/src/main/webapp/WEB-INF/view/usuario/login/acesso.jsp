<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<c:set value="/usuario/login/formulario" var="pathFormulario"/>

<jsp:include page="/resources/html/header.jsp"/>

<br/>
<div class="container-fluid">

	<!-- ALERTA -->
	<c:if test="${not empty responseUsuarioController}">
		<div class="row-fluid">
			<div class="span6">
				<tag:alert 
				id="alertUsuarioController" 
				titulo="Atenção!" 
				texto="${responseUsuarioController.message}" 
				tipo="alert-error" 
				width="50%"/>
			</div>
			<br/>
		</div>
	</c:if>
	
	<div class="row-fluid" align="center">
		<div class="span12">
			<tag:label texto="Acesso ao Workmeter" tipo="label-success" align="left" fontSize="x-large"/>
		</div>
	</div>
	<br/>
	
	<!-- FORMULARIO DE LOGIN -->
	<div class="row-fluid">
		<div class="span12 well">
			<div class="span5">
				<jsp:include page="${pathFormulario}"/>
			</div>
		</div>
	</div>

</div>

<jsp:include page="/resources/html/footer.jsp"/>