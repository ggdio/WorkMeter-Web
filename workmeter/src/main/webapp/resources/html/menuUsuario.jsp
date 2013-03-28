<div class="pull-right">
  	<ul class="nav">
	   	<li class="dropdown">
		    <a id="btnMenuUsuario" class="dropdown-toggle" data-toggle="dropdown" href="#">
		    	<b>${usuarioLogado.nome}</b>
		    	<b class="caret"></b>
		    </a>
		    <ul class="dropdown-menu">
		    	<li><a href="${pathDados}">Meus Dados</a></li>
			    <li><a id="btnLogout" href="#sair">Logout</a></li>
		    </ul>
   		</li>
    </ul>
</div>
<script>
	$('#btnMenuUsuario').dropdown();
</script>