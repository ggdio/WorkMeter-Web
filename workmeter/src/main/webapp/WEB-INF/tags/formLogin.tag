<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ attribute name="inputSpans" required="false"%>

<c:url value="/usuario/login/entrar" var="login"/>

<li class="dropdown">
	<a id="btnLoginForm" class="dropdown-toggle" data-toggle="dropdown" href="#">
		<i class="icon-lock icon-white"></i>
		<b>Entrar</b><b class="caret"></b>
	</a>
	<div class="dropdown-menu well-refined">
	    <form id="loginForm" method="POST" action="${login}">
	    
	    	<fieldset>
				<label class="simple-label">Email</label>
				<input class="${inputSpans}" type="text" placeholder="Digite seu email..." name="email" />
				<label class="simple-label">Senha</label>
				<input class="${inputSpans}" type="password" placeholder="Digite sua senha..." name="senha"/><br/>
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
	</div>
</li>