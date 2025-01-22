package com.qa.amazon.tests;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTest extends BaseTest {
    @Test(priority = 1)
    public void verifyLoginPageTitle(){
        loginPage=  homePage.navigateToLogin();
        String actualTitle = loginPage.getLoginPageTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void verifyForgotPwdExist(){
        Assert.assertTrue(loginPage.isForgotPwdExist());
    }

    @Test(priority = 3)
    public void verifyUserLoginSuccessfully(){
        Assert.assertTrue(loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password")));
    }
}
