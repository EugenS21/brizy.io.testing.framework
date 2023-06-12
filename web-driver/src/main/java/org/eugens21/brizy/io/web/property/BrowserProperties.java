package org.eugens21.brizy.io.web.property;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.brizy.io.web.enums.BrowserType;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class BrowserProperties {

    BrowserType type;
    List<String> args;
    String channel;
    Boolean chromiumSandbox;
    Boolean devTools;
    Path downloadsPath;
    Map<String, String> env;
    Path executablePath;
    Map<String, String> firefoxUserPrefs;
    Boolean handleSighup;
    Boolean handleSigint;
    Boolean handleSigterm;
    Boolean headless;
    Boolean ignoreAllDefaultArgs;
    Boolean ignoreDefaultArgs;
    String proxy;
    Double slowMo;
    Double timeout;
    Path tracesDir;

}
