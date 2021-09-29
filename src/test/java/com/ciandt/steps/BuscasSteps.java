package com.ciandt.steps;

import com.ciandt.configuration.TLDriverFactory;
import com.ciandt.pages.HomePage;
import com.ciandt.pages.ProcurarPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

public class BuscasSteps {

    private WebDriver driver;
    private ProcurarPage procurarPage;

    @Before
    public void setup() {
        TLDriverFactory.setDriver();
        driver = TLDriverFactory.getDriver();
        procurarPage = new ProcurarPage();
    }

    @After
    public void tearDown() {
        TLDriverFactory.endDriver();
    }

    @Dado("que navego para a pagina de busca do banco de questoes")
    public void queNavegoParaAPaginaDeBuscaDoBancoDeQuestoes() {
        acessarSite();
        new HomePage().acessarPaginaProcurar();
    }

    @Quando("digito {string} no campo de busca")
    public void digitoNoCampoDeBusca(String name) {
        procurarPage.digitarPesquisa(name);
    }

    @E("clico no botao de buscar")
    public void clicoNoBotaoDeBuscar() {
        procurarPage.clicarNoBotaoPesquisar();
    }

    @Entao("visualizo uma mensagem de erro com o texto {string}")
    public void visualizoUmaMensagemDeErroComOTexto(String mensagem) {
        procurarPage.validarMensagem(mensagem);
    }

    @Quando("seleciono a opção {string}")
    public void selecionoAOpcao(String opcao) {
        procurarPage.selecionarOpcao(opcao);
    }

    @Entao("visualizo {int} itens na listagem")
    public void visualizoItensNaListagem(Integer quantidadeItens) {
        procurarPage.validarQuantidadeDeItens(quantidadeItens);
    }

    @E("visualizo a paginação")
    public void visualizoAPaginacao() {
        procurarPage.validarPresencaDaPaginacao();
    }

    @Dado("que acesso a pagina inicial do site sem logar")
    public void queAcessoAPaginaInicialDoSiteSemLogar() {
        acessarSite();
    }
    @Quando("adicionar uma nova pergunta")
    public void clicoNoBotao() {
        procurarPage.adicionarNovaPergunta();
    }

    private void acessarSite() {
        driver.navigate().to("https://opentdb.com/");
    }

}
