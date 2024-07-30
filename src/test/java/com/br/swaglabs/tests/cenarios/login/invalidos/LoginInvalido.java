package com.br.swaglabs.tests.cenarios.login.invalidos;

import com.br.swaglabs.config.BrowserConfig;
import com.br.swaglabs.page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginInvalido {

    private BrowserConfig browserConfig = new BrowserConfig();
    private AndroidDriver driver;
    private LoginPage loginPage;
    private static final Logger logger = Logger.getLogger(LoginInvalido.class.getName());


    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = browserConfig.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Teste de login com user inváldio e senha válida")
    public void loginUserInvalido() {
        logger.info("Iniciando o teste");
        loginPage
                .login("test@test.com", "secret_sauce");
        assertEquals(loginPage.erroLogin("Username and password do not match any user in this service."), "Username and password do not match any user in this service.");
        logger.info("Teste de login com user inváldio e senha válida foi executado com sucesso");

    }

    @Test
    @DisplayName("Teste de login com user válido e senha inválida")
    public void loginSenhaInvalida() {
        logger.info("Iniciando o teste");
        loginPage
                .login("standard_user", "123456");
        assertEquals(loginPage.erroLogin("Username and password do not match any user in this service."), "Username and password do not match any user in this service.");
        logger.info("Teste de login com user válido e senha inválida foi executado com sucesso");

    }

    @Test
    @DisplayName("Teste validar login com nome em branco")
    public void loginUserNameVazio() {
        logger.info("Iniciando o teste ");
        loginPage
                .login("", "secret_sauce");
        assertEquals(loginPage.erroLogin("Username is required"), "Username is required");

        logger.info("O teste de login validar login nome em branco foi executado com sucesso");
    }

    @Test
    @DisplayName("Teste validar login com senha em branco")
    public void loginSenhaVazia() {
        logger.info("Iniciando o teste");
        loginPage
                .login("standard_user", "");
        assertEquals(loginPage.erroLogin("Password is required"), "Password is required");
        logger.info("O teste de login validar login senha em branco foi executado com sucesso");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
