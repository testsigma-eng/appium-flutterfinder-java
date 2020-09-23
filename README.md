# FlutterFinder-java-0.1

Flutter finder plugin for appium-java client

Sample code
```
FlutterFinder finder = new FlutterFinder(driver);
FlutterElement element = finder.byKey("welcomeStartBtn");
element.click();
```

Contains the Java port for FlutterElement ported from kotlin code for the same from https://github.com/truongsinh/appium-flutter-driver

More locator mechanisms to be added later.