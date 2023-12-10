package br.ifpb.imobiliaria.dao;

import br.ifpb.imobiliaria.model.Imovel;
import br.ifpb.imobiliaria.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ImovelDAO {

        private final EntityManager em;

        public ImovelDAO() {
            this.em = JPAUtil.getEntityManager();
        }

        public Boolean cadastrarImovel(Imovel imovel) {

            try {
                em.getTransaction().begin();
                em.persist(imovel);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive())
                    em.getTransaction().rollback();
                e.printStackTrace();
                return false;
            }
            return true;
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
                        "i.numeroSuites = :numeroSuites, i.numeroGaragem = :numeroGaragem, " +
                        "i.preco = :preco, i.status = :status, i.tipo = :tipo WHERE i.idImovel = :idImovel");

                query.setParameter("endereco", imovel.getEndereco());
                query.setParameter("numeroQuartos", imovel.getNumeroQuartos());
                query.setParameter("numeroBanheiros", imovel.getNumeroBanheiros());
                query.setParameter("numeroSuites", imovel.getNumeroSuites());
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
