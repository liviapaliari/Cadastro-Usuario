package br.bosch.CadastroUsuario.Service;

import br.bosch.CadastroUsuario.Entity.Endereco;
import br.bosch.CadastroUsuario.Model.EnderecoRecord;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConverteDados {
    Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting().create();

    // RECEBE JSON E RETORNA OBJETO ENDEREÇO
    public Endereco converteJsonParaEndereco(String json) {
        EnderecoRecord enderecoRecord = gson.fromJson(json, EnderecoRecord.class);
        return new Endereco(enderecoRecord);
    }
}

