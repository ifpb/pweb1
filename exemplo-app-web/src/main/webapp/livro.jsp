<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h1>Dados de um Livros</h1>
<ul>
	<li>${livro.id}</li>
	<li>${livro.titulo}</li>
	<li>${livro.autor}</li>
	<li>${livro.isbn}</li>
</ul>
</body>
</html>
