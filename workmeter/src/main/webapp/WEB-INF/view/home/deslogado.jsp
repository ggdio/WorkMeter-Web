<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<!-- PATH -->
<c:url value="/usuario/cadastro" var="pathCadastro"/>
<c:url value="/usuario/login/entrar-ajax" var="pathExecutaLogin"/>

<!-- IMG -->
<c:url value="/resources/img/apresentacao/completo.png" var="imgCompleto"/>
<c:url value="/resources/img/apresentacao/core.png" var="imgCore"/>
<c:url value="/resources/img/apresentacao/multi-plataforma.png" var="imgMultiPlataforma"/>
<c:url value="/resources/img/apresentacao/opensource.png" var="imgOpensource"/>
<c:url value="/resources/img/apresentacao/powered.png" var="imgPowered"/>

<fmt:setLocale value="en"/>

<div class="jumbotron masthead">
  <div class="container">
    <h1 class="titulo-apresentacao"><fmt:message key="sistema.nome"/></h1>
	<p><fmt:message key="index.deslogado.area_introducao.descricao"/></p>
    <p>
      <a href="${pathCadastro}" class="btn btn-primary btn-large"><fmt:message key="index.deslogado.area_introducao.cadastrar"/></a>
    </p>
    <ul class="masthead-links">
      <li>
        <a href="https://github.com/ggdio/WorkMeter-Web">Github</a>
      </li>
      <li>
        <a href="#"><fmt:message key="index.deslogado.area_introducao.demonstracao"/></a>
      </li>
      <li>
        <fmt:message key="index.deslogado.area_introducao.versao"/> ${versao}
      </li>
    </ul>
  </div>
</div>

<div class="bs-docs-social">
  <div class="container">
    <ul class="bs-docs-social-buttons">
	  <li>
		<iframe src="http://ghbtns.com/github-btn.html?user=ggdio&type=follow&count=true&size=large" allowtransparency="true" frameborder="0" scrolling="0" width="170" height="30"></iframe>
	  </li>
      <li>
        <iframe src="http://ghbtns.com/github-btn.html?user=ggdio&repo=WorkMeter-Web&type=fork&count=true&size=large" allowtransparency="true" frameborder="0" scrolling="0" width="170" height="30"></iframe>
      </li>
	  <li>
        <iframe style="margin-left: -50px;" src="http://ghbtns.com/github-btn.html?user=ggdio&repo=WorkMeter-Web&type=watch&count=true&size=large" allowtransparency="true" frameborder="0" scrolling="0" width="170" height="30"></iframe>
      </li>
    </ul>
  </div>
</div>

<div class="container">

  <div class="marketing">

    <h1><fmt:message key="index.deslogado.area_apresentacao.descricao"/></h1>
    <p class="marketing-byline"><fmt:message key="index.deslogado.area_apresentacao.marketing"/></p>

    <div class="row-fluid">
	  <div class="span4">
        <img class="marketing-img" src="${imgCompleto}">
        <h2><fmt:message key="index.deslogado.area_apresentacao.completo.titulo"/></h2>
        <p><fmt:message key="index.deslogado.area_apresentacao.completo.texto"/></p>
      </div>
      <div class="span4">
        <img class="marketing-img" src="${imgMultiPlataforma}">
        <h2><fmt:message key="index.deslogado.area_apresentacao.multiplataforma.titulo"/></h2>
        <p><fmt:message key="index.deslogado.area_apresentacao.multiplataforma.texto"/></p>
      </div>
	  <div class="span4">
        <img class="marketing-img" src="${imgOpensource}">
        <h2><fmt:message key="index.deslogado.area_apresentacao.opensource.titulo"/></h2>
        <p><fmt:message key="index.deslogado.area_apresentacao.opensource.texto"/>&nbsp;<a href="http://github.com/ggdio/WorkMeter-Web">github</a>.</p>
      </div>
    </div>

    <hr class="soften">

    <h1><fmt:message key="index.deslogado.area_tecnologia.descricao"/>&nbsp;<a href="http://github.com/sourcesphere/">Sourcesphere</a></h1>
    <p class="marketing-byline"><fmt:message key="index.deslogado.area_tecnologia.marketing"/></p>
    <div class="row-fluid footer-separated">
      <ul class="thumbnails example-sites">
		 <li class="span2"></li>
		 <li class="span4">
          <a class="thumbnail" href="http://github.com/sourcesphere/" target="_blank">
            <img src="${imgPowered}" alt="Sourcesphere Dev Team">
          </a>
        </li>
        <li class="span4">
          <a class="thumbnail" href="http://github.com/sourcesphere/core/" target="_blank">
            <img src="${imgCore}" alt="Core Framework">
          </a>
        </li>
		<li class="span2"></li>
      </ul>
     </div>

  </div>

</div>