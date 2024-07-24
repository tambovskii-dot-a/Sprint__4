package ru.praktikum.services.scooter.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterOrderPage {
    // Выпадающий список Срок аренды сутки
    public final By oneDayRent = By.xpath("//*[@class='Dropdown-menu']/*[text()='сутки']");
    //Выпадающий список Срок аренды семь суток
    public final By sevenDaysRent = By.xpath("//*[@class='Dropdown-menu']/*[text()='семеро суток']");
    //Цвет чёрный жемчуг
    public final By colorBlack = By.id("black");
    //Цвет серая безысходность
    public final By colorGray = By.id("grey");
    private final WebDriver driver;
    /*Локаторы раздела Для кого самокат*/
    //Имя
    private final By firstNameField = By.xpath("//*[@placeholder='* Имя']");
    //Фамилия
    private final By lastNameField = By.xpath("//*[@placeholder='* Фамилия']");
    // Адрес: куда привезти заказ
    private final By addressField = By.xpath("//*[@placeholder='* Адрес: куда привезти заказ']");
    // Станция метро
    private final By metroStationField = By.xpath("//*[@placeholder='* Станция метро']");
    // Телефон: на него позвонит курьер
    private final By phoneNumberField = By.xpath("//*[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By nextStepButton = By.xpath("//*[@class='Order_NextButton__1_rCA']/*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    /* Локаторы полей раздела Про аренду*/
    //Локатор раздела Про аренду
    private final By aboutRentSection = By.xpath("//*[@class='Order_Content__bmtHS']");
    //Когда привезти самокат
    private final By datePickerField = By.xpath("//*[@placeholder='* Когда привезти самокат']");
    //Локатор выбранного дня датапикера
    private final By datePickerDayButton = By.xpath("//*[@class='react-datepicker__week']/*[@tabindex='0']");
    //Срок аренды
    private final By rentalPeriodField = By.xpath("//*[@aria-haspopup='listbox']");
    //Комментарий для курьера
    private final By commentField = By.xpath("//*[@placeholder='Комментарий для курьера']");
    //кнопка Заказать
    private final By orderButton = By.xpath("//*[@class='Order_Buttons__1xGrp']/*[text()='Заказать']");
    /* Модалка Хотите оформить заказ? */
    // Локатор модального окна
    private final By modalOrderAccept = By.xpath("//*[@class='Order_Modal__YZ-d3']");
    // Локатор кнопки Да
    private final By modalOrderAcceptButton = By.xpath("//*[@class='Order_Buttons__1xGrp']/*[text()='Да']");
    /*Модалка Заказ оформлен*/
    // Локатор модального акна
    private final By modalOrderIsOk = By.xpath("//*[@class='Order_Modal__YZ-d3']/*[text()='Заказ оформлен']");

    public ScooterOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void orderScooter(String firstName, String lastName, String address, String metroStation, String phoneNumber, String date, By dayOfRentLocator, By colorLocator, String comment) {
        driver.findElement(firstNameField).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).click();
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).click();
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(metroStation);
        driver.findElement(By.xpath("//*[@class='select-search__options']/li[@data-value='126']")).click();
        driver.findElement(phoneNumberField).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(nextStepButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(aboutRentSection));
        driver.findElement(datePickerField).click();
        driver.findElement(datePickerField).sendKeys(date);
        driver.findElement(datePickerDayButton).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(dayOfRentLocator).click();
        driver.findElement(colorLocator).click();
        driver.findElement(commentField).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(modalOrderAccept));
        driver.findElement(modalOrderAcceptButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(modalOrderIsOk));
    }
}
