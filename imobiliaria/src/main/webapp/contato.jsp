<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contato - Imobiliária</title>
    <link rel="stylesheet" type="text/css" href="css/contato.css">
</head>
<body>

<header>
    <div id="logo">
        <h1>Imobiliária</h1>
    </div>
    <nav>
        <a href="index.jsp">Home</a>
        <a href="quemSomos.jsp">Quem Somos</a>
        <a href="anuncios.jsp">Anúncios</a>
        <a href="contato.jsp">Contato</a>
    </nav>
</header>

<section>
    <h2>Entre em Contato</h2>
    <form action="EnviarEmailServlet" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="email">E-mail:</label>
        <input type="email" id="email" name="email" required>

        <label for="mensagem">Mensagem:</label>
        <textarea id="mensagem" name="mensagem" rows="4" required></textarea>

        <button type="submit">Enviar</button>
    </form>
</section>

<footer>
    <p>&copy; 2023 Imobiliária. Todos os direitos reservados.</p>
</footer>

</body>
</html>
