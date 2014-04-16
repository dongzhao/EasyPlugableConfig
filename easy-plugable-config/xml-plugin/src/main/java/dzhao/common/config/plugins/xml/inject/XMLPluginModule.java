package dzhao.common.config.plugins.xml.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import dzhao.common.config.api.ConfigSource;
import dzhao.common.config.plugins.xml.service.XMLConfigService;
import dzhao.common.config.spi.ConfigPluginModule;

public class XMLPluginModule extends AbstractModule implements ConfigPluginModule {
    @Override
    protected void configure() {
        Multibinder<ConfigSource> sourceBinder = Multibinder.newSetBinder(binder(), ConfigSource.class);
        sourceBinder.addBinding().to(XMLConfigService.class).in(Singleton.class);
    }
}
