/**
 * validação de formulário Atividade contextualizada
 */
function validar(){
	//alert("olá mundo kkk")
	
	let nome = frmContato.nome.value
	let descricao = frmContato.descricao.value
	let preco = frmContato.preco.value
	if (nome ===""){
		alert("Preencha o campo nome")
		frmContato.nome.focus()
		return false
		}else if(preco ===""){
			alert("prencha o campo preço")
			frmContato.preco.focus()
			return false
			}else { 
				document.forms["frmContato"].submit()
		           }
		
	}//fim da função
	

