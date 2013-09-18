<%@tag import="br.com.ggdio.workmeter.http.ConstantesAtributos"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="inputSpans" required="false"%>

<jsp:useBean id="constantes" class="br.com.ggdio.workmeter.http.ConstantesAtributos"/>
<jsp:useBean id="idiomaConverter" class="br.com.ggdio.workmeter.converter.IdiomaConverter"/>

<ul class="nav">
	<li class="dropdown">
	    <a id="btnDropdownIdioma" class="dropdown-toggle" data-toggle="dropdown" href="#">
	    	<i class="icon-flag icon-white"></i>
	    	<b><fmt:message key="footer.button.idioma.titulo.texto"/></b><b class="caret"></b>
	    </a>
	    <ul class="dropdown-menu">
	    	<c:forEach items="<%=request.getAttribute(ConstantesAtributos.IDIOMAS_REQUEST)%>" var="idioma">
	    		<li><a href="#">${idiomaConverter.convertTo(idioma)}</a></li>
	    	</c:forEach>
	    </ul>
	</li>
</ul>