package com.google;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Класс <class>RunningAllSuiteTest</class>
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        JSExecutorTest.class
})
public class RunningAllSuiteTest {

    private static final String URL = "https://www.google.com";

    public static String getUrl() {
        return URL;
    }


}
