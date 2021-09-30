package com.iljasstan;

import org.junit.jupiter.api.Test;


public class FindIssueAnnotatedStepTest {
    public static final String rep = "eroshenkoam/allure-example";
    public static final int IssueNum = 74;

    @Test
    public void shouldFindIssueWithNumber() {
        WebSteps steps = new WebSteps();
        steps.openGithub();
        steps.findRepository(rep);
        steps.openIssues();
        steps.checkIssueNumber(IssueNum);
    }
}
