package se.dandel.jbehave.test.basics.steps;

import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivityTrackerSteps {
    private static Logger LOGGER = LoggerFactory.getLogger(ActivityTrackerSteps.class);

    @When("efter att all aktivitet har avstannat")
    public void whenEfterAttAllAktivitetHarAvstannat() {
        LOGGER.info("whenEfterAttAllAktivitetHarAvstannat");
    }

}
