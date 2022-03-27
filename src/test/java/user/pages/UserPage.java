package user.pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.BasePage;

import java.io.ByteArrayInputStream;

public class UserPage extends BasePage {
    //TODO: вытащить ожидаемый результат в отдельный файл, подумать о привязке учетки к ож резу
    private final static String USER_NAME = "//span[@class='equiring-send__title theme-text theme-text--large']";
    private final static String userNameExpected = "Герман Дзех";
    private final static String workspace = "//span[@class='equiring-send__workspace theme-text theme-text--small theme-text--bold theme-text--gray workplace-wrapper mt-xs']";
    private final static String workspaceExpected = " Bigati Bar ']";
    private final static String SUM_BUTTON_1 = "//div[@class='shortcut-sum-buttons__wrapper'][1]";
    private final static String SUM_BUTTON_2 = "//div[@class='shortcut-sum-buttons__wrapper'][2]";
    private final static String SUM_BUTTON_3 = "//div[@class='shortcut-sum-buttons__wrapper'][3]";
    private final static String SUM_BUTTON_4 = "//div[@class='shortcut-sum-buttons__wrapper'][4]";
    private final static String BILL_SUM = "//div[@class='check-sum']";
    private final static String billSumExpected = "Сумма в чеке: 200 ₽";
    private final static String TOP_PICTURE = "//img[@class='logo-wrapper__workplace-logo']";
    private final static String TIPS_PLACEHOLDER = "//input[@name='amount']";
    private final static String SIT_TEXT = "//span[@class='feedback__caption']";
    private final static String GPAY_TEXT = "//div[@class='setup-ag-pay-text _full']";
    private final static String YANDEX_PAY_BUTTON = "//button[@class='ya-pay-button ya-pay-button_type_pay ya-pay-button_theme_black ya-pay-button_width_max ya-pay-button_personalised']";
    private final static String CRD_PAY_BUTTON = "//button[@class='tip-btn _card']";
    private final static String DELETE_SUM = "//span[@class='equiring-reset']";
    private final static String USER_COMMISSION_CHECKBOX = "//input[@id='user-commission-after']/..";
    private final static String USER_COMMISSION_CHECKBOX_HIDDEN = "//input[@id='user-commission-after']";
    private final static String USER_AGREEMENT_LINK = "//div[@class='page-link' and .=' Пользовательского соглашения']";
    private static final String USER_AGREEMENT_TITLE = "//h2[.='Пользовательское соглашение для плательщиков чаевых сервиса «нетмонет»']";
    private static final String USER_AGREEMENT_TITLE_EXPECTED = "Пользовательское соглашение для плательщиков чаевых сервиса «нетмонет»";
    //TODO: вынести элементы в класс лендинга
    private final static String PERSONAL_DATA_AGREEMENT_CHECKBOX = "//input[@id='terms-agree']/../label/span";
    private final static String PERSONAL_DATA_AGREEMENT_CHECKBOX_HIDDEN = "//input[@id='terms-agree']";
    private static final String PERSONAL_DATA_AGREEMENT_TITLE = "//h2[.='Политика обработки персональных данных сервиса «нетмонет»']";
    private static final String PERSONAL_DATA_AGREEMENT_TITLE_EXPECTED = "Политика обработки персональных данных сервиса «нетмонет»";
    private final static String PERSONAL_DATA_AGREEMENT_LINK = "//div[@class='page-link' and .=' Политики обработки персональных данных']";
    private final static String TIPS_ONLINE_LINK = "//a[@href='https://netmonet.co']";
    private final static String FIRST_STAR = "//svg-star[1]";
    private final static String SECOND_STAR = "//svg-star[2]";
    private final static String THIRD_STAR = "//svg-star[3]";
    private final static String FOURTH_STAR = "//svg-star[4]";
    private final static String FIFTH_STAR = "//svg-star[5]";
    private final static String STARS_DESC = "//div[@class='feedback__stars']";
    private final static String SERVICE_DIV = "//div[@class='option' and .='Обслуживание']";
    private final static String SERVICE_INPUT = "//input[@id='text-option-0']";
    private final static String VIBE_DIV = "//div[@class='option' and .='Атмосфера']";
    private final static String QUALITY_DISHES_DIV = "//div[@class='option' and .='Качество блюд']";
    private final static String PURENESS_DIV = "//div[@class='option' and .='Чистота']";
    private final static String FEEDBACK_PLACEHOLDER = "//textarea[@class='feedback__textarea equiring__textarea ng-pristine ng-valid ng-touched']";
    private final static String HINTS_DIV ="//div[@class='hints']";
    private final static String PRETTY_PURENESS_BUTTON = "//label[@for='739e3890-e89b-12d3-a456-3489554423w8']";
    private final static String TASTY_FOOD_BUTTON = "//label[@for='739e3890-e89b-12d3-a456-3489554423a2']";
    private final static String GOOD_ATMOSPHERE_BUTTON = "//label[@for='321e7589-e89b-12d3-a456-4266554423k3']";
    private final static String GOOD_SERVICE_BUTTON = "//label[@for='739e3890-e89b-12d3-a456-3489554423x6']";
    private final static String VERY_CLEAN_BUTTON = "//label[@for='739e3890-e89b-12d3-a456-3489554423d8']";
    private final static String ELEGANT_DISH_BUTTON = "//label[@for='739e3890-e89b-12d3-a456-3489554423d9']";
    private final static String GREAT_ATMOSPHERE_BUTTON = "//label[@for='321e7589-e89b-12d3-a456-4266554423i4']";
    private final static String EXCELLENT_SERVICE_BUTTON = "//label[@for='739e3890-e89b-12d3-a456-3489554423w4']";
    private final static String USER_IMG = "//img[@class='equiring-send__photo’]";
    private final static String OPTIONS_WRAPPER = "//div[@class='options-wrapper']";
    private final static String ADD_FEEDBACK_BTN = "//span[@class='add-feedback-btn']";
    private final static String TEXTAREA_COMMENT = "//textarea[@id='comment']";

