<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:set value="/usuario/formulario" var="pathFormulario"/>

<jsp:include page="/resources/html/header.jsp"/>

<br/>
<br/>
<div class="container-fluid">
	
	<div class="row-fluid">
		<div class="span4 pull-left"></div>
		<div class="span4">
			<sc:label texto="Cadastro de Acesso" tipo="label-success" align="center" fontSize="x-large"/>
		</div>
		<div class="row-fluid span4 pull-right"></div>
	</div>
	<br/>
	
	<!-- FORMULARIO DE CADASTRO -->
	<div class="row-fluid">
		<div class="span3"></div>
		<div class="span6 well">
			<c:if test="${not empty responseCadastro}">
				<div class="mensagem-erro" align="center">
					<strong>${responseCadastro.message}</strong>
				</div>
			</c:if>
			<jsp:include page="${pathFormulario}">
				<jsp:param name="campoSpan" value="span7"/>
			</jsp:include>
		</div>
		<div class="span3"></div>
	</div>

</div>

<jsp:include page="/resources/html/footer.jsp"/>