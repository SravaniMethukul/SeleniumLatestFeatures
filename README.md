Selenium DevTools CDP Examples (Chrome & Edge)

This repository contains examples of how to use Chrome DevTools Protocol (CDP) with Selenium 4+ in Chromium-based browsers (Chrome/Edge) to enhance automation capabilities.

> 📄 **Files & Descriptions**
>
> | File/Class Name                      | Description                                                                 |
> |-------------------------------------|-----------------------------------------------------------------------------|
> | `MobileEmulatorTest.java`           | Emulates mobile device view by overriding screen metrics.                  |
> | `cdpCommandsTest.java`              | Uses `executeCdpCommand()` to send raw CDP commands when Selenium wrappers aren't available. |
> | `emulateGeolocationTest.java`       | Simulates browser location using `Emulation.setGeolocationOverride`.       |
> | `networkLogActivity.java`           | Captures and logs all network request and response activities.             |
> | `NetworkMocking.java`               | Demonstrates network mocking by modifying request URLs before execution.   |
> | `NetworkFail.java`                  | Simulates network failure to test application behavior with failed requests.|
> | `BlockNetworkRequests.java`         | Blocks specific resource types (e.g. images, CSS) to improve page load speed.|
> | `EmulateNetworkSpeed.java`          | Simulates slow/limited network conditions (e.g. 3G, Ethernet) to test performance. |
> | `LogErrorCaptureFromJavascript.java`| Captures browser console logs


🔧 Prerequisites

    Selenium Java 4.18.1 or higher

    ChromeDriver or EdgeDriver

    Maven dependencies for selenium-java and appropriate selenium-devtools-vXXX

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.20.0</version>
</dependency>

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-devtools-v122</artifactId>
    <version>4.18.1</version>
</dependency>

🧠 Notes

    CDP commands are accessed via DevTools.send() in Selenium.

    For unsupported methods, use executeCdpCommand(methodName, paramsMap).

    Chrome/Edge only — Firefox and Safari do not support CDP in Selenium 4.

