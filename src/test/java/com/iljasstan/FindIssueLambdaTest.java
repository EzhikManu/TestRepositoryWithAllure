package com.iljasstan;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class FindIssueLambdaTest {
    public static final String rep = "eroshenkoam/allure-example";
    public static final int IssueNum = 74;
    @Test
    void findIssue() {
        step("Открываем github.com"); {
        open("https://github.com");
        }
        step("Ищем репозиторий: " + rep); {
            $("[data-test-selector=nav-search-input]").setValue(rep).pressEnter();
            $(".px-2 ul").$("li a").click();
        }
        step("Открываем вкладку Issues");
        {
            $("#issues-tab").click();
        }
        step("Проверяем, что в Issues репозитория " + rep + " есть ссылка №" + IssueNum);
        $(".js-check-all-container").shouldHave(Condition.text("#" + IssueNum));
    }
}
