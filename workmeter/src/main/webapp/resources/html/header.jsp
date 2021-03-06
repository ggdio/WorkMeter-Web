<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!-- Estilo do CSS -->
<c:set var="estilo" value="/resources/css/default.css"/>
<c:if test="${not empty usuarioLogado}">
	<c:set var="estilo" value="${usuarioLogado.preferencia.estilo.url}"/>
</c:if>

<!-- Controllers -->
<c:url value="/" var="pathHome"/>
<c:url value="/usuario/login/sair" var="pathSair" />
<c:url value="/hora/" var="pathGerenciadorHora"/>

<!-- Resources Servlet -->
<c:url value="/webresources/jquery/JQuery.js" var="jquery_js"/>
<c:url value="/webresources/jquery/JQueryMask.js" var="jquerymask_js"/>
<c:url value="/webresources/jquery/JQueryUI.css" var="jqueryui_css"/>
<c:url value="/webresources/twitter-bootstrap/js/bootstrap.js" var="bootstrap_js"/>
<c:url value="${estilo}" var="bootstrap_css" />

<!-- Resources -->
<c:set value="/resources/html/menuUsuario.jsp" var="menuUsuario"/>
<c:url value="/resources/img/favicon.png" var="favicon"/>
<c:url value="/resources/img/background.jpg" var="background"/>
<c:url value="/resources/css/main.css" var="main_css"/>
<c:url value="/resources/js/main.js" var="main_js"/>
<c:url value="/resources/js/jquery-validate.js" var="jqueryvalidate_js"/>

<html>

<head>
	<!-- ICONE -->
	<title><fmt:message key="sistema.nome" /></title>
	
	<!-- FAVICON -->
	<link type="image/png" rel="icon" href="${favicon}">
	
	<!-- JS -->
	<script type="text/javascript" src="${jquery_js}"></script>
	<script type="text/javascript" src="${jquerymask_js}"></script>
	<script type="text/javascript" src="${jqueryvalidate_js}"></script>
	<script type="text/javascript" src="${bootstrap_js}"></script>
	<script type="text/javascript" src="${main_js}"></script>
	
	<!-- CSS -->
	<link type="text/css" rel="stylesheet" href="${jqueryui_css}"/>
	<link type="text/css" rel="stylesheet" href="${bootstrap_css}"/>
	<link type="text/css" rel="stylesheet" href="${main_css}"/>
	
	<!-- METAS -->
	<meta name="description" content="Calculo o tempo que gasta no trabalho, com pausa para diversos motivos. Extra��o de relatorios."/>
	<meta name="keywords" content="work,trabalho,medidor,horario,ponto,registro,calculo,relatorio"/>
	<meta name="expires" content="never"/>
</head>

<!-- JAVASCRIPT -->
<script type="text/javascript">
	$(document).ready(function()
	{
		$('#btnDropdown').dropdown();
		
		$('#btnLogout').click(function(event)
		{
			if(confirm('<fmt:message key="geral.alerta.logout" />'))
			{
				location.href = "${pathSair}";
			}
		});
	});
</script>

<body>
	
    <!-- BARRA DE NAVEGA��O -->
    <div class="navbar navbar-fixed-top">
	    <div class="navbar-inner">
		    <div class="pull-left">
		    	<!-- BRAND -->
		    	<a class="brand" href="${pathHome}"><b><fmt:message key="sistema.nome.personalizado" /></b></a>
	    	    <ul class="nav">
				    <li><a href="${pathHome}"><i class="icon-home icon-white"></i><b><fmt:message key="header.button.home.titulo.texto"/></b></a></li>
				    <c:choose>
				    	<c:when test="${not empty usuarioLogado}">
				    		<li class="dropdown">
							    <a id="btnDropdown" class="dropdown-toggle" data-toggle="dropdown" href="#">
							    	<i class="icon-book icon-white"></i>
							    	<b><fmt:message key="header.button.menu.titulo.texto" /></b><b class="caret"></b>
							    </a>
							    <ul class="dropdown-menu">
								    <li><a href="${pathGerenciadorHora}"><fmt:message key="header.button.menu.gerenciador.texto" /></a></li>
								    <li><a href="#relatorios"><fmt:message key="header.button.menu.relatorios.texto" /></a></li>
								    <li><a href="#calculos"><fmt:message key="header.button.menu.calculos.texto" /></a></li>
							    </ul>
						    </li>
				    	</c:when>
				    	<c:otherwise>
							<tags:formLoginDropdown inputSpans="span4"/>
				    	</c:otherwise>
				    </c:choose>
			    </ul>
		    </div>
		    <div class="pull-right">
			    <c:if test="${not empty usuarioLogado}">
			    	<jsp:include page="${menuUsuario}"/>
			    </c:if>
			</div>
	    </div>
    </div>