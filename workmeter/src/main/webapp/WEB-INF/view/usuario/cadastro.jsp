<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set value="/usuario/formulario" var="pathFormulario"/>

<jsp:include page="/resources/html/header.jsp"/>

<div class="container-fluid">

	<!-- FORMULARIO DE CADASTRO -->
	<div class="row-fluid vertical-aligned footer-separated">
		<div class="span4"></div>
		<div class="span4 well">
			<div class="titulo-secao" align="center"><fmt:message key="usuario.cadastro.formulario.titulo.texto" /></div>
			<br/>
			<c:if test="${not empty responseCadastro}">
				<div class="mensagem-erro" align="center">
					<strong>${responseCadastro.message}</strong>
				</div>
			</c:if>
			<tags:formCadastroUsuario inputSpans="span12"/>
		</div>
		<div class="span4"></div>
	</div>

</div>

<jsp:include page="/resources/html/footer.jsp"/>