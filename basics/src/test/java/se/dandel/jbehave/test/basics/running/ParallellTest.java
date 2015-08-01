package se.dandel.jbehave.test.basics.running;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.dandel.jbehave.test.basics.running.ParallellTest.MyReportBuilder;
import se.dandel.jbehave.test.basics.steps.ActivityTrackerSteps;
import se.dandel.jbehave.test.basics.steps.NyAnsokanSteps;

@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyReporterBuilder = MyReportBuilder.class)
@UsingEmbedder(threads = 10)
@UsingSteps(instances = { NyAnsokanSteps.class, ActivityTrackerSteps.class })
public class ParallellTest extends InjectableEmbedder {

    @Test
    public void run() {
        List<String> storyPaths = Arrays.asList("parallell1.story", "parallell2.story");
        injectedEmbedder().runStoriesAsPaths(storyPaths);
    }

    /**
     * @TODO: Hur få vettig junit-rapportering???
     */
    public static class MyReportBuilder extends StoryReporterBuilder {
        public MyReportBuilder() {
            withFormats(org.jbehave.core.reporters.Format.CONSOLE, org.jbehave.core.reporters.Format.TXT,
                    org.jbehave.core.reporters.Format.HTML, org.jbehave.core.reporters.Format.XML).withDefaultFormats();
        }
    }
}
