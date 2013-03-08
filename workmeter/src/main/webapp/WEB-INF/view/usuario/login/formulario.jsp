<!-- FORMULARIO DE CADASTRO DE USUARIO -->

<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/usuario/login/entrar" var="pathExecutaLogin"/>

<!-- Formulário -->
<form id="formUsuario" action="${pathExecutaLogin}" method="post">
	<fieldset>
		<label for="email"><b>Email</b></label>
		<input class="${param.campoSpan}" type="text" id="txtEmail" name="email" maxlength="100" placeholder="Seu email(login)..."/>
		<label for="senha"><b>Senha</b></label>
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