<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<!-- ATRIBUTOS -->
<%@ attribute name="texto" required="true" %>
<%@ attribute name="tipo" required="true" description="Tipo do Alerta: label-succes | label-info | label-warning | label-important" %>
<%@ attribute name="align" required="false" %>
<%@ attribute name="fontSize" required="false" %>

<script>
if(!window.jQuery)
{
   alert("Resources has not been loaded, you need to specify the main servlet name on tag's attributes");
}
</script>

<!-- HTML -->
<div align="${align}">
	<span style="font-size: ${fontSize};" class="label ${tipo}">${texto}</span>
</div>
