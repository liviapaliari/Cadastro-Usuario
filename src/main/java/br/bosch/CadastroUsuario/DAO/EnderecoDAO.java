package br.bosch.CadastroUsuario.DAO;

import br.bosch.CadastroUsuario.Entity.Endereco;
import javax.persistence.EntityManager;
import java.util.List;

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

    public Endereco buscarPorId(int id) {
        return entityManager.find(Endereco.class, id);
    }

    public List<Endereco> buscarTodos() {
        // 'E' REPRESENTA UMA VARIÁVEL, 'Endereco' REPRESENTA A ENTIDADE NO JAVA
        String jpql = "SELECT e FROM Endereco e";
        return entityManager.createQuery(jpql, Endereco.class).getResultList();
    }
}