package com.br.swaglabs.tests.base;

import com.br.swaglabs.config.BrowserConfig;
import com.br.swaglabs.fluxo.Fluxo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {
    protected final Fluxo fluxo = new Fluxo();

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        BrowserConfig
                .setUp();
    }

    @AfterMethod
    public void afterMethod() {
        BrowserConfig
                .tearDown();
    }

}
