<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<c:url value="/resources/img/icon.png" var="icon"/>

<!-- ALERTA -->
<div class="container">
	<br><br><br><br><br><br>
    <div class="hero-unit">
	    <h1>Seja bem vindo !</h1>
	    <p>Voc� �inda n�o possu� conta em nosso sistema ?</p>
	    <p>Ent�o clique no bot�o abaixo:</p>
	    <a id="btnDetalhes" class="btn btn-primary btn-large">Criar Conta</a>
    </div>
</div>

<!-- POPUP -->
<tag:popup id="popup" component="btnDetalhes" imagem="${icon}" titulo="Criar Conta" retornar="retornar">
	<jsp:attribute name="texto">
		<p>Preencha o formul�rio abaixo:</p>
		<ul>
			<li>Nome:</li>
			<li>Endere�o:</li>
			<li>Empresa:</li>
		</ul>
	</jsp:attribute>
</tag:popup>
