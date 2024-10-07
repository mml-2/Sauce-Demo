package jiratests.core;

import com.jira.pages.*;
import com.saucedemo.pages.*;
import org.junit.jupiter.api.BeforeEach;
import saucedemotests.enums.TestData;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class JiraBaseTest extends BaseWebTest {

    protected AtlassianHomePage atlassianHomePage;
    protected AtlassianLoginPage atlassianLoginPage;
    protected AtlassianNavigationMenu atlassianNavigationMenu;
    protected BaseJiraPage baseJiraPage;
    protected CreateIssuePage createIssuePage;
    protected CreateStoryPage createStoryPage;
    protected LinkBugAndStory linkBugAndStory;

    public void beforeTests() {
        // perform some code before each test starts

        atlassianHomePage = new AtlassianHomePage();
        atlassianLoginPage = new AtlassianLoginPage();
        atlassianNavigationMenu = new AtlassianNavigationMenu();
        baseJiraPage = new BaseJiraPage();
        createIssuePage = new CreateIssuePage();
        createStoryPage = new CreateStoryPage();
        linkBugAndStory = new LinkBugAndStory();

        // Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("jiraBaseUrl"));
    }
}
