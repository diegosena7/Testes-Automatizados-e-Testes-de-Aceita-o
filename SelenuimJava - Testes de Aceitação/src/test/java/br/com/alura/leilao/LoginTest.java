package br.com.alura.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Nesta classe estamos testando o acesso a página de login
 * É possível recuperar elementos na página utilizando o método findElement();
 * É possível recuperar o código fonte da página utilizando o método getPageSource();
 * É possível recuperar o url atual do browser utilizando o método getCurrentUrl();
 * Devemos utilizar o método sendKeys() para enviar textos para os inputs da página;
 * Uma das maneiras de submeter um formulário é via método submit().
 */
public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    /**
     * Neste método usamos o método findElement para encontrar e selecionar os elementos da tela, usamos
     * no cenário atual o id que se refere a tag onde está o input da página do front end.
     * Através do método navigate.to passamos a url para ser acessada, usamos o método   Assert.assertFalse
     * para verificar se houve a mundança de url ao acessar a página, passando a url login como parâmetro.
     * Usamos o método  Assert.assertEquals para comparar se o nome de usuario acessado é o mesmo nome de
     * usuário digitado para logar na página. E por fim, usamos o método afterEach para fecharmos o navegador.
     */
    @Test
    public void deveriaEfetuarLoginComDadosValidos(){
        paginaDeLogin.efetuarLogin("fulano", "pass");

        String nomeUsuarioLogado = paginaDeLogin.getNomeUsuarioLogado();
        Assert.assertEquals("fulano", nomeUsuarioLogado);
        Assert.assertFalse(paginaDeLogin.isPaginaAtual());
    }

    /**
     * Neste método u samos o método findElement para encontrar e selecionar os elementos da tela, usamos
     * no cenário atual o id que se refere a tag onde está o input da página do front end.
     * Usamos o método setProperty para passar o arquivo web e o caminho do arquivo de execução.
     * Através do método navigate.to passamos a url para ser acessada, usamos o método   Assert.assertTrue
     * para verificar se com o erro, houve a permanencia da url (login) ao acessar a página, passando a url
     * login como parâmetro. E usamos o método getPageSource().contains para verificar se a msg de erro ao
     * logar com dados inválidos foi informada ao usuário na tela. Fazemos a verificação se o ícone de usuário
     * logado encontra-se vazio através do método assertThrows passando o parâmetro do retorno com uma função lambda,
     * pois como o elemento do login não será encontrado o método lançará uma exception.
     * E por fim, usamos o método afterEach para fechar o navegador.
     */
    @Test
    public void naoDeveriaLogarComDadosInvalidos(){
        paginaDeLogin.efetuarLogin("invalido", "errada");
        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComErro());

        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertTrue(paginaDeLogin.isPaginaAtual());
        Assert.assertTrue(paginaDeLogin.isMensagemDeLoginInvalidoVisivel());
    }

    @Test
    public void naoDeveriaAcessarPaginaSemEstarLogado(){
        LancesPage paginaDeLances = new LancesPage();
        Assert.assertFalse(paginaDeLances.isPaginaAtual());
        Assert.assertFalse(paginaDeLances.isTituloLeilaoVisivel());
        paginaDeLances.fechar();
    }
}
