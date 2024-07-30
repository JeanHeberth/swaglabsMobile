package com.br.swaglabs.tests.cenarios.login.validos;

import com.br.swaglabs.config.BrowserConfig;
import com.br.swaglabs.page.LoginPage;
import com.br.swaglabs.tests.base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.logging.Logger;

public class LoginValido extends BaseTest {


    private LoginPage loginPage;
    private static final Logger logger = Logger.getLogger(LoginValido.class.getName());


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        loginPage = new LoginPage(BrowserConfig.getDriver());
    }

    @Test(testName = "Teste de login com user e senha válidos")
    public void loginValido() {
        logger.info("Iniciando o teste");
        loginPage
                .realizarLogin("standard_user", "secret_sauce");

    }

    @AfterMethod
    public void tearDown() {
        logger.info("O teste de login com usuário e senha foi executado com sucesso");
        BrowserConfig
                .tearDown();
    }
}
