<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Inicial</title>
</head>
<body>
<h1>Olá, bem-vindo ao exemplo do funcionamento de Sessões HTTP</h1>
<p>Você está logado com o usuário ${sessionScope.usuarioLogado}</p>
<p><a href="logout">Clique aqui</a> para encerrar sua sessão</p>
</body>
</html>