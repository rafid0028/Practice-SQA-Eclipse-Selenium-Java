# **ECLIPSE_SELENIUM_JAVA**

## **Overview**
This project demonstrates a **Selenium WebDriver** automation script using **Java** and **Maven** in Eclipse. It automates opening web pages, fetching titles, and verifying them with expected values.

## **Prerequisites**
Before running the project, ensure you have:
- **Java JDK (11 or later)** installed and configured.
- **Eclipse IDE** installed.
- **Maven** configured in Eclipse.
- **Google Chrome** installed.

## **Setup Instructions**
### **1. Import the Project in Eclipse**
1. Open **Eclipse**.
2. Click on **File** → **Import**.
3. Select **Existing Maven Projects**.
4. Browse to the cloned repository folder and select it.
5. Click **Finish**.

### **3. Install Dependencies**
## **Project Dependencies (pom.xml)**
Add the following dependencies to your **pom.xml**:
```xml
<dependencies>
    <!-- Selenium Java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.27.0</version>
    </dependency>

    <!-- WebDriver Manager (Automatically manages drivers) -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.6.2</version>
    </dependency>

    <!-- TestNG (Optional, for test framework) -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.9.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### **Project Structure**
```
ECLIPSE_SELENIUM_JAVA
│── src/main/java/org/SeleniumEclipse/
│   ├── Main.java
│── pom.xml
│── README.md
```

## **Main Automation Script (Main.java)**
The following code performs the following actions:
- Opens **Google** and verifies its title.
- Opens **Facebook** and intentionally mismatches the title for testing.
- Uses **WebDriverWait** to handle explicit waits.

```java
package org.SeleniumEclipse;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "Google";

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.titleContains("Google"));

        if (actualTitle1.equals(expectedTitle1)) {
            System.out.println(actualTitle1 + "\nTitle Matched ^_^");
        } else {
            System.out.println("X TITLE MISMATCH -_-\nExpected Title - " + expectedTitle1);
        }

        driver.manage().window().minimize();
        driver.get("https://www.facebook.com");

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Google"; // Intentionally incorrect for testing

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.titleContains("Facebook"));

        if (actualTitle2.equals(expectedTitle2)) {
            System.out.println(actualTitle2 + "\nTitle Matched ^_^");
        } else {
            System.out.println("X TITLE MISMATCH -_-\nExpected Title - " + expectedTitle2);
            System.out.println("CHECK THE CODE");
        }

        driver.quit();
    }
}
```

## **How to Run the Project**
1. **Open Eclipse** and **import** the project.
2. **Right-click** `Main.java` → **Run As** → **Java Application**.
3. There should be a pop up chrome browser with Google homepage and one minimized facebook homepage.
4. The console will display title verification results.

## **Expected Output (Sample)**
```
Google
Title Matched ^_^
Facebook
X TITLE MISMATCH -_-
Expected Title - Google
CHECK THE CODE
```
---

