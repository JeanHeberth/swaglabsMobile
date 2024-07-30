package com.br.swaglabs.page;

import com.br.swaglabs.elements.LoginElements;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginElements {


    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public HomePage realizarLogin(String email, String senha) {
        username.sendKeys(email);
        password.sendKeys(senha);
        btnLogin.click();
        return new HomePage();
    }

    public String erroLogin(String mensagem) {
        switch (mensagem) {
            case "Username and password do not match any user in this service.":
                return "Username and password do not match any user in this service.";
            case "Username is required":
                return "Username is required";
            case "Password is required":
                return "Password is required";
            default:
                return "";
        }
    }


    public String sucessLogin(String mensagem) {
        if (mensagem.equals("PRODUCTS")) return "PRODUCTS";
        return "";
    }
}
