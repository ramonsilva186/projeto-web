package br.ifpb.imobiliaria.dao;

import br.ifpb.imobiliaria.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class UsuarioDAO {
    private EntityManagerFactory entityManagerFactory;

    public UsuarioDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("imobiliaria");
    }

    public void salvar(Usuario usuario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Usuario buscaPorId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Usuario usuario = null;

        try {
            usuario = entityManager.find(Usuario.class, id);
        } finally {
            entityManager.close();
        }

        return usuario;
    }

    public List<Usuario> listarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Usuario> usuarios = null;

        return usuarios;
    }

    public void atualizar(Usuario usuario) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void excluir(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Usuario usuario = entityManager.find(Usuario.class, id);
            if (usuario != null) {
                entityManager.remove(usuario);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
