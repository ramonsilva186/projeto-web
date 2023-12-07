<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Imovel</title>
    <link rel="stylesheet" type="text/css" >

</head>
<body>
<h1>Editar Imovel</h1>

<c:choose>
    <c:when test="${not empty imoveis}">
        <form action="atualizar-imovel" method="post">
            <input type="hidden" name="idImovel" value="${imoveis.idImovel}">

            <label for="endereco">Endereco:</label>
            <input type="text" id="endereco" name="endereco" value="${imoveis.endereco}" required><br>

            <label for="numeroQuartos">Num. Quartos:</label>
            <input type="number" id="numeroQuartos" name="numeroQuartos" value="${imoveis.numeroQuartos}" required><br>

            <label for="numeroBanheiros">Num. Banheiros:</label>
            <input type="number" id="numeroBanheiros" name="numeroBanheiros" value="${imoveis.numeroBanheiros}" required><br>

            <label for="numeroSuites">Num. Suites:</label>
            <input type="number" id="numeroSuites" name="numeroSuites" value="${imoveis.numeroSuites}" required><br>

            <label for="numeroGaragem">Num. Garagens:</label>
            <input type="number" id="numeroGaragem" name="numeroGaragem" value="${imoveis.numeroGaragem}" required><br>

            <label for="preco">Preco:</label>
            <input type="number" id="preco" name="preco" value="${imoveis.preco}" required><br>


            <button type="submit">Atualizar</button>
        </form>
    </c:when>
    <c:otherwise>
        <h2>Imovel não encontrado.</h2>
    </c:otherwise>
</c:choose>

<br>
<a href="ListagemImovelServlet">Voltar para a Lista de Usuários</a>
</body>
</html>
