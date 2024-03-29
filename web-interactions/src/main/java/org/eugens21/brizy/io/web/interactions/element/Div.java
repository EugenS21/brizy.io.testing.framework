package org.eugens21.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.dto.workspace.ElementPositionDto;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Div {

    Locator locator;

    public void hover() {
        locator.hover();
    }

    public void moveWithMouse(ElementPositionDto elementPosition) {
        Mouse mouse = locator.page().mouse();
        hover();
        mouse.down();
        mouse.move(elementPosition.getX(), elementPosition.getY(), new Mouse.MoveOptions().setSteps(10));
        mouse.up();
    }

}
