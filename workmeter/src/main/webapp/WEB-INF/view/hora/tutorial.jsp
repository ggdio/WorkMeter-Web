<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/resources/img/icon.png" var="icon"/>

<input type="button" hidden="hidden" id="hiddenInicio"/>
<sc:popup identificador="popupTutorial" component="hiddenInicio" imagem="${icon}" titulo="Introdução:Gerenciador de Horas" retornar="retornar">
	<jsp:attribute name="texto">
		<div class="well" id="inicial" align="left">
	 		<p>Bem vindo ao módulo de gerenciamento de horas !</p>
	 		<p>Identificamos que você está utilizando o sistema pela primeira vez, portanto iremos lhe apresentar um pequeno tutorial
	 		   sobre como acompanhar suas horas de trabalho no dia-a-dia.</p>
	 		<p>Para iniciar, feche este popup ou pressione ESC...</p>
	 	</div>
	</jsp:attribute>
</sc:popup>

<sc:alert identificador="alertParteA" align="left" tipo="label-green" texto="Clique no botão abaixo para iniciar um dia de trabalho" titulo="Tutorial - Parte 1"/>
<div align="center">
	<sc:popover identificador="btnIniciarTrabalho" position="right" value="Iniciar Trabalho" classe="btn btn-primary btn-large span12" titulo="Dica" texto="Clicando neste botão você estará iniciando o seu dia de trabalho..."/>
</div>
<br/>


<script>
$(document).ready(function()
{
	init();
});

function init()
{
	//Força o popup a ser apresentado no início
	getElemento('hiddenInicio').click();
	getElemento('btnVoltar_popupTutorial').hide();
}
</script>

<jsp:include page="/resources/html/footer.jsp"/>