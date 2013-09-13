<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="inputSpans" required="false"%>

<c:url value="/usuario/login/entrar" var="pathExecutaLogin"/>

<!-- Formulário -->
<form id="formUsuario" action="${pathExecutaLogin}" method="post">
	<fieldset>
		<label for="email"><b>Email</b></label>
		<input class="${inputSpans}" type="text" id="txtEmail" name="email" maxlength="100" placeholder='<fmt:message key="header.formlogin.text.login.placeholder"/>'/>
		<label for="senha"><b>Senha</b></label>
		<input class="${inputSpans}" type="password" id="txtSenha" name="senha" maxlength="100" placeholder='<fmt:message key="header.formlogin.password.senha.placeholder"/>'/>
	</fieldset>
	<div class="form-actions">
		<div class="pull-right">
			<button type="reset" class="btn btn-medium btn-danger"><fmt:message key="header.formlogin.button.limpar.texto"/></button>
			<button id="btnLogin" type="submit" class="btn btn-medium btn-primary">
				<i class="icon-ok icon-white"></i>
				<span><fmt:message key="header.formlogin.button.login.texto"/></span>
			</button>
		</div>
	</div>
</form>