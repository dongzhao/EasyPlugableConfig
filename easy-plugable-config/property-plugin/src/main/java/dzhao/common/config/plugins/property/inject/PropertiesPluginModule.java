package dzhao.common.config.plugins.property.inject;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import dzhao.common.config.api.ConfigSource;
import dzhao.common.config.plugins.property.service.PropertiesConfigService;
import dzhao.common.config.spi.ConfigPluginModule;

public class PropertiesPluginModule extends AbstractModule implements ConfigPluginModule {
    @Override
    protected void configure() {
        Multibinder<ConfigSource> sourceBinder = Multibinder.newSetBinder(binder(), ConfigSource.class);
        sourceBinder.addBinding().to(PropertiesConfigService.class);
    }
}
