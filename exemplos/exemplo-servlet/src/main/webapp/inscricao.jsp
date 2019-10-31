<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Inscrição</title>

<style type="text/css">

	form {
		font: 18px 'Arial';
		padding: 15px;
		border: 1px solid #000;
		background: #448844;
		color: #fff;
		float: left;
	}

	label, button {
		clear: left;
		float: left;
		padding: 5px;
	}
	
	input, select {
		float: left;
		padding: 5px;
	}

</style>

</head>
<body>
	
	<form method="post" action="inscricao">
	
		<label>Nome: </label>
		<input type="text" name="nome" />
		
		<label>E-mail:</label>
		<input type="email" name="email" />
		
		
		<label>Estado: </label>
		<select name="estado">
			<option value="PB">Paraíba</option>
			<option value="RN">Rio Grande do Norte</option>
			<option value="CE">Ceará</option>
			<option value="PE">Pernambuco</option>
		</select>
		
		<button type="submit">Enviar</button>
	
	</form>

</body>
</html>