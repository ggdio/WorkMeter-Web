<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<%@ attribute name="inputSpans" required="false"%>

<c:url value="/usuario/criar" var="pathCriar"/>
<c:url value="/usuario/acesso" var="pathAcesso"/>

<sc:alert titulo='<fmt:message key="geral.alerta.atencao" />' texto="" identificador="alertErroCadastro" hidden="hidden" tipo="alert-danger"/>
<form id="formUsuario" action="${pathCriar}" method="post" class="form-inline">
	<fieldset>
		<p>
			<label for="nome"><b><fmt:message key="usuario.cadastro.formulario.label.nome.texto" /></b></label>
			<input class="${inputSpans}" type="text" id="txtNome" name="nome" maxlength="100" placeholder='<fmt:message key="usuario.cadastro.formulario.text.nome.placeholder" />'/>
		</p>
		
		<p>
			<label for="nascimento"><b><fmt:message key="usuario.cadastro.formulario.label.nascimento.texto" /></b></label>
			<sc:dateField classe="${inputSpans}" nome="nascimento" identificador="txtNascimento"/>
		</p>
		
		<p>
			<label for="empresa"><b><fmt:message key="usuario.cadastro.formulario.label.empresa.texto" /></b></label>
			<input class="${inputSpans}" type="text" id="txtEmpresa" name="empresa" maxlength="100" placeholder='<fmt:message key="usuario.cadastro.formulario.text.empresa.placeholder" />'/>
		</p>
		
		<p>
			<label for="email"><b><fmt:message key="usuario.cadastro.formulario.label.email.texto" /></b></label>
			<input class="${inputSpans}" type="text" id="txtEmail" name="email" maxlength="100" placeholder='<fmt:message key="usuario.cadastro.formulario.text.empresa.placeholder" />'/>
		</p>
		
		<p>
			<label for="senha"><b><fmt:message key="usuario.cadastro.formulario.label.senha.texto" /></b></label>
			<input class="${inputSpans}" type="password" id="txtSenha" name="senha" maxlength="20" placeholder='<fmt:message key="usuario.cadastro.formulario.text.senha.placeholder" />'/>
		</p>
		
		<p>
			<label for="confSenha"><b><fmt:message key="usuario.cadastro.formulario.label.confirmacaosenha.texto" /></b></label>
			<input class="${inputSpans}" type="password" id="txtConfSenha" name="confSenha" maxlength="20" placeholder='<fmt:message key="usuario.cadastro.formulario.text.confirmacaosenha.placeholder" />'/>
		</p>
	</fieldset>
	<div class="form-actions">
		<div class="pull-left">
			<a href="${pathAcesso}" class="btn btn-primary btn-medium"><fmt:message key="usuario.cadastro.formulario.button.possuicadastro.texto" /></a>
		</div>
		<div class="pull-right">
			<button type="reset" class="btn btn-danger btn-medium"><fmt:message key="usuario.cadastro.formulario.button.limpar.texto" /></button>
			<button id="btnConcluir" type="submit" class="btn btn-primary btn-medium">
				<i class="icon-ok icon-white"></i>
				<span><fmt:message key="usuario.cadastro.formulario.button.concluir.texto" /></span>
			</button>
		</div>
	</div>
</form>

<script type="text/javascript">
	$(document).ready(function(){
		$('#formUsuario').validate({
			rules:{ 
				nome:{ 
					required: true,
					minlength: 4
				},
				nascimento:{
					required: true,
					minlength: 10
				},
				email: {
					required: true,
					email: true
				},
				senha: {
					required: true,
					minlength: 8,
					equalTo: "#txtConfSenha"
				},
				confSenha:{
					required: true
				}
			},
			messages:{
				nome:{ 
					required: '<fmt:message key="usuario.cadastro.formulario.alerta.digitar.nome" />',
					minlength: '<fmt:message key="usuario.cadastro.formulario.alerta.minimo.nome" />'
				},
				nascimento: {
					required: '<fmt:message key="usuario.cadastro.formulario.alerta.digitar.nascimento" />'
				},
				email: {
					required: '<fmt:message key="usuario.cadastro.formulario.alerta.digitar.email" />',
					email: '<fmt:message key="usuario.cadastro.formulario.alerta.valido.email" />'
				},
				senha: {
					required: '<fmt:message key="usuario.cadastro.formulario.alerta.digitar.senha" />',
					minlength: '<fmt:message key="usuario.cadastro.formulario.alerta.minimo.senha" />',
					equalTo: '<fmt:message key="usuario.cadastro.formulario.alerta.valido.confirmacaosenha" />'
				},
				confSenha:{
					required: '<fmt:message key="usuario.cadastro.formulario.alerta.digitar.confirmacaosenha" />'
				}
			},
			invalidHandler: function(form, validator) {
			    var errors = validator.numberOfInvalids();
			    if (errors) 
			    {
			    	trocarTextoInterno("alertErroCadastro", "span", "<span>"+validator.errorList[0].message+"</span>");
			    	getElemento("alertErroCadastro").show();
			        validator.errorList[0].element.focus();
			    }
			},
		    errorPlacement: function(error, element) {}
		});
	});
</script>