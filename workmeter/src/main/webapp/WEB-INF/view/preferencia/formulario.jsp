<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/preferencias/atualizar" var="pathAtualizarPreferencias"/>

<form id="formPreferencia" action="${pathAtualizarPreferencias}" method="post">
	<fieldset>
	
		<input type="hidden" id="txtId" name="id" value="${preferencia.id}"/><br/>
		
		<label for="estilo"><b>Estilo das Paginas</b></label>
		<sc:combobox identificador="cbEstilo" name="estilo" dados="${estilos}" converter="${estiloConverter}" selecionado="${preferencia.estilo.descricao}"/><br/>
		
		<label for="idioma"><b>Idioma</b></label>
		<select id="cbIdioma" class="combobox" name="idioma">
			<option selected="selected">${preferencia.idioma}</option>
			<c:forEach items="${idiomas}" var="idioma" varStatus="index">
				<c:if test="${idioma != preferencia.idioma}">
					<option>${idioma}</option>
				</c:if>
			</c:forEach>
		</select>
		
	</fieldset>
	
	<div class="form-actions">
		<button id="btnConcluir" type="submit" class="btn btn-primary btn-large">
			<i class="icon-ok icon-white"></i>
			<span>Concluir</span>
		</button>
	</div>
	
</form>