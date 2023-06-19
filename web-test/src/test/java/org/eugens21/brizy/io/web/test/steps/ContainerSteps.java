package org.eugens21.brizy.io.web.test.steps;

import io.cucumber.java.en.When;
import io.vavr.NotImplementedError;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.dto.SidebarItemDto;
import org.eugens21.brizy.io.web.interactions.page.EditorPage;
import org.eugens21.brizy.io.web.test.enums.StorageKey;
import org.eugens21.brizy.io.web.test.model.page.ItemToAdd;
import org.eugens21.brizy.io.web.test.model.page.PageItem;
import org.eugens21.brizy.io.web.test.storage.Storage;
import org.eugens21.brizy.io.web.test.transformer.MapperTransformerUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ContainerSteps {

    ModelMapper modelMapper;
    Storage storage;

    @Autowired
    public ContainerSteps(ModelMapper modelMapper, Storage storage) {
        this.modelMapper = modelMapper;
        this.storage = storage;
    }

    @When("prepare the following items to be added to the page:")
    public void prepareTheFollowingItemsToBeAddedToThePage(List<ItemToAdd> items) {
        storage.addValue(StorageKey.ITEMS_TO_BE_ADDED_TO_THE_PAGE, items);
    }

    @When("prepare the following properties for the items to be added to the page:")
    public void prepareTheFollowingPropertiesForTheItemsToBeAddedToThePage(List<PageItem> items) {
        throw new NotImplementedError();
    }

    @When("add the items to the page")
    public void addTheItemsToThePage() {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR_PAGE, EditorPage.class);
        List<ItemToAdd> itemsToAdd = storage.getListValue(StorageKey.ITEMS_TO_BE_ADDED_TO_THE_PAGE, ItemToAdd.class);
        List<SidebarItemDto> sidebarItemsToAdd = MapperTransformerUtil.getSidebarItemsDtoFromPageItems.apply(itemsToAdd);
        editorPage.editPage().add(sidebarItemsToAdd);
    }



}
