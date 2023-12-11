<%@ page import="br.ifpb.imobiliaria.enums.TipoImovel" %>
<%@ page import="br.ifpb.imobiliaria.enums.TipoAnuncio" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Anúncio</title>
    <script>
        // Função para formatar o valor monetário
        function formatarDinheiro(valor) {
            // Adapte esta lógica conforme necessário para a moeda do seu país
            return valor.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
        }

        // Função chamada quando o valor no campo é alterado
        function atualizarCampoDinheiro() {
            var campo = document.getElementById('valor');
            var valor = parseFloat(campo.value.replace(/[^\d.-]/g, '')) || 0; // Remover caracteres não numéricos

            campo.value = formatarDinheiro(valor);
        }
    </script>
</head>
<body>

<h2>O que voce esta anunciando ?</h2>

<form action="CadastroAnuncioServlet" method="post" enctype="multipart/form-data">

    <label for="titulo">Titulo:</label>
    <input type="text" id="titulo" name="titulo" required><br>

    <label for="descricao">Descrição*</label>
    <textarea id="descricao" name="descricao" required></textarea><br>

    <label for="tipoImovel">Tipo do Imovel</label>
    <select id="tipoImovel" name="tipoImovel">
        <% for (TipoImovel tipo : TipoImovel.values()) { %>
        <option value="<%= tipo.getValue() %>"><%= tipo.getValue() %></option>
        <% } %>
    </select><br>


    <label for="tipoAnuncio">Quer Vender ou Alugar?</label>
    <select id="tipoAnuncio" name="tipoAnuncio">
        <% for (TipoAnuncio tipo : TipoAnuncio.values()) { %>
        <option value="<%= tipo.getValue() %>"><%= tipo.getValue() %></option>
        <% } %>
    </select><br>

    <label for="numeroQuartos">Número de quartos</label>
    <input type="number" max="100" min="0" id="numeroQuartos" name="numeroQuartos" required><br>

    <label for="numeroBanheiros">Número de banheiros</label>
    <input type="number" max="100" min="0" id="numeroBanheiros" name="numeroBanheiros" required><br>

    <label for="area">Área (m²)</label>
    <input type="number" max="10000" min="0" id="area" name="area" required><br>

    <label for="numeroGaragem">Vagas na garagem</label>
    <input type="number" max="100" min="0" id="numeroGaragem" name="numeroGaragem" required><br>

    <label for="endereco">Endereço</label>
    <input type="text" max="100" min="0" id="endereco" name="endereco" required><br>

    <label for="fotos">Fotos:</label>
    <input type="file" multiple accept="image/*" id="fotos" name="fotos" required><br>

    <label for="preco">Preço (R$)</label>
    <input type="text" id="preco" name="preco" oninput="atualizarCampoDinheiro()" placeholder="Digite o valor">


<%--    fazer contato --%>



    <input type="submit" value="Cadastrar">
</form>

</body>
</html>
