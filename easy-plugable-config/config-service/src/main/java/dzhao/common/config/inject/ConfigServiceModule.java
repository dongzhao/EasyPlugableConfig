package dzhao.common.config.inject;


import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import dzhao.common.config.provider.ConfigSourceProvider;
import dzhao.common.config.spi.ConfigPluginModule;

import java.util.ServiceLoader;

public class ConfigServiceModule extends AbstractModule{
    @Override
    protected void configure() {
        // install plugin's module
        ServiceLoader<ConfigPluginModule> plugins = ServiceLoader.load(ConfigPluginModule.class);
        for (ConfigPluginModule plugin : plugins) {
            install(plugin);
        }

        bind(ConfigSourceProvider.class).in(Singleton.class);

    }
}
