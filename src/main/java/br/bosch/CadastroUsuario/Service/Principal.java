package br.bosch.CadastroUsuario.Service;

import br.bosch.CadastroUsuario.Entity.Usuario;
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

        Usuario usuario = new Usuario(nome, cpf, email);

        System.out.println(converteDados.converteJsonParaEndereco(consumoAPI.obterDados(cep)));
    }
}