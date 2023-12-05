<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Pacientes</title>
    <link rel="stylesheet" type="text/css" >


</head>
<body>
<h1>Lista de Paciente</h1>
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
</body>
</html>
