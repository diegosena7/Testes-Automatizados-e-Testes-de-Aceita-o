package br.com.alura.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject{

    public static final String URL_LOGIN = "http://localhost:8080/login";
    public static final String LOGIN_URL_ERROR = "http://localhost:8080/login?error";
    public static final String LEILOES_URL = "http://localhost:8080/leiloes/2";

   public LoginPage() {
       super(null);
       this.browser.navigate().to(URL_LOGIN);
    }

    private void preencherFormularioDeLogin(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);//Insere usuário no formulário
        browser.findElement(By.id("password")).sendKeys(password);//Insere senha no formulário
    }

    public LeiloesPage efetuarLogin(String username, String password) {
        this.browser.findElement(By.id("password")).submit();//clica no botão de login
        this.preencherFormularioDeLogin(username, password);
        return new LeiloesPage(browser);
    }

    public boolean isPaginaAtual() {
       return browser.getCurrentUrl().equals(URL_LOGIN);
    }


    public boolean isPaginaDeLoginComErro() {
       return browser.getCurrentUrl().equals(LOGIN_URL_ERROR);
    }

    public String getNomeUsuarioLogado() {
        try {
            return browser.findElement(By.id("usuarioLogado")).getText();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public void navegaParaPaginaDeLances() {
        this.browser.navigate().to(LEILOES_URL);
    }

    public boolean isMensagemDeLoginInvalidoVisivel() {
        return browser.getPageSource().contains("Usuário e senha inválidos");
    }
}
