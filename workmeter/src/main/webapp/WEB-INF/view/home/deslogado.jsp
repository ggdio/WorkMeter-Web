<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<!-- PATH -->
<c:url value="/usuario/cadastro" var="pathCadastro"/>

<!-- IMG -->
<c:url value="/resources/img/apresentacao/completo.png" var="imgCompleto"/>
<c:url value="/resources/img/apresentacao/core.png" var="imgCore"/>
<c:url value="/resources/img/apresentacao/multi-plataforma.png" var="imgMultiPlataforma"/>
<c:url value="/resources/img/apresentacao/opensource.png" var="imgOpensource"/>
<c:url value="/resources/img/apresentacao/powered.png" var="imgPowered"/>

<div class="jumbotron masthead">
  <div class="container">
    <h1 class="titulo-apresentacao">WorkMeter</h1>
	<p>Um facilitador para o seu dia-a-dia de trabalho.</p>
    <p>
      <a href="${pathCadastro}" class="btn btn-primary btn-large">Cadastre-se agora mesmo !</a>
    </p>
    <ul class="masthead-links">
      <li>
        <a href="https://github.com/ggdio/WorkMeter-Web">Github</a>
      </li>
      <li>
        <a href="#">Demonstração</a>
      </li>
      <li>
        Versão 1.0.0
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

    <h1>Apresentação</h1>
    <p class="marketing-byline">Quais as vantagens de se utilizar o Workmeter ???</p>

    <div class="row-fluid">
	  <div class="span4">
        <img class="marketing-img" src="${imgCompleto}">
        <h2>Completo</h2>
        <p>Com muitas funcionalidades interessantes, você tem todo o controle das horas gastas em seu dia-a-dia de trabalho. Facilita muito na agilidade e no detalhamento das tarefas realizadas em determinados períodos, assim como as paradas para o café.</p>
      </div>
      <div class="span4">
        <img class="marketing-img" src="${imgMultiPlataforma}">
        <h2>Multi-Plataforma</h2>
        <p>O Workmeter foi desenvolvido pensando no dia-a-dia das pessoas, e para isso criamos uma aplicação multi-plataforma, assim você acessa o sistema de qualquer dispositivo.</p>
      </div>
	  <div class="span4">
        <img class="marketing-img" src="${imgOpensource}">
        <h2>Opensource</h2>
        <p>O projeto é opensource, livre para modificações, basta acessar página do projeto no <a href="http://github.com/ggdio/WorkMeter-Web">github</a>.</p>
      </div>
    </div>

    <hr class="soften">

    <h1>Tecnologia <a href="http://github.com/sourcesphere/">Sourcesphere</a></h1>
    <p class="marketing-byline">Todo o sistema foi desenvolvido com a tecnologia dos frameworks SourceSphere.</p>
    <div class="row-fluid">
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