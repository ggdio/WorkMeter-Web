<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="inputSpans" required="false"%>

<c:url value="/usuario/login/entrar-ajax" var="pathExecutaLogin"/>
<c:url value="/" var="pathHome"/>
<c:url value="/resources/img/loading.gif" var="imgLoading"/>

<li class="dropdown">
	<a id="btnLoginForm" class="dropdown-toggle" data-toggle="dropdown" href="#">
		<i class="icon-lock icon-white"></i>
		<b><fmt:message key="header.button.entrar.titulo.texto" /></b><b class="caret"></b>
	</a>
	<div class="dropdown-menu well-refined">
	    <form id="loginForm" method="POST" action="${pathExecutaLogin}">
	    
	    	<fieldset>
				<label class="simple-label"><fmt:message key="usuario.acesso.formulario.label.email.texto"/></label>
				<input class="${inputSpans}" type="text" placeholder='<fmt:message key="usuario.acesso.formulario.text.email.placeholder"/>' name="email" />
				<label class="simple-label"><fmt:message key="usuario.acesso.formulario.label.senha.texto"/></label>
				<input id="txtSenha" class="${inputSpans}" type="password" placeholder='<fmt:message key="usuario.acesso.formulario.text.senha.placeholder"/>' name="senha"/><br/>
				<div id="divMsg" class="mensagem-erro"></div>
			</fieldset>
			
			<div class="form-actions">
				<div id="loading" class="pull-left" hidden="hidden">
					<img src="${imgLoading}"/>&nbsp;<fmt:message key="geral.loading.texto"/>
				</div>
				<div class="pull-right">
					<button id="btnReset" type="reset" class="btn btn-medium btn-danger"><fmt:message key="usuario.acesso.formulario.button.limpar.texto"/></button>
					<button id="btnLogin" type="submit" class="btn btn-medium btn-primary">
						<i class="icon-ok icon-white"></i>
						<span><fmt:message key="usuario.acesso.formulario.button.login.texto"/></span>
					</button>
				</div>
			</div>
			
		</form>
	</div>
</li>

<script>
	$(document).ready(function() {
		getElemento("loginForm").on('submit',function(e) {
			e.preventDefault();
			var isValid = getElemento('loginForm').valid();
			if(isValid){
				getElemento("loading").show();
				e.preventDefault();
				ajaxLogin();				
			}
		});

		getElemento("btnReset").click(function() {
			getElemento('divMsg').empty();
		});

		function ajaxLogin() {
			$.ajax({
				type : 'POST',
				url : '${pathExecutaLogin}',
				data : getElemento('loginForm').serialize(),
				success : function(response) {
					window.location = "${pathHome}";
				},
				error : function(response) {
					var info = parseJson(response);
					getElemento('divMsg').text(info.message);
					getElemento("loading").hide();
				}
			});
		}
		
		$('#loginForm').validate({
			rules:{ 
				email:{ 
					required: true,
				},
				senha:{
					required: true,
					minlength: 8
				}
			},
			messages:{
				email:{ 
					required: '<fmt:message key="usuario.acesso.formulario.alerta.digitar.email"/>'
				},
				senha: {
					required: '<fmt:message key="usuario.acesso.formulario.alerta.digitar.senha"/>',
					minlength: '<fmt:message key="usuario.acesso.formulario.alerta.minimo.senha"/>'
				}
			},
			invalidHandler: function(form, validator) {
			    var errors = validator.numberOfInvalids();
			    if (errors) 
			    {
			    	trocarTextoInterno("divMsg", "span", "<span>"+validator.errorList[0].message+"</span>");
			    	getElemento("divMsg").show();
			        validator.errorList[0].element.focus();
			    }
			},
		    errorPlacement: function(error, element) {}
		});
	});
</script>