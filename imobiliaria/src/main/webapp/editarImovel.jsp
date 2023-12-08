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
    <c:when test="${not empty imovel}">
        <form action="atualizar-imovel" method="post">
            <input type="hidden" name="idImovel" value="${imovel.idImovel}">

            <label for="endereco">Endereco:</label>
            <input type="text" id="endereco" name="endereco" value="${imovel.endereco}" required><br>

            <label for="numeroQuartos">Num. Quartos:</label>
            <input type="number" id="numeroQuartos" name="numeroQuartos" value="${imovel.numeroQuartos}" required><br>

            <label for="numeroBanheiros">Num. Banheiros:</label>
            <input type="number" id="numeroBanheiros" name="numeroBanheiros" value="${imovel.numeroBanheiros}" required><br>

            <label for="numeroSuites">Num. Suites:</label>
            <input type="number" id="numeroSuites" name="numeroSuites" value="${imovel.numeroSuites}" required><br>

            <label for="numeroGaragem">Num. Garagens:</label>
            <input type="number" id="numeroGaragem" name="numeroGaragem" value="${imovel.numeroGaragem}" required><br>

            <label for="preco">Preco:</label>
            <input type="number" id="preco" name="preco" value="${imovel.preco}" required><br>

            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="DISPONIVEL" ${imovel.status == 'DISPONIVEL' ? 'selected' : ''}>Disponivel</option>
                <option value="INDISPONIVEL" ${imovel.status == 'INDISPONIVEL' ? 'selected' : ''}>Indisponivel</option>
            </select><br>

            <label for="tipo">Tipo:</label>
            <select id="tipo" name="tipo" required>
                <option value="CASA" ${imovel.tipo == 'CASA' ? 'selected' : ''}>Casa</option>
                <option value="APARTAMENTO" ${imovel.tipo == 'APARTAMENTO' ? 'selected' : ''}>Apartamento</option>
                <option value="TERRENO" ${imovel.tipo == 'TERRENO' ? 'selected' : ''}>Terreno</option>
                <option value="COMERCIAL" ${imovel.tipo == 'COMERCIAL' ? 'selected' : ''}>Comercial</option>
            </select><br>


            <button type="submit">Atualizar</button>
        </form>
    </c:when>
    <c:otherwise>
        <h2>Imovel não encontrado.</h2>
    </c:otherwise>
</c:choose>

<br>
<a href="atualizar-imovel">Voltar para a Lista de Imovel</a>
</body>
</html>
