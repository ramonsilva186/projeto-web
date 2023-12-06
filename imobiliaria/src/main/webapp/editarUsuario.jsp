<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Usuário</title>
    <link rel="stylesheet" type="text/css" >

</head>
<body>
<h1>Editar Usuário</h1>

<c:choose>
    <c:when test="${not empty usuario}">
        <form action="atualizar-usuario" method="post">
            <input type="hidden" name="idUsuario" value="${usuario.idUsuario}">

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="${usuario.nome}" required><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${usuario.email}" required><br>

            <label for="telefone">Telefone:</label>
            <input type="tel" id="telefone" name="telefone" value="${usuario.telefone}" required><br>

            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" value="${usuario.cpf}" required><br>

            <button type="submit">Atualizar</button>
        </form>
    </c:when>
    <c:otherwise>
        <h2>Usuário não encontrado.</h2>
    </c:otherwise>
</c:choose>

<br>
<a href="ListagemUsuarioServlet">Voltar para a Lista de Usuários</a>
</body>
</html>
