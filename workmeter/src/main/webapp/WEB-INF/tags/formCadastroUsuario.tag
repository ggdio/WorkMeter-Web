<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<%@ attribute name="inputSpans" required="false"%>

<c:url value="/usuario/criar" var="pathCriar"/>
<c:url value="/usuario/acesso" var="pathAcesso"/>

<sc:alert titulo="Aten��o" texto="" identificador="alertErro" hidden="hidden" tipo="alert-danger"/>
<form id="formUsuario" action="${pathCriar}" method="post" class="form-inline">
	<fieldset>
		<p>
			<label for="nome"><b>Nome</b></label>
			<input class="${inputSpans}" type="text" id="txtNome" name="nome" maxlength="100" placeholder="Nome Completo..."/>
		</p>
		
		<p>
			<label for="nascimento"><b>Data de Nascimento</b></label>
			<sc:dateField classe="${inputSpans}" nome="nascimento" identificador="txtNascimento"/>
		</p>
		
		<p>
			<label for="empresa"><b>Empresa</b></label>
			<input class="${inputSpans}" type="text" id="txtEmpresa" name="empresa" maxlength="100" placeholder="Empresa em que trabalha..."/>
		</p>
		
		<p>
			<label for="email"><b>Email</b></label>
			<input class="${inputSpans}" type="text" id="txtEmail" name="email" maxlength="100" placeholder="meu_email@exemplo.com.br..."/>
		</p>
		
		<p>
			<label for="senha"><b>Senha</b></label>
			<input class="${inputSpans}" type="password" id="txtSenha" name="senha" maxlength="20" placeholder="Senha..."/>
		</p>
		
		<p>
			<label for="confSenha"><b>Confirma��o de Senha</b></label>
			<input class="${inputSpans}" type="password" id="txtConfSenha" name="confSenha" maxlength="20" placeholder="Confirma��o de Senha..."/>
		</p>
	</fieldset>
	<div class="form-actions">
		<div class="pull-left">
			<a href="${pathAcesso}" class="btn btn-primary btn-medium">J� possu� cadastro ?</a>
		</div>
		<div class="pull-right">
			<button type="reset" class="btn btn-danger btn-medium">Limpar</button>
			<button id="btnConcluir" type="submit" class="btn btn-primary btn-medium">
				<i class="icon-ok icon-white"></i>
				<span>Concluir</span>
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
					required: "O campo nome � obrigatorio.",
					minlength: "O campo nome deve conter no m�nimo 3 caracteres."
				},
				nascimento: {
					required: "O campo data de nascimento � obrigatorio."
				},
				email: {
					required: "O campo email � obrigatorio.",
					email: "O campo email deve conter um email v�lido."
				},
				senha: {
					required: "O campo senha � obrigatorio.",
					minlength: "Utilize no m�nimo 8 caracteres para a senha."
				},
				confSenha:{
					required: "O campo confirma��o de senha � obrigatorio.",
					equalTo: "O campo confirma��o de senha deve ser identico ao campo senha."
				}
			},
			invalidHandler: function(form, validator) {
			    var errors = validator.numberOfInvalids();
			    if (errors) 
			    {
			    	trocarTextoInterno("alertErro", "span", "<span>"+validator.errorList[0].message+"</span>");
			    	getElemento("alertErro").show();
			        validator.errorList[0].element.focus();
			    }
			},
		    errorPlacement: function(error, element) {}
		});
	});
</script>