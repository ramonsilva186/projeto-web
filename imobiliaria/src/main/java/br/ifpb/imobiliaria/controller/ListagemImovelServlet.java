package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.ImovelDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/listarImoveis")
public class ListagemImovelServlet extends HttpServlet {

    private final ImovelDAO imovelDAO = new ImovelDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var imoveis = imovelDAO.listarTodos();
        System.out.println("listando imoveis: \n" + imoveis);

        req.setAttribute("listaImoveis", imoveis);
        req.getRequestDispatcher("listagemImoveis.jsp").forward(req, resp);

    }
}
