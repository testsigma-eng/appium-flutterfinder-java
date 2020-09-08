package com.testsigma.flutter;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * Implement finder for key based locators when using
 * Flutter driver in Appium java test scripts
 * @author renju
 * @version 0.1
 */
public class FlutterFinder {
    RemoteWebDriver driver;
    FileDetector fileDetector;

    public FlutterFinder(RemoteWebDriver driver){
        this.driver=driver;
        this.fileDetector = null;
    }

    public FlutterElement byValueKey(String key){
        FlutterElement flutterElement = new FlutterElement(ImmutableMap
                .of("finderType","ByValueKey",
                        "keyValueType","String",
                        "keyValueString",key));
        flutterElement.setParent(driver);
        flutterElement.setFileDetector(fileDetector);
        return flutterElement;
    }
}