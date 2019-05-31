<%@ page import="model.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Usuario usuario = null;
    if (request.getParameter("nome") != null) {
        usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setRg(request.getParameter("rg"));
    }
%>

<html>
<head>
    <title>Exemplo com Scriptlets</title>
    <style>

        label {
            width: 200px;
            text-align: right;
            float: left;
            clear: left;
        }
        input {
            float: left;
            margin-left: 5px;
            width: 300px;
        }
        button {
            clear: left;
            display: block;
        }
    </style>
</head>
<body>
    <form method="post" action="scripts.jsp">
        <label>Nome: </label>
        <input type="text" name="nome" />
        <label>E-mail: </label>
        <input type="text" name="email" />
        <label>CPF: </label>
        <input type="text" name="cpf" />
        <label>RG: </label>
        <input type="text" name="rg" />
        <button type="submit">Enviar</button>
    </form>

    <%if (usuario != null) { %>

        <dl>
            <dt>Nome</dt>
            <dd><%=usuario.getNome()%></dd>
            <dt>E-mail</dt>
            <dd><%=usuario.getEmail()%></dd>
            <dt>RG</dt>
            <dd><%=usuario.getRg()%></dd>
            <dt>CPF:</dt>
            <dd><%=usuario.getCpf()%></dd>
        </dl>

    <% } %>

</body>
</html>
