package user.tests;

import CommonFiles.CustomLogger;
import CommonFiles.Endpoints;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import user.pages.UserPage;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Properties;


public class UserPageTests {
    WebDriver driver;
    private static ChromeOptions options = new ChromeOptions();
    private Duration duration = Duration.ofSeconds(5);

    @BeforeAll
    static void registerDriver() {
        //WebDriverManager.chromedriver().setup();
        System.out.println(new  Properties(System.getProperties()).getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver",new  Properties(System.getProperties()).getProperty("user.dir") + "/src/main/resources/chromedriver");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("--dns-prefetch-disable",/* "--window-size=600,920", */"--ignore-certificate-errors");
        options.addArguments("--headless","--disable-gpu","--lang=ru","--no-sandbox");
//
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver(options);
        //driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver(options));
        //driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(duration);
        driver.get(Endpoints.WAITER_URL);
    }

    @DisplayName("Проверка имени юзера")
    @Test
    public void checkUserNameTest() throws InterruptedException {

        Thread.sleep(1000);
        new UserPage(driver)
                .checkUserName();
        new CustomLogger().beforeQuit(driver);
    }

    @DisplayName("Текст 1-й кнопки суммы")
    @Test
    public void checkSumButton_1() throws InterruptedException {

        new UserPage(driver)
                .checkSumButton_1();
    }

    @DisplayName("Текст 2-й кнопки суммы")
    @Test
    public void checkSumButton_2() throws InterruptedException {
        new UserPage(driver)
                .checkSumButton_2();
    }

    @DisplayName("Текст 3-й кнопки суммы")
    @Test
    public void checkSumButton_3() throws InterruptedException {
        new UserPage(driver)
                .checkSumButton_3();
    }

    @DisplayName("Текст 4-й кнопки суммы")
    @Test
    public void checkSumButton_4() throws InterruptedException {
        new UserPage(driver)
                .checkSumButton_3();
    }

    @DisplayName("Клик по ссылке пользовательского соглашения")
    @Test
    public void userAgreementLinkTest() {
        Allure.addAttachment("Скриншот страницы",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        new UserPage(driver)
                .clickOnUserAgreementLink();
        new CustomLogger().beforeQuit(driver);
    }

    @DisplayName("Клик по ссылке Политика обработки персональных данных")
    @Test
    public void personalDataAgreementLinkTest() {
        Allure.addAttachment("Скриншот страницы",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        new UserPage(driver)
                .clickOnPersonalDataAgreementLink();
        new CustomLogger().beforeQuit(driver);
    }

    @DisplayName("Проверка чекбокса издержки")
    @Test
    public void userCommissionCheckboxTest() {

        new UserPage(driver)
                .clickOnUserCommissionCheckbox();
    }

    @DisplayName("Проверка чекбокса соглашений")
    @Test
    public void personalDataAgreementCheckboxTest() {
        Allure.addAttachment("Скриншот страницы",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        new UserPage(driver)
                .clickOnPersonalDataAgreementCheckbox();
        new CustomLogger().beforeQuit(driver);
    }

    @DisplayName("Удаление суммы")
    @Test
    public void deleteSumTest() {
        new UserPage(driver)
                .clickDeleteSum()
                .clickSumButton_1()
                .clickDeleteSum();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Клик по 1-й звезде")
    @Test
    public void clickOnFirstStarTest() {
        new UserPage(driver).clickOnFirstStar();
    }

    @DisplayName("Клик по 2-й звезде")
    @Test
    public void clickOnSecondStarTest() {
        new UserPage(driver).clickOnSecondStar();
    }

    @DisplayName("Клик по 3-й звезде")
    @Test
    public void clickOnThirdStarTest() {
        new UserPage(driver).clickOnThirdStar();
    }

    @DisplayName("Клик по 4-й звезде")
    @Test
    public void clickOnFourthStarTest() {
        new UserPage(driver).clickOnFourthStar();
    }

    @DisplayName("Клик по 5-й звезде")
    @Test
    public void clickOnFifthStarTest() {
        new UserPage(driver).clickOnFifthStar();
    }

    @DisplayName("Выбрать пункт Обслуживание")
    @Test
    public void clickOnServiceRadioButton() {
        new UserPage(driver)
                .clickOnFirstStar()
                .clickOnServiceRadioButton();
    }

    @DisplayName("Выбрать пункт Атмосфера")
    @Test
    public void clickOnVibeRadioButton() {
        new UserPage(driver)
                .clickOnFirstStar()
                .clickOnVibeRadioButton();
    }

    @DisplayName("Выбрать пункт Качество блюд")
    @Test
    public void clickOnQualityDishesRadioButton() {
        new UserPage(driver)
                .clickOnFirstStar()
                .clickOnQualityDishesRadioButton();
    }

    @DisplayName("Выбрать пункт Чистота")
    @Test
    public void clickOnPurenessRadioButton() {
        new UserPage(driver)
                .clickOnFirstStar()
                .clickOnPurenessRadioButton();
    }

    @DisplayName("Клик по кнопке рассказать подробнее (5 звезд)")
    @Test
    public void checkAddFeedbackBtnOnFiveStars() {
        new UserPage(driver)
                .clickOnFifthStar()
                .checkAddFeedbackBtn();
    }

    @DisplayName("Клик по кнопке рассказать подробнее (4 звезды)")
    @Test
    public void checkAddFeedbackBtn() {
        new UserPage(driver)
                .clickOnFourthStar()
                .checkAddFeedbackBtn();
    }
    @DisplayName("Оставить комментарий (1 звездa)")
    @Test
    public void checkTextAreaWithOneStars() {
        new UserPage(driver)
                .clickOnFirstStar()
                .checkTextArea();
        new CustomLogger().beforeQuit(driver);
    }
    @DisplayName("Оставить комментарий (2 звезды)")
    @Test
    public void checkTextAreaWithTwoStars() {
        new UserPage(driver)
                .clickOnSecondStar()
                .checkTextArea();
        new CustomLogger().beforeQuit(driver);
    }
    @DisplayName("Оставить комментарий (3 звезды)")
    @Test
    public void checkTextAreaWithThreeStars() {
        new UserPage(driver)
                .clickOnThirdStar()
                .checkTextArea();
        new CustomLogger().beforeQuit(driver);
    }
    @DisplayName("Оставить комментарий (4 звезды)")
    @Test
    public void checkTextAreaWithFourStars() {
        new UserPage(driver)
                .clickOnFourthStar()
                .checkAddFeedbackBtn()
                .checkTextArea();
        new CustomLogger().beforeQuit(driver);
    }

    @DisplayName("Оставить комментарий (5 звезд)")
    @Test
    public void checkTextAreaWithFiveStars() {
        new UserPage(driver)
                .clickOnFifthStar()
                .checkAddFeedbackBtn()
                .checkTextArea();
        new CustomLogger().beforeQuit(driver);
    }

    @DisplayName("Клик по кнопке Оплатить картой")
    @Test
    public void clickOnPayByCardBtn() {
        new UserPage(driver)
                .clickOnPayByCardBtn();
        new CustomLogger().beforeQuit(driver);
    }


    @AfterEach
    void closeDriver() {
        driver.close();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
