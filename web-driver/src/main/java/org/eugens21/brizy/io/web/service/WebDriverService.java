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

    /**
     * Initializes Playwright components (context and browser) on the defined properties.
     */
    public void init() {
        Playwright playwright = playwrightService.create();
        Browser browser = browserService.launch(playwright);
        contextService.newContext(browser);
    }

    public Page create() {
        return pageService.createNewPage(contextService.getContext());
    }

    /**
     * Initializes Playwright components (context and browser) on the defined properties.
     */
    public void close() {
        contextService.close();
        browserService.close();
        playwrightService.close();
    }


}
