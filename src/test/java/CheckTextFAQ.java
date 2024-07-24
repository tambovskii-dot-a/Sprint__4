import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.services.scooter.qa.pages.ScooterMainPage;
import java.time.Duration;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class CheckTextFAQ {

    //  Ожидаемый текст для checkTextFAQ
    private static final String[] EXPECTED_TEXT_IN_ACCORDION_ELEMENTS = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };
    private static WebDriver driver;
    private final String expectedText;
    private final String actualText;

    public CheckTextFAQ(String expectedText, String actualText) {
        this.expectedText = expectedText;
        this.actualText = actualText;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        ScooterMainPage objScooterMainPage = new ScooterMainPage(driver);
        objScooterMainPage.open(objScooterMainPage.URL);
        return new Object[][]{
                {EXPECTED_TEXT_IN_ACCORDION_ELEMENTS[0], objScooterMainPage.checkTextInAccordionElement_0()},
                {EXPECTED_TEXT_IN_ACCORDION_ELEMENTS[1], objScooterMainPage.checkTextInAccordionElement_1()},
                {EXPECTED_TEXT_IN_ACCORDION_ELEMENTS[2], objScooterMainPage.checkTextInAccordionElement_2()},
                {EXPECTED_TEXT_IN_ACCORDION_ELEMENTS[3], objScooterMainPage.checkTextInAccordionElement_3()},
                {EXPECTED_TEXT_IN_ACCORDION_ELEMENTS[4], objScooterMainPage.checkTextInAccordionElement_4()},
                {EXPECTED_TEXT_IN_ACCORDION_ELEMENTS[5], objScooterMainPage.checkTextInAccordionElement_5()},
                {EXPECTED_TEXT_IN_ACCORDION_ELEMENTS[6], objScooterMainPage.checkTextInAccordionElement_6()},
                {EXPECTED_TEXT_IN_ACCORDION_ELEMENTS[7], objScooterMainPage.checkTextInAccordionElement_7()}
        };
    }

    @After
    public void driverQuit() {
        driver.quit();
    }


    @Test
    public void checkTextFAQ() {
        assertEquals(expectedText, actualText);
    }
}


