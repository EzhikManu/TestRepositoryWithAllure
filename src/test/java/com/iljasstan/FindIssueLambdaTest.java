package com.iljasstan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class FindIssueLambdaTest {
    public static final String rep = "eroshenkoam/allure-example";
    public static final int IssueNum = 74;

    @Test
    void findIssue() {
        step("Открываем github.com");
        {
            open("https://github.com");
            takeScreenshot();
            takePageSource();
        }
        step("Ищем репозиторий: " + rep);
        {
            $("[data-test-selector=nav-search-input]").setValue(rep).pressEnter();
            $(".px-2 ul").$("li a").click();
            takeScreenshot();
        }
        step("Открываем вкладку Issues");
        {
            $("#issues-tab").click();
            takeScreenshot();
        }
        step("Проверяем, что в Issues репозитория " + rep + " есть ссылка №" + IssueNum);
        {
            $(".js-check-all-container").shouldHave(Condition.text("#" + IssueNum));
        }
    }

    @Attachment(value = "Код страницы", type = "text/html")
    public byte[] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Страница", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}