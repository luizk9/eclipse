<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Pão amigo e Cia here</title>
		<link rel="icon" href="imagens/p3.png">
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<h1>Editar novo Cadastro</h1>
		<form name="frmContato" action="update">
			<table>
				<tr>
					<td><input type="text" name="idcon" id="caixa3" readonly
						value="<%out.print(request.getAttribute("idcon"));%>"></td>
				</tr>
		
				<tr>
					<td><input type="text" name="nome" class="Caixa1"
						value="<%out.print(request.getAttribute("nome"));%>"></td>
				</tr>
				<tr>
					<td><input type="text" name="descricao" class="Caixa1"
						value="<%out.print(request.getAttribute("descricao"));%>"></td>
				</tr>
				<tr>
					<td><input type="text" name="preco" class="Caixa2"
						value="<%out.print(request.getAttribute("preco"));%>"></td>
				</tr>
		
			</table>
		   <input type="button" value="Salvar" class="Botao1" onclick="validar()">
		</form>
			<script src="scripts/validador.js"></script>
			<div class="img1">
				<img src="imagens/hferro.gif">
			</div>
	</body>
</html>