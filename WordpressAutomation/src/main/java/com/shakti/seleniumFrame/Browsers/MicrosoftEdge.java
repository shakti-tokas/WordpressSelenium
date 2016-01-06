package com.shakti.seleniumFrame.Browsers;

import com.shakti.seleniumFrame.seleniumLogger.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * Created by stokas on 06-01-2016.
 */
public class MicrosoftEdge {

    private static final String edgePath = "E:\\GitHub\\WordpressSelenium\\WordpressAutomation\\src\\main\\resources\\Ext_WebDrivers\\MicrosoftWebDriver.exe";
    //"C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe";
    //In current build browser maximize is not supported by Microsoft Egde.

    public static EdgeDriver InitializeEdge(){

        Log.info("Initializing the Edge Driver");
        System.setProperty("webdriver.edge.driver", edgePath);
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy("eager");
        return new EdgeDriver();
    }
}
