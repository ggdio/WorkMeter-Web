<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<c:set var="estilo" value="cerulean"/>

<!-- URL's -->
<c:url var="home" value="/"/>
<c:url value="/webresources/jquery/JQuery.js" var="jquery"/>
<c:url value="/webresources/twitter-bootstrap/js/bootstrap.js" var="bootstrap_js"/>
<c:url value="/webresources/twitter-bootstrap/css/bootstrap-${estilo}.css" var="bootstrap_css" />
<c:url value="/resources/img/favicon.png" var="favicon"/>
<c:url value="/resources/img/background.jpg" var="background"/>

<html>

<!-- IMPORT JQUERY+BOOTSTRAP -->
<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript" src="${bootstrap_js}"></script>

<!-- JAVASCRIPT -->
<script type="text/javascript">
	$(document).ready(function()
	{
		$('#btnDropdown').dropdown();
		
		$('#btnPesquisar').click(function(event)
		{
			alert('Nao implementado');
		});
		$('form#formPesquisa').submit(function(event)
		{
			alert('Nao implementado');
		});
		$('form#formPesquisa').bind('keydown',function(event)
		{
			var key = e.keyCode || e.which;
            if (key === 13) 
            {
            	alert('Nao implementado');
            }
		});
	});
</script>

<head>
	<!-- ICONE -->
	<title>WorkMeter</title>
	
	<!-- FAVICON -->
	<link type="image/png" rel="icon" href="${favicon}">
	
	<!-- CSS -->
	<link type="text/css" rel="stylesheet" href="${bootstrap_css}"/>
	
	<!-- METAS -->
	<meta name="description" content="Calculo o tempo que gasta no trabalho, com pausa para diversos motivos. Extração de relatorios."/>
	<meta name="keywords" content="work,trabalho,medidor,horario,ponto,registro,calculo,relatorio"/>
	<meta name="expires" content="never"/>
</head>

<body background="${background}">
	
    <!-- BARRA DE NAVEGAÇÃO -->
    <div class="navbar navbar-fixed-top">
	    <div class="navbar-inner">
		    <div class="container pull-left">
		    	<a class="brand" href="${home}"><b>WorkMeter</b></a>
	    	    <ul class="nav">
				    <li><a href="${home}"><i class="icon-home icon-white"></i><b>Home</b></a></li>
			    	<li class="dropdown">
					    <a id="btnDropdown" class="dropdown-toggle" data-toggle="dropdown" href="#"><b>Menu</b><b class="caret"></b></a>
					    <ul class="dropdown-menu">
						    <li><a href="#itemA">Item A</a></li>
						    <li><a href="#itemB">Item B</a></li>
						    <li><a href="#itemC">Item C</a></li>
					    </ul>
				    </li>
			    </ul>
		    </div>
		    <form id="formPesquisa" class="pull-right">
		    	<input id="txtPesquisa" style="vertical-align: baseline;" name="pesquisa" class="search-query span3" placeholder="Pesquisar..." type="text">
		    	<a id="btnPesquisar" href="#" class="btn">Buscar</a>
		    </form>
	    </div>
    </div>

	<br/>
	<br/>
	<br/>