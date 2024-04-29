package com.epam.training.yuliya_azovtseva.framework.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${env}.properties"
})

public interface AppConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("webUrl")
    @DefaultValue("https://cloud.google.com/")
    String webUrl();

    @Key("timeout")
    @DefaultValue("10")
    int timeout();
}
