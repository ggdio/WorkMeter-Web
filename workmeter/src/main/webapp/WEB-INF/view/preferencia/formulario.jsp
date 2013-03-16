<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/preferencias/atualizar" var="pathAtualizarPreferencias"/>

<form id="formPreferencia" action="${pathAtualizarPreferencias}" method="post">
	<fieldset>
	
		<input type="hidden" id="txtId" name="idPreferencia" value="${usuarioLogado.preferencia.id}"/>
		
		<label for="idEstilo"><b>Estilo das Paginas</b></label>
		<select id="cbEstilo" class="combobox" name="idEstilo">
			<c:set var="selecionado" value="${usuarioLogado.preferencia.estilo}"/>
			<option value="${selecionado.id}" selected="selected">${estiloConverter.convertTo(selecionado)}</option>
			<c:forEach items="${estilos}" var="estilo">
				<c:if test="${selecionado.equals(estilo) == false}">
					<option value="${estilo.id}">${estiloConverter.convertTo(estilo)}</option>
				</c:if>
			</c:forEach>
		</select>
		<script>
		$(document).ready(function()
		{
		  	$('#cbEstilo').combobox();
		});
		</script>

		<label for="idioma"><b>Idioma</b></label>
		<sc:combobox identificador="cbIdioma" nome="idioma" dados="${idiomasGeral}" converter="${idiomaConverter}" selecionado="${usuarioLogado.preferencia.idioma}"/><br/>
		<br/>
	</fieldset>
	
	<div class="form-actions">
		<button id="btnConcluir" type="submit" class="btn btn-primary btn-large">
			<i class="icon-ok icon-white"></i>
			<span>Concluir</span>
		</button>
	</div>
	
</form>