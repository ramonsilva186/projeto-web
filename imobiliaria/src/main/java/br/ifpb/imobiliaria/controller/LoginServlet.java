package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.UsuarioDAO;
import br.ifpb.imobiliaria.model.Usuario;
import br.ifpb.imobiliaria.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        EntityManager em = JPAUtil.getEntityManager();

        try {
            Usuario usuario = usuarioDAO.autenticarUsuario(email, senha);

            if (usuario != null) {
                resp.getWriter().println("Usuário autenticado com sucesso!");
            } else {
                resp.getWriter().println("Usuário não encontrado!");
            }
        } finally {
            JPAUtil.close(em);
        }

    }
}
