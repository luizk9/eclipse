/**
 * confirmação de exclusão de informação
 */

function confirmar(idcon){
	let resposta = confirm("Confirme a exlusão deste contato?")
	if(resposta===true){
		// alert(idcon)
		// js encaminha ao servillet este documento
		window.location.href="delete?idcon=" + idcon
		// observar que href esta levando o delete a pagina do id
		// usado p redirecionar leva para outro local definido pelo delete
		// parametro atribui o contato
	}
}