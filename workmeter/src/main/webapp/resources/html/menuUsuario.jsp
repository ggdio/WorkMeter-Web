<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/usuario/dados" var="pathDados" />

 <ul class="nav">
   	<li class="dropdown">
	    <a id="btnMenuUsuario" class="dropdown-toggle" data-toggle="dropdown" href="#">
	    	<b>${usuarioLogado.nome}</b>
	    	<b class="caret"></b>
	    </a>
	    <ul class="dropdown-menu">
	    	<li><a href="${pathDados}">Meus Dados</a></li>
		    <li><a id="btnLogout" href="#sair">Logout</a></li>
	    </ul>
	</li>
</ul>