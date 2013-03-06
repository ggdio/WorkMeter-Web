<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- FORMULARIO DE CADASTRO DE USUARIO -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/usuario/criar" var="pathCriar"/>


<form id="formUsuario" class="well" action="${pathCriar}" method="post">
	<fieldset>
		<label for="nome"><b>Nome Completo</b></label>
		<input class="span5" type="text" id="txtNome" name="nome" maxlength="100" placeholder="Nome completo..."/><br/>
		<label for="nome"><b>Empresa</b></label>
		<input class="span5" type="text" id="txtEmpresa" name="empresa" maxlength="100" placeholder="Empresa em que trabalha..."/><br/>
		<label for="login"><b>Login</b></label>
		<input class="span4" type="text" id="txtLogin" name="login" maxlength="20" placeholder="Login..."/><br/>
		<label for="senha"><b>Senha</b></label>
		<input class="span4" type="password" id="txtSenha" name="senha" maxlength="20" placeholder="Senha..."/>
	</fieldset>
	<div class="form-actions">
		<button id="btnConcluir" type="submit" class="btn btn-primary btn-large">
			<i class="icon-ok icon-white"></i>
			<span>Concluir</span>
		</button>
		<button type="reset" class="btn btn-warning btn-large">Limpar</button>
	</div>
</form>