package org.eugens21.brizy.io.web.interactions.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.enums.EditorSidebarElement;
import org.eugens21.brizy.io.web.interactions.enums.ElementPositions;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SidebarItemDto {

    EditorSidebarElement type;
    ElementPositions elementPosition;
    String parentName;
    String elementName;
    Object elementProperties;

}
