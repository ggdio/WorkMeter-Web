<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>


<c:url value="/resources/img/icon.png" var="icon"/>

<!-- Introducao -->
<div class="container">
	<br><br><br><br><br><br>
    <div class="hero-unit span10">
	    <h1>Bem vindo ao WorkMeter!</h1>
	    <br/>
	    <br/>
	    <a id="btnPopupLogin" class="btn btn-primary btn-large span2">Login</a>
	    <a id="btnPopupDetalhes" class="btn btn-warning btn-large span5">Ainda nao possui conta? Clique Aqui!</a>
    </div>
</div>

<!-- Formulario de Login -->
<sc:popup identificador="popupLogin" component="btnPopupLogin" imagem="${icon}" titulo="Login" retornar="retornar">
	<jsp:attribute name="texto">
		<div class="well">
	 		<c:import url="/usuario/login/formulario">
	 			<c:param name="campoSpan">span6</c:param>
	 		</c:import>
	 	</div>
	</jsp:attribute>
</sc:popup>

<!-- Formulario de Cadastro -->
<sc:popup identificador="popupCriarConta" component="btnPopupDetalhes" imagem="${icon}" titulo="Criar Conta" retornar="retornar">
	<jsp:attribute name="texto">
		<c:import url="/usuario/formulario"/>
	</jsp:attribute>
</sc:popup>
