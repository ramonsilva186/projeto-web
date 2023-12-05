package br.ifpb.imobiliaria.dao;

import br.ifpb.imobiliaria.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class UsuarioDAO  {

    private final EntityManager em;

    public UsuarioDAO() {
        this.em = JPAUtil.getEntityManager();
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
        Usuario usuario = null;

        try {
            usuario = em.find(Usuario.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return usuario;
    }

    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = null;
        
        try{
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            usuarios = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return usuarios;
    }

    public void atualizar(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            e.printStackTrace();
        }
    }

    public void excluir(Long id) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            e.printStackTrace();
        }
    }
}
