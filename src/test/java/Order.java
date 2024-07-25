import ru.praktikum.services.scooter.qa.pages.ScooterMainPage;
import ru.praktikum.services.scooter.qa.pages.ScooterOrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class Order extends BaseTest{

    private static WebDriver driver;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final By dayOfRentLocator;
    private final By colorLocator;
    private final String comment;

    public Order(String firstName, String lastName, String address, String metroStation, String phoneNumber, String date, By dayOfRentLocator, By colorLocator, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.dayOfRentLocator = dayOfRentLocator;
        this.colorLocator = colorLocator;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        // Примеры данных для тестирования
        ScooterOrderPage objScooterOrderPage = new ScooterOrderPage(driver);
        return new Object[][]{
                {"Иван", "Иванов", "Ул Пушкина, дом Колотушкина", "Пушкинская", "+0123456789", "01.01.2025", objScooterOrderPage.oneDayRent, objScooterOrderPage.colorBlack, "Комментарий"},
                {"Вячеслав", "О", "Ул Ленина, дом Тюленина", "Пушкинская", "+0987654321", "05.05.2025", objScooterOrderPage.sevenDaysRent, objScooterOrderPage.colorGray, ""}
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void TestOrderHeadButton() {
        ScooterMainPage objScooterMainPage = new ScooterMainPage(driver);
        ScooterOrderPage objScooterOrderPage = new ScooterOrderPage(driver);

        objScooterMainPage.open(objScooterMainPage.URL);
        objScooterMainPage.clickOrderButtonOnTheHeader();
        objScooterOrderPage.orderScooter(firstName, lastName, address, metroStation, phoneNumber, date, dayOfRentLocator, colorLocator, comment);
    }

    @Test
    public void TestOrderBodyButton() {
        ScooterMainPage objScooterMainPage = new ScooterMainPage(driver);
        ScooterOrderPage objScooterOrderPage = new ScooterOrderPage(driver);
        objScooterMainPage.open(objScooterMainPage.URL);
        objScooterMainPage.clickOrderButtonOnTheBody();
        objScooterOrderPage.orderScooter(firstName, lastName, address, metroStation, phoneNumber, date, dayOfRentLocator, colorLocator, comment);
    }

}
