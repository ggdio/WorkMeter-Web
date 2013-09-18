<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="inputSpans" required="false"%>

<c:url value="/usuario/login/entrar" var="pathExecutaLogin"/>
<c:url value="/resources/img/loading.gif" var="imgLoading"/>

	<fmt:message var="alertErroLoginFormTitle" key="geral.alerta.atencao"/>
	<sc:alert titulo="${alertErroLoginFormTitle}" texto="" identificador="alertErroLoginForm" hidden="hidden" tipo="alert-danger"/>
    <form id="loginFormAcesso" method="POST" action="${pathExecutaLogin}">
    
    	<fieldset>
			<label class="simple-label"><fmt:message key="usuario.acesso.formulario.label.email.texto"/></label>
			<input class="${inputSpans}" type="text" placeholder='<fmt:message key="usuario.acesso.formulario.text.email.placeholder"/>' name="email" />
			<label class="simple-label"><fmt:message key="usuario.acesso.formulario.label.senha.texto"/></label>
			<input id="txtSenha" class="${inputSpans}" type="password" placeholder='<fmt:message key="usuario.acesso.formulario.text.senha.placeholder"/>' name="senha"/><br/>
		</fieldset>
		
		<div class="form-actions">
			<div class="pull-right">
				<button id="btnReset" type="reset" class="btn btn-medium btn-danger"><fmt:message key="usuario.acesso.formulario.button.limpar.texto"/></button>
				<button id="btnLogin" type="submit" class="btn btn-medium btn-primary">
					<i class="icon-ok icon-white"></i>
					<span><fmt:message key="usuario.acesso.formulario.button.login.texto"/></span>
				</button>
			</div>
		</div>
		
	</form>

<script>
	$(document).ready(function() {
		
		getElemento("loginFormAcesso").on('submit',function(e) {
			var isValid = getElemento('loginForm').valid();
			if(!isValid){
				e.preventDefault();			
			}
		});
		
		getElemento("loginFormAcesso").validate({
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
			    	trocarTextoInterno("alertErroLoginForm", "span", "<span>"+validator.errorList[0].message+"</span>");
			    	getElemento("alertErroLoginForm").show();
			        validator.errorList[0].element.focus();
			    }
			},
		    errorPlacement: function(error, element) {}
		});
	});
</script>