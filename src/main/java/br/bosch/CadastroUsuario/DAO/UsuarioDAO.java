package br.bosch.CadastroUsuario.DAO;

import br.bosch.CadastroUsuario.Entity.Usuario;
import javax.persistence.EntityManager;

public class UsuarioDAO {
    private EntityManager entityManager;

    // MÉTODO CONSTRUTOR
    public UsuarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // MÉTODO QUE CADASTRA NO BANCO
    public void cadastrar(Usuario usuario) {
        this.entityManager.persist(usuario);
    }
}