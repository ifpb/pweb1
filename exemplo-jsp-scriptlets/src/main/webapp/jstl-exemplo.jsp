<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <c:import url="topo.jsp">
        <c:param name="nomedosite" value="Meu site JSTL" />
    </c:import>
</header>
<main>
    <c:set scope="page" var="turma" value="${param.turma}" />
    <h2>Conteúdo Principal</h2>
    <ul>
    <c:forEach begin="1" end="10" var="i">
        <li>${i}</li>
    </c:forEach>
    </ul>

    <c:if test="${turma == 'pweb1'}">
        <h3>Olá, turma de PWEB1</h3>
    </c:if>
    <c:if test="${turma != 'pweb1'}">
        <h3>Olá, outra turma</h3>
    </c:if>

    <ul>
    <c:forEach var="pais" items="${paises}">
        <li>${pais}</li>
        <c:choose>
            <c:when test="${pais == 'Brasil'}">
                Samba
            </c:when>
            <c:when test="${pais == 'Argentina'}">
                Tango
            </c:when>
            <c:when test="${pais == 'Itália'}">
                Pizza
            </c:when>
            <c:otherwise>
                Cerveja
            </c:otherwise>
        </c:choose>
    </c:forEach>
    </ul>

    <c:set var="usuario" scope="session" value="Diego" />

</main>
</body>
</html>
