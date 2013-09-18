<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<c:url value="/" var="pathHome"/>

<jsp:include page="/resources/html/header.jsp"/>

<!-- Introducao -->
<div class="container">
	<br><br><br><br><br><br>
    <div class="hero-unit span11">
    	<h1><fmt:message key="geral.alerta.500.titulo" /></h1>
		<p><fmt:message key="geral.alerta.500.descricao" /></p>
		<p/>
	    <a class="btn btn-primary btn-large span2" href="${pathHome}"><fmt:message key="geral.pagina.inicial.texto" /></a>
    </div>
</div>

<br/>
<br/>
<jsp:include page="/resources/html/footer.jsp"/>