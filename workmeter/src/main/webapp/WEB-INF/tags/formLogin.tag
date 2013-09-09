<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%@ attribute name="inputSpans" required="false"%>

<c:url value="/usuario/login/entrar" var="pathExecutaLogin"/>

<!-- Formulário -->
<form id="formUsuario" action="${pathExecutaLogin}" method="post">
	<fieldset>
		<label for="email"><b>Email</b></label>
		<input class="${inputSpans}" type="text" id="txtEmail" name="email" maxlength="100" placeholder="Digite seu email..."/>
		<label for="senha"><b>Senha</b></label>
		<input class="${inputSpans}" type="password" id="txtSenha" name="senha" maxlength="100" placeholder="Digite sua senha..."/>
	</fieldset>
	<div class="form-actions">
		<div class="pull-right">
			<button type="reset" class="btn btn-medium btn-danger">Limpar</button>
			<button id="btnLogin" type="submit" class="btn btn-medium btn-primary">
				<i class="icon-ok icon-white"></i>
				<span>Login</span>
			</button>
		</div>
	</div>
</form>