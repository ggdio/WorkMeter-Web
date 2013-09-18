<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:set value="/usuario/login/formulario" var="pathFormulario"/>

<jsp:include page="/resources/html/header.jsp"/>

<br/>
<br/>
<div class="container-fluid">
	
	<!-- FORMULARIO DE LOGIN -->
	<div class="row-fluid vertical-aligned">
		<div class="span4 pull-left"></div>
		<div class="span4 well">
			<div class="titulo-secao span12" align="center"><fmt:message key="usuario.acesso.formulario.titulo.texto"/></div>
			<br/>
			<div class="span12">
				<c:if test="${not empty responseLogin}">
					<div class="mensagem-erro" align="center">
						${responseLogin.message}
					</div>
				</c:if>
				<tags:formLogin inputSpans="span10" />
			</div>
		</div>
		<div class="span4 pull-right"></div>
	</div>

</div>

<jsp:include page="/resources/html/footer.jsp"/>