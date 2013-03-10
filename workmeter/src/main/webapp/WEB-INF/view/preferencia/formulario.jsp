<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/preferencias/atualizar" var="pathAtualizarPreferencias"/>
<c:set value="/estilo/listar" var="pathListaEstilos"/>

<form id="formPreferencia" action="${pathAtualizarPreferencias}" method="post">
	<fieldset>
	
		<input type="hidden" id="txtId" name="id" value="${usuarioLogado.preferencia.id}"/>
		
		<jsp:include page="${pathListaEstilos}"/>
		<label for="estilo"><b>Estilo das Paginas</b></label>
		<sc:combobox identificador="cbEstilo" name="estilo" dados="${estilos}" converter="${estiloConverter}" selecionado="${usuarioLogado.preferencia.estilo}"/><br/>
		
		<label for="idioma"><b>Idioma</b></label>
		<sc:combobox identificador="cbIdioma" name="idioma" dados="${idiomas}" converter="${idiomaConverter}" selecionado="${usuarioLogado.preferencia.idioma}"/><br/>
		
	</fieldset>
	
	<div class="form-actions">
		<button id="btnConcluir" type="submit" class="btn btn-primary btn-large">
			<i class="icon-ok icon-white"></i>
			<span>Concluir</span>
		</button>
	</div>
	
</form>