    /*
    кликабельные
    * */

    @FindBy(xpath = TEXTAREA_COMMENT)
    WebElement textAreaComment;
    @FindBy(xpath = ADD_FEEDBACK_BTN)
    WebElement addFeedbackBtn;
    @FindBy(xpath = HINTS_DIV)
    WebElement hintsDiv;
    @FindBy(xpath = SERVICE_DIV)
    WebElement serviceDiv;
    @FindBy(xpath = VIBE_DIV)
    WebElement vibeDiv;
    @FindBy(xpath = QUALITY_DISHES_DIV)
    WebElement qualityDishesDiv;
    @FindBy(xpath = PURENESS_DIV)
    WebElement purenessDiv;
    @FindBy(xpath = FIRST_STAR)
    WebElement firstStar;
    @FindBy(xpath = SECOND_STAR)
    WebElement secondStar;
    @FindBy(xpath = THIRD_STAR)
    WebElement thirdStar;
    @FindBy(xpath = FOURTH_STAR)
    WebElement fourthStar;
    @FindBy(xpath = FIFTH_STAR)
    WebElement fifthStar;
    @FindBy(xpath = SUM_BUTTON_1)
    WebElement sumButton_1;
    @FindBy(xpath = SUM_BUTTON_2)
    WebElement sumButton_2;
    @FindBy(xpath = SUM_BUTTON_3)
    WebElement sumButton_3;
    @FindBy(xpath = SUM_BUTTON_4)
    WebElement sumButton_4;
    @FindBy(xpath = USER_NAME)
    WebElement userName;
    @FindBy(xpath = DELETE_SUM)
    WebElement deleteSum;
    @FindBy(xpath = TIPS_PLACEHOLDER)
    WebElement tipsPlaceholder;
    @FindBy(xpath = USER_AGREEMENT_LINK)
    WebElement userAgreementLink;
    @FindBy(xpath = USER_AGREEMENT_TITLE)
    WebElement userAgreementTitle;
    @FindBy(xpath = PERSONAL_DATA_AGREEMENT_LINK)
    WebElement personalDataAgreementLink;
    @FindBy(xpath = PERSONAL_DATA_AGREEMENT_TITLE)
    WebElement personalDataAgreementTitle;
    @FindBy(xpath = USER_COMMISSION_CHECKBOX)
    WebElement userCommissionCheckbox;
    @FindBy(xpath = USER_COMMISSION_CHECKBOX_HIDDEN)
    WebElement userCommissionCheckboxHidden;
    @FindBy(xpath = PERSONAL_DATA_AGREEMENT_CHECKBOX)
    WebElement personalDataAgreementCheckbox;
    @FindBy(xpath = PERSONAL_DATA_AGREEMENT_CHECKBOX_HIDDEN)
    WebElement personalDataAgreementCheckboxHidden;
    @FindBy(xpath = OPTIONS_WRAPPER)
    WebElement optionsWrapper;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Step("Выбрать пункт Обслуживание")
    public UserPage clickOnServiceRadioButton() {
        //waitForElementToClick(serviceDiv.findElement(By.xpath("label"))).click();
        clickToElement(serviceDiv.findElement(By.xpath("label")));
        Assertions.assertTrue(serviceDiv.findElement(By.xpath("input")).isSelected());
        return this;
    }

