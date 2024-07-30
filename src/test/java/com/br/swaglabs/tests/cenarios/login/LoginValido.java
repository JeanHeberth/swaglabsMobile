package com.br.swaglabs.tests.cenarios.login;

import com.br.swaglabs.config.BrowserConfig;
import com.br.swaglabs.page.LoginPage;
import com.br.swaglabs.tests.base.BaseTest;
import com.br.swaglabs.utils.PropertiesReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

public class LoginValido extends BaseTest {


    private LoginPage loginPage;
    private static final Logger logger = Logger.getLogger(LoginValido.class.getName());


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        loginPage = new LoginPage(BrowserConfig.getDriver());
    }

    @Test(testName = "Teste de login com user e senha válidos")
    public void loginValido() {
        var nome = PropertiesReader.get("username");
        var senha = PropertiesReader.get("password");
        logger.info("Iniciando o teste");
        loginPage
                .realizarLogin(nome, senha);
        assertEquals(loginPage.sucessLogin("PRODUCTS"), "PRODUCTS");

    }

    @Test(testName = "Teste de login com user inváldio e senha inválida")
    public void loginUserInvalido() {
        logger.info("Iniciando o teste");
        loginPage
                .realizarLogin("test@test.com", "secret_sauce");
        assertEquals(loginPage.erroLogin("Username and password do not match any user in this service."), "Username and password do not match any user in this service.");
        logger.info("Teste de login com user inváldio e senha válida foi executado com sucesso");

    }

    @Test(testName = "Teste de login com user inváldio e senha inválida")
    public void loginSenhaInvalida() {
        logger.info("Iniciando o teste");
        loginPage
                .realizarLogin("standard_user", "123456");
        assertEquals(loginPage.erroLogin("Username and password do not match any user in this service."), "Username and password do not match any user in this service.");
        logger.info("Teste de login com user válido e senha inválida foi executado com sucesso");

    }

    @Test(testName = "Teste validar login com nome em branco")
    public void loginUserNameVazio() {
        logger.info("Iniciando o teste ");
        loginPage
                .realizarLogin("", "secret_sauce");
        assertEquals(loginPage.erroLogin("Username is required"), "Username is required");

        logger.info("O teste de login validar login nome em branco foi executado com sucesso");
    }

    @Test(testName = "Teste validar login com senha em branco")
    public void loginSenhaVazia() {
        logger.info("Iniciando o teste");
        loginPage
                .realizarLogin("standard_user", "");
        assertEquals(loginPage.erroLogin("Password is required"), "Password is required");
        logger.info("O teste de login validar login senha em branco foi executado com sucesso");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("O teste de login com usuário e senha foi executado com sucesso");
        BrowserConfig
                .tearDown();
    }
}
