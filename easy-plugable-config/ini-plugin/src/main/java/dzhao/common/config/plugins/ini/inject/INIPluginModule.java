package dzhao.common.config.plugins.ini.inject;


import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import dzhao.common.config.api.ConfigSource;
import dzhao.common.config.plugins.ini.service.INIConfigService;
import dzhao.common.config.spi.ConfigPluginModule;

public class INIPluginModule extends AbstractModule implements ConfigPluginModule {
    @Override
    protected void configure() {
        Multibinder<ConfigSource> readerBinder = Multibinder.newSetBinder(binder(), ConfigSource.class);
        readerBinder.addBinding().to(INIConfigService.class);
    }
}