    @Step("Выбрать пункт Атмосфера")
    public UserPage clickOnVibeRadioButton() {
        clickToElement(vibeDiv.findElement(By.xpath("label")));
        Assertions.assertTrue(vibeDiv.findElement(By.xpath("input")).isSelected());
        return this;
    }

    @Step("Выбрать пункт Качество блюд")
    public UserPage clickOnQualityDishesRadioButton() {
        clickToElement(qualityDishesDiv.findElement(By.xpath("label")));
        Assertions.assertTrue(qualityDishesDiv.findElement(By.xpath("input")).isSelected());
        return this;
    }

    @Step("Выбрать пункт Чистота")
    public UserPage clickOnPurenessRadioButton() {
        clickToElement(purenessDiv.findElement(By.xpath("label")));
        Assertions.assertTrue(purenessDiv.findElement(By.xpath("input")).isSelected());
        return this;
    }

    @Step("Клик по первой звезде")
    public UserPage clickOnFirstStar() {
        //waitForElementToClick(firstStar).click();
        clickToElement(firstStar);
        Assertions.assertTrue(waitForElement(optionsWrapper).isDisplayed());
        return this;
    }

    @Step("Клик по 2-й звезде")
    public UserPage clickOnSecondStar() {
        clickToElement(secondStar);
        Assertions.assertTrue(waitForElement(optionsWrapper).isDisplayed());
        return this;
    }

    @Step("Клик по 3-й звезде")
    public UserPage clickOnThirdStar() {
        clickToElement(thirdStar);
        Assertions.assertTrue(waitForElement(optionsWrapper).isDisplayed());
        return this;
    }

    @Step("Клик по 4-й звезде")
    public UserPage clickOnFourthStar() {
        clickToElement(fourthStar);
        Assertions.assertTrue(waitForElement(hintsDiv).isDisplayed());
        return this;
    }

    @Step("Клик по 5-й звезде")
    public UserPage clickOnFifthStar() {
        clickToElement(fifthStar);
        Assertions.assertTrue(waitForElement(hintsDiv).isDisplayed());
        return this;
    }

    @Step("Клик по ссылке пользовательского соглашения")
    public UserPage clickOnUserAgreementLink() {
        clickToElement(userAgreementLink);
        Assertions.assertEquals(USER_AGREEMENT_TITLE_EXPECTED, waitForElement(userAgreementTitle).getText());
        return this;
    }

