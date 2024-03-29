package org.eugens21.brizy.io.web.test.storage;

import io.cucumber.spring.ScenarioScope;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.test.enums.StorageKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Component
@FieldDefaults(makeFinal = true, level = PRIVATE)
@ScenarioScope
public class Storage {

    Map<StorageKey, Object> store;

    @Autowired
    public Storage() {
        this.store = new HashMap<>();
    }

    public void addValue(StorageKey key, Object value) {
        store.put(key, value);
    }

    public <U> U getValue(StorageKey key, Class<U> clazz) {
        return clazz.cast(store.get(key));
    }

    public <U> List<U> getListValue(StorageKey key, Class<U> clazz) {
        return (List<U>) ((List) store.get(key)).stream()
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    public boolean containsKey(StorageKey key) {
        return store.containsKey(key);
    }

}
