package jiratests.core;

import com.jira.pages.CreateIssuePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;
import static testframework.DriverManager.driver;

public class JiraBugCreationTest extends CreateIssuePage{
    public JiraBugCreationTest(WebDriver driver) {
        super(driver);
    }

    @Test
    public void testBugCreation() {
        // Create a Bug and get the Bug key
        String bugKey = createJiraIssue().createBug();

        // Validate that the Bug was created
        assertNotNull(bugKey, "Bug key should not be null!");

        // Optionally, verify that the Bug appears in the Jira project
        driver.get("https://your-jira-instance-url.com/browse/" + bugKey); // Navigate to the created Bug's page

        // Check if the Bug's page is displayed and contains the expected title or summary
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Bug: " + bugKey), "The page title should indicate the Bug was created!");

        // Optionally, check for specific elements on the Bug page
        // Example: Assert that the summary of the Bug is correct
        String expectedSummary = "Automated Bug Blocked by Story"; // Replace with your expected summary
        String actualSummary = driver.findElement(By.id("summary-val")).getText();
        assertEquals(expectedSummary, actualSummary, "The Bug summary should match the expected summary!");
    }
}
