<%@tag import="br.com.ggdio.workmeter.http.ConstantesAtributos"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:url value="/idioma/alterar/" var="pathAlterarIdioma"/>

<%@ attribute name="inputSpans" required="false"%>

<ul class="nav">
	<li class="dropdown">
	    <a id="btnDropdownIdioma" class="dropdown-toggle" data-toggle="dropdown" href="#">
	    	<i class="icon-flag icon-white"></i>
	    	<b><fmt:message key="footer.button.idioma.titulo.texto"/></b><b class="caret"></b>
	    </a>
	    <ul class="dropdown-menu">
	    	<c:forEach items="<%=request.getAttribute(ConstantesAtributos.IDIOMAS_REQUEST)%>" var="idioma">
	    		<li><a id="btnIdioma_${idioma.toString()}" href="#">${idioma.nomeLocal}</a></li>
	    		<script type="text/javascript">
		    		getElemento("btnIdioma_${idioma.toString()}").click(function(){
		    			var url = "${pathAlterarIdioma}?valor=${idioma.nome}&paginaAtual="+document.location.href;
		    			document.location.href = url;
		    		});
	    		</script>
	    	</c:forEach>
	    </ul>
	</li>
</ul>
