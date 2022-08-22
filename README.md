Reproduces https://github.com/serenity-bdd/serenity-core/issues/2470

# Usage

- adjust if necessary: only configured to use
  - Chrome
  - Maven
  - Java 18

1. mvn verify -q
   - should wait for you to attach a debugger
   - should download chromedriver into target folder, if none found (but it seems to find one from idk where on my machine, so it never downloads... - sorry if it does not work)
2. prepare breakpoints
   1. enabled in `StepInterceptor.executeTestStepMethod` after `invokeMethod`
   2. disabled in `WebDriverFacade.getScreenshotAs` at `getScreenshotAs`
3. attach debugger to maven process offered in StdOut
4. when reaching 2.1 and the alert is visible in the Browser, enable 2.2
5. when reaching 2.2 the alert is gone
6. locally build a snapshot of [this fork](https://github.com/Zsar/serenity-core/tree/fix/2470-cannotCauseAlertWithoutDestroyingIt)
   - mvn install -T1C -q -DskipTests
   - note project.version in pom.xml
7. use locally built snapshop here
   - update version of serenity-core in pom.xml with value from 6
   - mvn clean compile -U -q
8. repeat steps 1 - 5 => now works as expected

Refer to [discussion starting here](https://github.com/serenity-bdd/serenity-core/issues/2470#issuecomment-1221334308) for more in-depth analysis.
