package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.ImovelDAO;
import br.ifpb.imobiliaria.enums.StatusAnuncio;
import br.ifpb.imobiliaria.model.Imovel;
import br.ifpb.imobiliaria.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/CadastroAnuncioServlet")
public class CadastroAnuncioServlet extends HttpServlet {

    private final ImovelDAO imovelDAO = new ImovelDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastro de anuncio");
        Imovel imovel = imovelDAO.buscarPorId(Long.parseLong(req.getParameter("imovel")));
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");

        String[] fotos = req.getParameterValues("fotos");
        Date anunciadoEm = new Date();
        StatusAnuncio status = StatusAnuncio.valueOf(req.getParameter("status"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Imovel> listaImoveis = imovelDAO.listarTodos();

        req.setAttribute("listaImoveis", listaImoveis);

        req.getRequestDispatcher("cadastroAnuncio.jsp").forward(req, resp);
    }
}
