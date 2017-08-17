package com.zipcodewilmington.selenium.smartystreet.crawlpaths;

import com.zipcodewilmington.selenium.smartystreet.pages.DemoPage;
import com.zipcodewilmington.selenium.tools.mockdata.Actor;
import com.zipcodewilmington.selenium.tools.mockdata.ActorFactory;
import org.junit.Test;

/**
 * Created by leon on 8/17/17.
 */
public class SmartyStreetWebCrawl extends AbstractSmartyStreetWebCrawl {

    @Override
    public void setup() {
        browserHandler.options.screenshotOnEvent.setValue(false);
        browserHandler.options.defaultWait.setValue(60);
    }

    @Test
    @Override
    public void test() {
        Actor actor = ActorFactory.createDefaultActor();
        browserHandler.options.screenshotOnEvent.setValue(true);
        browserHandler.navigateTo("https://smartystreets.com/");
        demoPage.selectService("us");
        demoPage.enterDetails(actor.getAddressLine1(), actor.getCity(), actor.getState(), actor.getZipcode());
        browserHandler.click(DemoPage.USView.byButtonSubmit);
        browserHandler.options.defaultWait.setValue(60);
        browserHandler.wait.forPageLoad(browserHandler.options.defaultWait.getValue());
    }
}