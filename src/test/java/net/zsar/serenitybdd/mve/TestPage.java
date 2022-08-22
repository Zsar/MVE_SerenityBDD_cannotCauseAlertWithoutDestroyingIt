package net.zsar.serenitybdd.mve;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestPage extends PageObject {
	static final Target BUTTON = Target.the("alert button").located(By.xpath("//button"));

	public Performable pushTheButton() {
		return Task.where("{0} pushed the button and confirmed the alert"
				, Ensure.that(BUTTON).isDisplayed()
				, Click.on(BUTTON)
				, new ClickOnAlert()
		);
	}

	class ClickOnAlert implements Task {
		@Override
		public void performAs(final Actor actor) {
			final var alert = new WebDriverWait(getDriver(), Duration.ZERO).until(ExpectedConditions.alertIsPresent());
			alert.accept();
		}
	}
}
