package br.ifpb.imobiliaria.controller;

import br.ifpb.imobiliaria.dao.AnuncioDAO;
import br.ifpb.imobiliaria.dao.ImovelDAO;
import br.ifpb.imobiliaria.enums.StatusAnuncio;
import br.ifpb.imobiliaria.enums.StatusImovel;
import br.ifpb.imobiliaria.enums.TipoAnuncio;
import br.ifpb.imobiliaria.enums.TipoImovel;
import br.ifpb.imobiliaria.model.Anuncio;
import br.ifpb.imobiliaria.model.Imovel;
import br.ifpb.imobiliaria.model.Usuario;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;

@WebServlet("/CadastroAnuncioServlet")
@MultipartConfig
public class CadastroAnuncioServlet extends HttpServlet {

    private final ImovelDAO imovelDAO = new ImovelDAO();

    private final AnuncioDAO anuncioDAO = new AnuncioDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastro de anuncio");

        String titulo = req.getParameter("titulo");
        String descricao = req.getParameter("descricao");

        TipoImovel tipoImovel = TipoImovel.valueOf(req.getParameter("tipoImovel"));
        TipoAnuncio tipoAnuncio = TipoAnuncio.valueOf(req.getParameter("tipoAnuncio"));
        Integer numeroQuartos = Integer.parseInt(req.getParameter("numeroQuartos"));
        Integer numeroBanheiros = Integer.parseInt(req.getParameter("numeroBanheiros"));
        Double area = Double.parseDouble(req.getParameter("area"));
        Integer numeroGaragem = Integer.parseInt(req.getParameter("numeroGaragem"));
        Double preco = Double.parseDouble(req.getParameter("preco"));
        String endereco = req.getParameter("endereco");

        List<InputStream> fotos = new ArrayList<>();

        Collection<Part> parts = req.getParts();

        for (Part part : parts) {
            if (part.getName().equals("fotos") && part.getContentType() != null) {
                InputStream inputStream = part.getInputStream();
                fotos.add(inputStream);
            }
        }

        Imovel imovelCadastrado = imovelDAO.cadastrarImovel(Imovel.builder()
                        .tipo(tipoImovel)
                        .area(area)
                        .numeroGaragem(numeroGaragem)
                        .endereco(endereco)
                        .status(StatusImovel.DISPONIVEL)
                        .preco(preco)
                        .numeroQuartos(numeroQuartos)
                        .numeroBanheiros(numeroBanheiros)
                .build());

        Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("usuario");

        if ( Objects.nonNull(imovelCadastrado) && Objects.nonNull(usuarioLogado)) {
            try {

                ServletContext servletContext = req.getServletContext();
                String realPath = servletContext.getRealPath("/WEB-INF/images/");  // Ajuste conforme a estrutura do seu projeto

                List<String> fotosSalvas = imovelDAO.salvarFotos(imovelCadastrado.getIdImovel(), fotos, realPath);

                Anuncio anuncio = Anuncio.builder()
                        .imovel(imovelCadastrado)
                        .usuario(usuarioLogado)
                        .anunciadoEm(java.sql.Date.valueOf(LocalDate.now()))
                        .descricao(descricao)
                        .titulo(titulo)
                        .tipo(tipoAnuncio)
                        .fotos(fotosSalvas)
                        .status(StatusAnuncio.ATIVO)
                            .build();

                anuncioDAO.cadastrarAnuncio(anuncio);
            }catch (Exception ex){
                ex.printStackTrace();
                resp.sendError(500, "erro ao publicar anuncio");
            }
        }else{
            resp.sendError(500, "erro ao publicar anuncio");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Imovel> listaImoveis = imovelDAO.listarTodos();

        req.setAttribute("listaImoveis", listaImoveis);

        req.getRequestDispatcher("cadastroAnuncio.jsp").forward(req, resp);
    }
}
