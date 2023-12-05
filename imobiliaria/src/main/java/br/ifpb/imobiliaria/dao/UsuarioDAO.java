package br.ifpb.imobiliaria.dao;

import br.ifpb.imobiliaria.model.Usuario;
import br.ifpb.imobiliaria.util.JPAUtil;
import jakarta.persistence.*;

import java.util.List;

public class UsuarioDAO  {

    private final EntityManager em;

    public UsuarioDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    public Boolean cadastrarUsuario(Usuario usuario) {

        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
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

    public Usuario autenticarUsuario(String email, String senha) {
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);

            List<Usuario> usuarios = query.getResultList();

            return usuarios.isEmpty() ? null : usuarios.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        List<Usuario> usuarios = listarTodos();

        if (usuarios != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Lista de Usuários:\n");

            for (Usuario usuario : usuarios) {
                stringBuilder.append(usuario.toString()).append("\n");
            }

            return stringBuilder.toString();
        } else {
            return "Falha ao listar usuários";
        }
    }
}
