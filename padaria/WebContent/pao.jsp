<%@ page language="java" contentType="text/html; charset= utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.JavaBeans"%>
     <%@ page import="java.util.ArrayList"%>
    <%
    	ArrayList<JavaBeans>lista= (ArrayList<JavaBeans>)
    	request.getAttribute("contatos");
 	// teste
 		for (int i = 0; i < lista.size(); i++) {
 			out.println(lista.get(i).getIdcon());
 			out.println(lista.get(i).getNome());
 			out.println(lista.get(i).getDescricao());
 			out.println(lista.get(i).getPreco());			
 			
 		} // fim do for	
    
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
	<h1>Pão Cadastro e Preços</h1>
	<a href="novo.html" class="Botao1"> Cadastro e Preço </a>
</body>
</html>