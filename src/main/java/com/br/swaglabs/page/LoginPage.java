package com.br.swaglabs.page;

import com.br.swaglabs.elements.LoginElements;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginElements {

    AndroidDriver driver;


    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public LoginPage login(String email,String senha) {
        username.sendKeys(email);
        password.sendKeys(senha);
        btnLogin.click();
        return this;
    }

}
