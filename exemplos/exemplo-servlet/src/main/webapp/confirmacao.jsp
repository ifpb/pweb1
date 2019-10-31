<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmação da inscrição</title>
<style type="text/css">
	dl, dt, dd {
		float: left;
		padding: 5px;
	}
	dt {
		clear: left;
	}
	dl {
		background: #c0c0c0;
	}
</style>
</head>
<body>
	<h1>Parabéns! Sua inscrição foi feita com sucesso!</h1>
	<h2>Confira os seus dados:</h2>
	<dl>
		<dt>Nome:</dt>
		<dd>${participante.nome}</dd>
		<dt>E-mail:</dt>
		<dd>${participante.email}</dd>
		<dt>Estado:</dt>
		<dd>${participante.estado}</dd>
	</dl>
</body>
</html>