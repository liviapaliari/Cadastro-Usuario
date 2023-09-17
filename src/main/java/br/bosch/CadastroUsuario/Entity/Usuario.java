package br.bosch.CadastroUsuario.Entity;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome, cpf, email;

    public Usuario(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\n" +
                "Nome: %s\n" +
                "CPF: %s\n" +
                "E-mail: %s", id, nome, cpf, email);
    }
}