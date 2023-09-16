package br.bosch.CadastroUsuario.Entity;

import br.bosch.CadastroUsuario.Model.EnderecoRecord;

public class Endereco {
    private String logradouro, bairro, cidade, estado;

    // MÉTODO CONSTRUTOR RECEBE RECORD COM CAMPOS DA API
    public Endereco(EnderecoRecord enderecoRecord) {
        this.logradouro = enderecoRecord.logradouro();
        this.bairro = enderecoRecord.bairro();
        this.cidade = enderecoRecord.cidade();
        this.estado = enderecoRecord.estado();
    }

    @Override
    public String toString() {
        return String.format("Logradouro: %s\n" +
                "Bairro: %s\n" +
                "Cidade: %s\n" +
                "Estado: %s", logradouro, bairro, cidade, estado);
    }
}
