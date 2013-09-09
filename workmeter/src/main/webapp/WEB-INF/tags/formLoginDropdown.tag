<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ attribute name="inputSpans" required="false"%>

<c:url value="/usuario/login/entrar-ajax" var="pathExecutaLogin"/>
<c:url value="/resources/img/loading.gif" var="imgLoading"/>

<li class="dropdown">
	<a id="btnLoginForm" class="dropdown-toggle" data-toggle="dropdown" href="#">
		<i class="icon-lock icon-white"></i>
		<b>Entrar</b><b class="caret"></b>
	</a>
	<div class="dropdown-menu well-refined">
	    <form id="loginForm" method="POST" action="${pathExecutaLogin}">
	    
	    	<fieldset>
				<label class="simple-label">Email</label>
				<input class="${inputSpans}" type="text" placeholder="Digite seu email..." name="email" />
				<label class="simple-label">Senha</label>
				<input id="txtSenha" class="${inputSpans}" type="password" placeholder="Digite sua senha..." name="senha"/><br/>
				<div id="divMsg" class="mensagem-erro"></div>
			</fieldset>
			
			<div class="form-actions">
				<div id="loading" class="pull-left" hidden="hidden">
					<img src="${imgLoading}"/>&nbsp;Aguarde...
				</div>
				<div class="pull-right">
					<button id="btnReset" type="reset" class="btn btn-medium btn-danger">Limpar</button>
					<button id="btnLogin" type="submit" class="btn btn-medium btn-primary">
						<i class="icon-ok icon-white"></i>
						<span>Login</span>
					</button>
				</div>
			</div>
			
		</form>
	</div>
</li>

<script>
	getElemento("loginForm").submit(function (e) {
    	getElemento("loading").show();
		e.preventDefault();
    	ajaxLogin();
	});
	
	getElemento("btnReset").click(function(){
		getElemento('divMsg').empty();
	});
	
	function ajaxLogin(){
		$.ajax
		({
			type : 'POST',
			url : '${pathExecutaLogin}',
			data : getElemento('loginForm').serialize(),
			success: function(response)
			{
				window.location.reload();
			},
			error: function(response)
			{
				var info = parseJson(response);
				getElemento('divMsg').text(info.message);
				getElemento("loading").hide();
			}
		});
	}
</script>