import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;


public class Maintests {
    public SelenideElement InputFormControl(String label) {
        return $(By.xpath("//div[@class='form-group']/label[text()='" + label + "']/following-sibling::input"));
    }

    @BeforeAll
    @DisplayName("Should be open Paysera in browser")
    static void openPaysera() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("89.0");
        open("https://www.paysera.bg/v2/en-LT/fees/currency-conversion-calculator");
        $(By.className("transformable-table")).should(Condition.exist);
    }

    @Test
    @DisplayName("When user fills \"BUY\" amount, \"SELL\" amount box is being emptied and vice versa")
    public void emptiedSellField(){
        InputFormControl("Sell").shouldHave(Condition.cssClass("ng-not-empty"));
        InputFormControl("Buy").should(Condition.exist);
        InputFormControl("Buy").setValue("100");
        InputFormControl("Sell").shouldHave(Condition.cssClass("ng-empty"));
    }

//    @Test
//    @DisplayName("When user selects another country rates must be updated and currency option should be changed")
//    public void localization() {
//
//    }

    @Test
    @DisplayName("When selling (X) is lower than the amount, provided by Paysera (Y) should be text box is displayed, representing the loss (X-Y)")
    public void representingLoss() {
//        int count = 1;
//        $(By.xpath("//table//tbody//tr[" + count + "]//td[@data-title=\"Swedbank amount\"]")).getValue();
//        $(By.xpath("//table//tbody//tr[" + count + "]//td[@data-title=\"Paysera amount\"]")).getValue();
        }
    }