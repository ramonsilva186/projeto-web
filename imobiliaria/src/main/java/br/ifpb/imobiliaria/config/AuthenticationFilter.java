package br.ifpb.imobiliaria.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Método de inicialização do filtro
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Entrei no filtro");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        // Permitir acesso ao servlet de logout
        if (httpRequest.getRequestURI().endsWith("logout") || httpRequest.getRequestURI().endsWith("LoginServlet")) {
            chain.doFilter(request, response);
            return;
        }

        // Verificar se o usuário está autenticado
        boolean loggedIn = (session != null && session.getAttribute("usuario") != null);

        // Se o usuário não estiver autenticado, redirecione para a página de login
        if (!loggedIn && !httpRequest.getRequestURI().endsWith("login.jsp")) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            return;
        }

        // Continuar a cadeia de filtros se o usuário estiver autenticado ou acessando a página de login
        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {
        // Método de destruição do filtro
    }
}
