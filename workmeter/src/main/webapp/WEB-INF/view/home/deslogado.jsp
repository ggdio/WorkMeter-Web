<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<c:url value="/resources/img/icon.png" var="icon"/>
<c:url value="/usuario/criar" var="pathCriar"/>

<!-- ALERTA -->
<div class="container">
	<br><br><br><br><br><br>
    <div class="hero-unit span10">
	    <h1>Seja bem vindo !</h1>
	    <br/>
	    <br/>
	    <a id="btnPopupLogin" class="btn btn-primary btn-large span2">Login</a>
	    <a id="btnPopupDetalhes" class="btn btn-warning btn-large span5">Ainda nao possui conta? Clique Aqui!</a>
    </div>
</div>

<!-- POPUP Login -->
<tag:popup id="popupLogin" component="btnPopupLogin" imagem="${icon}" titulo="Login" retornar="retornar">
	<jsp:attribute name="texto">
		<p>Realizar Login no Sistema</p>
		<ul>
			<li>Login:</li>
			<li>Senha:</li>
		</ul>
	</jsp:attribute>
</tag:popup>

<!-- POPUP Criar Conta -->
<tag:popup id="popupCriarConta" component="btnPopupDetalhes" imagem="${icon}" titulo="Criar Conta" retornar="retornar">
	<jsp:attribute name="texto">
		<p>Informe os seus dados abaixo:</p>
		<br/>
		<form id="formUsuario" class="well" action="${pathCriar}" method="post">
			<fieldset>
				<label for="nome"><b>Nome Completo</b></label>
				<input class="span5" type="text" id="txtNome" name="nome" maxlength="100" placeholder="Nome completo..."/><br/>
				<label for="nome"><b>Empresa</b></label>
				<input class="span5" type="text" id="txtEmpresa" name="empresa" maxlength="100" placeholder="Empresa em que trabalha..."/><br/>
				<label for="login"><b>Login</b></label>
				<input class="span4" type="text" id="txtLogin" name="login" maxlength="20" placeholder="Login..."/><br/>
				<label for="senha"><b>Senha</b></label>
				<input class="span4" type="password" id="txtSenha" name="senha" maxlength="20" placeholder="Senha..."/><br/>
			</fieldset>
			<div class="form-actions">
				<button id="btnConcluir" type="submit" class="btn btn-primary btn-large">
				<i class="icon-ok icon-white"></i>
				<span>Concluir</span>
				</button>
				<button type="reset">Limpar</button>
			</div>
		</form>
	</jsp:attribute>
</tag:popup>
