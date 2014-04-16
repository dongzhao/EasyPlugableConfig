package dzhao.common.config.provider;

import com.google.inject.Inject;
import dzhao.common.config.api.ConfigSource;

import java.util.Set;

public class ConfigSourceProvider{

    private final Set<ConfigSource> sources;

    @Inject
    public ConfigSourceProvider(Set<ConfigSource> sources){
        this.sources = sources;
    }

    public Set<ConfigSource> getSources() {
        return sources;
    }

}
