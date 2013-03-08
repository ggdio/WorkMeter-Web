<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<c:set value="/usuario/preferencias" var="pathFormularioPreferencias"/>

<jsp:include page="/resources/html/header.jsp"/>

<br/>
<br/>
<div class="container-fluid">
	
	<div class="row-fluid">
		<div class="span2 pull-left"></div>
		<div class="span8">
			<sc:label texto="Meus Dados" tipo="label-success" align="left" fontSize="x-large"/>
		</div>
		<div class="row-fluid span2 pull-right"></div>
	</div>
	<br/>
	
	<div class="row-fluid">
		<div class="span2 pull-left"></div>
			<div class="span8 well">
				<jsp:include page="${pathFormularioPreferencias}"/>
			</div>
		<div class="span2 pull-right"></div>
	</div>

</div>

<jsp:include page="/resources/html/footer.jsp"/>