package br.bosch.CadastroUsuario.Entity;

import br.bosch.CadastroUsuario.Model.EnderecoRecord;
import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String logradouro, bairro, cidade, estado, cep, numero, complemento;

    // CONSTRUTOR PADRÃO OBRIGATÓRIO
    public Endereco() {

    }

    // MÉTODO CONSTRUTOR RECEBE RECORD COM CAMPOS DA API
    public Endereco(EnderecoRecord enderecoRecord, String numero, String complemento) {
        this.logradouro = enderecoRecord.logradouro();
        this.bairro = enderecoRecord.bairro();
        this.cidade = enderecoRecord.cidade();
        this.estado = enderecoRecord.estado();
        this.cep = enderecoRecord.cep().replace("-", "");
        this.numero = numero;
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", logradouro, bairro, numero, complemento);
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
}