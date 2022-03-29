package user.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import user.BasePage;

public class PayByCardPage extends BasePage {
    public PayByCardPage(WebDriver driver) {
        super(driver);
    }
    private final static String CARD_LABEL = "//label[@for='card']";
    @FindBy(xpath = CARD_LABEL)
    WebElement cardLabelOnPayByCardPage;
    private final static String CARD_LABEL_EXP_RES = "Номер карты";
    public PayByCardPage checkCardLabelText(){
        Assertions.assertEquals(CARD_LABEL_EXP_RES, getTextOfElement(cardLabelOnPayByCardPage));
        return this;
    }
}
