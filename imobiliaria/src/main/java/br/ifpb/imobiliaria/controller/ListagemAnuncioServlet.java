package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.AnuncioDAO;
import br.ifpb.imobiliaria.enums.StatusAnuncio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/anuncios")
public class ListagemAnuncioServlet extends HttpServlet {

    private final AnuncioDAO anuncioDAO = new AnuncioDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var anuncios = anuncioDAO.listarTodos();
        anuncios = anuncios.stream().filter(anuncio -> anuncio.getStatus().equals(StatusAnuncio.ATIVO)).collect(Collectors.toList());
        req.setAttribute("listaAnuncios", anuncios);
        req.getRequestDispatcher("listagemAnuncios.jsp").forward(req, resp);
    }
}
