package com.br.swaglabs.tests.cenarios.invalidos;

import com.br.swaglabs.config.BrowserConfig;
import com.br.swaglabs.page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    public void testAvulso() {
        logger.info("Iniciando o teste de validar login inválido");
        loginPage
                .login("test@test.com", "123456");
        assertEquals(true, loginPage.getTxtLoginError().isDisplayed());
        logger.info("O teste de login inválido foi executado com sucesso");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
