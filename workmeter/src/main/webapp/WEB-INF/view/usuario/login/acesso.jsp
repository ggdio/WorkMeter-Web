<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:set value="/usuario/login/formulario" var="pathFormulario"/>

<jsp:include page="/resources/html/header.jsp"/>

<br/>
<br/>
<div class="container-fluid">
	
	<!-- FORMULARIO DE LOGIN -->
	<div class="row-fluid vertical-aligned">
		<div class="span4 pull-left"></div>
			<div class="span4 well">
				<div class="titulo-secao" align="center">Acesso ao Workmeter</div>
				<br/>
				<div class="span11">
					<c:if test="${not empty responseLogin}">
						<div class="mensagem-erro" align="center">
							${responseLogin.message}
						</div>
					</c:if>
					<jsp:include page="${pathFormulario}">
						<jsp:param name="campoSpan" value="span12"/>
					</jsp:include>
				</div>
			</div>
		<div class="span4 pull-right"></div>
	</div>

</div>

<jsp:include page="/resources/html/footer.jsp"/>