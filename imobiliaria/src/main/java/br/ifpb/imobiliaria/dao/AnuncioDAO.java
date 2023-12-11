package br.ifpb.imobiliaria.dao;

import br.ifpb.imobiliaria.enums.StatusAnuncio;
import br.ifpb.imobiliaria.model.Anuncio;
import br.ifpb.imobiliaria.model.Imovel;
import br.ifpb.imobiliaria.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

public class AnuncioDAO {

    private final EntityManager em;

    public AnuncioDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    public Boolean cadastrarAnuncio(Anuncio anuncio) {
        try {
            em.getTransaction().begin();
            em.persist(anuncio);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
        return true;

    }

    public Anuncio buscarPorId(Long id) {
        Anuncio anuncio = null;

        try {
            anuncio = em.find(Anuncio.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return anuncio;
    }

    public List<Anuncio> listarTodos() {
        List<Anuncio> anuncios = null;

        try {
            em.getTransaction().begin();
            anuncios = em.createQuery("SELECT DISTINCT a FROM Anuncio a LEFT JOIN FETCH a.fotos", Anuncio.class).getResultList();
            em.getTransaction().commit();
            em.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return anuncios;
    }

    public boolean atualizar(Anuncio anuncio) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    public void excluir(Long id) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Anuncio anuncio = em.find(Anuncio.class, id);
            if (anuncio != null) {
                em.createQuery("UPDATE Anuncio SET status = :status WHERE idAnuncio = :idAnuncio")
                        .setParameter("status", StatusAnuncio.INATIVO)
                        .setParameter("idAnuncio", id)
                        .executeUpdate();
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
