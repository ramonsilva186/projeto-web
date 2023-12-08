<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Imoveis</title>
    <link rel="stylesheet" type="text/css" >

</head>
<body>
<h1>Lista de Imoveis</h1>
<table border="1">
    <c:set var="imoveis" value="${requestScope.listaImoveis}"/>

    <c:choose>
        <c:when test="${not empty imoveis}">
            <tr>
                <th>Endereco</th>
                <th>Num. Quartos</th>
                <th>Num. Banheiros</th>
                <th>Num. Suites</th>
                <th>Num. Garagens</th>
                <th>Preco</th>
                <th>Status</th>
                <th>Tipo</th>
            </tr>

            <c:forEach var="imv" items="${imoveis}">
                <tr>
                    <td>${imv.endereco}</td>
                    <td>${imv.numeroQuartos}</td>
                    <td>${imv.numeroBanheiros}</td>
                    <td>${imv.numeroSuites}</td>
                    <td>${imv.numeroGaragem}</td>
                    <td>${imv.preco}</td>
                    <td>${imv.status}</td>
                    <td>${imv.tipo}</td>

                    <td><a href="<c:url value="/atualizar-imovel?idImovel=${imv.idImovel}"/>">Editar</a></td>
                    <td><a href="<c:url value="/excluir-imovel?idImovel=${imv.idImovel}"/>">Excluir</a></td>

                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h2>Nenhum imovel disponivel.</h2>
        </c:otherwise>
    </c:choose>

</table>
<br>
<a href="cadastroImovel.jsp">Novo Imovel</a>
</body>
</html>
