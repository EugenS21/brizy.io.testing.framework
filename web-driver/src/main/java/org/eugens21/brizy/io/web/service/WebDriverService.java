package org.eugens21.brizy.io.web.service;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright.CreateOptions;
import com.microsoft.playwright.options.RecordVideoSize;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.exception.PlaywrightLoadingException;
import org.eugens21.brizy.io.web.property.WebDriverProperties;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.Context;

import static lombok.AccessLevel.PRIVATE;

@Component
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
public class WebDriverService {

    BrowserContextService contextService;
    BrowserService browserService;
    PageService pageService;
    PlaywrightService playwrightService;

    @Autowired
    public WebDriverService(ModelMapper modelMapper, WebDriverProperties props) {
        CreateOptions createOptions = modelMapper.map(props.getPlaywright(), CreateOptions.class);
        LaunchOptions launchOptions = modelMapper.map(props.getBrowser(), LaunchOptions.class);
        NewContextOptions contextOptions = modelMapper.map(props.getContext(), NewContextOptions.class);
        this.playwrightService = new PlaywrightService(createOptions);
        this.browserService = new BrowserService(props.getBrowser().getType(), launchOptions);
        this.contextService = new BrowserContextService(contextOptions);
        this.pageService = new PageService();
    }

    public Playwright createInstance() {
        return playwrightService.create();
    }

    public void closeInstance() {
        playwrightService.close();
    }

    public Browser createBrowser(Playwright playwright) {
        return browserService.launch(playwright);
    }

    public void closeBrowser() {
        browserService.close();
    }

    public BrowserContext createContext(Browser browser) {
        return contextService.newContext(browser);
    }

    public void closeContext() {
        contextService.close();
    }

    public Page createNewPage(BrowserContext context) {
        return pageService.createNewPage(context);
    }

}
