package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.UsuarioDAO;
import br.ifpb.imobiliaria.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/atualizar-usuario")
public class AtualizarUsuarioServlet extends HttpServlet {

    private final UsuarioDAO service = new UsuarioDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastro de usuario");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");
        String cpf = req.getParameter("cpf");


        Usuario user = new Usuario();
        user.setNome(nome);
        user.setEmail(email);
        user.setTelefone(telefone);
        user.setCpf(cpf);
        user.setIdUsuario(Long.parseLong(req.getParameter("idUsuario")));

        if (!service.atualizar(user)){
            resp.sendError(422, "Erro ao atualizar usuario");
        }else{
            resp.sendRedirect("listarUsuarios");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idUsuario = req.getParameter("idUsuario");
        Usuario user = service.buscaPorId(Long.parseLong(idUsuario));
        if(user != null){
            req.setAttribute("usuario", user);
            req.getRequestDispatcher("editarUsuario.jsp").forward(req, resp);
        }
        else {
            resp.sendError(404, "Usuario não encontrado");
        }
    }
}
