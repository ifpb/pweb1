<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h1>Lista de Livros</h1>
	<c:forEach items="${livros}" var="livro">
		<ul>
			<li><strong>${livro.titulo}</strong></li>
			<li>Autor: ${livro.autor}</li>
			<li>ISBN: ${livro.isbn}</li>
			<li>Descrição: ${livro.descricao}</li>
		</ul>
	</c:forEach>

</body>
</html>
