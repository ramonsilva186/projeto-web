package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/listarUsuarios")
public class ListagemUsuarioServlet extends HttpServlet {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtém a lista de usuários do banco de dados
        var usuarios = usuarioDAO.listarTodos();
        System.out.println("listando usuarios: \n" + usuarios);

        req.setAttribute("listaUsuarios", usuarios);
        req.getRequestDispatcher("listagemUsuarios.jsp").forward(req, resp);
    }


}
