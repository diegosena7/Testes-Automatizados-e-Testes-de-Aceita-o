package br.com.alura.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Nesta classe estamos testando o acesso a página de login
 * É possível recuperar elementos na página utilizando o método findElement();
 * É possível recuperar o código fonte da página utilizando o método getPageSource();
 * É possível recuperar o url atual do browser utilizando o método getCurrentUrl();
 * Devemos utilizar o método sendKeys() para enviar textos para os inputs da página;
 * Uma das maneiras de submeter um formulário é via método submit().
 */
public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;
    private CadastroLeilaoPage paginaDeCadastroDeLeilao;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        this.paginaDeLeiloes = paginaDeLogin.efetuarLogin("fulano", "pass");
        this.paginaDeCadastroDeLeilao = paginaDeLeiloes.carregarFormulario();
    }

    @AfterEach
    public void afterEach(){
        this.paginaDeLeiloes.fecharBrowser();
        this.paginaDeCadastroDeLeilao.fecharBrowser();
    }

    @Test
    public void deveriaCadastrarLeilao(){
        String dataDeHoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nomeLeilao = "Leilao do dia " + dataDeHoje;
        String valorLeilao = "500.00";

        this.paginaDeLeiloes = paginaDeCadastroDeLeilao.cadastrarLeilao(nomeLeilao, valorLeilao, dataDeHoje);
        Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nomeLeilao, valorLeilao, dataDeHoje));
    }

    @Test
    public void validaDadosDeCadastroDeLeilao(){
        this.paginaDeLeiloes = paginaDeCadastroDeLeilao.cadastrarLeilao(" ", " ", " ");
        Assert.assertFalse(this.paginaDeCadastroDeLeilao.isPaginaAtual());
        Assert.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
        Assert.assertTrue(this.paginaDeCadastroDeLeilao.idMsgDeValidacao());
    }
}