    @Step("Проверка чекбокса издержки")
    public UserPage clickOnUserCommissionCheckbox() {
        System.out.println(waitForHiddenElement(USER_COMMISSION_CHECKBOX_HIDDEN).isSelected());
        clickToElement(userCommissionCheckbox);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(waitForHiddenElement(USER_COMMISSION_CHECKBOX_HIDDEN).isSelected());
        //Assertions.assertEquals(USER_AGREEMENT_TITLE_EXPECTED, waitForElement(userAgreementTitle).getText());
        return this;
    }

    @Step("Проверка чекбокса соглашений")
    public UserPage clickOnPersonalDataAgreementCheckbox() {
        System.out.println(waitForHiddenElement(PERSONAL_DATA_AGREEMENT_CHECKBOX_HIDDEN).isSelected());
        clickToElement(personalDataAgreementCheckbox);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(waitForHiddenElement(PERSONAL_DATA_AGREEMENT_CHECKBOX_HIDDEN).isSelected());
        //Assertions.assertEquals(USER_AGREEMENT_TITLE_EXPECTED, waitForElement(userAgreementTitle).getText());
        return this;
    }

    @Step("Клик по ссылке Политика обработки персональных данных")
    public UserPage clickOnPersonalDataAgreementLink() {
        clickToElement(personalDataAgreementLink);
        Assertions.assertEquals(PERSONAL_DATA_AGREEMENT_TITLE_EXPECTED, waitForElement(personalDataAgreementTitle).getText());
        return this;
    }

    @Step("Клик по кнопке удаления суммы")
    public UserPage clickDeleteSum() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(TIPS_PLACEHOLDER)));
        System.out.println("sum is: " + tipsPlaceholder.getAttribute("value"));
        clickToElement(deleteSum);
        System.out.println("sum is: " + tipsPlaceholder.getAttribute("value"));
        Assertions.assertEquals("", tipsPlaceholder.getAttribute("value"));
        return this;
    }

    @Step("Проверка имени юзера")
    public UserPage checkUserName() throws InterruptedException {
        Assertions.assertEquals(userNameExpected, waitForElement(userName).getText());
        return this;
    }

    @Step("Текст первой кнопки суммы")
    public UserPage checkSumButton_1() throws InterruptedException {
        Assertions.assertEquals("14%", waitForElement(sumButton_1).getText());
        return this;
    }

    @Step("Текст второй кнопки суммы")
    public UserPage checkSumButton_2() throws InterruptedException {
        Assertions.assertEquals("13%", waitForElement(sumButton_2).getText());
        return this;
    }

    @Step("Текст 3-й кнопки суммы")
    public UserPage checkSumButton_3() throws InterruptedException {
        Assertions.assertEquals("12%", waitForElement(sumButton_3).getText());
        return this;
    }

    @Step("Текст 4-й кнопки суммы")
    public UserPage checkSumButton_4() throws InterruptedException {
        Assertions.assertEquals("11%", waitForElement(sumButton_4).getText());
        return this;
    }


    @Step("Клик первой кнопки суммы")
    public UserPage clickSumButton_1() {
        clickToElement(sumButton_1);
        return this;
    }

    @Step("Клик второй кнопки суммы")
    public UserPage clickSumButton_2() {
        clickToElement(sumButton_2);
        return this;
    }

    @Step("Клик 3-й кнопки суммы")
    public UserPage clickSumButton_3() {
        clickToElement(sumButton_3);
        return this;
    }

    @Step("Клик 4-й кнопки суммы")
    public UserPage clickSumButton_4() {
        clickToElement(sumButton_3);
        return this;
    }
    @Step("Клик по кнопке рассказать подробнее")
    public UserPage checkAddFeedbackBtn (){

        clickToElement(addFeedbackBtn);
        Assertions.assertTrue(waitForElement(textAreaComment).isDisplayed());
        return this;
    }
    @Step("Ввод комментария")
    public UserPage checkTextArea (){
        String text = "TEST TEST T E S T TEST TEST TEST T E S T";
        waitForElement(textAreaComment)
                .sendKeys("TEST TEST T E S T TEST TEST TEST T E S T");
        Assertions.assertEquals(text, textAreaComment.getAttribute("value"));
        return this;

    }


}
