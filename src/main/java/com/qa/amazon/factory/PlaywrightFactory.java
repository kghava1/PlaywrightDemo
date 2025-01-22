package com.qa.amazon.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PlaywrightFactory {
    //Playwright playwright;
    //Browser browser;
    //BrowserContext browserContext;
    //Page page;
    Properties properties;

    private static ThreadLocal<Browser>tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext>tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page>tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright>tlPlaywright = new ThreadLocal<>();

    public static Browser getBrowser(){
        return tlBrowser.get();
   }
   public static BrowserContext getBrowserContext(){
        return tlBrowserContext.get();
   }
   public static Page getPage(){
        return tlPage.get();
   }
   public static Playwright getPlayWright(){
        return tlPlaywright.get();
   }


    public Page initBrowser(Properties properties){
        System.out.println("Browser Name is : " + properties.getProperty("browser"));
        String browserName = properties.getProperty("browser").trim();
        //playwright = Playwright.create();
        tlPlaywright.set(Playwright.create());
        switch (browserName.toLowerCase()) {
            case "chromium" ->
                    //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    tlBrowser.set(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            case "chrome" ->
                    //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                    tlBrowser.set(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
            case "firefox" ->
                    //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    tlBrowser.set(getPlayWright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            default -> System.out.println("Please pass right browser .......");
        }

        //browserContext = browser.newContext();
        //page = browserContext.newPage();
        //page.navigate(properties.getProperty("url").trim());

        tlBrowserContext.set(getBrowser().newContext());
        tlPage.set(getBrowserContext().newPage());
        getPage().navigate(properties.getProperty("url").trim());
        return getPage();
    }

    /**
     * To initialize properties of config file
     *
     * @return
     */
    public Properties init_properties() throws IOException {
        try {
            FileInputStream inputStream = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    /**
     * take Screenshot
     */
    public static String takeScreenShot(){
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return path;
    }

}
