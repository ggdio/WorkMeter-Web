<!-- FORMULARIO DE CADASTRO DE USUARIO -->

<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<c:url value="/login/entrar" var="pathExecutaLogin"/>

<!-- Mensagem -->
<div id="msgLogin">
	<c:if test="${not empty responseLoginController}">
			<tag:alert 
			id="alertaLoginController" 
			titulo="Atenção" 
			texto="${responseLoginController.message}" 
			tipo="alert-warning" 
			width="50%"/>
	</c:if>
</div>

<!-- Formulário -->
<form id="formUsuario" class="well" action="${pathExecutaLogin}" method="post">
	<fieldset>
		<label for="nome"><b>Login</b></label>
		<input class="span5" type="text" id="txtNome" name="login" maxlength="100" placeholder="Seu login..."/><br/>
		<label for="nome"><b>Senha</b></label>
		<input class="span5" type="password" id="txtSenha" name="senha" maxlength="100" placeholder="Sua senha..."/><br/>
	</fieldset>
	<div class="form-actions">
		<button id="btnLogin" type="submit" class="btn btn-primary btn-large">
			<i class="icon-ok icon-white"></i>
			<span>Login</span>
		</button>
		<button type="reset" class="btn btn-warning btn-large">Limpar</button>
	</div>
</form>