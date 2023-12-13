<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Imobiliária</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>

<header>
    <div id="logo">
        <h1>Imobiliária</h1>
    </div>
    <nav>
        <a href="quemSomos.jsp">Quem Somos</a>
        <a href="anuncios">Anúncios</a>
        <a href="listarUsuarios">Usuarios</a>
        <a href="contato.jsp">Contato</a>
        <a href="logout">Logout</a>
    </nav>
</header>

<section>
    <div class="imagem-container">
        <div>
            <h2>Bem-vindo à Imobiliária</h2>
            <p>Sua fonte confiável para encontrar a casa dos seus sonhos.</p>
        </div>
    </div>
</section>

<section id="quem-somos">
    <h2>Quem Somos</h2>
    <p>Texto explicativo sobre a sua empresa.</p>
    <button onclick="window.location.href='quemSomos.jsp'">Saiba Mais</button>
</section>

<section id="servicos">
    <h2>Nossos Serviços</h2>
    <p>Descrição dos serviços que você oferece.</p>
    <button onclick="window.location.href='anuncios'">Veja Mais</button>
</section>

<section id="contato">
    <h2>Entre em Contato</h2
    <p>Informações de contato e formulário de contato.</p><br>
    <button onclick="window.location.href='contato.jsp'">Fale Conosco</button>
</section>


<footer>
    <p>&copy; 2023 Imobiliária. Todos os direitos reservados.</p>
</footer>

</body>
</html>
