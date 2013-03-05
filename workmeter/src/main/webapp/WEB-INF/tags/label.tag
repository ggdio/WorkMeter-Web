<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<!-- ATRIBUTOS -->
<%@ attribute name="texto" required="true" %>
<%@ attribute name="tipo" required="true" description="Tipo do Alerta: label-succes | label-info | label-warning | label-important" %>
<%@ attribute name="align" required="false" %>
<%@ attribute name="fontSize" required="false" %>

<!-- HTML -->
<div align="${align}">
	<span style="font-size: ${fontSize};" class="label ${tipo}">${texto}</span>
</div>
