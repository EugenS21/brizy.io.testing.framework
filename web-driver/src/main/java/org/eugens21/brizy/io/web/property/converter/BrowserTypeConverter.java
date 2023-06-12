package org.eugens21.brizy.io.web.property.converter;

import org.eugens21.brizy.io.web.enums.BrowserType;
import org.eugens21.brizy.io.web.exception.IllegalPropertyValueException;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class BrowserTypeConverter implements Converter<String, BrowserType> {

    @Override
    public BrowserType convert(String source) {
        if (source.isEmpty() || source.isBlank()) {
            throw new IllegalPropertyValueException("Empty value provided to browser type property!");
        }
        return BrowserType.valueOf(source.toUpperCase());
    }

}
