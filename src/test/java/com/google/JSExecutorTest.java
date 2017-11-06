package com.google;

import com.google.helpers.DriverSetUp;
import com.google.pages.MainGooglePage;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

/**
 * Класс <class>JSExecutorTest</class>
 */
public class JSExecutorTest extends DriverSetUp {

    private static final String URL = RunningAllSuiteTest.getUrl();

    private MainGooglePage mainGooglePage = new MainGooglePage(driver);

    @Test
    public void test01()throws Exception{
        openMainGooglePage(driver,URL);
        printAttributeFindInput("width");
        checkScroll(driver);
        setFindAndGo("find JSExecutor");
        checkScroll(driver);

    }

    private void openMainGooglePage(WebDriver driver, String url) {
        driver.get(url);
    }

    private void printAttributeFindInput(String attr){
        System.out.println(mainGooglePage.getAttributeFindInput(attr));
    }

    private void checkScroll(WebDriver driver){
        String js = "function get_scroll() {" +
                "var scrollHeight = Math.max(\n" +
                "  document.body.scrollHeight, document.documentElement.scrollHeight,\n" +
                "  document.body.offsetHeight, document.documentElement.offsetHeight,\n" +
                "  document.body.clientHeight, document.documentElement.clientHeight\n" +
                ");" +
                "var isVisible='ScrollBar';"+
                " if (document.body.scrollHeight > document.body.clientHeight) {return isVisible=isVisible+\"IsTrue\"}" +
                "else {return isVisible=isVisible+\"IsFalse\"}" +
               "}" +
                "return get_scroll()";
        System.out.println((String) ((JavascriptExecutor)driver).executeScript(js));
    }



    private void setFindAndGo(String str){
        mainGooglePage.setFindInput(str);
        mainGooglePage.blurFindInput();
        mainGooglePage.findButtonClick();
    }
}
