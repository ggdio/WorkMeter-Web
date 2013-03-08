<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/usuario/salvar" var="pathSalvar"/>

<form id="formPreferencia" action="${pathSalvar}" method="post">
	<fieldset>
	
		<input type="hidden" value="${usuarioLogado.id}"/>
		
		<label for="estilo"><b>Estilo das Paginas</b></label>
		<sc:combobox identificador="cbEstilo" name="estilo" dados="${estilos}" converter="${estiloConverter}" /><br/>
		
		<label for="idioma"><b>Idioma</b></label>
		<select id="cbIdioma" class="combobox" name="idioma">
<%-- 			<option selected="selected">${usuarioLogado.preferencia.idioma}</option> --%>
			<c:forEach items="${idiomas}" var="idioma" varStatus="index">
				<option>${idioma}</option>
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