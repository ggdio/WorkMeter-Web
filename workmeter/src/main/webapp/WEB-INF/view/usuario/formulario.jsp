<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- FORMULARIO DE CADASTRO DE USUARIO -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<c:url value="/usuario/criar" var="pathCriar"/>

<form id="formUsuario" class="well" action="${pathCriar}" method="post">
	<fieldset>
	
		<label for="nome"><b>Nome</b></label>
		<input class="span5" type="text" id="txtNome" name="nome" maxlength="100" placeholder="Nome Completo..."/><br/>
		
		<label for="nascimento"><b>Data de Nascimento</b></label>
		<sc:dateField nome="nascimento" identificador="txtNascimento"/><br/>
		
		<label for="empresa"><b>Empresa</b></label>
		<input class="span5" type="text" id="txtEmpresa" name="empresa" maxlength="100" placeholder="Empresa em que trabalha..."/><br/>
		
		<label for="email"><b>Email</b></label>
		<input class="span4" type="text" id="txtEmail" name="email" maxlength="100" placeholder="meu_email@exemplo.com.br..."/><br/>
		
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