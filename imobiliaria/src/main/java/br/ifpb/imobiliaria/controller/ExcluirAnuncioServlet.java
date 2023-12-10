package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.AnuncioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/excluir-anuncio")
public class ExcluirAnuncioServlet extends HttpServlet {

    private final AnuncioDAO anuncioDAO = new AnuncioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idAnuncio = Long.parseLong(req.getParameter("idAnuncio"));

        anuncioDAO.excluir(idAnuncio);
        resp.sendRedirect("listarAnuncios");
    }
}
