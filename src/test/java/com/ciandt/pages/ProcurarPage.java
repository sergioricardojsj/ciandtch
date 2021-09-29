package com.ciandt.pages;

import com.ciandt.configuration.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProcurarPage extends BasePage {

    @FindBy(id = "query")
    private WebElement caixaDePerguntas;

    @FindBy(xpath = ".//button[@role='button']")
    private WebElement botaoPesquisar;

    @FindBy(xpath = ".//a[contains(text(), 'ADD NEW')]")
    private WebElement botaoAdicionarPergunta;

    @FindBy(xpath = ".//div[contains(@class, 'alert')]")
    private WebElement mensagemErro;

    @FindBy(id = "type")
    private WebElement opcoes;

    @FindBy(xpath = ".//table/child::tbody/child::tr")
    private List<WebElement> listaDeQuestoes;

    @FindBy(xpath = ".//ul[contains(@class, 'pagination')]")
    private WebElement paginacao;

    public ProcurarPage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public ProcurarPage digitarPesquisa(String name) {
        caixaDePerguntas.sendKeys(name);
        return this;
    }

    public ProcurarPage clicarNoBotaoPesquisar() {
        botaoPesquisar.click();
        return this;
    }

    public ProcurarPage adicionarNovaPergunta() {
        botaoAdicionarPergunta.click();
        return this;
    }

    public void validarMensagem(String mensagem) {
        waitForElementToShowUp(mensagemErro);
        assertEquals(mensagem, mensagemErro.getText());
    }

    public ProcurarPage selecionarOpcao(String opcao) {
        selectElement(opcoes, opcao);
        return this;
    }

    public void validarQuantidadeDeItens(int quantidade) {
        assertEquals(quantidade, listaDeQuestoes.size());
    }

    public void validarPresencaDaPaginacao() {
        assertTrue(paginacao.isDisplayed());
    }

}
