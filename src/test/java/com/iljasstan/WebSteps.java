package com.iljasstan;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем github.com")
    public void openGithub() {
        open("https://github.com");
    }
    @Step("Ищем репозиторий: {repo}")
    public void findRepository(String repo) {
        $("[data-test-selector=nav-search-input]").setValue(repo).pressEnter();
        $(".px-2 ul").$("li a").click();
    }
    @Step("Открываем вкладку Issues")
    public void openIssues() {
        $("#issues-tab").click();
    }
    @Step("Проверяем, что есть Issue c номером {issueNum}")
    public void checkIssueNumber(int issueNum){
        $(".js-check-all-container").shouldHave(Condition.text("#" + issueNum));
    }
}
