package br.bosch.CadastroUsuario;

import br.bosch.CadastroUsuario.Service.VerificaDados;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerificaDadosTest {
    @Test
    public void entradaDeDadosSemPontosEHifens() {
        String entrada = "13088000";
        Assertions.assertEquals(entrada, VerificaDados.verificaTamanho(entrada, 8));
    }

    // PONTOS, HÍFENS E ESPAÇOS DEVEM SER REMOVIDOS ANTES DE SALVAR NO BANCO DE DADOS
    @Test
    public void entradaDeDadosComPontosEHifens() {
        String entrada = "13088-000";
        Assertions.assertEquals("13088000", VerificaDados.verificaTamanho(entrada, 8));
    }

    // NÃO PASSOU
    @Test
    public void entradaDeDadosForaDoLimite() {
        String entrada = "1308800";
        try {
            VerificaDados.verificaTamanho(entrada, 8);
            Assertions.fail("Não gerou exceção.");
        } catch (Exception e) {
            Assertions.assertEquals("Caracteres inválidos.", e.getMessage());
        }
    }
}