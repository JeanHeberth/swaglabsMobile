package com.br.swaglabs.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginElements {

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    protected WebElement username;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    protected WebElement password;

    @FindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    protected WebElement btnLogin;



}
