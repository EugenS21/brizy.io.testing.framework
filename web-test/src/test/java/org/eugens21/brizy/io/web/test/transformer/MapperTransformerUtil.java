package org.eugens21.brizy.io.web.test.transformer;

import lombok.experimental.UtilityClass;
import org.eugens21.brizy.io.web.interactions.dto.SidebarItemDto;
import org.eugens21.brizy.io.web.interactions.enums.EditorSidebarElement;
import org.eugens21.brizy.io.web.interactions.enums.ElementPositions;
import org.eugens21.brizy.io.web.test.model.page.Item;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class MapperTransformerUtil {

    public Function<List<Item>, List<SidebarItemDto>> getSidebarItemsDtoFromPageItems = pageItems -> pageItems.stream()
            .map(el->SidebarItemDto.builder()
                    .type(EditorSidebarElement.valueOf(el.getItem()))
                    .elementPosition(ElementPositions.findForString(el.getPosition()))
                    .parentName(el.getParent())
                    .elementName(el.getName())
                    .build())
            .collect(Collectors.toList());

}
