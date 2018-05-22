package com.git_leon.selenium.tools.browsertools;

import com.git_leon.selenium.tools.ReflectionUtils;
import com.git_leon.selenium.tools.browsertools.browserhandler.MyBrowserHandler;
import org.openqa.selenium.By;

public abstract class WebPage {
    protected MyWebCrawl crawler;
    protected MyBrowserHandler browserHandler;

    public WebPage(MyWebCrawl web) {
        this.crawler = web;
        this.browserHandler = crawler.browserHandler;
    }

    public By[] getDeclaredBys() {
        return ReflectionUtils.getFieldValues(this, By.class).toArray(By[]::new);
    }

    public void highlightElements() {
        boolean defaultOption = browserHandler.options.continueOnNoSuchElement.getValue();
        browserHandler.options.continueOnNoSuchElement.setValue(true);
        browserHandler.highlightElements(getDeclaredBys(), "yellow");
        browserHandler.options.continueOnNoSuchElement.setValue(defaultOption);
    }
}