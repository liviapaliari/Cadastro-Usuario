package br.bosch.CadastroUsuario.Entity;

import javax.persistence.*;

@Entity
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames={"cpf", "email"})})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome, cpf, email;

    @ManyToOne
    private Endereco endereco;

    // CONSTRUTOR
    public Usuario(String nome, String cpf, String email, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s\n", nome, cpf, email);
    }
}