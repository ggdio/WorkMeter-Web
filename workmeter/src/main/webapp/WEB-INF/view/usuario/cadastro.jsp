<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:set value="/usuario/formulario" var="pathFormulario"/>

<jsp:include page="/resources/html/header.jsp"/>

<div class="container-fluid">

	<!-- FORMULARIO DE CADASTRO -->
	<div class="row-fluid vertical-aligned">
		<div class="span4"></div>
		<div class="span4 well">
			<div class="titulo-secao" align="center">Cadastro de Acesso</div>
			<br/>
			<c:if test="${not empty responseCadastro}">
				<div class="mensagem-erro" align="center">
					<strong>${responseCadastro.message}</strong>
				</div>
			</c:if>
			<jsp:include page="${pathFormulario}">
				<jsp:param name="campoSpan" value="span12"/>
			</jsp:include>
		</div>
		<div class="span4"></div>
	</div>

</div>

<jsp:include page="/resources/html/footer.jsp"/>