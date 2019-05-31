<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Lista de Usuários</h2>
<c:forEach items="${usuarios}" var="usuario">
    ${usuario.nome}
</c:forEach>
</body>
</html>
