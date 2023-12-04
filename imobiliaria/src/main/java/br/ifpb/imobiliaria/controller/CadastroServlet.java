package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.IOException;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chegueiiiii mona");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");

        Usuario user = new Usuario();
        user.setNome(nome);
        user.setCpf(cpf);
        user.setEmail(email);
        user.setSenha(senha);
        user.setTelefone(telefone);

        em.persist(user);

        resp.getWriter().println("Cadastrado com sucesso!");
    }
}
