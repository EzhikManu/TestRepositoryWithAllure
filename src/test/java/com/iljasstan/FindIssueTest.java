package com.iljasstan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FindIssueTest {
    @Test
    void findIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $("[data-test-selector=nav-search-input]").setValue("eroshenkoam/allure-example").pressEnter();
        $(".px-2 ul").$("li a").click();
        $("#issues-tab").click();
        $(".js-check-all-container").shouldHave(Condition.text("#74"));
    }
}