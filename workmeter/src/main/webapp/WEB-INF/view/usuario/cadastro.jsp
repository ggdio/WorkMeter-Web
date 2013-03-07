<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set value="/usuario/formulario" var="pathFormulario"/>

<jsp:include page="/resources/html/header.jsp"/>

<div id="conteudo">
	<jsp:include page="${pathFormulario}"/>
</div>

<jsp:include page="/resources/html/footer.jsp"/>