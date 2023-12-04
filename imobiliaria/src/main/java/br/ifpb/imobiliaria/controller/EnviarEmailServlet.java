package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.EmailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/EnviarEmailServlet")
public class EnviarEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String mensagem = request.getParameter("mensagem");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");

        String destinatario = "imobiliaria247@gmail.com";
        String assunto = "Novo contato:  " + email;
        String corpo = String.format("Contato\n" +
                "Nome: %s\n" +
                "Telefone: %s\n" +
                "E-mail: %s\n" +
                "\n\n\n" +
                "------------Mensagem----------\n" +
                "%s", nome, telefone, email, mensagem);

        EmailDAO emailDAO = new EmailDAO();
        emailDAO.enviarEmail(destinatario, assunto, corpo);

        response.getWriter().println("E-mail enviado com sucesso!");
        response.sendRedirect("confirmacao.jsp");
    }

}
