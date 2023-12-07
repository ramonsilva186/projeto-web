package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.ImovelDAO;
import br.ifpb.imobiliaria.model.Imovel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/atualizar-imovel")
public class AtualizarImovelServlet extends HttpServlet {

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

        Imovel imv = new Imovel();
        imv.setEndereco(endereco);
        imv.setNumeroQuartos(numeroQuartos);
        imv.setNumeroBanheiros(numeroBanheiros);
        imv.setNumeroSuites(numeroSuites);
        imv.setNumeroGaragem(numeroGaragem);
        imv.setPreco(preco);
        imv.setIdImovel(Long.parseLong(req.getParameter("idImovel")));

        if (!imovelDAO.atualizar(imv)) {
            resp.sendError(422, "Erro ao atualizar imovel");
        } else {
            resp.sendRedirect("listarImoveis");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idImovel = req.getParameter("idImovel");
        Imovel imv = imovelDAO.buscarPorId(Long.parseLong(idImovel));

        if (imv != null) {
            req.setAttribute("imovel", imv);
            req.getRequestDispatcher("editarImovel.jsp").forward(req, resp);
        } else {
            resp.sendError(404, "Imovel não encontrado");
        }
    }
}
