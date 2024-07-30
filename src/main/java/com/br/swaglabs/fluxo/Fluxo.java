package com.br.swaglabs.fluxo;

import com.br.swaglabs.config.BrowserConfig;
import com.br.swaglabs.page.HomePage;
import com.br.swaglabs.page.LoginPage;
import io.appium.java_client.android.AndroidDriver;

public class Fluxo {

    public HomePage acessarSwagLabs(String email, String senha) {
        AndroidDriver driver = new BrowserConfig().getDriver();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.realizarLogin(email, senha);
    }

}
