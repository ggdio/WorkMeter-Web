<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%-- <%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %> --%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sc" %>

<c:url value="/preferencias/atualizar" var="pathAtualizarPreferencias"/>

<form id="formPreferencia" action="${pathAtualizarPreferencias}" method="post">
	<fieldset>
	
		<input type="hidden" id="txtId" name="idPreferencia" value="${usuarioLogado.preferencia.id}"/>
		
<!-- 		<label for="idEstilo"><b>Estilo das Paginas</b></label> -->
<%-- 		<sc:combobox identificador="cbEstilo" nome="estilo" dados="${estilos}" converter="${estiloConverter}" selecionado="${usuarioLogado.preferencia.estilo}"/><br/> --%>
		
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