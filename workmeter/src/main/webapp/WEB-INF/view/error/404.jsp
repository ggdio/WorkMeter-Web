<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<c:url value="/" var="pathHome"/>

<jsp:include page="/resources/html/header.jsp"/>

<!-- Introducao -->
<div class="container">
	<br><br><br><br><br><br>
    <div class="hero-unit span11">
    	<h1>Página Inexistente (404)</h1>
		<p>A página que você solicitou não existe !</p>
		<p/>
	    <a class="btn btn-primary btn-large span2" href="${pathHome}">Pagina Inicial</a>
    </div>
</div>

<br/>
<br/>
<jsp:include page="/resources/html/footer.jsp"/>