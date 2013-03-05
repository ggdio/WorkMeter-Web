<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<c:set value="/usuario/login/formulario" var="pathFormulario"/>

<jsp:include page="/resources/html/header.jsp"/>

<br/>
<br/>
<div class="container-fluid">
	
	<div class="row-fluid">
		<div class="span4 pull-left"></div>
		<div class="span4">
			<tag:label texto="Acesso ao Workmeter" tipo="label-success" align="left" fontSize="x-large"/>
		</div>
		<div class="row-fluid span4 pull-right"></div>
	</div>
	<br/>
	
	<!-- FORMULARIO DE LOGIN -->
	<div class="row-fluid">
		<div class="span4 pull-left"></div>
			<div class="span4 well">
				<div class="span11">
					<c:if test="${not empty responseUsuarioController}">
						<div align="center">
							<font color="red"><strong>${responseUsuarioController.message}</strong></font>
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