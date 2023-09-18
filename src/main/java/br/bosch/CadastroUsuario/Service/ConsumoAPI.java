package br.bosch.CadastroUsuario.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    // MÉTODO QUE FAZ A REQUISIÇÃO
    private String requisitaDados(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().proxy(ProxySelector.of(new InetSocketAddress("proxy.br.bosch.com", 8080))).build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    // MÉTODO QUE PASSA DADOS PARA REQUISIÇÃO
    public String obterDados(String cep) throws IOException, InterruptedException {
        String url = String.format("http://viacep.com.br/ws/%s/json/", cep);
        return requisitaDados(url);
    }
}