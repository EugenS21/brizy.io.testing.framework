package org.eugens21.brizy.io.web.interactions.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.interactions.properties.dashboard.DashboardPageProperties;
import org.eugens21.brizy.io.web.interactions.properties.editor.EditorPageProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@ConfigurationProperties(prefix = "pages")
public class WebLocatorsProperties {

    @NestedConfigurationProperty
    HomePageProperties home;
    @NestedConfigurationProperty
    DashboardPageProperties dashboard;
    @NestedConfigurationProperty
    EditorPageProperties editor;

}
