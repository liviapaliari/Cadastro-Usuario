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

    static EntityManager entityManager = JPAUtil.getEntityManager();
    static UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);
    static EnderecoDAO enderecoDAO = new EnderecoDAO(entityManager);

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
        System.out.print("Nº: ");
        String numero = scanner.nextLine();
        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();

        Endereco endereco = converteDados.converteJsonParaEndereco(consumoAPI.obterDados(cep), numero, complemento);

        System.out.println("--- USUÁRIO CADASTRADO ---");
        cadastrar(nome, cpf, email, endereco);
    }

    public static Usuario cadastrar(String nome, String cpf, String email, Endereco endereco) {
        Usuario usuario = new Usuario(nome, cpf, email, endereco);
        int id = VerificaDados.retornaEndereco(entityManager, endereco);

        // SE ENDEREÇO NÃO EXISTE NO BANCO
        if (id == -1) {
            enderecoDAO.cadastrar(endereco);
            usuario.setEndereco(endereco);

        } else {
            endereco = enderecoDAO.buscarPorId(id);
            usuario.setEndereco(endereco);
        }

        entityManager.getTransaction().begin();
        usuarioDAO.cadastrar(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();

        return usuario;
    }
}