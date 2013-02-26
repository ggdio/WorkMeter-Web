<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!-- URL's -->
<c:url var="home" value="/"/>
<c:url value="/resources/jquery/JQuery.js" var="jquery"/>
<c:url value="/resources/bootstrap/js/bootstrap.js" var="bootstrap_js"/>
<c:url value="/resources/bootstrap/css/bootstrap-cyborg.css" var="bootstrap_css" />
<c:url value="/resources/img/logo.png" var="logo"/>
<c:url value="/resources/img/favicon.png" var="favicon"/>
<c:url value="/resources/img/background.jpg" var="background"/>
<c:url value="/resources/img/header.jpg" var="header"/>

<html>

<!-- JAVASCRIPT -->
<script type="text/javascript">
	$(document).ready(function()
	{
		$('#btnToggle').dropdown();
		
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

<!-- IMPORT JQUERY+BOOTSTRAP -->
<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript" src="${bootstrap_js}"></script>

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
						    <li><a href="#">Horas</a></li>
						    <li><a href="#">Clientes</a></li>
						    <li><a href="#">Outros</a></li>
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
    
    <br>

    <!-- HEADER -->
    <div style="background-color: green;height: 80px;" class="page-header">
    
    	<!-- LOGOTIPO -->
	    <a class="span5 pull-left" href="${home}"><img src="${logo}" alt="Workmeter" title="Workmeter" width="100%" height="100px"/></a>
	    
	    <!-- SLIDE -->
		<div id="slide_header" class="carousel span4 pull-right">
			
			<!-- ITEMS -->
			<div class="carousel-inner">
					<div class="item active">
						<img src="${slide_a}" width="100%" height="96px"/>
					</div>
					<div class="item">
						<img src="${slide_b}" width="100%" height="96x"/>
					</div>
					<div class="item">
						<img src="${slide_c}" width="100%" height="96px"/>
					</div>
					<div class="item">
						<img src="${slide_d}" width="100%" height="96px"/>
					</div>
					<div class="item">
						<img src="${slide_e}" width="100%" height="96px"/>
					</div>
			</div>
		</div> 
	</div>
	
	<br><br>  