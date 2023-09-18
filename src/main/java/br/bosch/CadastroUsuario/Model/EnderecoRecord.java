package br.bosch.CadastroUsuario.Model;

import com.google.gson.annotations.SerializedName;

public record EnderecoRecord(@SerializedName("logradouro") String logradouro,
                             @SerializedName("bairro") String bairro,
                             @SerializedName("localidade") String cidade,
                             @SerializedName("uf") String estado,
                             @SerializedName("cep") String cep) {
}