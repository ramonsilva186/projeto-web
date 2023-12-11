<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Anúncios</title>
    <link rel="stylesheet" type="text/css" href="css/anuncio.css">
    <!-- Inclua esses scripts no cabeçalho da sua página -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



</head>
<body>
<h1>Anúncios</h1>

<c:set var="anuncios" value="${requestScope.listaAnuncios}"/>

<c:forEach var="anuncio" items="${anuncios}">
    <div class="anuncio">
        <h2>${anuncio.titulo}</h2>
        <p>${anuncio.descricao}</p>
        <p>Anunciado por: ${anuncio.usuario.nome}</p>
        <p>Data do anúncio: ${anuncio.anunciadoEm}</p>

        <!-- Carrossel do Bootstrap -->
        <div id="carouselExample${anuncio.idAnuncio}" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <c:forEach var="foto" items="${anuncio.fotos}" varStatus="loop">
                    <div class="carousel-item ${loop.index == 0 ? 'active' : ''}">
                        <img src="<c:url value='${foto}'/>" class="d-block w-100" alt="Foto do Anúncio">
                    </div>
                </c:forEach>
            </div>
            <a class="carousel-control-prev" href="#carouselExample${anuncio.idAnuncio}" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Anterior</span>
            </a>
            <a class="carousel-control-next" href="#carouselExample${anuncio.idAnuncio}" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Próximo</span>
            </a>
        </div>

        <!-- Adicione mais informações do anúncio conforme necessário -->
    </div>
</c:forEach>

<a class="link" href="cadastroAnuncio.jsp">Cadastrar Novo Anúncio</a>
<br>
<a class="link" href="homeAdm.jsp">Voltar</a>
</body>
</html>
