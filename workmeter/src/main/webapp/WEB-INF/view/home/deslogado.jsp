<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/resources/img/icon.png" var="icon"/>
<c:set value="/usuario/popup-formulario" var="popupFormularioCadastro"/>
<c:set value="/usuario/login/popup-formulario" var="popupFormularioAcesso"/>
<c:url value="/usuario/cadastro" var="pathCadastro"/>

<!-- Introducao -->
<div id="banner" class="container">
    <div class="hero-unit span10">
	    <h1>Bem vindo ao WorkMeter!</h1>
	    <br/>
	    <br/>
	    <a id="btnPopupLogin" class="btn btn-primary btn-large span2">Login</a>
	    <a id="btnPopupCadastro" class="btn btn-warning btn-large span5" href="${pathCadastro}">Criar uma conta</a>
    </div>
</div>

<!-- Formulario de Login -->
<jsp:include page="${popupFormularioAcesso}">
	<jsp:param name="botaoClique" value="btnPopupLogin"/>
</jsp:include>

<script>
$(document).ready(function()
{
    centralizarVertical('banner');
});
</script>
