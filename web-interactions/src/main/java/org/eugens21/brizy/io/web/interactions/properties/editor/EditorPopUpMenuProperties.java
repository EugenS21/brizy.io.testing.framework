package org.eugens21.brizy.io.web.interactions.properties.editor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.properties.editor.pop_up.EditorPopUpMenuBodyProperties;
import org.eugens21.brizy.io.web.interactions.properties.editor.pop_up.EditorPopUpMenuHeaderProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorPopUpMenuProperties {

    String self;
    @NestedConfigurationProperty
    EditorPopUpMenuHeaderProperties header;
    @NestedConfigurationProperty
    EditorPopUpMenuBodyProperties body;

}
