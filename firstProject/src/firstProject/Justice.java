package firstProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Justice {

    int pageNumber = 12;
    String baseUrl = "https://www.justice.gov/epstein/doj-disclosures/data-set-2-files?page=";

    WebDriver driver = new EdgeDriver();

    @BeforeTest
    public void setup() {

        driver.get(baseUrl + pageNumber);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/main/div/input")).click();
        driver.findElement(By.id("age-button-yes")).click();
    }

    @Test
    public void openCloseTabsOneByOne() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> links = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector(".views-field.views-field-title a")
                )
        );

        // فتح كل التابات
        for (WebElement link : links) {
            js.executeScript("window.open(arguments[0], '_blank');",
                    link.getAttribute("href"));
        }

        // جلب كل التابات
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // أول تاب هو الصفحة الرئيسية — نتركه
        for (int i = 1; i < tabs.size(); i++) {

            driver.switchTo().window(tabs.get(i));

            Thread.sleep(6000); // ⏱️ انتظر 10 ثواني

            driver.close(); // ❌ اغلاق التاب
        }

        // الرجوع للتاب الأساسي
        driver.switchTo().window(tabs.get(0));
    }
}
