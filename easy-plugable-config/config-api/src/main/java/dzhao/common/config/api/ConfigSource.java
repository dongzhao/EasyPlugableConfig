package dzhao.common.config.api;

import dzhao.common.config.api.domain.ConfigSourceType;

public interface ConfigSource extends ConfigService{
    public ConfigSourceType getSourceType();
}
