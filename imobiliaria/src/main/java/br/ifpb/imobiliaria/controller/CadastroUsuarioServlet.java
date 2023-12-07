package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.UsuarioDAO;
import br.ifpb.imobiliaria.model.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/CadastroServlet")
public class CadastroUsuarioServlet extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Cadastro de usuario");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");

        Usuario user = new Usuario();
        user.setNome(nome);
        user.setEmail(email);
        user.setTelefone(telefone);
        user.setCpf(cpf);
        user.setSenha(senha);

        if (!usuarioDAO.cadastrarUsuario(user)){
            resp.sendError(422, "Erro ao cadastrar usuario");
        }else{
            resp.sendRedirect("listarUsuarios");
        }
    }
}
