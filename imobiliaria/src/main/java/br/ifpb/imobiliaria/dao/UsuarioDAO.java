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
            em.getTransaction().begin();
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            usuarios = query.getResultList();
            em.getTransaction().commit();
            em.clear();
        }catch (Exception e){
            e.printStackTrace();
        }

        return usuarios;
    }

    public boolean atualizar(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Query query = em.createQuery("UPDATE Usuario SET nome = :nome, email = :email, telefone = :telefone, cpf = :cpf WHERE idUsuario = :idUsuario");
            query.setParameter("nome", usuario.getNome());
            query.setParameter("email", usuario.getEmail());
            query.setParameter("telefone", usuario.getTelefone());
            query.setParameter("cpf", usuario.getCpf());
            query.setParameter("idUsuario", usuario.getIdUsuario());
            System.out.println("query: " + usuario + "\n");

            var linhasAftadas = query.executeUpdate();
            transaction.commit();
            em.clear();
            return linhasAftadas > 0;
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
            Usuario usuario = em.find(Usuario.class, id);

            if (usuario != null) {
                em.remove(usuario);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Usuario autenticarUsuario(String email, String senha) {
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class);
            System.out.println("Email: " + email);
            System.out.println("Senha: " + senha);
            query.setParameter("email", email);
            query.setParameter("senha", senha);

            List<Usuario> usuarios = query.getResultList();
            System.out.println(usuarios);

            return usuarios.isEmpty() ? null : usuarios.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public long countUsuarios() {
        try {
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(u) FROM Usuario u", Long.class);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
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
