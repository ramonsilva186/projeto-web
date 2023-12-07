package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.ImovelDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/excluir-imovel")
public class ExcluirImovelServlet extends HttpServlet {

    private final ImovelDAO imovelDAO = new ImovelDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idImovel = Long.parseLong(req.getParameter("idImovel"));

        imovelDAO.excluir(idImovel);
        resp.sendRedirect("listarImoveis");
    }
}
