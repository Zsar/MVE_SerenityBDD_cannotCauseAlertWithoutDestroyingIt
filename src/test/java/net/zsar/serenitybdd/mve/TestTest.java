package net.zsar.serenitybdd.mve;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TestTest {
	TestPage testPage;
	WebDriver webDriver;

	/** reproduces <a href="https://github.com/serenity-bdd/serenity-core/issues/2470">2470</a> */
	@Test
	public void pushTheButton() {
		final var actor = Actor.named("Hobbyist").whoCan(BrowseTheWeb.with(this.webDriver));
		actor.attemptsTo(
				  Open.browserOn(this.testPage)
				, this.testPage.pushTheButton()
		);
	}
}
