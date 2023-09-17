package br.bosch.CadastroUsuario.Service;

import br.bosch.CadastroUsuario.DAO.EnderecoDAO;
import br.bosch.CadastroUsuario.DAO.UsuarioDAO;
import br.bosch.CadastroUsuario.Entity.Endereco;
import br.bosch.CadastroUsuario.Entity.Usuario;
import br.bosch.CadastroUsuario.Util.JPAUtil;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    Scanner scanner = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConverteDados converteDados = new ConverteDados();

    public void exibeMenu() throws IOException, InterruptedException {
        System.out.println("--- Cadastro de Usuário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.println(cadastrar(nome, cpf, email, converteDados.converteJsonParaEndereco(consumoAPI.obterDados(cep))).toString());
    }

    public static Usuario cadastrar(String nome, String cpf, String email, Endereco endereco) {
        Usuario usuario = new Usuario(nome, cpf, email, endereco);
        EntityManager entityManager = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);
        EnderecoDAO enderecoDAO = new EnderecoDAO(entityManager);

        entityManager.getTransaction().begin();
        enderecoDAO.cadastrar(endereco);
        usuarioDAO.cadastrar(usuario);

        entityManager.getTransaction().commit();
        entityManager.close();

        return usuario;
    }
}