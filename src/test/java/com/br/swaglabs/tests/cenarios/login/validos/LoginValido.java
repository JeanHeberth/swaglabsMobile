package com.br.swaglabs.tests.cenarios.login.validos;

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

public class LoginValido {

    private BrowserConfig browserConfig = new BrowserConfig();
    private AndroidDriver driver;
    private LoginPage loginPage;
    private static final Logger logger = Logger.getLogger(LoginValido.class.getName());


    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = browserConfig.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Teste de login com user e senha válidos")
    public void loginValido() {
        logger.info("Iniciando o teste");
        loginPage
                .login("standard_user", "secret_sauce");

    }

    @AfterEach
    public void tearDown() {
        logger.info("O teste de login com usuário e senha foi executado com sucesso");
        driver.quit();
    }}
