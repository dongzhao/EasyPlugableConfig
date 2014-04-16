package dzhao.common.config.plugins.property;


import com.google.inject.AbstractModule;
import dzhao.common.config.api.ConfigSource;
import dzhao.common.config.plugins.property.service.PropertiesConfigService;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ConfigSource.class).to(PropertiesConfigService.class);
    }
}
