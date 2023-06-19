package org.eugens21.brizy.io.web.test.types.data_table;

import io.cucumber.java.DataTableType;
import lombok.SneakyThrows;
import org.eugens21.brizy.io.web.test.model.page.ItemToAdd;

import java.util.Map;

public class PageItemDataTable {

    @DataTableType
    @SneakyThrows
    public ItemToAdd getPageItems(Map<String, String> dataTable) {
        return ItemToAdd.builder()
                .position(dataTable.get(ItemToAdd.Fields.position))
                .item(dataTable.get(ItemToAdd.Fields.item))
                .parent(dataTable.get(ItemToAdd.Fields.parent))
                .name(dataTable.get(ItemToAdd.Fields.name))
                .build();
    }


}
