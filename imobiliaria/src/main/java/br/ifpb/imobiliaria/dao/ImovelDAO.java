package br.ifpb.imobiliaria.dao;

import br.ifpb.imobiliaria.model.Imovel;
import br.ifpb.imobiliaria.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO {

    private final EntityManager em;

    public ImovelDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    public List<String> salvarFotos(Long anuncioId, List<InputStream> fotos) {

        String diretorioFotos = ("../webapps/imobiliaria/images/").concat(anuncioId.toString()).concat("/");

        File diretorio = new File(diretorioFotos);
        if (!diretorio.exists()) {
            if (!diretorio.mkdirs()) {
                System.out.println("Não foi possivel criar o directorio de fotos");
                throw new RuntimeException("Não foi possível criar o diretório de fotos.");
            }
        }

        List<String> caminhosFotos = new ArrayList<>();

        try {
            for (int i = 0; i < fotos.size(); i++) {
                String nomeArquivo = "foto_" + anuncioId + "_" + i + ".jpg";
                Path caminhoCompleto = Path.of(diretorioFotos, nomeArquivo);

                System.out.println(caminhoCompleto);

                // Copiar arquivo
                java.nio.file.Files.copy(fotos.get(i), caminhoCompleto, StandardCopyOption.REPLACE_EXISTING);

                // Adicionar caminho à lista
                caminhosFotos.add("/images/" + anuncioId + "/" + nomeArquivo);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar fotos.", e);
        } finally {
            // Fechar InputStreams
            fotos.forEach(inputStream -> {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // Tratar ou registrar a exceção, conforme necessário
                    e.printStackTrace();
                }
            });
        }

        return caminhosFotos;
    }


    public Imovel  cadastrarImovel(Imovel imovel) {

            try {
                em.getTransaction().begin();
                em.persist(imovel);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive())
                    em.getTransaction().rollback();
                e.printStackTrace();
                return null;
            }
            return imovel;
        }

        public Imovel buscarPorId(Long id) {
                Imovel imovel = null;

                try {
                    imovel = em.find(Imovel.class, id);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return imovel;
        }
        public List<Imovel> listarTodos() {
            List<Imovel> imoveis = null;

            try {
                    em.getTransaction().begin();
                    TypedQuery<Imovel> query = em.createQuery("SELECT i FROM Imovel i", Imovel.class);
                    imoveis = query.getResultList();
                    em.getTransaction().commit();
                    em.clear();
            } catch (Exception e) {
                    e.printStackTrace();
            }
            return imoveis;
        }

        public boolean atualizar(Imovel imovel) {
            EntityTransaction transaction = em.getTransaction();

            try {
                transaction.begin();
                Query query = em.createQuery("UPDATE Imovel i SET i.endereco = :endereco, " +
                        "i.numeroQuartos = :numeroQuartos, i.numeroBanheiros = :numeroBanheiros, " +
                       "i.numeroGaragem = :numeroGaragem, " +
                        "i.preco = :preco, i.status = :status, i.tipo = :tipo WHERE i.idImovel = :idImovel");

                query.setParameter("endereco", imovel.getEndereco());
                query.setParameter("numeroQuartos", imovel.getNumeroQuartos());
                query.setParameter("numeroBanheiros", imovel.getNumeroBanheiros());
                query.setParameter("numeroGaragem", imovel.getNumeroGaragem());
                query.setParameter("preco", imovel.getPreco());
                query.setParameter("status", imovel.getStatus());
                query.setParameter("tipo", imovel.getTipo());
                query.setParameter("idImovel", imovel.getIdImovel());

                System.out.println("query:" + imovel + "\n");

                var linhasAfetadas = query.executeUpdate();
                transaction.commit();
                em.clear();
                return linhasAfetadas > 0;
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
                return false;
            }
        }

        public void excluir(Long id) {
                EntityTransaction transaction = em.getTransaction();

                try {
                        transaction.begin();
                        Imovel imovel = em.find(Imovel.class, id);
                        if (imovel != null) {
                                em.remove(imovel);
                        }
                        transaction.commit();
                } catch (Exception e) {
                        if (transaction != null && transaction.isActive()) {
                                transaction.rollback();
                        }
                        e.printStackTrace();
                }

        }
}
