package com.qa.amazon.page;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    //String Locators
    private String email = "#input-email";
    private String password = "#input-password";
    private String forgottenPassword = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String loginBtn = "//input[@value='Login']";

    private String logoutBtn = "//a[@class='list-group-item' and text()= 'Logout']";

    //Page Constructor
    public LoginPage(Page page){
        this.page = page;
    }

    //Page Actions
    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean isForgotPwdExist(){
        return page.isVisible(forgottenPassword);
    }

    public boolean doLogin(String appUsername, String appPassword){
        page.fill(email, appUsername);
        page.fill(password, appPassword);
        page.click(loginBtn);
        if (page.isVisible(logoutBtn)){
            System.out.println("Login Successfully");
            return true;
        }
        return false;
    }
}
