package se.dandel.jbehave.test.basics.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.dandel.jbehave.test.basics.StoryContext;

public class NyAnsokanSteps {
    private static Logger LOGGER = LoggerFactory.getLogger(NyAnsokanSteps.class);

    @Given("ny ansokan med persorgnr $persorgnr")
    public void givenNyAnsokanMedPersorgnr(String persorgnr) {
        LOGGER.info("givenNyAnsokanMedPersorgnr");
        StoryContext.get().add("persorgnr", persorgnr);
    }

    @Given("ny ansokan")
    public void givenNyAnsokan() {
        LOGGER.info("givenNyAnsokan");
    }

    @When("ansokan skickas in")
    public void whenAnsokanSkickasIn() {
        LOGGER.info("whenAnsokanSkickasIn, for persorgnr " + StoryContext.get().get("persorgnr"));
    }

    @Then("antal arkiveringar = $antal")
    public void thenAntalArkiveringar(int antal) {
        StoryContext.get().add("antal_arkiveringar", antal);
    }

    @Then("antal utskrifter = $antal")
    public void thenAntalUtskrifter(int antal) {
        StoryContext.get().add("antal_utskrifter", antal);
    }

    @Then("antal arbetsuppgifter = $antal")
    public void thenAntalArbetsuppgifter(int antal) {
        StoryContext.get().add("antal_arbetsuppgifter", antal);
    }

    @Then("antal mal = $antal")
    public void thenAntalMal(int antal) {
        StoryContext.get().add("antal_mal", antal);
    }

}