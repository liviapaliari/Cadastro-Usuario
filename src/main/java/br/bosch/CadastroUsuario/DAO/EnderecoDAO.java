package br.bosch.CadastroUsuario.DAO;

import br.bosch.CadastroUsuario.Entity.Endereco;
import javax.persistence.EntityManager;

public class EnderecoDAO {
    private EntityManager entityManager;

    // MÉTODO CONSTRUTOR
    public EnderecoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // MÉTODO QUE CADASTRA NO BANCO
    public void cadastrar(Endereco endereco) {
        this.entityManager.persist(endereco);
    }
}