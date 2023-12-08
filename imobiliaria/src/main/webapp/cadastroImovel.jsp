<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Imóvel</title>
</head>
<body>

<h1>Cadastro de Imóvel</h1>

<form action="CadastroImovelServlet" method="post">
    <label for="endereco">Endereço:</label>
    <input type="text" id="endereco" name="endereco" required><br>

    <label for="numeroQuartos">Número de Quartos:</label>
    <input type="number" id="numeroQuartos" name="numeroQuartos" required><br>

    <label for="numeroBanheiros">Número de Banheiros:</label>
    <input type="number" id="numeroBanheiros" name="numeroBanheiros" required><br>

    <label for="numeroSuites">Número de Suítes:</label>
    <input type="number" id="numeroSuites" name="numeroSuites" required><br>

    <label for="numeroGaragem">Número de Garagens:</label>
    <input type="number" id="numeroGaragem" name="numeroGaragem" required><br>

    <label for="preco">Preço:</label>
    <input type="number" id="preco" name="preco" step="0.01" required><br>

    <label for="status">Status:</label>
    <select id="status" name="status">
        <option value="DISPONIVEL">Disponível</option>
        <option value="INDISPONIVEL">Indisponível</option>
    </select><br>

    <label for="tipo">Tipo:</label>
    <select id="tipo" name="tipo">
        <option value="CASA">Casa</option>
        <option value="APARTAMENTO">Apartamento</option>
        <option value="TERRENO">Terreno</option>
        <option value="COMERCIAL">Comercial</option>
    </select><br>

    <input type="submit" value="Cadastrar Imóvel">
</form>

</body>
</html>
