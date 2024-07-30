package com.br.swaglabs.page;

import com.br.swaglabs.elements.ProdutoElements;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class ProdutoPage extends ProdutoElements {

    public ProdutoPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
