<%@ page language="java" contentType="text/html; charset= utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.JavaBeans"%>
     <%@ page import="java.util.ArrayList"%>
    <%
    	ArrayList<JavaBeans>lista= (ArrayList<JavaBeans>)
    	request.getAttribute("listarPao"); 	   
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Pão Amigo e Cia</title>
<link rel="icon" href="imagens/p3.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
		<div>	
			<h1>Pão Cadastro e Preços</h1> 
			<a href="novo.html" class="Botao1"> Novo Cadastro e Preço !!! </a> 
		</div>							
		<table id="tabela">
			<thead class="a">
				<tr>	<!-- cabeçalho da tabela -->					
					<th> Idcon</th>
					<th> Nome</th>
					<th> Descrição</th>
					<th> Preço R$</th>	
					<!-- 1- o botão editar da tabela -->	
					<th> Opção</th>	
								
				</tr>					
			</thead>			
			
				<% for(int i = 0; i < lista.size(); i++){ %>
					<tr>
						<td><%=lista.get(i).getIdcon()%></td>
						
						<td><%=lista.get(i).getNome()%></td>
						
						<td><%=lista.get(i).getDescricao()%></td>
						<!-- 2=colocando o botão EDITAR -->
						<td><%=lista.get(i).getPreco()%></td>
						<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="Botao">Editar</a></td>
					</tr>
				<% } %>
		</table>	
		<!-- imagem de brincadeira -->
	<img src="imagens/batman.gif" class ="img1"  align="right"  height="200">
</body>
</html>