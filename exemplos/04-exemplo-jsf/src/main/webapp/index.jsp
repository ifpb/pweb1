<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Olá mundo!</title>
</head>
<f:view>
<body>
	<h1>Olá, bem-vindo ao exemplo JSF</h1>
	<h:form>
		
		<h:panelGrid columns="3">
	
		<h:outputLabel value="Login: " />
		<h:inputText id="login" required="true" requiredMessage="Login obrigatório" />
		<h:message for="login" />
		
		<h:outputLabel value="Senha: " />
		<h:inputSecret id="senha" required="true" requiredMessage="Senha obrigatória" />
		<h:message for="senha"></h:message>
		
		<h:commandButton value="Enviar" />
		
		</h:panelGrid>
		
	</h:form>
</body>
</f:view>
</html>