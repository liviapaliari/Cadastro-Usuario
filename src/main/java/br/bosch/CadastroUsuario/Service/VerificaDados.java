package br.bosch.CadastroUsuario.Service;

import br.bosch.CadastroUsuario.DAO.EnderecoDAO;
import br.bosch.CadastroUsuario.Entity.Endereco;
import javax.persistence.EntityManager;
import java.util.List;

public class VerificaDados {
    public static int retornaEndereco(EntityManager entityManager, Endereco endereco) {
        EnderecoDAO enderecoDAO = new EnderecoDAO(entityManager);
        List<Endereco> enderecos = enderecoDAO.buscarTodos();

        for (Endereco e : enderecos) {
            System.out.printf("%d, %s, %s, %s, %s, %s\n", e.getId(), e.getCep(), e.getLogradouro(), e.getBairro(), e.getNumero(), e.getComplemento());

            if (e.getCep().equalsIgnoreCase(endereco.getCep()) &&
                    e.getNumero().equalsIgnoreCase(endereco.getNumero()) &&
                    e.getComplemento().equalsIgnoreCase(endereco.getComplemento())) {
                return e.getId();
            }
        }
        return -1;
    }

    public static String verificaTamanho(String informacao, int limite) {
        informacao = limpaCaracteresEspeciais(informacao);

        if (informacao.length() == limite && informacao.matches("\\d{" + limite + "}")) {
            return informacao;
        } else {
            throw new IllegalArgumentException("Caracteres inválidos.");
        }
    }

    public static String limpaCaracteresEspeciais(String informacao) {
        informacao = informacao.replace("-", "");
        informacao = informacao.replace(".", "");
        informacao = informacao.replace(" ", "");

        return informacao;
    }
}