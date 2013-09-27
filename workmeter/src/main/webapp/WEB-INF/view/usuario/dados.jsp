<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:set value="/preferencias/formulario" var="pathFormularioPreferencias"/>

<jsp:include page="/resources/html/header.jsp"/>
<br/>
<br/>
<div class="container-fluid">

	<div class="row-fluid vertical-aligned">
	<c:if test="${not empty responsePreferenciaController}">
		<div class="row-fluid">
			<div class="span2 pull-left"></div>
			<div class="span8">
				<sc:alert titulo="${responsePreferenciaController.status}" texto="${responsePreferenciaController.message}" identificador="alertPreferenciaController"/>
			</div>
			<div class="row-fluid span2 pull-right"></div>
		</div>
		<br/>
	</c:if>
	
	<div class="row-fluid">
		<div class="span4 pull-left"></div>
			<div class="span4 well">
				<div class="titulo-secao" align="center"><fmt:message key="usuario.dados.formulario.titulo.texto" /></div>
				<br/>
				<jsp:include page="${pathFormularioPreferencias}"/>
			</div>
		<div class="span4 pull-right"></div>
	</div>
	</div>

</div>

<jsp:include page="/resources/html/footer.jsp"/>