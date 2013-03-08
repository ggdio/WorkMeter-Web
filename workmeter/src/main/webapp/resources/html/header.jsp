<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="estilo" value="spacelab"/>

<!-- URL's -->
<c:url value="/" var="pathHome"/>
<c:url value="/usuario/meusDados" var="pathMeusDados" />
<c:url value="/usuario/login/sair" var="pathSair" />
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
		
		$('#btnLogout').click(function(event)
		{
			if(confirm('Deseja realmente sair ?'))
			{
				location.href = "${pathSair}";
			}
		});
	});
</script>

<head>
	<!-- ICONE -->
	<title>{Work}Meter</title>
	
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
		    	<a class="brand" href="${pathHome}"><b>{Work}Meter</b></a>
	    	    <ul class="nav">
				    <li><a href="${pathHome}"><i class="icon-home icon-white"></i><b>Home</b></a></li>
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
		    <c:if test="${not empty usuarioLogado}">
		    	<div class="pull-right">
			    	<ul class="nav">
				    	<li class="dropdown">
						    <a id="btnMenuUsuario" class="dropdown-toggle" data-toggle="dropdown" href="#"><b>${usuarioLogado.nome}</b><b class="caret"></b></a>
						    <ul class="dropdown-menu">
						    	<li><a href="${pathMeusDados}">Meus Dados</a></li>
							    <li><a href="#sair" id="btnLogout">Logout</a></li>
						    </ul>
				   		</li>
				    </ul>
			    </div>
		    	<script>
		    		$('#btnMenuUsuario').dropdown();
		    	</script>
		    </c:if>    
	    </div>
    </div>

	<br/>
	<br/>
	<br/>