package com.qa.amazon.tests;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.constants.AppConstants;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void HomePageTitleTest() {
        String homePageTitle = homePage.getHomePageTitle();
        Assert.assertEquals(homePageTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void HomePageUrlTest() {
        String homePageUrl = homePage.getHomePageUrl();
        Assert.assertEquals(homePageUrl, properties.getProperty("url"));
    }

    @DataProvider
    public Object[][] getTestData() {
        return new Object[][]{
                {"MacBook"},
                {"iPhone"},
                {"Toys"}
        };
    }

    @Test(dataProvider = "getTestData")
    public void searchTest(String productName) {
        String actualSearchHeader = homePage.doSearch(productName);
        Assert.assertEquals(actualSearchHeader, "Search - " + productName);
    }


}
