package org.eugens21.brizy.io.web.interactions.properties.editor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EditorFrameProperties {

    String name;
    String addButton;
    @NestedConfigurationProperty
    EditorWorkspaceProperties workspace;

}
