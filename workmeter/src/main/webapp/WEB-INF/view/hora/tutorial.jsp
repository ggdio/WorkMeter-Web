<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/resources/img/icon.png" var="icon"/>

<input type="button" hidden="hidden" id="hiddenInicio"/>
<sc:popup identificador="popupTutorial" component="hiddenInicio" imagem="${icon}" titulo="Introdução" retornar="retornar">
	<jsp:attribute name="texto">
		<div class="well" id="inicial" align="left">
	 		<p>Olá, seja bem vindo ao WorkMeter !</p>
	 		<p>Neste tutorial você aprenderá como declarar suas horas de trabalho utilizando o sistema</p>
	 		<p>Feche esta janela para iniciar...</p>
	 	</div>
	</jsp:attribute>
</sc:popup>

<sc:alert identificador="alertParteA" align="left" tipo="label-info" texto="Clique no botão abaixo para iniciar o dia de trabalho" titulo="Tutorial - Parte 1"/>
<sc:popover identificador="btnIniciarTrabalho" value="Iniciar Trabalho" classe="btn btn-primary btn-large span12" titulo="Dica" texto="Ao clicar, você estará iniciando o dia de trabalho"/>
<br/>


<script>
$(document).ready(function()
{
	init();
});

function init()
{
	$('#hiddenInicio').click();
	$('#btnVoltar_popupInicial').hide();
}
</script>

<jsp:include page="/resources/html/footer.jsp"/>