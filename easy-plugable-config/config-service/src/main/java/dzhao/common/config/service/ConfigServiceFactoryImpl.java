package dzhao.common.config.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dzhao.common.config.api.ConfigService;
import dzhao.common.config.api.ConfigServiceFactory;
import dzhao.common.config.api.ConfigSource;
import dzhao.common.config.api.domain.ConfigSourceType;
import dzhao.common.config.inject.ConfigServiceModule;
import dzhao.common.config.provider.ConfigSourceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConfigServiceFactoryImpl implements ConfigServiceFactory {

    private static Injector injector;
    private static Set<ConfigSource> configSources;
    private static ConfigServiceFactoryImpl _instance;

    private ConfigServiceFactoryImpl(){
        injector = Guice.createInjector(new ConfigServiceModule());
    }

    public static synchronized ConfigServiceFactory newInstance(){
        if (_instance == null) {
            _instance = new ConfigServiceFactoryImpl();
            configSources = injector.getInstance(ConfigSourceProvider.class).getSources();
        }
        return _instance;
    }

    public ConfigService getConfigService(ConfigSourceType type){
        if(configSources==null){
            throw new UnsupportedOperationException("no config source found!");
        }
        for(ConfigSource service : configSources){
            if(service.getSourceType().equals(type))
                return service;
        }
        throw new UnsupportedOperationException("unsupported source type [" + type.name() + "]");
    }
}
