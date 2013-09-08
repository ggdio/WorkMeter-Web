/***************************
 * @author Guilherme Dio   *
 * @since 1.0              *
 ***************************/

var CONSTANTE_TAMANHO = 50;
var ALTURA_JANELA = window.innerHeight;
var LARGURA_JANELA = window.innerWidth;

/*
 * Centraliza um elemento verticalmente na tela
 * @author Guilherme Dio
 */
function centralizarVertical(elemento)
{
	componente = getElemento(elemento);
    var posicao = Math.ceil((ALTURA_JANELA/2) - (componente.height()/2));
    posicao -= CONSTANTE_TAMANHO;
    componente.css('margin-top', posicao + 'px');
}

/**
 * Recupera um elemento no documento HTML
 * @param id - Identificador do elemento
 * @returns Um elemento html
 */
function getElemento(id)
{
	return $('#'+id);
}

var MasterController = (function(){
	this.sistema = "workmeter";
	this.versao = "1.0.0";
	this.desenvolvedor = "guilherme";
});

/**
 * Realiza a troca de html de uma tag especifica dentro de uma tag pai
 * @param elementoPai - Tag pai
 * @param elementoEspecifico -  Tag filha especifica
 * @param html - Novo html a ser inserido
 */
function trocarTextoInterno(elementoPai,elementoEspecifico,html)
{
	elemento = getElemento(elementoPai);
	$(elementoEspecifico, elemento).empty().remove();
	elemento.append(html);
}

/**
 * Habilita a visibilidade do elemento especifico
 * @param id - Identificador do elemento
 */
function exibirElemento(id)
{
	elemento = getElemento(id);
	elemento.show();
}

/**
 * Desabilita a visibilidade do elemento especifico
 * @param id - Identificador do elemento
 */
function esconderElemento(id)
{
	elemento = getElemento(id);
	elemento.hide();
}

/**
 * Altera o foco para o elemento específico
 * @param id - Identificador do elemento
 */
function focarElemento(id)
{
	elemento = getElemento(id);
	elemento.focus();
}

/**
 * Habilita a visibilidade do elemento especifico
 * Altera o foco para o elemento específico
 * @param id - Identificador do elemento
 */
function exibirEFocarElemento(id)
{
	exibirElemento(id);
	focarElemento(id);
}

/**
 * Deserializa Json retornado em ajax
 * @param ajaxResponse - O response vindo no ajax
 * @returns Objeto com os dados
 */
function parseJson(ajaxResponse){
	return $.parseJSON(ajaxResponse.responseText).response;
}