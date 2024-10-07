package jiratests.core;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class JiraCreateStoryTest<storyKey> {
    Assertions.assertNotNull(storyKey, "Story key should not be null!");
    Assertions.assertTrue(storyKey.startsWith("EPIC-"), "Story key should start with 'EPIC-'!");
}
