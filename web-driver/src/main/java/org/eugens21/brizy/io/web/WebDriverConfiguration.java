package org.eugens21.brizy.io.web;

import org.eugens21.brizy.io.web.common.property.CustomYamlProcessor;
import org.eugens21.brizy.io.web.property.WebDriverProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ComponentScan
@Configuration
@EnableConfigurationProperties(WebDriverProperties.class)
@PropertySource(value = "classpath:web-driver-properties.yml", factory = CustomYamlProcessor.class)
public class WebDriverConfiguration {}
