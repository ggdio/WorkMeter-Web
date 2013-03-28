<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/resources/img/icon.png" var="icon"/>

<!-- Formulario de Login -->
<sc:popup identificador="popupLogin" component="${param.botaoClique}" imagem="${icon}" titulo="Login" retornar="retornar">
	<jsp:attribute name="texto">
		<div class="well">
	 		<c:import url="/usuario/login/formulario">
	 			<c:param name="campoSpan">span6</c:param>
	 		</c:import>
	 	</div>
	</jsp:attribute>
</sc:popup>
