package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.AnuncioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/listarAnuncios")
public class ListagemAnuncioServlet extends HttpServlet {

    private final AnuncioDAO anuncioDAO = new AnuncioDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var anuncios = anuncioDAO.listarTodos();
        System.out.println("listando anuncios: \n" + anuncios);

        req.setAttribute("listaAnuncios", anuncios);
        req.getRequestDispatcher("listagemAnuncios.jsp").forward(req, resp);
    }
}
