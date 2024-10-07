package com.jira.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

import static testframework.DriverManager.driver;

public class BaseJiraPage extends BaseWebPage {

    public BaseJiraPage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    @Override
    public String getBasePageUrl() {
        return PropertiesManager
                .getConfigProperties()
                .getProperty("jiraBaseUrl");

        CreateStoryPage createStoryPage = new CreateStoryPage(driver);
        CreateIssuePage createIssuePage = new CreateIssuePage(driver);

        // Create the Story and capture the Story Key
        String storyKey = createStoryPage.CreateJiraStory();

        // Create the Bug and capture the Bug Key
        String bugKey = createIssuePage.createJiraIssue();

        // Create an instance of IssueLinker to link the Bug to the Story
        LinkBugAndStory issueLinker = new LinkBugAndStory(driver);
        issueLinker.linkIssue(bugKey, storyKey);
    }
}
