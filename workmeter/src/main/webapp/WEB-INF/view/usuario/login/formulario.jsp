<!-- FORMULARIO DE CADASTRO DE USUARIO -->

<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<c:url value="/usuario/login/entrar" var="pathExecutaLogin"/>

<!-- Formulário -->
<form id="formUsuario" action="${pathExecutaLogin}" method="post">
	<fieldset>
		<label for="nome"><b>Login</b></label>
		<input class="${param.campoSpan}" type="text" id="txtNome" name="login" maxlength="100" placeholder="Seu login..."/>
		<label for="nome"><b>Senha</b></label>
		<input class="${param.campoSpan}" type="password" id="txtSenha" name="senha" maxlength="100" placeholder="Sua senha..."/>
	</fieldset>
	<div class="form-actions">
		<button id="btnLogin" type="submit" class="btn btn-primary btn-large">
			<i class="icon-ok icon-white"></i>
			<span>Login</span>
		</button>
		<button type="reset" class="btn btn-warning btn-large">Limpar</button>
	</div>
</form>