package br.bosch.CadastroUsuario.Service;

import br.bosch.CadastroUsuario.DAO.UsuarioDAO;
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

        System.out.println(converteDados.converteJsonParaEndereco(consumoAPI.obterDados(cep)));
        System.out.println(cadastrar(nome, cpf, email).toString());
    }

    public static Usuario cadastrar(String nome, String cpf, String email) {
        Usuario usuario = new Usuario(nome, cpf, email);
        EntityManager entityManager = JPAUtil.getEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);

        entityManager.getTransaction().begin();
        usuarioDAO.cadastrar(usuario);

        entityManager.getTransaction().commit();
        entityManager.close();

        return usuario;
    }
}