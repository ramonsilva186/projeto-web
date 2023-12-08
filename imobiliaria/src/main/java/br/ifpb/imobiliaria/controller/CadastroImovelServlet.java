package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.ImovelDAO;
import br.ifpb.imobiliaria.enums.StatusImovel;
import br.ifpb.imobiliaria.enums.TipoImovel;
import br.ifpb.imobiliaria.model.Imovel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/CadastroImovelServlet")
public class CadastroImovelServlet extends HttpServlet {

    private final ImovelDAO imovelDAO = new ImovelDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastro de imovel");
        String endereco = req.getParameter("endereco");
        Integer numeroQuartos = Integer.parseInt(req.getParameter("numeroQuartos"));
        Integer numeroBanheiros = Integer.parseInt(req.getParameter("numeroBanheiros"));
        Integer numeroSuites = Integer.parseInt(req.getParameter("numeroSuites"));
        Integer numeroGaragem = Integer.parseInt(req.getParameter("numeroGaragem"));
        Double preco = Double.parseDouble(req.getParameter("preco"));
        String status = req.getParameter("status");
        String tipo = req.getParameter("tipo");

        Imovel imovel = new Imovel();
        imovel.setEndereco(endereco);
        imovel.setNumeroQuartos(numeroQuartos);
        imovel.setNumeroBanheiros(numeroBanheiros);
        imovel.setNumeroSuites(numeroSuites);
        imovel.setNumeroGaragem(numeroGaragem);
        imovel.setPreco(preco);
        imovel.setStatus(StatusImovel.valueOf(status));
        imovel.setTipo(TipoImovel.valueOf(tipo));

        if (!imovelDAO.cadastrarImovel(imovel)) {
            resp.sendError(422, "Erro ao cadastrar imovel");
        } else {
            resp.sendRedirect("listarImoveis");
        }

    }
}
