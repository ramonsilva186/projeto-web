<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Usuário</title>
    <link rel="stylesheet" type="text/css" href="css/cadastro.css">
</head>
<body>
<h2>Cadastro de Usuário</h2>
<form action="CadastroServlet" method="post">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required><br>

    <label for="email">E-mail:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="telefone">Telefone:</label>
    <input type="tel" id="telefone" name="telefone" required><br>

    <label for="cpf">CPF:</label>
    <input type="text" id="cpf" name="cpf" required><br>

    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha" required><br>

    <input type="submit" value="Cadastrar">
</form>
</body>
</html>
