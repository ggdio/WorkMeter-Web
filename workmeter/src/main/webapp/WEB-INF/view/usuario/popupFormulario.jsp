<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/resources/img/icon.png" var="icon"/> 

<!-- Formulario de Cadastro -->
<sc:popup identificador="popupCriarConta" component="${param.botaoClique}" imagem="${icon}" titulo="Criar Conta" retornar="retornar">
	<jsp:attribute name="texto">
		<c:import url="/usuario/formulario"/>
	</jsp:attribute>
</sc:popup>
