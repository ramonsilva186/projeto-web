<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" type="text/css" >

</head>
<body>
<h1>Lista de Usuarios</h1>
<table border="1">
    <c:set var="usuarios" value="${requestScope.listaUsuarios}"/>

    <c:choose>
        <c:when test="${not empty usuarios}">
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Telefone</th>
                <th>CPF</th>
            </tr>

            <c:forEach var="usr" items="${usuarios}">
                <tr>
                    <td>${usr.nome}</td>
                    <td>${usr.email}</td>
                    <td>${usr.telefone}</td>
                    <td>${usr.cpf}</td>
                    <td><a href="<c:url value="/atualizar-usuario?idUsuario=${usr.idUsuario}"/>">Editar</a></td>
                    <td><a href="<c:url value="/excluir-usuario?idUsuario=${usr.idUsuario}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h2>Nenhum usuario disponivel.</h2>
        </c:otherwise>
    </c:choose>

</table>
<br>
<a href="cadastro.jsp">Novo Usuario</a>
<a href="homeAdm.jsp">Voltar</a>
</body>
</html>
