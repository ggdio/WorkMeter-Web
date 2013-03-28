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