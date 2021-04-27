package br.com.alura.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage extends PageObject{


    public static final String CADASTRO_LEILOES_URL = "http://localhost:8080/leiloes/new";

    public CadastroLeilaoPage(WebDriver browser) {
        super(browser);
    }

    public CadastroLeilaoPage() {
        super(null);
    }

    /**
     * Método responsável por cadastrar um leilão, preenche os dados do leilão
     * e em seguida submete as informações de cadastro.
     * @param nomeLeilao
     * @param valorInicialLeilao
     * @param dataAbertura
     */
    public LeiloesPage cadastrarLeilao(String nomeLeilao, String valorInicialLeilao, String dataAbertura) {
        this.browser.findElement(By.id("nome")).sendKeys(nomeLeilao);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicialLeilao);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.browser.findElement(By.id("button-submit")).submit();
        return new LeiloesPage(browser);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(CADASTRO_LEILOES_URL);
    }

    public boolean idMsgDeValidacao() {
        String pageSource = browser.getPageSource();
        return pageSource.contains("minimo 3 caracteres") && pageSource.contains("não deve estar em branco")
                && pageSource.contains("deve ser um valor maior de 0.1")
                && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}

