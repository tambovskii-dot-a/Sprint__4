package finalProjectSprin4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterMainPage {
    public final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;
    //Локатор блока FAQ
    private final By FaqAccardion = By.xpath("//*[@class='Home_FAQ__3uVm4']");
    // Локаторы кликабельных заголовков акордиона FAQ
    private final By FaqAccordionElement_0 = By.id("accordion__heading-0");
    private final By FaqAccordionElement_1 = By.id("accordion__heading-1");
    private final By FaqAccordionElement_2 = By.id("accordion__heading-2");
    private final By FaqAccordionElement_3 = By.id("accordion__heading-3");
    private final By FaqAccordionElement_4 = By.id("accordion__heading-4");
    private final By FaqAccordionElement_5 = By.id("accordion__heading-5");
    private final By FaqAccordionElement_6 = By.id("accordion__heading-6");
    private final By FaqAccordionElement_7 = By.id("accordion__heading-7");
    //Локаторы текста в акордионе FAQ
    private final By textInFaqAccordionElement_0 = By.id("accordion__panel-0");
    private final By textInFaqAccordionElement_1 = By.id("accordion__panel-1");
    private final By textInFaqAccordionElement_2 = By.id("accordion__panel-2");
    private final By textInFaqAccordionElement_3 = By.id("accordion__panel-3");
    private final By textInFaqAccordionElement_4 = By.id("accordion__panel-4");
    private final By textInFaqAccordionElement_5 = By.id("accordion__panel-5");
    private final By textInFaqAccordionElement_6 = By.id("accordion__panel-6");
    private final By textInFaqAccordionElement_7 = By.id("accordion__panel-7");

    // Локатор кнопки Заказать вверху страницы
    private final By orderButtonInTheHeader = By.xpath("//*[@class='Header_Nav__AGCXC']/*[@class='Button_Button__ra12g']");
    // Локатор кнопки Заказать внизу страницы
    private final By orderButtonInTheBody = By.xpath("//*[@class='Home_FinishButton__1_cWm']/*[text()='Заказать']");

    public ScooterMainPage(WebDriver driver) {
        this.driver = driver;

    }

    public void open(String url) {
        driver.get(url);
    }

    public void scrollToFaqAccordion() {
        WebElement element = driver.findElement(FaqAccardion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String checkTextInAccordionElement_0() {
        scrollToFaqAccordion();
        driver.findElement(FaqAccordionElement_0).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textInFaqAccordionElement_0));
        return driver.findElement(textInFaqAccordionElement_0).getText();

    }

    public String checkTextInAccordionElement_1() {
        scrollToFaqAccordion();
        driver.findElement(FaqAccordionElement_1).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textInFaqAccordionElement_1));
        return driver.findElement(textInFaqAccordionElement_1).getText();

    }

    public String checkTextInAccordionElement_2() {
        scrollToFaqAccordion();
        driver.findElement(FaqAccordionElement_2).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textInFaqAccordionElement_2));
        return driver.findElement(textInFaqAccordionElement_2).getText();

    }

    public String checkTextInAccordionElement_3() {
        scrollToFaqAccordion();
        driver.findElement(FaqAccordionElement_3).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textInFaqAccordionElement_3));
        return driver.findElement(textInFaqAccordionElement_3).getText();

    }

    public String checkTextInAccordionElement_4() {
        scrollToFaqAccordion();
        driver.findElement(FaqAccordionElement_4).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textInFaqAccordionElement_4));
        return driver.findElement(textInFaqAccordionElement_4).getText();

    }

    public String checkTextInAccordionElement_5() {
        scrollToFaqAccordion();
        driver.findElement(FaqAccordionElement_5).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textInFaqAccordionElement_5));
        return driver.findElement(textInFaqAccordionElement_5).getText();

    }

    public String checkTextInAccordionElement_6() {
        scrollToFaqAccordion();
        driver.findElement(FaqAccordionElement_6).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textInFaqAccordionElement_6));
        return driver.findElement(textInFaqAccordionElement_6).getText();

    }

    public String checkTextInAccordionElement_7() {
        scrollToFaqAccordion();
        driver.findElement(FaqAccordionElement_7).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textInFaqAccordionElement_7));
        return driver.findElement(textInFaqAccordionElement_7).getText();

    }

    public void clickOrderButtonOnTheHeader() {
        driver.findElement(orderButtonInTheHeader).click();
    }

    public void clickOrderButtonOnTheBody() {
        WebElement element = driver.findElement(orderButtonInTheBody);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButtonInTheBody).click();
    }
}
