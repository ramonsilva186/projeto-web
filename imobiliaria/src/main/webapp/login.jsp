<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<h2>Login</h2>
<form action="LoginServlet" method="post">
    <label for="email">E-mail:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha" required><br>

    <input type="submit" value="Entrar">

</form>

<a href="cadastro.jsp">Cadastre-se</a>
</body>
</html>
