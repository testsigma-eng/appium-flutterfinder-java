# appium-flutterfinder-java-0.1.1

Flutter finder plugin for appium-java client

Sample code
```
FlutterFinder finder = new FlutterFinder(driver);
FlutterElement element = finder.byKey("welcomeStartBtn");
element.click();
```

Contains the Java port for FlutterElement ported from kotlin code for the same from https://github.com/truongsinh/appium-flutter-driver

FlutterElement extends the MobileElement Class. Therefore, all the basic actions like click, sendKeys e.t.c are supported on the FlutterElement `element` found using FlutterFinder. It is basically an extension of a MobileElement type.

### TODO
- [ ] Add Testing Code
- [ ] Implement mocking for selenium webdriver
- [ ] Add locators by text
- [ ] Add locators by byTooltip
- [ ] Add locators by bySemanticsLabel
- [ ] Add locators by ancestor
- [ ] Add locators by descendant
- [ ] Add locators by byType
