package org.eugens21.brizy.io.web.interactions.element.nested;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.EditorSidebarElement;
import org.eugens21.brizy.io.web.interactions.element.Button;
import org.eugens21.brizy.io.web.interactions.properties.editor.sidebar.EditorAddItemsSidebarContentMainProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.eugens21.brizy.io.web.interactions.EditorSidebarElement.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorSidebarContent {

    Map<EditorSidebarElement, Supplier<Button>> availableElements;

    public EditorSidebarContent(EditorAddItemsSidebarContentMainProperties main, Page page) {
        this.availableElements = new HashMap<>() {{
            put(COLUMNS, () -> new Button(page.locator(main.getColumns())));
            put(ROW, () -> new Button(page.locator(main.getRow())));
            put(TEXT, () -> new Button(page.locator(main.getText())));
            put(IMAGE, () -> new Button(page.locator(main.getImage())));
            put(BUTTON, () -> new Button(page.locator(main.getButton())));
            put(ICON, () -> new Button(page.locator(main.getIcon())));
            put(SPACER, () -> new Button(page.locator(main.getSpacer())));
            put(MAP, () -> new Button(page.locator(main.getMap())));
            put(FORM, () -> new Button(page.locator(main.getForm())));
            put(LINE, () -> new Button(page.locator(main.getLine())));
            put(MENU_SIMPLE, () -> new Button(page.locator(main.getMenuSimple())));
            put(TRANSLATION, () -> new Button(page.locator(main.getTranslation())));
            put(VIDEO, () -> new Button(page.locator(main.getVideo())));
            put(AUDIO, () -> new Button(page.locator(main.getAudio())));
            put(ICON_TEXT, () -> new Button(page.locator(main.getIconText())));
            put(EMBED_CODE, () -> new Button(page.locator(main.getEmbedCode())));
            put(ALERT, () -> new Button(page.locator(main.getAlert())));
            put(COUNTER, () -> new Button(page.locator(main.getCounter())));
            put(COUNTDOWN_2, () -> new Button(page.locator(main.getCountdown2())));
            put(PROGRESS_BAR, () -> new Button(page.locator(main.getProgressBar())));
            put(TABS, () -> new Button(page.locator(main.getTabs())));
            put(ACCORDION, () -> new Button(page.locator(main.getAccordion())));
            put(POST_TITLE, () -> new Button(page.locator(main.getPostTitle())));
            put(POSTS, () -> new Button(page.locator(main.getPosts())));
            put(ASSETS_POSTS, () -> new Button(page.locator(main.getAssetsPost())));
        }};
    }

    public void element(EditorSidebarElement element) {

    }

}
