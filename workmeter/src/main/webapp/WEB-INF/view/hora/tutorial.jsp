<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sourcesphere.com.br/jsp/tags/style-bootstrap/sc" prefix="sc" %>

<c:url value="/resources/img/icon.png" var="icon"/>

<input type="button" hidden="hidden" id="handler1"/>
<sc:popup identificador="popupTutorial" component="handler1" imagem="${icon}" titulo="Introdu��o:Gerenciador de Horas" retornar="retornar">
	<jsp:attribute name="texto">
		<div class="well" align="left">
	 		<p>Bem vindo ao m�dulo de gerenciamento de horas !</p>
	 		<p>Identificamos que voc� est� utilizando o sistema pela primeira vez, portanto iremos lhe apresentar um pequeno tutorial
	 		   sobre como acompanhar suas horas de trabalho no dia-a-dia.</p>
	 		<p>Clique em 'Iniciar' para come�ar...</p>
	 	</div>
	</jsp:attribute>
</sc:popup>

<input type="button" hidden="hidden" id="handler2"/>
<sc:popup identificador="popupIniciarTrabalho" component="handler2" imagem="${icon}" titulo="Tutorial:Iniciar Dia de Trabalho" retornar="retornar">
	<jsp:attribute name="texto">
		<div class="well" align="left">
	 		<p>Voc� esta dando in�cio a sua jornada de trabalho !</p>
	 		<p>Clique em 'Continuar'...</p>
	 	</div>
	</jsp:attribute>
</sc:popup>

<input type="button" hidden="hidden" id="handler3"/>
<sc:popup identificador="popupPausarTrabalho" component="handler3" imagem="${icon}" titulo="Tutorial:Pausa de Trabalho" retornar="retornar">
	<jsp:attribute name="texto">
		<div class="well" align="left">
	 		<p>Muito bom, neste momento voc� j� esta trabalhando h� um tempo.</p>
	 		<p>Por�m sentiu um cansa�o, e percebe que precisa tomar um caf�, portanto decide dar uma pausa em sua rotina de trabalho.</p>
	 		<p>Clique em 'Continuar' para vermos esta fun��o...</p>
	 	</div>
	</jsp:attribute>
</sc:popup>

<input type="button" hidden="hidden" id="handler4"/>
<sc:popup identificador="popupTrabalhoPausado" component="handler4" imagem="${icon}" titulo="Tutorial:Trabalho Pausado" retornar="retornar">
	<jsp:attribute name="texto">
		<div class="well" align="left">
	 		<p>Agora voc� est� em seu momento de pausa do expediente, aproveite para tomar seu caf� e esticar as pernas.</p>
	 		<p>Quando voltar, pressione o bot�o 'Retorno ao Trabalho' para retomar o servi�o.</p>
	 	</div>
	</jsp:attribute>
</sc:popup>

<sc:alert identificador="alertParteA" align="left" tipo="label-green" texto="Clique no bot�o abaixo para iniciar um dia de trabalho" titulo="Tutorial - Parte 1"/>
<div align="center">
	<sc:popover identificador="btnTrabalho" position="right" value="Iniciar Trabalho" classe="btn btn-primary btn-large span12" titulo="Dica" texto="Clicando neste bot�o voc� estar� iniciando o seu dia de trabalho..."/>
</div>
<br/>


<script>
$(document).ready(function()
{
	init();
});

function init()
{
	//Altera o texto dos bot�es de voltar dos popups
	getElemento('btnVoltar_popupTutorial').html('<b>Iniciar</b>');
	getElemento('btnVoltar_popupIniciarTrabalho').html('<b>Continuar</b>');
	getElemento('btnVoltar_popupPausarTrabalho').html('<b>Continuar</b>');
	getElemento('btnVoltar_popupTrabalhoPausado').html('<b>Ok</b>');
	
	//Ativa o handler do primeiro popup
	getElemento('handler1').click();
	
	//Evento do bot�o
	getElemento('btnTrabalho').on('click',btnIniciarTrabalho_Click);
}

function btnIniciarTrabalho_Click(){
	//Livra evento anterior
	getElemento('btnTrabalho').on('click',null);
	
	//Ativa o handler do segundo popup
	getElemento('handler2').click();
	
	//Apresenta a hora no div lateral esquerdo
	var currentdate = new Date(); 
	var data =  currentdate.getDate() + "/"
	            + (currentdate.getMonth()+1)  + "/" 
	            + currentdate.getFullYear() + " "  
	            + currentdate.getHours() + ":"  
	            + currentdate.getMinutes() + ":" 
	            + currentdate.getSeconds();
	getElemento('divInfoHora').html('<br/><b>Trabalho Iniciado: '+data+'</b><br/><br/><br/><br/>');
	
	//Evento do bot�o
	getElemento('btnTrabalho').on('click',btnPausarTrabalho_Click);
	
	//Ao esconder o segundo popup ativa o handler do terceiro popup
	getElemento('popupIniciarTrabalho').on('hide',function(){
		getElemento('handler3').click();
		getElemento('btnTrabalho').text('Pausar Trabalho');
		getElemento('btnTrabalho').attr('data-content','Ao clicar neste bot�o, voc� pausar� o seu expediente...');
	});
}

function btnPausarTrabalho_Click(){
	//Livra o evento do popup anterior
	getElemento('popupIniciarTrabalho').on('hide',null);
	
	//Ativa o handler do quarto popup
	getElemento('handler4').click();
	
	//Apresenta a hora no div lateral esquerdo
	var currentdate = new Date(); 
	var data =  currentdate.getDate() + "/"
	            + (currentdate.getMonth()+1)  + "/" 
	            + currentdate.getFullYear() + " "  
	            + currentdate.getHours() + ":"  
	            + currentdate.getMinutes() + ":" 
	            + currentdate.getSeconds();
	getElemento('divInfoHora').html('<br/><b>Trabalho Pausado: '+data+'</b><br/><br/><br/><br/>');
	
	//Evento do bot�o
	getElemento('btnTrabalho').on('click',btnRetornoTrabalho_Click);
	
	//Ao esconder o terceiro popup ativa o handler do quarto popup
// 	getElemento('popupTrabalhoPausado').on('hide',function(){
// 		getElemento('handler5').click();
// 		getElemento('btnTrabalho').text('Retorno Trabalho');
// 		getElemento('btnTrabalho').attr('data-content','Ao clicar neste bot�o, voc� retomar� o seu expediente...');
// 	});
}

function btnRetornoTrabalho_Click(){
	
}
</script>

<jsp:include page="/resources/html/footer.jsp"/>