package se.dandel.jbehave.test.basics.running;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.dandel.jbehave.test.basics.StoryContext;
import se.dandel.jbehave.test.basics.steps.ActivityTrackerSteps;
import se.dandel.jbehave.test.basics.steps.NyAnsokanSteps;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class JUnitReportingRunnerTest extends JUnitStories {
    private static Logger LOGGER = LoggerFactory.getLogger(NyAnsokanSteps.class);

    public JUnitReportingRunnerTest() {
        System.setProperty("jjm.loglevel", "DEBUG");
        JUnitReportingRunner.recommendedControls(configuredEmbedder());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new NyAnsokanSteps(), new ActivityTrackerSteps());
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration();
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("basics.story");
    }

    @BeforeStories
    public void beforeStories() {
        LOGGER.info("beforeStories");
    }

    @BeforeStory
    public void beforeStory() {
        LOGGER.info("beforeStory");
        StoryContext.reset();
    }

}
