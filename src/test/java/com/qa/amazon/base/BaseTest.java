package com.qa.amazon.base;

import com.microsoft.playwright.Page;
import com.qa.amazon.factory.PlaywrightFactory;
import com.qa.amazon.page.HomePage;
import com.qa.amazon.page.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    Page page;
    PlaywrightFactory pf;

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected Properties properties;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName) throws IOException {
        pf = new PlaywrightFactory();
        properties = pf.init_properties();
        if(browserName!= null){
            properties.setProperty("browser", browserName);
        }
        page = pf.initBrowser(properties);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
