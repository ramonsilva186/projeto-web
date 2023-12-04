package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.model.Usuario;
import br.ifpb.imobiliaria.util.JPAUtil;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chegueiiiii mona");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Usuario user = new Usuario();

            user.setNome(nome);
            user.setCpf(cpf);
            user.setEmail(email);
            user.setSenha(senha);
            user.setTelefone(telefone);

            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.close(em);
        }
        resp.getWriter().println("Cadastrado com sucesso!");
    }
}
