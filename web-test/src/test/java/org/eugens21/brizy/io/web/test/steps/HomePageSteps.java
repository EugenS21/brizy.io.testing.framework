package org.eugens21.brizy.io.web.test.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.test.enums.StorageKey;
import org.eugens21.brizy.io.web.test.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePageSteps {

    Storage storage;

    @Autowired
    public HomePageSteps(Storage storage) {
        this.storage = storage;
    }

    @Given("navigate to home page")
    public void navigateToHomePage() {
        Page page = storage.getValue(StorageKey.PAGE, Page.class);
        page.navigate("");
    }

}
