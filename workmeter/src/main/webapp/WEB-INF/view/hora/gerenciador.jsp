<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:set value="/hora/conteudo" var="pathConteudo"/>
<fmt:formatDate value="${dataAtual}" pattern="dd/MM/yyyy" var="data"/>
<fmt:formatDate value="${dataAtual}" pattern="hh:mm:ss" var="hora"/>

<jsp:include page="/resources/html/header.jsp"/>
<br/>
<div class="container-fluid" align="center">
	<div class="row-fluid">
	
		<!-- ESQUERDA -->
		<div class="span3" style="min-height: 100%;position: relative;height: 100%;bottom: auto;">
			<div class="row">
				<div class="span12">
				</div>
				<br/>
				<br/>
			</div>
			<div class="row">
				<div class="span12 well-silver">
					<sc:label tipo="label-transparent" texto="Informações de Hora" fontSize="medium"/>
					<div id="divInfoHora" align="right">
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
					</div>
				</div>
			</div>
		</div>
		
		<!-- CENTRO -->
		<div class="span6">
			<div class="row">
				<div class="span12">
					<sc:label tipo="label-info" texto="Gerenciador de Hora" align="center" fontSize="x-large"/>
				</div>
				<br/>
				<br/>
			</div>
			<div class="row">
				<div class="span12 well-silver">
					<jsp:include page="${pathConteudo}"/>
				</div>
			</div>
		</div>
		
		<!-- DIREITA -->
		<div class="span3">
			<div class="row">
				<div class="span12">
				</div>
				<br/>
				<br/>
			</div>
			<div class="row">
				<div class="span12 well-silver">
					<sc:label tipo="label-transparent" texto="Informações Gerais" fontSize="medium"/><br/>
					<div id="divInfoGeral" align="left">
						<h5>Data: ${data}</h5>
						<h5>Hora: ${hora}</h5>
						<h5>Empresa: ${usuarioLogado.empresa}</h5>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
					</div>
				</div>
			</div>
		</div>
	
	</div>
</div>

<jsp:include page="/resources/html/footer.jsp"/>