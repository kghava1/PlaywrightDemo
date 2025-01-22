package com.qa.amazon.page;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    //String Locators
    private String searchTextBox = "input[name='search']";
    private String searchIcon = "button.btn-lg";
    private String searchHeader = "div#content h1";
    private String myAccount = "//span[text()='My Account']";
    private String loginLink = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']";

    //Page Constructor
    public HomePage(Page page) {
        this.page = page;
    }

    //Page Actions
    public String getHomePageTitle() {
        return page.title();
    }

    public String getHomePageUrl() {
        return page.url();
    }

    public String doSearch(String productName) {
        page.fill(searchTextBox, productName);
        page.click(searchIcon);
        System.out.println("Header is : " + page.textContent(searchHeader));
        return page.textContent(searchHeader);
    }

    public LoginPage navigateToLogin(){
        page.click(myAccount);
        page.click(loginLink);
        return new LoginPage(page);
    }
}
